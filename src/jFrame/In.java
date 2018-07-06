package jFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Store;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class In {
	JFrame frame;
	JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	Store s;
	private Object [] D;
	protected MainPanel mainPanel;
	String ss;
	private JComboBox comboBox;
	

	public Object[] getD() {
		return D;
	}

	public void setD(Object[] d) {
		D = d;
	}

	public Store getS() {
		return s;
	}

	public void setS(Store s) {
		this.s = s;
	}

	public In(JTextField textField, JTextField textField_1, JTextField textField_2, JTextField textField_3) {
		super();
		this.textField = textField;
		this.textField_1 = textField_1;
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					In window = new In();
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
	public In() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Desktop\\\u6211\u7684\u4F5C\u4E1A\\\u6570\u636E\u5E93\u8BFE\u7A0B\u8BBE\u8BA1\\1.jpg"));
		frame.setBounds(100, 100, 358, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("产品编号");
		lblNewLabel.setBounds(63, 37, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("名称");
		lblNewLabel_1.setBounds(63, 84, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("产品类别");
		lblNewLabel_2.setBounds(63, 134, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(192, 34, 102, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 81, 102, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("确定");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ss=(String) comboBox.getSelectedItem();
				Object []C={textField.getText(),textField_1.getText(),ss,0};
				D=C;
				MainPanel.inserts();
				frame.dispose();
			}
				
		});
		btnNewButton.setBounds(63, 192, 77, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(191, 192, 77, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		
		Object []o={"成品","半成品","材料"};
		comboBox = new JComboBox(o);
		comboBox.setBounds(192, 131, 102, 24);
		frame.getContentPane().add(comboBox);
		
		
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	
}
