import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.io.IOException;
import javax.print.DocFlavor.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
	
//private JPanel contentPane;
	
	public class Start01 extends JFrame implements ActionListener{       //�~��JFrame��
		JButton b9;
		
		Start01 () {
			getContentPane().setForeground(new Color(0, 128, 128));
			getContentPane().setFont(new Font("�L�n������ Light", Font.BOLD, 13));
			getContentPane().setBackground(new Color(0, 128, 128));
			getContentPane().setLayout(null);	//����G��

			//�ݭn���Ϥ�
			java.net.URL imgURL1 = Start01.class.getResource("/res/Hospital_180x270_Poster.jpg");
			ImageIcon i1 = new ImageIcon(imgURL1);
			java.net.URL imgURL2 = Start01.class.getResource("/res/KEEPROLLING_180x270_Poster.jpg");
			ImageIcon i2 = new ImageIcon(imgURL2);
			java.net.URL imgURL3 = Start01.class.getResource("/res/KimetsunoYaibaMugenResshaHenNEW_180x270_Poster.jpg");
			ImageIcon i3 = new ImageIcon(imgURL3);
			java.net.URL imgURL4 = Start01.class.getResource("/res/MissAndy_180x270_Poster.jpg");
			ImageIcon i4 = new ImageIcon(imgURL4);
			java.net.URL imgURL5 = Start01.class.getResource("/res/MyMissingValentine_180x270_Poster.jpg");
			ImageIcon i5 = new ImageIcon(imgURL5);
			java.net.URL imgURL6 = Start01.class.getResource("/res/ShockWave2new_180x270_Poster.jpg");
			ImageIcon i6 = new ImageIcon(imgURL6);
			java.net.URL imgURL7 = Start01.class.getResource("/res/Souldate_180x270_Poster.jpg");
			ImageIcon i7 = new ImageIcon(imgURL7);
			java.net.URL imgURL8 = Start01.class.getResource("/res/THEGERMANLESSON_180x270_Poster.jpg");
			ImageIcon i8 = new ImageIcon(imgURL8);
						
			Container c = getContentPane();	//����@�Ӯe��

			
			
			//���s����
			JButton b1 = new JButton("");
			/*b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object[] options = { "�O", "����" };
			
					JOptionPane.showOptionDialog(null, "�z���s�����L����", "�K�ߴ���",  JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE,  null, options, options[0]);
				
				
				}
			});*/
			b1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try {
					Process process = runtime.exec("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE https://www.youtube.com/watch?v=5MT9rJp-lFY");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				});
						
			
			JButton b2 = new JButton("");
			b2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try {
					Process process = runtime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\CHROME.EXE https://www.youtube.com/watch?v=7QB0tc6agK0");
					//"C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE https://www.youtube.com/watch?v=7QB0tc6agK0"
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				});
			JButton b3 = new JButton("");
			b3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try {
					Process process = runtime.exec("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE https://www.youtube.com/watch?v=4bXKIFVzHJs");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				});
			
			JButton b4 = new JButton("");
			b4.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try {
					Process process = runtime.exec("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE https://www.youtube.com/watch?v=fVl7qzqna1s");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				});
			JButton b5 = new JButton("");
			b5.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try {
					Process process = runtime.exec("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE https://www.youtube.com/watch?v=I0RCwJLTTeo");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				});
			JButton b6 = new JButton("");
			b6.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try {
					Process process = runtime.exec("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE https://www.youtube.com/watch?v=WBbpjsEi8xk");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				});
			JButton b7 = new JButton("");
			b7.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try {
					Process process = runtime.exec("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE https://www.youtube.com/watch?v=zXTVxkd9KUY");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				});
			JButton b8 = new JButton("");
			b8.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try {
					Process process = runtime.exec("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE https://www.youtube.com/watch?v=1rg5Gn3KxDk");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				});
			
			b9 = new JButton("�}�l�q��"); //�q���s��
			b9.setForeground(Color.BLACK);
			b9.setFont(new Font("�L�n������", Font.BOLD, 13));
			b9.addActionListener(this);
			
			//�]�w���s�j�p
			b1.setBounds(20, 40, 180, 270);
			b2.setBounds(220, 40, 180, 270);
			b3.setBounds(420, 40, 180, 270);
			b4.setBounds(620, 40, 180, 270);
			b5.setBounds(20, 330, 180, 270);
			b6.setBounds(220, 330, 180, 270);
			b7.setBounds(420, 330, 180, 270);
			b8.setBounds(620, 330, 180, 270);
			b9.setBounds(360, 605, 89, 28);
			//bcg.setBounds(0, 0, 854, 631);
			
			//�]�w�Ϥ��j�p
			i1.setImage(i1.getImage().getScaledInstance(180, 270, 1000));
			i2.setImage(i2.getImage().getScaledInstance(180, 270, 1000));
			i3.setImage(i3.getImage().getScaledInstance(180, 270, 1000));
			i4.setImage(i4.getImage().getScaledInstance(180, 270, 1000));
			i5.setImage(i5.getImage().getScaledInstance(180, 270, 1000));
			i6.setImage(i6.getImage().getScaledInstance(180, 270, 1000));
			i7.setImage(i7.getImage().getScaledInstance(180, 270, 1000));
			i8.setImage(i8.getImage().getScaledInstance(180, 270, 1000));
			//i9.setImage(i9.getImage().getScaledInstance(600, 400, 1000));
			
			
			//�N�Ϥ�ô������s�W
			b1.setIcon(i1);
			b2.setIcon(i2);
			b3.setIcon(i3);
			b4.setIcon(i4);
			b5.setIcon(i5);
			b6.setIcon(i6);
			b7.setIcon(i7);
			b8.setIcon(i8);
			//bcg.setIcon(i9);	//���B�O�N�Ϥ�ô������ҤW�A�ΰ��I���Ϥ�
			
			
			//�N����[�J��e����
			c.add(b1);
			c.add(b2);
			c.add(b3);
			c.add(b4);
			c.add(b5);
			c.add(b6);
			c.add(b7);
			c.add(b8);
			c.add(b9);
			
			
			//�]�w�p�ϥ�
			Image icon=Toolkit.getDefaultToolkit().getImage("Src/res/movie-icon07.jpg");
			setIconImage(icon);
			
			//�]�w���D
			setTitle("�N���q�v�|�����J�f");
			
			//�]�w���X�{��m�H�Ϊ��j�p
			setBounds(50,100,880,680);	
			
			//�]�w���i��j
			
			setResizable(false);
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
 
	public void actionPerformed(ActionEvent e){

			if (e.getSource() == b9) {
	    		this.dispose();
	    	    new Login();
	    	}
		}

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start01();	//�d�Ҥ�
	
	}
	}

