import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;

public class Login extends JFrame implements ActionListener{  
	static Container ctpane;
	static String id;
	JLabel l, l1, l2, l3, l4, l5, l6, l7;  
    JButton b, b1, b2, b3, b4; 
    JTextField tf1, tf2;
    JPasswordField pf1, pf2;
    
    Login(){
    	setBgimg();
    	java.net.URL imgURL0 = Login.class.getResource("/res/movie-icon07.jpg");
    	Image icon=Toolkit.getDefaultToolkit().getImage(imgURL0);
		setIconImage(icon);
        l=new JLabel("燒腦電影訂票會員系統 ");  
        l.setFont(new Font("標楷體", Font.ITALIC, 22));
        l.setBounds(200,20,240,20);
        l.setForeground(Color.cyan);
        
        l1=new JLabel("1. 會員登入");
        l1.setFont(new Font("標楷體", Font.PLAIN, 16));
        l1.setBounds(20,80,100,20);
        l1.setForeground(Color.orange);
        
        l2=new JLabel("帳號  :  ");
        l2.setFont(new Font("標楷體", Font.PLAIN, 16));
        l2.setBounds(20,120,300,20);
        l2.setForeground(Color.orange);
        tf1=new JTextField();  
        tf1.setBounds(100,120,150,20);
        
        l3=new JLabel("密碼  :  ");
        l3.setFont(new Font("標楷體", Font.PLAIN, 16));
        l3.setBounds(300,120,300,20);
        l3.setForeground(Color.orange);
        pf1=new JPasswordField();  
        pf1.setBounds(380,120,150,20);

        b=new JButton("登入"); 
        b.setFont(new Font("標楷體", Font.PLAIN, 16));
        b.setBounds(40,160,100,20);  
        b.addActionListener(this);
      
        b1=new JButton("會員修改密碼"); 
        b1.setFont(new Font("標楷體", Font.PLAIN, 16));
        b1.setBounds(380,160,150,20);  
        b1.addActionListener(this);
        
        l4=new JLabel("2. 非會員");
        l4.setFont(new Font("標楷體", Font.PLAIN, 16));
        l4.setBounds(20,210,100,20);
        l4.setForeground(Color.RED);
        
        b2=new JButton("帳號申請"); 
        b2.setFont(new Font("標楷體", Font.PLAIN, 16));
        b2.setBounds(40,250,100,20);  
        b2.addActionListener(this);
        
        l5=new JLabel("3. 系統管理");
        l5.setFont(new Font("標楷體", Font.PLAIN, 16));
        l5.setBounds(20,300,100,20);
        l5.setForeground(Color.orange);
 
        l6=new JLabel("帳號  :  ");
        l6.setFont(new Font("標楷體", Font.PLAIN, 16));
        l6.setBounds(20,340,300,20);
        l6.setForeground(Color.orange);
        tf2=new JTextField();  
        tf2.setBounds(100,340,150,20);
        
        l7=new JLabel("密碼  :  ");
        l7.setFont(new Font("標楷體", Font.PLAIN, 16));
        l7.setBounds(300,340,300,20);
        l7.setForeground(Color.orange);
        pf2=new JPasswordField();  
        pf2.setBounds(380,340,150,20);
                
        b3=new JButton("登入系統管理"); 
        b3.setFont(new Font("標楷體", Font.PLAIN, 16));
        b3.setBounds(40,380,130,20);  
        b3.addActionListener(this);
                
        b4=new JButton("登出系統"); 
        b4.setFont(new Font("標楷體", Font.PLAIN, 16));
        b4.setBounds(240,450,100,20);  
        b4.addActionListener(this);        
               
        getContentPane().add(l);getContentPane().add(l1);getContentPane().add(l2);getContentPane().add(l3);
        getContentPane().add(l4);getContentPane().add(l5);getContentPane().add(l6);getContentPane().add(l7);
        getContentPane().add(tf1);getContentPane().add(tf2);
        getContentPane().add(pf1);getContentPane().add(pf2);
        getContentPane().add(b);getContentPane().add(b1);getContentPane().add(b2);getContentPane().add(b3);getContentPane().add(b4);
        setSize(600,600); 
        setLocationRelativeTo(null);
        ctpane = getContentPane();
    	ctpane.setBackground(new Color(204, 255, 255));
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
    	 java.net.URL imgURL = Login.class.getResource("/res/login.jpg");
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
    
    public static boolean LoginChk(String name, String pwd) {
        boolean LoginChk = false;
    	Connection conn = null;
 	    Statement stmt = null;

    	try{
           	Class.forName("com.mysql.cj.jdbc.Driver");
           	conn = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_b34224e1adfc18a?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8","b8a24d218a0919","d4d1d");
            stmt= conn.createStatement(); 
            ResultSet rs;
            
            String check = "SELECT vipid, vpass FROM vip WHERE vipid='"+name+"' AND vpass='"+pwd+"' "; 
            rs=stmt.executeQuery(check); 

            String dbusr = null;
            String dbpswd = null;

               if (rs.next())
                    {
            	       dbusr = rs.getString("vipid");
                       dbpswd = rs.getString("vpass");
                    } 
                       if(name.equals(dbusr) && pwd.equals(dbpswd))
                         {
                          rs.close();
                          stmt.close();
                          conn.close();
                          LoginChk = true;
                         }
             
                      else
                         { 
                           rs.close();
                           stmt.close();
                           conn.close();
                           LoginChk = false;
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
        return LoginChk;
    }
     
    public void actionPerformed(ActionEvent e){ 
      	String s1 = tf1.getText();
    	String p1 = new String(pf1.getPassword());
    	String s2 = tf2.getText();
    	String p2 = new String(pf2.getPassword());
    	String msg="";   	      
    	
    	if(e.getSource() == b) {
    		if (LoginChk(s1,p1) == false)
      	      JOptionPane.showMessageDialog(this,msg+"  帳號或密碼錯誤，無法登入 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
    		else {
    		  // JOptionPane.showMessageDialog(this,msg+"訂票系統建置中 ！", "系統訊息", JOptionPane.INFORMATION_MESSAGE);
        	  this.dispose();
  		      this.id = s1;
    	      new Buy();		
    	    }
    	}
    	if (e.getSource() == b1) {
    		this.dispose();
    	    new ChgPwd();
    	}
    	
    	if (e.getSource() == b2) {
    		this.dispose();
    	    new NewUsr();
    	}    
    	
    	if (e.getSource() == b3) {
    		if (s2.equals("admin888") == false)
          	  JOptionPane.showMessageDialog(this, msg+"  非系統管理員，請至會員登入 ！！！", "警示訊息", JOptionPane.ERROR_MESSAGE);
    		else if (LoginChk(s2,p2) == false)
        	  JOptionPane.showMessageDialog(this, msg+"  帳號或密碼錯誤，無法登入系統管理 ！ ", "錯誤訊息", JOptionPane.WARNING_MESSAGE);
      		else {
      		  // newJOptionPane.showMessageDialog(this, msg+"後台管理系統建置中 ！", "系統訊息", JOptionPane.INFORMATION_MESSAGE);
      			this.dispose();
    	        new Data_MGMT();
      		}    
    	} 
    	
    	if (e.getSource() == b4) {
    		System.exit(0);	
    	}      	
    }   
    
    public static void main(String[] args) {  
        new Login();  
    }  
} 
