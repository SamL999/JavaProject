import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.sql.*;

public class ChgPwd extends JFrame implements ActionListener{  
	static Container ctpane;
	JLabel l1, l2, l3, l4, l5;  
    JButton b1, b2; 
    JTextField tf1;
    JPasswordField pf1, pf2, pf3;
       
    ChgPwd(){
    	setBgimg();
    	java.net.URL imgURL0 = ChgPwd.class.getResource("/res/movie-icon07.jpg");
    	Image icon=Toolkit.getDefaultToolkit().getImage(imgURL0);
		setIconImage(icon);
        l1=new JLabel("會員修改密碼");  
        l1.setFont(new Font("標楷體", Font.ITALIC, 22));
        l1.setBounds(200,20,150,20);
        l1.setForeground(Color.yellow);
        
        l2=new JLabel("請輸入會員帳號 :  ");
        l2.setFont(new Font("標楷體", Font.PLAIN, 16));
        l2.setBounds(40,120,200,20);
        l2.setForeground(Color.orange);
        tf1=new JTextField();  
        tf1.setBounds(250,120,150,20);
             
        l3=new JLabel("請輸入原密碼 : ");
        l3.setFont(new Font("標楷體", Font.PLAIN, 16));
        l3.setBounds(40,180,200,20);
        l3.setForeground(Color.orange);
        pf1=new JPasswordField();  
        pf1.setBounds(250,180,150,20);

        l4=new JLabel("請輸入新密碼 : ");
        l4.setFont(new Font("標楷體", Font.PLAIN, 16));
        l4.setBounds(40,240,200,20);
        l4.setForeground(Color.orange);
        pf2=new JPasswordField();  
        pf2.setBounds(250,240,150,20);
        
        l5=new JLabel("請再次輸入新密碼確認 : ");
        l5.setFont(new Font("標楷體", Font.PLAIN, 16));
        l5.setBounds(40,300,200,20);
        l5.setForeground(Color.orange);
        pf3=new JPasswordField();  
        pf3.setBounds(250,300,150,20);
  
        b1=new JButton("修改完成返回系統"); 
        b1.setFont(new Font("標楷體", Font.PLAIN, 16));
        b1.setBounds(40,360,180,20);  
        b1.addActionListener(this);   
        
        b2=new JButton("離開"); 
        b2.setFont(new Font("標楷體", Font.PLAIN, 16));
        b2.setBounds(460,520,100,20);  
        b2.addActionListener(this);
               
        getContentPane().add(l1);getContentPane().add(l2);getContentPane().add(l3);getContentPane().add(l4);getContentPane().add(l5);
        getContentPane().add(tf1);
        getContentPane().add(pf1);getContentPane().add(pf2);getContentPane().add(pf2);getContentPane().add(pf3);
        getContentPane().add(b1);getContentPane().add(b2);
        setSize(600,600);
        setLocationRelativeTo(null);
    	ctpane = getContentPane();
    	ctpane.setBackground(new Color(204, 255, 204));
        getContentPane().setLayout(null);  
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }  

    public static void UpdatePwd(String name, String pwd) {
    	Connection conn = null;
 	    Statement stmt = null;
 	    
    	try{
           	Class.forName("com.mysql.cj.jdbc.Driver");
           	conn = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_b34224e1adfc18a?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8","b8a24d218a0919","d4d1d");
            stmt = conn.createStatement(); 
            
            String Uppwd = "update vip set vpass='"+pwd+"' where vipid = '"+name+"'"; 
            stmt.executeUpdate(Uppwd); 

            stmt.close();
            conn.close();
         
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
    	 java.net.URL imgURL = ChgPwd.class.getResource("/res/login.jpg");
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
    
    public void actionPerformed(ActionEvent e){ 
    	String s1 = tf1.getText();
    	String p1 = new String(pf1.getPassword());
    	String p2 = new String(pf2.getPassword());
    	String p3 = new String(pf3.getPassword());
    	String msg = "";
    	boolean usrchk = Login.LoginChk(s1,p1);

          if(e.getSource() == b1) {
              if (usrchk == false)
        		  JOptionPane.showMessageDialog(this, msg+"  原使用者帳號或密碼輸入錯誤 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else if (NewUsr.RuleChk(8,p2) == false)
        	      JOptionPane.showMessageDialog(this, msg+"  密碼不符規定，請重新輸入 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else if (s1.equals(p2))
        	      JOptionPane.showMessageDialog(this, msg+"  密碼不可設定與帳號相同，請重新輸入 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else if (p2.equals(p1))  
        	      JOptionPane.showMessageDialog(this, msg+"  新密碼與舊密碼重複，請重新輸入 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else if (p2.equals(p3) == false)  
        	      JOptionPane.showMessageDialog(this, msg+"  新密碼再次確認錯誤，請檢查 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
        	  else { 
        		      UpdatePwd(s1,p2); 
         	    	  this.dispose();
         	    	  new Login();
                  }
              }
          if(e.getSource() == b2) {
        	  this.dispose();
 	    	  new Login(); 
          }
  	
    }   

	public static void main(String[] args) { 
		new ChgPwd();   
	}  
} 
