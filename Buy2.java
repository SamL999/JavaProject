import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Buy2 extends JFrame {
	JLabel NL2_1,NL2_2,NL2_3,NL2_4,NL2_5;	
	JLabel NL3,NL3_0,NL3_1,NL3_2,NL3_3,NL3_4,NL3_5;
	JLabel NL3_6,NL3_7,NL3_8,NL3_9,NL3_10,NL3_11;

   	Buy2() {
   		JFrame f= new JFrame("�ʲ����G");
   		
   		JLabel NL3 = new JLabel("�˷R���|��:"+Login.id+"�z�q��p�U");
   		NL3.setForeground(Color.WHITE);
		NL3.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3.setBounds(40, 20, 200, 30);
    	 
   		JLabel NL3_0 = new JLabel("�q�v");
   		NL3_0.setForeground(Color.WHITE);
   		NL3_0.setFont(new Font("�L�n������", Font.PLAIN, 16));
   		NL3_0.setBounds(40, 60, 90, 30);
		
		JLabel NL3_1 = new JLabel("���");
		NL3_1.setForeground(Color.WHITE);
		NL3_1.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3_1.setBounds(40, 100, 90, 30);
		
		JLabel NL3_2 = new JLabel("�ɬq");
		NL3_2.setForeground(Color.WHITE);
		NL3_2.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3_2.setBounds(40, 140, 90, 30);
		
		JLabel NL3_3 = new JLabel("�q�v������");
		NL3_3.setForeground(Color.WHITE);
		NL3_3.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3_3.setBounds(40, 180, 90, 30);
		
		JLabel NL3_4 = new JLabel("���I���B");
		NL3_4.setForeground(Color.WHITE);
		NL3_4.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3_4.setBounds(40, 280, 90, 30);
		
		JLabel NL3_5 = new JLabel("�|����"+Buy.mby+"�i");
		NL3_5.setForeground(Color.WHITE);
		NL3_5.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3_5.setBounds(150, 180, 120, 30);
	
		JLabel NL3_6 = new JLabel("�αi��");
		NL3_6.setForeground(Color.WHITE);
		NL3_6.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3_6.setBounds(40, 220, 90, 30);
		
		JLabel NL3_7 = new JLabel("�q�Ѳ�"+Buy.cby+"�i");
		NL3_7.setForeground(Color.WHITE);
		NL3_7.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3_7.setBounds(150, 220, 120, 30);
		
		JLabel NL3_8 = new JLabel("�@"+(Buy.mby*320)+"��");
		NL3_8.setForeground(Color.WHITE);
		NL3_8.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3_8.setBounds(280, 180, 100, 30);
		
		JLabel NL3_9 = new JLabel("�@"+(Buy.cby*240)+"��");
		NL3_9.setForeground(Color.WHITE);
		NL3_9.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3_9.setBounds(280, 220, 100, 30);
		
		JLabel NL3_10 = new JLabel("�`���B"+Buy.aby+"��");
		NL3_10.setForeground(Color.WHITE);
		NL3_10.setFont(new Font("�L�n������", Font.PLAIN, 16));
		NL3_10.setBounds(150, 280, 100, 30);
		
   		JLabel NL2_1 = new JLabel(Buy.data);
   		NL2_1.setForeground(Color.WHITE);
   		NL2_1.setFont(new Font("�L�n������", Font.PLAIN, 16));
   		NL2_1.setBounds(150, 60, 250, 30);
   		
   		JLabel NL2_2 = new JLabel(Buy.data1);
   		NL2_2.setForeground(Color.WHITE);
   		NL2_2.setFont(new Font("�L�n������", Font.PLAIN, 16));
   		NL2_2.setBounds(150, 100, 90, 30);
   		
   		JLabel NL2_3 = new JLabel(Buy.data2);
   		NL2_3.setForeground(Color.WHITE);
   		NL2_3.setFont(new Font("�L�n������", Font.PLAIN, 16));
   		NL2_3.setBounds(150, 140, 90, 30);
   		
   		JButton c=new JButton("�^����");  
	     c.setBounds(180,350,100,30);
		
		JButton d=new JButton("���}�t��");  
	     d.setBounds(300,600,100,30);
   		
   		
   		
   		
   		
	    java.net.URL imgURL0 = Buy2.class.getResource("/res/movie-icon07.jpg");
   		Image icon=Toolkit.getDefaultToolkit().getImage(imgURL0);
		f.setIconImage(icon);
		       
		
		f.add(NL2_1);f.add(NL2_2);f.add(NL2_3);
		f.add(NL3_1);f.add(NL3_2);f.add(NL3_3);
		f.add(NL3_4);f.add(NL3_5);f.add(NL3_6);
		f.add(NL3_7);f.add(NL3_8);f.add(NL3_9);
		f.add(NL3);f.add(NL3_0);f.add(NL3_10);
		f.add(c);f.add(d);
		
		//�]�w����
		java.net.URL imgURL1 = Buy2.class.getResource("/res/login.jpg");
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
        
        c.addActionListener(new ActionListener() {  
    	    public void actionPerformed(ActionEvent e) { 
    	    	new Start01();
    	    }
       
    	    }); 

	    	
   	    d.addActionListener(new ActionListener() {  
	    public void actionPerformed(ActionEvent e) { 
	    	System.exit(0);	
	    }
   
	    }); 

    } 	
	public static void main(String[] args) {
     
	 new Buy2();		
	 
	}
}
