import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class movie_modify {  
	
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private JTable jt;
    
    String connectionURL = "jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_b34224e1adfc18a?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8";
	
     movie_modify()  
        {  
        JFrame f= new JFrame("電影資料維護");    
        JPanel panel=new JPanel();  
        JButton b1,b2,b3,b4,b5;
        JLabel l1,l2,l3,l4;
	    JTextField tf1,tf2,tf3,tf4;
	    Vector rowData,columnNames;
        
		l1 = new JLabel("編號");
		l1.setBounds(360, 40, 46, 21);
		l1.setForeground(Color.white);
		l1.setFont(new Font("微軟正黑體", Font.BOLD, 13));	
		l2 = new JLabel("電影名稱");
		l2.setBounds(360, 70, 52, 21);
		l2.setForeground(Color.white);
		l2.setFont(new Font("微軟正黑體", Font.BOLD, 13));		
		l3 = new JLabel("上映日");
		l3.setBounds(360, 100, 46, 21);
		l3.setForeground(Color.white);
		l3.setFont(new Font("微軟正黑體", Font.BOLD, 13));		
		l4 = new JLabel("海報檔名");
		l4.setBounds(360, 130, 52, 21);
		l4.setForeground(Color.white);
		l4.setFont(new Font("微軟正黑體", Font.BOLD, 13));		
		
        tf1=new JTextField();
        tf1.setBounds(420, 40, 140, 21);
        tf1.setEditable(false);
        tf2=new JTextField();
        tf2.setBounds(420, 70, 140, 21);
        tf3=new JTextField();
        tf3.setBounds(420, 100, 140, 21);
        tf4=new JTextField();
        tf4.setBounds(420, 130, 140, 21);		
        
        
		b1 = new JButton("新增");
		b1.setBounds(370, 260, 90, 26);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("微軟正黑體", Font.BOLD, 15));			
		b2 = new JButton("修改");
		b2.setBounds(480, 260, 90, 26);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("微軟正黑體", Font.BOLD, 15));		
		b3 = new JButton("刪除");
		b3.setBounds(370, 300, 90, 26);
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("微軟正黑體", Font.BOLD, 15));		
		b4 = new JButton("回上頁");
		b4.setBounds(480, 300, 90, 26);	
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("微軟正黑體", Font.BOLD, 15));		
		b5 = new JButton("今日");
		b5.setBounds(560, 100, 20, 21);				
	    
        panel.setBounds(20,30,330,300);    
        //panel.setBackground(Color.gray); 
        
		columnNames=new Vector();

		columnNames.add("編號");
		columnNames.add("電影名稱");
		columnNames.add("上映日");
		columnNames.add("海報檔名");
		
		rowData = new Vector();	
		
		try {        	
			DBconn();
            st= con.createStatement();
            
            String query = "select * from movie";
            rs = st.executeQuery(query);
			
			while(rs.next()){
				
				Vector hang=new Vector();
				hang.add(rs.getInt(1));
				hang.add(rs.getString(2));
				hang.add(rs.getDate(3));
				hang.add(rs.getString(4));

				rowData.add(hang);
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
		        

		jt=new JTable(rowData,columnNames); 
		
		jt.setPreferredScrollableViewportSize(new Dimension(320, 270));
		//jt.setBounds(0,0,200,200);  
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//jt.setDefaultRenderer(Object.class, new TableStyle());
		JScrollPane sp=new JScrollPane(jt);    
		
		//取得這個table的欄位模型
		TableColumnModel cModel = jt.getColumnModel();

		//取得這個table某個欄位的資訊
		TableColumn columnid = cModel.getColumn(0);
		TableColumn columnname = cModel.getColumn(1);
		TableColumn columndate = cModel.getColumn(2);
		TableColumn columnimg = cModel.getColumn(3);

		//個別設定偏好的寬度
		columnid.setPreferredWidth(40);
		columnname.setPreferredWidth(120);
		columndate.setPreferredWidth(80);
		columnimg.setPreferredWidth(80);
		
        jt.setCellSelectionEnabled(true);  
        ListSelectionModel select= jt.getSelectionModel();  
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  

        jt.addMouseListener(new java.awt.event.MouseAdapter() { 
            @Override 
            public void mouseClicked(java.awt.event.MouseEvent evt) { 
             int row = jt.rowAtPoint(evt.getPoint()); 
             int col = jt.columnAtPoint(evt.getPoint()); 
             
             tf1.setText(jt.getValueAt(row, 0).toString());
             tf2.setText(jt.getValueAt(row, 1).toString());
             tf3.setText(jt.getValueAt(row, 2).toString());
             tf4.setText(jt.getValueAt(row, 3).toString());
                          
            } 
        });
        
        //新增
	    b1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           String s1=tf1.getText();  
	           String s2=tf2.getText(); 
	           String s3=tf3.getText();  
	           String s4=tf4.getText();
	             
	           
	           if ((s1.length()==0)&&(validateDateFormat(s3)!=null)) {

	       		try {
	       			
	       			//刪除掉jtable資料內容
        		    DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        		    for( int i = dm.getRowCount() - 1; i >= 0; i-- ) {
        		        dm.removeRow(i);        		       
        		    }
        		    
        		    DBconn();
	                st= con.createStatement();
	                
	                //新增資料
                    String sql1="INSERT INTO movie (mname,playdate,mimg) VALUES ('"+ s2 +"','"+ s3 +"','"+ s4 +"');";
                    st.executeUpdate(sql1);
                    
                    //重新把資料載入jtable
                    String query = "select * from movie";
                    rs = st.executeQuery(query);
        			
        			while(rs.next()){
        				
        				Vector hang=new Vector();
        				hang.add(rs.getInt(1));
        				hang.add(rs.getString(2));
        				hang.add(rs.getDate(3));
        				hang.add(rs.getString(4));

        				rowData.add(hang);
        			}        			        			
        			
        			jt=new JTable(rowData,columnNames);         			        			     
        			JScrollPane sp=new JScrollPane(jt);
        			panel.add(sp);          
        	        f.add(panel);
        	        
        	        JOptionPane.showMessageDialog(null, "新增成功");                    
                    
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
	           } else {
	        	 tf1.setText("");
	        	 tf2.setText("");
	        	 tf3.setText("");
	        	 tf4.setText("");
	           }
	           
	        }
	    });
	    
        //修改
	    b2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           String s1=tf1.getText();  
	           String s2=tf2.getText(); 
	           String s3=tf3.getText();  
	           String s4=tf4.getText();
	           
	           if ((s1.length()!=0)&&(validateDateFormat(s3)!=null)) {

	       		try {
	       			//刪除掉jtable資料內容
        		    DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        		    for( int i = dm.getRowCount() - 1; i >= 0; i-- ) {
        		        dm.removeRow(i);        		       
        		    }
        		    
        		    DBconn();
	                st= con.createStatement();
	                
	                //修改資料
                    String sql1="update movie set mname='"+ s2 +"',playdate='"+ s3 +"',mimg='"+ s4 +"' where mvid='"+ s1 +"'";
                    st.executeUpdate(sql1);

                    //重新把資料載入jtable
                    String query = "select * from movie";
                    rs = st.executeQuery(query);
        			
        			while(rs.next()){
        				
        				Vector hang=new Vector();
        				hang.add(rs.getInt(1));
        				hang.add(rs.getString(2));
        				hang.add(rs.getDate(3));
        				hang.add(rs.getString(4));

        				rowData.add(hang);
        			}        			        			
        			
        			jt=new JTable(rowData,columnNames);         			        			     
        			JScrollPane sp=new JScrollPane(jt);
        			panel.add(sp);          
        	        f.add(panel); 
        	        
        	        JOptionPane.showMessageDialog(null, "修改成功");
                    
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
	           } 
	           
	        }
	    });
	    	    
	    
        //刪除
	    b3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           String s1=tf1.getText();  
	           
	           if (s1.length()!=0) {

	       		try {
	       			//刪除掉jtable資料內容
        		    DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        		    for( int i = dm.getRowCount() - 1; i >= 0; i-- ) {
        		        dm.removeRow(i);        		       
        		    }	       			
	       			
        		    DBconn();
	                st= con.createStatement();
	                
	                //刪除資料
                    String sql1="delete from movie where mvid='"+ s1 +"'";
                    st.executeUpdate(sql1);
                    
                    //重新把資料載入jtable
                    String query = "select * from movie";
                    rs = st.executeQuery(query);
        			
        			while(rs.next()){
        				
        				Vector hang=new Vector();
        				hang.add(rs.getInt(1));
        				hang.add(rs.getString(2));
        				hang.add(rs.getDate(3));
        				hang.add(rs.getString(4));

        				rowData.add(hang);
        			}        			        			
        			
        			jt=new JTable(rowData,columnNames);         			        			     
        			JScrollPane sp=new JScrollPane(jt);
        			panel.add(sp);          
        	        f.add(panel);    
        	        
        	        JOptionPane.showMessageDialog(null, "刪除成功");
			
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

	           }
	           
	        }
	    });	    
        
	    //離開
	    b4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	f.dispose(); 
	        	new Data_MGMT();	           
	        }
	    });	  
	    
	    //今天日期放入上映日
	    b5.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	Date dt = new Date();
	        	SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");	        	
	        	tf3.setText(dateFormat.format(dt));           
	        }
	    });
	    		

		//設定小圖示
		Image icon=Toolkit.getDefaultToolkit().getImage("Src/res/movie-icon07.jpg");
		f.setIconImage(icon);
		
		panel.add(sp);          
        f.add(panel);        
        f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);f.add(l1);f.add(l2);f.add(l3);f.add(l4);
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);
        
        //設定底圖
	    ImageIcon icon1 = new ImageIcon("Src/res/new.jpg");
	    JLabel label = new JLabel(icon1);
	    f.getContentPane().add(label);	 
	    f.pack();        
  
        f.setSize(620,420);    
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }  
     
        public static void main(String args[]) {  
          new movie_modify();  
        }  
        
        public class TableStyle extends DefaultTableCellRenderer{
        	public TableStyle(){
        		setHorizontalAlignment(CENTER);
        	}	
        }  
        //檢查是否為日期格式
        public Date validateDateFormat(String dateToValdate) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");          
            formatter.setLenient(false);
            Date parsedDate = null;
            try {
                parsedDate = formatter.parse(dateToValdate);
               // System.out.println(formatter.format(parsedDate));

            } catch (ParseException e) {
                //Handle exception
            }
            return parsedDate;
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