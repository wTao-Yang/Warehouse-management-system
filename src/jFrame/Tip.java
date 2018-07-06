package jFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tip {

	public JFrame frame;
	private JPasswordField passwordField;
	public String s=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tip window = new Tip(1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tip(int t) {
		if(t==1)
			initialize1();
		else if(t==2)
			initialize2();
		else if(t==3)
			initialize3();
		else if(t==4)
			initialize4();
		else if(t==5)
			initialize5();
		else if(t==6)
			initialize6();
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize6() {
		frame = new JFrame();
		frame.setBounds(100, 100, 290, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�޸���Ϣ�ɹ�!");
		lblNewLabel.setBounds(32, 27, 235, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(76, 76, 113, 27);
		frame.getContentPane().add(btnNewButton);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize1() {
		frame = new JFrame();
		frame.setBounds(100, 100, 290, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("���������Ϣ��������������!");
		lblNewLabel.setBounds(32, 27, 235, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(76, 76, 113, 27);
		frame.getContentPane().add(btnNewButton);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initialize2() {
		frame = new JFrame();
		frame.setBounds(100, 100, 290, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�����ظ����޷����!");
		lblNewLabel.setBounds(32, 27, 235, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(76, 76, 113, 27);
		frame.getContentPane().add(btnNewButton);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initialize3() {
		frame = new JFrame();
		frame.setBounds(100, 100, 290, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("�Ҳ�������Ϣ!");
		lblNewLabel.setBounds(32, 27, 235, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(76, 76, 113, 27);
		frame.getContentPane().add(btnNewButton);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initialize4() {
		frame = new JFrame();
		frame.setBounds(100, 100, 290, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("�޷��޸Ĵ���Ϣ!");
		lblNewLabel.setBounds(32, 27, 235, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(76, 76, 113, 27);
		frame.getContentPane().add(btnNewButton);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initialize5() {
		frame = new JFrame();
		frame.setBounds(100, 100, 290, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�����ɹ�!");
		lblNewLabel.setBounds(32, 27, 235, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(76, 76, 113, 27);
		frame.getContentPane().add(btnNewButton);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
}
