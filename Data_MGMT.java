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
		
        JFrame f= new JFrame("��ƺ޲z");  
        JButton b1,b2,b3,b4;
            
		b1 = new JButton("�|����ƺ��@");
		b1.setBounds(40, 20, 150, 36);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("�L�n������", Font.BOLD, 14));		
		b2 = new JButton("�q�v��ƺ��@");
		b2.setBounds(40, 70, 150, 36);
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("�L�n������", Font.BOLD, 14));		
		b3 = new JButton("�q����Ƭd��");
		b3.setBounds(40, 120, 150, 36);
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("�L�n������", Font.BOLD, 14));
		b4 = new JButton("�^�W��");
		b4.setBounds(40, 170, 150, 36);
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("�L�n������", Font.BOLD, 14));		
		
	    //�|����ƺ��@
	    b1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	f.dispose(); 
	        	new Usr_modify();         
	        }
	    });		
		
	    //�q�v��ƺ��@
	    b2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	f.dispose(); 
	        	new movie_modify();            
	        }
	    });
	    
	    
	    //�q����
	    b3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	f.dispose(); 
	        	new order_view();            
	        }
	    });	    
	    
		
	    //�^�W��
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

		//�]�w�p�ϥ�
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