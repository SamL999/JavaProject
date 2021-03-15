import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class Usr_modify  {

	JTextField add_t1,add_t2,add_t3,add_t4;
	private Vector<String> dataTitle = new Vector<String>();//表格列名
	private Vector<Vector<String>> data = new Vector<Vector<String>>();//表格單元格內容
	JTable jt;
	Connection con =null;
	PreparedStatement ps;
	DefaultTableModel tableModel;
	
	
	Usr_modify()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_b34224e1adfc18a?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","b8a24d218a0919","d4d1d");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
	   tableModel=new DefaultTableModel();

	  JFrame frame2 = new JFrame("會員後台資料庫");
	  
	  JLabel add_l1=new JLabel("帳號：");//標籤欄位設定
	  JLabel add_l2=new JLabel("密碼："); 
	  JLabel add_l3=new JLabel("姓名："); 
	  JLabel add_l4=new JLabel("電話："); 
	  add_l1.setBounds(520,100, 100,25); 
	  add_l2.setBounds(520,150, 100,25); 
	  add_l3.setBounds(520,200, 100,25);
	  add_l4.setBounds(520,250, 100,25);
	  add_l1.setForeground(Color.black);
	  add_l1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	  add_l2.setForeground(Color.black);
	  add_l2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	  add_l3.setForeground(Color.black);
	  add_l3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	  add_l4.setForeground(Color.black);
	  add_l4.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	  
	  add_t1=new JTextField(); //填寫欄位設定
	  add_t2=new JTextField(); 
	  add_t3=new JTextField(); 
	  add_t4=new JTextField();
	  add_t1.setBounds(580,100, 100,25);  
	  add_t2.setBounds(580,150, 100,25); 
	  add_t3.setBounds(580,200, 100,25); 
	  add_t4.setBounds(580,250, 100,25); 
	  
	  JButton add_b1=new JButton("新增"); //按鈕欄位設定
	  JButton add_b2=new JButton("修改");
	  JButton add_b3=new JButton("刪除"); 
	  JButton add_b4=new JButton("回上一頁"); 
	  add_b1.setBounds(480,300,60,30); //按鈕位置大小設定 
	  add_b2.setBounds(550,300,60,30);
	  add_b3.setBounds(620,300,60,30);
	  add_b4.setBounds(690,300,60,30);
	  add_b1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));//按鈕字型大小設定
	  add_b2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	  add_b3.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	  add_b4.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
	  add_b1.setBorder(BorderFactory.createRaisedBevelBorder());//按鈕浮起設定
	  add_b2.setBorder(BorderFactory.createRaisedBevelBorder());
	  add_b3.setBorder(BorderFactory.createRaisedBevelBorder());
	  add_b4.setBorder(BorderFactory.createRaisedBevelBorder());
	  
	  dataTitle.add("帳號");//JTable的表頭
	  dataTitle.add("密碼");
	  dataTitle.add("姓名");
	  dataTitle.add("電話");
	  
	  tableModel = new DefaultTableModel(data, dataTitle);
	  jt = new JTable(tableModel);
	  jt.setBounds(15,40,400,400);
	  jt.setBackground(Color.lightGray);
	  jt.setCellSelectionEnabled(false);
	  jt.setRowSorter(new TableRowSorter<TableModel>(tableModel));
	  jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//為表格新增滑鼠事件監聽器(單擊事件)
	  JScrollPane sp=new JScrollPane(jt); 
	  JPanel panel=new JPanel(); 
	  panel.setBounds(15,50,450,400);
	  
	  		try {	
	  			ps = con.prepareStatement("SELECT * FROM vip");
				ResultSet rs = ps.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();                 
				int numberOfColumns=rsmd.getColumnCount(); //numberOfColumns=4         
				
			
				while(rs.next())  //以下是在表格中顯示資料中的內容                	
				{       			
					Vector<String> W = new Vector<String>();//重置w的內容
					int c=1; 
					while(c<=numberOfColumns) 
					{ 
						W.add(rs.getString(c));
						c++;
					}
					
					tableModel.addRow(W);  
				}   	
				
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
	  
	  		jt.addMouseListener(new MouseAdapter() //滑鼠點選JTable事件啟動
	  		{
	  			public void mouseClicked(MouseEvent e) {
	  			int selectRow = jt.getSelectedRow();//獲取滑鼠選擇行的索引值
	  			Object selectValues1 = jt.getValueAt(selectRow, 0);//獲取選擇的單元格的內容
	  			Object selectValues2 = jt.getValueAt(selectRow, 1);
	  			Object selectValues3 = jt.getValueAt(selectRow, 2);
	  			Object selectValues4 = jt.getValueAt(selectRow, 3);
	  			add_t1.setText(selectValues1.toString());//將單元格的內容顯示在文字框中
	  			add_t2.setText(selectValues2.toString());
	  			add_t3.setText(selectValues3.toString());
	  			add_t4.setText(selectValues4.toString());
	  			}
	  		});
	  		
	  		
	  //frame的設定如下
	  frame2.add(add_l1);frame2.add(add_l2);frame2.add(add_l3);frame2.add(add_l4);
	  frame2.add(add_t1);frame2.add(add_t2);frame2.add(add_t3);frame2.add(add_t4);
	  frame2.add(add_b1);frame2.add(add_b2);frame2.add(add_b3);frame2.add(add_b4);
	  panel.add(sp);
	  frame2.add(panel);
	  java.net.URL imgURL2 = Usr_modify.class.getResource("/res/new.jpg");
	  ImageIcon icon2 = new ImageIcon(imgURL2);//設定底圖
	  JLabel label = new JLabel(icon2);//設定底圖
//	  label.setBounds(0,0,100,100); 
	  frame2.getContentPane().add(label);
	  frame2.pack(); //設定frame最適大小
	  frame2.setSize(780,500);
	  frame2.setResizable(false);//設定frame不讓使用者調整大小
	  frame2.setLayout(null);
	  frame2.setVisible(true);
	  frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//按「x」可結束程式
	  java.net.URL imgURL0 = Usr_modify.class.getResource("/res/movie-icon07.jpg");
	  Image icon=Toolkit.getDefaultToolkit().getImage(imgURL0);//設定小圖示
	  frame2.setIconImage(icon);//設定小圖示
	  
		 
	
	  
	  
	add_b1.addActionListener(new ActionListener()//按下新增按鈕的功能
	{
		public void actionPerformed(ActionEvent e)
		{    
			if (verifText()) {
				String Newaccount = add_t1.getText();
				String Newpass = add_t2.getText();
				String Newname = add_t3.getText();
				String Newphone = add_t4.getText();
				
				
			try {
				ps = con.prepareStatement("INSERT INTO vip(vipid, vpass, vname,vmobile) VALUES (?,?,?,?)");
				ps.setString(1, Newaccount);
				ps.setString(2, Newpass);
				ps.setString(3, Newname);
				ps.setString(4, Newphone);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "新增成功");
				String[] addData = {add_t1.getText(), add_t2.getText(),add_t3.getText(),add_t4.getText()};//獲取文字框中的內容
				tableModel.addRow(addData);
				
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			}
		}
			
	});
	
	add_b2.addActionListener(new ActionListener()//按下修改按鈕的功能
	{
		public void actionPerformed(ActionEvent e)
		{    
			if (verifText()) {
			
			String Newaccount = add_t1.getText();
			String Newpass = add_t2.getText();
			String Newname= add_t3.getText();
			String Newphone = add_t4.getText();
			try {
				ps = con.prepareStatement("UPDATE vip SET vipid=?,vpass=?,vname=?,vmobile=? WHERE vipid=?");
				ps.setString(1, Newaccount);
				ps.setString(2, Newpass);
				ps.setString(3, Newname);
				ps.setString(4, Newphone);
				ps.setString(5, Newaccount);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "修改成功");
				int row = jt.getSelectedRow();// 獲得被選中行的索引
				tableModel.setValueAt(add_t1.getText(),row, 0);// 修改表格模型當中的指定值
				tableModel.setValueAt(add_t2.getText(),row, 1);// 修改表格模型當中的指定值
				tableModel.setValueAt(add_t3.getText(),row, 2);
				tableModel.setValueAt(add_t4.getText(),row, 3);
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			}
		}
			
	});
	
	add_b3.addActionListener(new ActionListener()//按下刪除按鈕的功能
			{
				public void actionPerformed(ActionEvent e)
				{    
					if (verifText()) {
					
					String Newaccount = add_t1.getText();

					try {
						ps = con.prepareStatement("DELETE FROM vip WHERE vipid = ?");
						ps.setString(1, Newaccount);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "刪除成功");
						int row = jt.getSelectedRow();// 獲得被選中行的索引
						tableModel.removeRow(row);//從表格模型中刪除
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					}
				}
					
			});
			
	add_b4.addActionListener(new ActionListener()//按下「回上一頁」按鈕的功能
			{
				public void actionPerformed(ActionEvent e)
				{    
					frame2.dispose(); //關閉這個frame
		        	new Data_MGMT();  //開啟
				}
					
			});
	
	
	
	
	}
	
	  public boolean verifText()//如果欄位有空值時跳出警示
	  {
		  if (add_t1.getText().equals("")||add_t2.getText().equals("")||add_t3.getText().equals("")||add_t4.getText().equals(""))
		  {
			  JOptionPane.showMessageDialog(null, "有未填寫的值，請填寫後再按確定");
			  return false;
		  }
		  else
		  {
			  return true; 
		  }  	
	  }
	
	
	  
	
	
	public static void main(String[] args) 
	{
		new Usr_modify();

	}

}