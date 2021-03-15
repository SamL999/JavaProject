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
        JFrame f= new JFrame("�q�v��ƺ��@");    
        JPanel panel=new JPanel();  
        JButton b1,b2,b3,b4,b5;
        JLabel l1,l2,l3,l4;
	    JTextField tf1,tf2,tf3,tf4;
	    Vector rowData,columnNames;
        
		l1 = new JLabel("�s��");
		l1.setBounds(360, 40, 46, 21);
		l1.setForeground(Color.white);
		l1.setFont(new Font("�L�n������", Font.BOLD, 13));	
		l2 = new JLabel("�q�v�W��");
		l2.setBounds(360, 70, 52, 21);
		l2.setForeground(Color.white);
		l2.setFont(new Font("�L�n������", Font.BOLD, 13));		
		l3 = new JLabel("�W�M��");
		l3.setBounds(360, 100, 46, 21);
		l3.setForeground(Color.white);
		l3.setFont(new Font("�L�n������", Font.BOLD, 13));		
		l4 = new JLabel("�����ɦW");
		l4.setBounds(360, 130, 52, 21);
		l4.setForeground(Color.white);
		l4.setFont(new Font("�L�n������", Font.BOLD, 13));		
		
        tf1=new JTextField();
        tf1.setBounds(420, 40, 140, 21);
        tf1.setEditable(false);
        tf2=new JTextField();
        tf2.setBounds(420, 70, 140, 21);
        tf3=new JTextField();
        tf3.setBounds(420, 100, 140, 21);
        tf4=new JTextField();
        tf4.setBounds(420, 130, 140, 21);		
        
        
		b1 = new JButton("�s�W");
		b1.setBounds(370, 260, 90, 26);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("�L�n������", Font.BOLD, 15));			
		b2 = new JButton("�ק�");
		b2.setBounds(480, 260, 90, 26);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("�L�n������", Font.BOLD, 15));		
		b3 = new JButton("�R��");
		b3.setBounds(370, 300, 90, 26);
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("�L�n������", Font.BOLD, 15));		
		b4 = new JButton("�^�W��");
		b4.setBounds(480, 300, 90, 26);	
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("�L�n������", Font.BOLD, 15));		
		b5 = new JButton("����");
		b5.setBounds(560, 100, 20, 21);				
	    
        panel.setBounds(20,30,330,300);    
        //panel.setBackground(Color.gray); 
        
		columnNames=new Vector();

		columnNames.add("�s��");
		columnNames.add("�q�v�W��");
		columnNames.add("�W�M��");
		columnNames.add("�����ɦW");
		
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
		
		//���o�o��table�����ҫ�
		TableColumnModel cModel = jt.getColumnModel();

		//���o�o��table�Y����쪺��T
		TableColumn columnid = cModel.getColumn(0);
		TableColumn columnname = cModel.getColumn(1);
		TableColumn columndate = cModel.getColumn(2);
		TableColumn columnimg = cModel.getColumn(3);

		//�ӧO�]�w���n���e��
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
        
        //�s�W
	    b1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           String s1=tf1.getText();  
	           String s2=tf2.getText(); 
	           String s3=tf3.getText();  
	           String s4=tf4.getText();
	             
	           
	           if ((s1.length()==0)&&(validateDateFormat(s3)!=null)) {

	       		try {
	       			
	       			//�R����jtable��Ƥ��e
        		    DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        		    for( int i = dm.getRowCount() - 1; i >= 0; i-- ) {
        		        dm.removeRow(i);        		       
        		    }
        		    
        		    DBconn();
	                st= con.createStatement();
	                
	                //�s�W���
                    String sql1="INSERT INTO movie (mname,playdate,mimg) VALUES ('"+ s2 +"','"+ s3 +"','"+ s4 +"');";
                    st.executeUpdate(sql1);
                    
                    //���s���Ƹ��Jjtable
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
        	        
        	        JOptionPane.showMessageDialog(null, "�s�W���\");                    
                    
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
	    
        //�ק�
	    b2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           String s1=tf1.getText();  
	           String s2=tf2.getText(); 
	           String s3=tf3.getText();  
	           String s4=tf4.getText();
	           
	           if ((s1.length()!=0)&&(validateDateFormat(s3)!=null)) {

	       		try {
	       			//�R����jtable��Ƥ��e
        		    DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        		    for( int i = dm.getRowCount() - 1; i >= 0; i-- ) {
        		        dm.removeRow(i);        		       
        		    }
        		    
        		    DBconn();
	                st= con.createStatement();
	                
	                //�ק���
                    String sql1="update movie set mname='"+ s2 +"',playdate='"+ s3 +"',mimg='"+ s4 +"' where mvid='"+ s1 +"'";
                    st.executeUpdate(sql1);

                    //���s���Ƹ��Jjtable
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
        	        
        	        JOptionPane.showMessageDialog(null, "�ק令�\");
                    
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
	    	    
	    
        //�R��
	    b3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           String s1=tf1.getText();  
	           
	           if (s1.length()!=0) {

	       		try {
	       			//�R����jtable��Ƥ��e
        		    DefaultTableModel dm = (DefaultTableModel) jt.getModel();
        		    for( int i = dm.getRowCount() - 1; i >= 0; i-- ) {
        		        dm.removeRow(i);        		       
        		    }	       			
	       			
        		    DBconn();
	                st= con.createStatement();
	                
	                //�R�����
                    String sql1="delete from movie where mvid='"+ s1 +"'";
                    st.executeUpdate(sql1);
                    
                    //���s���Ƹ��Jjtable
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
        	        
        	        JOptionPane.showMessageDialog(null, "�R�����\");
			
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
        
	    //���}
	    b4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	f.dispose(); 
	        	new Data_MGMT();	           
	        }
	    });	  
	    
	    //���Ѥ����J�W�M��
	    b5.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	Date dt = new Date();
	        	SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");	        	
	        	tf3.setText(dateFormat.format(dt));           
	        }
	    });
	    		

		//�]�w�p�ϥ�
		Image icon=Toolkit.getDefaultToolkit().getImage("Src/res/movie-icon07.jpg");
		f.setIconImage(icon);
		
		panel.add(sp);          
        f.add(panel);        
        f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);f.add(l1);f.add(l2);f.add(l3);f.add(l4);
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);
        
        //�]�w����
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
        //�ˬd�O�_������榡
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