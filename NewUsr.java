import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.sql.*;

public class NewUsr extends JFrame implements ActionListener{  
	static Container ctpane;
	JLabel l1, l2, l3, l4, l5, l6;  
    JButton b1, b2; 
    JTextField tf1, tf2, tf3;
    JPasswordField pf1, pf2;
       
    NewUsr(){
    	setBgimg();
    	java.net.URL imgURL0 = NewUsr.class.getResource("/res/movie-icon07.jpg");
    	Image icon=Toolkit.getDefaultToolkit().getImage(imgURL0);
		setIconImage(icon);
        l1=new JLabel("會員帳號申請 ");  
        l1.setFont(new Font("標楷體", Font.ITALIC, 22));
        l1.setBounds(220,20,150,20);
        l1.setForeground(Color.cyan);
        
        l2=new JLabel("1. 用戶帳號  :  (6碼(含)以上，至少一個英文及數字，不可中文及特殊符號) ");
        l2.setFont(new Font("標楷體", Font.PLAIN, 16));
        l2.setBounds(20,80,600,20);
        l2.setForeground(Color.orange);
        tf1=new JTextField();  
        tf1.setBounds(20,120,150,20);
             
        l3=new JLabel("2. 密碼設定  :  (8碼(含)以上，至少一個英文及數字，不可中文及特殊符號) ");
        l3.setFont(new Font("標楷體", Font.PLAIN, 16));
        l3.setBounds(20,170,600,20);
        l3.setForeground(Color.orange);
        pf1=new JPasswordField();  
        pf1.setBounds(20,210,150,20);

        l4=new JLabel("再輸入確認 : ");
        l4.setFont(new Font("標楷體", Font.PLAIN, 16));
        l4.setBounds(230,210,150,20);
        l4.setForeground(Color.orange);
        pf2=new JPasswordField();  
        pf2.setBounds(330,210,150,20);

        l5=new JLabel("3. 姓    名  :  ( 英文 或 中文 均可 ) ");
        l5.setFont(new Font("標楷體", Font.PLAIN, 16));
        l5.setBounds(20,260,500,20);
        l5.setForeground(Color.orange);
        tf2=new JTextField();  
        tf2.setBounds(20,300,150,20);    
        
        l6=new JLabel("4. 手機號碼  :  (  輸入格式  :  09xxxxxxxx，共10位數  )");
        l6.setFont(new Font("標楷體", Font.PLAIN, 16));
        l6.setBounds(20,350,500,20);
        l6.setForeground(Color.orange);
        tf3=new JTextField();  
        tf3.setBounds(20,390,150,20);    
         
        b1=new JButton("資料輸入完成申請帳號"); 
        b1.setFont(new Font("標楷體", Font.PLAIN, 16));
        b1.setBounds(40,450,200,20);  
        b1.addActionListener(this);   
        
        b2=new JButton("離開"); 
        b2.setFont(new Font("標楷體", Font.PLAIN, 16));
        b2.setBounds(460,520,100,20);  
        b2.addActionListener(this); 
               
        getContentPane().add(l1);getContentPane().add(l2);getContentPane().add(l3);getContentPane().add(l4);getContentPane().add(l5);getContentPane().add(l6);
        getContentPane().add(tf1);getContentPane().add(tf2);getContentPane().add(tf3);
        getContentPane().add(pf1);getContentPane().add(pf2);
        getContentPane().add(b1);getContentPane().add(b2);
        setSize(600,600);
        setLocationRelativeTo(null);
    	ctpane = getContentPane();
    	ctpane.setBackground(new Color(204, 255, 204));
        getContentPane().setLayout(null);  
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }  

    public class xLabel extends JLabel {
      private Image image;

      public xLabel(Image image){
			 this.image = image;
		 }
      
		 @Override
		 public void paintComponent(Graphics g){
			 super.paintComponent(g);
			 int x = this.getWidth();
			 int y = this.getHeight();

			 g.drawImage(image, 0, 0, x, y, null);
		 }
	 }  
    
    public void setBgimg(){ 
    	 java.net.URL imgURL = NewUsr.class.getResource("/res/login.jpg");
    	 Image image = new ImageIcon(imgURL).getImage();
		 JLabel imgLabel = new xLabel(image);
		 this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		 Container cp = this.getContentPane();
		 ((JPanel) cp).setOpaque(false);

		 this.setLocation(200,100);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(600, 600);
		 this.setResizable(false);
		 this.setVisible(true);

		 imgLabel.setBounds(0, 0, this.getWidth(),this.getHeight());
    }    
    
    public static boolean RuleChk(int leng, String str) {
        boolean RuleChk = false;
        int x = leng - 1;

		if(str.length() > x ) {
            boolean isDigit = false;
            boolean isLetter = false;
            
            // 判斷字串中至少各有一個英文字母及數字
            for(int i = 0 ; i < str.length(); i++) {
                if(Character.isDigit(str.charAt(i))) {
                    isDigit = true;  
                }
                if(Character.isLetter(str.charAt(i))) {
                    isLetter = true;
                }
                // 符合至少一個英文字母及數字就跳出
                if(isDigit && isLetter)
                    break;
            }
            
            // 判斷字串中是否包含大小寫英文字母 和 數字(或 特殊符號)
            // ^[a-zA-Z0-9]+$  用正則表示式不包含特殊符號
            String regex = "^[a-zA-Z0-9\\p{Punct}]+$";      
            RuleChk = isDigit && isLetter && str.matches(regex);
        }    
        return RuleChk;
    }
    
    public void actionPerformed(ActionEvent e){ 
    	Connection conn = null;
 	    Statement stmt = null;
    	String s1 = tf1.getText();
    	String s2 = tf2.getText();
    	String s3 = tf3.getText();
    	String p1 = new String(pf1.getPassword());
    	String p2 = new String(pf2.getPassword());
    	String msg = "";
    	
 	    try{
       	Class.forName("com.mysql.cj.jdbc.Driver");
       	conn = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_b34224e1adfc18a?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8","b8a24d218a0919","d4d1d");
        stmt= conn.createStatement();     
 	      
          if(e.getSource() == b1) {
        	  String sql1 = "select count(*) from vip where vipid ='"+s1+"'";
        	  ResultSet rs = stmt.executeQuery(sql1);
        	  rs.next();
        	  if ( rs.getInt(1) > 0)
        		  JOptionPane.showMessageDialog(this, msg+"  此帳號已有人使用，請輸入其他帳號 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else if (RuleChk(6,s1) == false)
        	      JOptionPane.showMessageDialog(this, msg+"  帳號不符合規定，請重新輸入 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else if (RuleChk(8,p1) == false)
        	      JOptionPane.showMessageDialog(this, msg+"  密碼不符合規定，請重新輸入 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else if (s1.equals(p1))
        	      JOptionPane.showMessageDialog(this, msg+"  密碼不可設定與帳號相同，請重新輸入 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else if (p1.equals(p2) == false)
        	      JOptionPane.showMessageDialog(this, msg+"  密碼確認錯誤，請檢查與重新輸入 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else if (s3.length() != 10)
        	      JOptionPane.showMessageDialog(this, msg+"  手機號碼長度錯誤，請重新輸入 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else { 
         	  	      String sql2 = "insert into vip values('"+s1+"', '"+p1+"', '"+s2+"', '"+s3+"')";
         	 	      stmt.executeUpdate(sql2);
         	    	  this.dispose();
         	    	  new Login();
                  }
          }
          if(e.getSource() == b2) {
        	  this.dispose();
 	    	  new Login();  
          }
 	    }catch(SQLException se){
 	      se.printStackTrace();
 	    }catch(Exception e1){
 	      e1.printStackTrace();
 	    }finally{
 	      try{
 	         if(stmt!=null)
 	            conn.close();
 	      }catch(SQLException se){
 	      }
 	      try{
 	         if(conn!=null)
 	            conn.close();
 	      }catch(SQLException se){
 	         se.printStackTrace();
 	      }
 	   }   	
    }   

	public static void main(String[] args) { 
		new NewUsr();   
	}  
} 
