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


public class order_view {  
	
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private JTable jt;
    
    String connectionURL = "jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_b34224e1adfc18a?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8";
	
     order_view()  
        {  
        JFrame f= new JFrame("訂票資料查詢");    
        JPanel panel=new JPanel();  
        JButton b4;
	    Vector rowData,columnNames;
        
		b4 = new JButton("回上頁");
		b4.setBounds(300, 340, 90, 26);	
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("微軟正黑體", Font.BOLD, 15));		
			    
        panel.setBounds(20,20,630,300);    
        //panel.setBackground(Color.gray); 
        
		columnNames=new Vector();

		columnNames.add("訂單編號");
		columnNames.add("電影名稱");
		columnNames.add("帳號");
		columnNames.add("日期");
		columnNames.add("時段");
		columnNames.add("票種");
		columnNames.add("張數");
		columnNames.add("金額");
		
		rowData = new Vector();	
		
		try {        	
			DBconn();
            st= con.createStatement();
            
            String query = "select * from morder";
            rs = st.executeQuery(query);
			
			while(rs.next()){
				
				Vector hang=new Vector();
				hang.add(rs.getInt(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getDate(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getInt(7));
				hang.add(rs.getInt(8));

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
		
		jt.setPreferredScrollableViewportSize(new Dimension(615, 270));
		//jt.setBounds(0,0,200,200);  
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.setDefaultRenderer(Object.class, new TableStyle());
		JScrollPane sp=new JScrollPane(jt);    
		
		//取得這個table的欄位模型
		TableColumnModel cModel = jt.getColumnModel();

		//取得這個table某個欄位的資訊
		TableColumn columnid = cModel.getColumn(0);
		TableColumn columnname = cModel.getColumn(1);
		TableColumn columnvid = cModel.getColumn(2);
		TableColumn columndate = cModel.getColumn(3);
		TableColumn columntime = cModel.getColumn(4);
		TableColumn columntname = cModel.getColumn(5);
		TableColumn columnunit = cModel.getColumn(6);
		TableColumn columnamount = cModel.getColumn(7);		

		//個別設定偏好的寬度
		columnid.setPreferredWidth(55);
		columnname.setPreferredWidth(160);
		columnvid.setPreferredWidth(80);
		columndate.setPreferredWidth(80);
		columntime.setPreferredWidth(60);
		columntname.setPreferredWidth(60);
		columnunit.setPreferredWidth(60);
		columnamount.setPreferredWidth(60);		
		
        jt.setCellSelectionEnabled(true);  
        ListSelectionModel select= jt.getSelectionModel();  
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  


	    //離開
	    b4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	f.dispose(); 
	        	new Data_MGMT();	           
	        }
	    });	  	        		

		//設定小圖示
	    java.net.URL imgURL0 = NewUsr.class.getResource("/res/movie-icon07.jpg");
		Image icon=Toolkit.getDefaultToolkit().getImage(imgURL0);
		f.setIconImage(icon);
		
		panel.add(sp);          
        f.add(panel);        
        f.add(b4);        
        
        //設定底圖
	    ImageIcon icon1 = new ImageIcon("Src/res/new.jpg");
	    JLabel label = new JLabel(icon1);
	    f.getContentPane().add(label);	 
	    f.pack();        
  
        f.setSize(700,425);    
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }  
     
        public static void main(String args[]) {  
          new order_view();  
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
        
        public class TableStyle extends DefaultTableCellRenderer{
        	public TableStyle(){
        		setHorizontalAlignment(CENTER);
        	}	
        }  
        

    }  