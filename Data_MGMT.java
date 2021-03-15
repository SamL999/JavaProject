import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Data_MGMT {
	
	Data_MGMT() {
		
        JFrame f= new JFrame("資料管理");  
        JButton b1,b2,b3,b4;
            
		b1 = new JButton("會員資料維護");
		b1.setBounds(40, 20, 150, 36);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("微軟正黑體", Font.BOLD, 14));		
		b2 = new JButton("電影資料維護");
		b2.setBounds(40, 70, 150, 36);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("微軟正黑體", Font.BOLD, 14));		
		b3 = new JButton("訂票資料查詢");
		b3.setBounds(40, 120, 150, 36);
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		b4 = new JButton("回上頁");
		b4.setBounds(40, 170, 150, 36);
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("微軟正黑體", Font.BOLD, 14));		
		
	    //會員資料維護
	    b1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	f.dispose(); 
	        	new Usr_modify();         
	        }
	    });		
		
	    //電影資料維護
	    b2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	f.dispose(); 
	        	new movie_modify();            
	        }
	    });
	    
	    
	    //訂單資料
	    b3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	f.dispose(); 
	        	new order_view();            
	        }
	    });	    
	    
		
	    //回上頁
	    b4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {	         
	        	f.dispose(); 
	        	new Login();          
	        }
	    });	 		
	    
	    
        f.getContentPane().setForeground(new Color(0, 128, 128));
	    f.getContentPane().setBackground(new Color(0, 128, 128));
		f.getContentPane().setVisible(true);		

		//設定小圖示
		java.net.URL imgURL0 = Data_MGMT.class.getResource("/res/movie-icon07.jpg");
		Image icon=Toolkit.getDefaultToolkit().getImage(imgURL0);
		f.setIconImage(icon);
		
        f.add(b1);f.add(b2);f.add(b3);f.add(b4);      
		
        f.setSize(260,270);    
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
                
		
	}

	public static void main(String[] args) {
	    new Data_MGMT();
	}
	
}