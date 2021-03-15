import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

public class Buy extends JFrame {
	static int mby,cby,aby;
	static String data,data1,data2,ab2,s1,s2;
	static Container ctpane;
    private Connection con;
    
    private Statement st;
    private ResultSet rs;

    static JComboBox<ArrayList> cb;
     
    String connectionURL = "jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_b34224e1adfc18a?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8";
    
	    Buy() {
	    
	     JFrame f= new JFrame("電影購票");
	          
	    JLabel NLl = new JLabel("親愛的會員:"+Login.id);
			NLl.setForeground(Color.white);
			NLl.setFont(new Font("微軟正黑體", Font.BOLD, 16));
			NLl.setBounds(40, 20, 200, 30); 
		
		JLabel NL_l = new JLabel("選擇電影");
		    NL_l.setForeground(Color.WHITE);
		    NL_l.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    NL_l.setBounds(40, 60, 90, 30);
		
		
		JLabel NLl_2 = new JLabel("選擇日期");
		    NLl_2.setForeground(Color.WHITE);
		    NLl_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    NLl_2.setBounds(40, 100, 90, 30);
	
		
		JLabel NLl_3 = new JLabel("選擇時段");
		    NLl_3.setForeground(Color.WHITE);
		    NLl_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    NLl_3.setBounds(40, 140, 90, 30);
		
		
		JLabel NLl_4 = new JLabel("電影票種類");
		    NLl_4.setForeground(Color.WHITE);
		    NLl_4.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    NLl_4.setBounds(40, 180, 90, 30);
		
		JLabel NLl_5 = new JLabel("應付金額");
		    NLl_5.setForeground(Color.WHITE);
		    NLl_5.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    NLl_5.setBounds(40, 280, 90, 30);
		
		JLabel NLl_6 = new JLabel("會員票");
		    NLl_6.setForeground(Color.WHITE);
		    NLl_6.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    NLl_6.setBounds(150, 180, 60, 30);
		
		JLabel NLl_7 = new JLabel("及張數");
		    NLl_7.setForeground(Color.WHITE);
		    NLl_7.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    NLl_7.setBounds(40, 220, 90, 30);
		
		JLabel NLl_8 = new JLabel("敬老票");
		    NLl_8.setForeground(Color.WHITE);
		    NLl_8.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    NLl_8.setBounds(150, 220, 120, 30);
		
		JLabel NLl_9 = new JLabel("張");
		    NLl_9.setForeground(Color.WHITE);
		    NLl_9.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    NLl_9.setBounds(300, 180, 28, 30);
		
		JLabel NLl_10 = new JLabel("張");
		    NLl_10.setForeground(Color.WHITE);
		    NLl_10.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		    NLl_10.setBounds(300, 220, 28, 30);		
		
		
		
		
	    
		//電影名稱從資料庫拿       
        ArrayList<String> mname1 = new ArrayList<String>();
         
		try {        	
			DBconn();
            st= con.createStatement();
            
            String query = "select * from movie";
            rs = st.executeQuery(query);            

			while(rs.next()){
				
				mname1.add(rs.getString(2));				
				cb=new JComboBox(mname1.toArray());
											
			}			
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
				rs.close();
				}
				if(st!=null){
					st.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		
        
		//String languages[]={"靈魂急轉彎","叱咤風雲","拆彈專家2","馬德里金庫盜數90分鐘","神力女超人1984","鬼滅之刃劇場版 無限列車篇","異種獵殺","俘虜"};        
		cb.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		cb.setBounds(150, 60, 250, 30);
		
		//日期改用今天取得一週
		String languages1[]=new String[7];		
        for (int i=0;i<7;i++) {
        	
        	Date dt = new Date();

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(dt);
            calendar.add(calendar.DATE,i);
            dt=calendar.getTime(); 
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            languages1[i] = formatter.format(dt);                  
        }

		//String languages1[]={"2021/01/20","2021/01/21","2021/01/22","2021/01/23","2021/01/24"};        
	    JComboBox cb1=new JComboBox(languages1); 
		cb1.setBounds(150, 100, 120, 30);
		
		JComboBox cBox_2 = new JComboBox();
		String languages2[]={"10:00","12:00","14:00","16:00","18:00","20:00","22:00","00:00"};        
	    JComboBox cb2=new JComboBox(languages2); 
		cb2.setBounds(150, 140, 100, 30);
		
		JComboBox cBox_3 = new JComboBox();
		String languages3[]={"0","1","2","3","4","5","6","7","8","9"};        
	    JComboBox cb3=new JComboBox(languages3); 
		cb3.setBounds(210, 180, 80, 30);
		
		JComboBox cBox_4 = new JComboBox();
		String languages4[]={"0","1","2","3","4","5","6","7","8","9"};        
	    JComboBox cb4=new JComboBox(languages4); 
		cb4.setBounds(210, 220, 80, 30);
		
		JTextField tF_2 = new JTextField();
		tF_2.setBounds(150, 280, 100, 30);
		tF_2.setEditable(false);   
		
		
		
		JButton a=new JButton("試算金額");  
	     a.setBounds(260,280,100,30);
		
		JButton b=new JButton("結帳");  
	     b.setBounds(150,320,80,30);
	     
	     java.net.URL imgURL0 = Buy.class.getResource("/res/movie-icon07.jpg");
	     Image icon=Toolkit.getDefaultToolkit().getImage(imgURL0);
			f.setIconImage(icon);
			

		f.add(NLl);f.add(NL_l);f.add(NLl_2);
		f.add(NLl_3);f.add(NLl_4);f.add(NLl_5);
		f.add(NLl_6);f.add(NLl_7);f.add(NLl_8);
		f.add(NLl_9);f.add(NLl_10);
		f.add(tF_2);//f.add(tF_3);f.add(tF_4);
		f.add(cb);f.add(cb1);f.add(cb2);f.add(cb3);f.add(cb4);
		f.add(b);f.add(a);
		
		//設定底圖
		java.net.URL imgURL1 = Buy.class.getResource("/res/login.jpg");
	    ImageIcon icon1 = new ImageIcon(imgURL1);
	    JLabel label = new JLabel(icon1);
	    f.getContentPane().add(label);	 
	    f.pack();        
  
        f.setSize(450,700);    
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
        
       a.addActionListener(new ActionListener() {  
    	    public void actionPerformed(ActionEvent e) { 
    		     s1=""+cb3.getItemAt(cb3.getSelectedIndex());
    		     s2=""+cb4.getItemAt(cb4.getSelectedIndex()); 
    		     mby=Integer.parseInt(s1);  
    		     cby=Integer.parseInt(s2);  
    		     aby=0;  
    		     aby= mby*320+cby*240;
    		     ab2=String.valueOf(aby);  
    		     tF_2.setText(ab2);  
    	    }
       
    	    }); 
       
	        
	    b.addActionListener(new ActionListener() {  
	    public void actionPerformed(ActionEvent e) { 
	    	
		     data =""+cb.getItemAt(cb.getSelectedIndex()); 
		     data1 =""+cb1.getItemAt(cb1.getSelectedIndex()); 
		     data2 =""+cb2.getItemAt(cb2.getSelectedIndex());
		     s1=""+cb3.getItemAt(cb3.getSelectedIndex());
		     s2=""+cb4.getItemAt(cb4.getSelectedIndex()); 
		     mby=Integer.parseInt(s1);  
		     cby=Integer.parseInt(s2);  
		     aby=0;  
		     aby= mby*320+cby*240;
		     ab2=String.valueOf(aby);  
		     tF_2.setText(ab2);  
		     
		     
		     //訂票資料寫入資料庫
	         try {	        		    
        	    DBconn();
	            st= con.createStatement();
	            
	            if (mby > 0 ) {	                	
	            	String sql1="INSERT INTO morder(mname,vipid,odate,operiod,tname,tunit,tamount) VALUES('"+ data +"','"+ Login.id +"','"+ data1 +"','"+ data2 +"','會員票','"+ mby +"','"+ mby*500 +"');";
	            	st.executeUpdate(sql1);	            	   	                
	            }
	            
	            if (cby > 0 ) {		            	
	                String sql2="INSERT INTO morder(mname,vipid,odate,operiod,tname,tunit,tamount) VALUES('"+ data +"','"+ Login.id +"','"+ data1 +"','"+ data2 +"','敬老票','"+ cby +"','"+ cby*320 +"');";
	                st.executeUpdate(sql2);	                  
	            }
                                       
		      } catch (Exception e1) {
		 		  e1.printStackTrace();
		      } finally {	   			
		   		try {
		  			if(rs!=null){
		  			rs.close();
		  			}
					if(st!=null){
					st.close();
		 			}
					if(con!=null){
						con.close();
					}
	   			} catch (SQLException e1) {
		   			e1.printStackTrace();
				}                
		 	 }   
		     
	         f.dispose();
		     new Buy2();		
		   
			}


			}); 
 
       }  
	    
	    
	public static void main(String[] args) {
		new Buy(); 
	}
	
    public void DBconn(){
  	   try {
  		   		// Load the database driver
  		    	Class.forName("com.mysql.cj.jdbc.Driver");     		    
  		    	con = DriverManager.getConnection(connectionURL, "b8a24d218a0919","d4d1d"); 
  		    }catch(Exception e){
  		    	System.out.println("Exception is ;"+e);
  		    }	   
  	   
     }
       }
	    