package jFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.DBConnect;
import model.Table;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class AddPeople {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	protected Object[] D;
	private JTextField textField_2;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPeople window = new AddPeople();
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
	public AddPeople() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 370, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("工号");
		lblNewLabel.setBounds(70, 60, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(180, 57, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(70, 118, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 115, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("性别");
		lblNewLabel_2.setBounds(70, 179, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("出生日期");
		lblNewLabel_3.setBounds(70, 238, 72, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("手机号码");
		lblNewLabel_4.setBounds(70, 294, 72, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 235, 34, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(180, 291, 86, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("登录密码");
		lblNewLabel_5.setBounds(70, 347, 72, 18);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(180, 344, 86, 24);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		Object []o={"男","女"};
		JComboBox comboBox = new JComboBox(o);
		comboBox.setBounds(180, 176, 86, 24);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				 DBConnect db=new DBConnect();
				Connection conn=db.getConnect();
				try {
					String sss=(String) comboBox.getSelectedItem();
					int rs=conn.createStatement().executeUpdate("Insert admins(WorkNo,Name,Ssex,bir,Phone,WPassWord) values('"+textField.getText()+"','"+textField_1.getText()+"','"+sss+"','"+textField_3.getText()+"-"+textField_2.getText()+"-"+textField_6.getText()+"','"+textField_4.getText()+"','"+textField_5.getText()+"')");
					MainPanel.admins=new Table(3);
					MainPanel.scrollPane.setViewportView(MainPanel.admins.table);
				} catch (SQLException e) {
					 Tip tt=new Tip(2);
 					 tt.frame.setVisible(true);
 					 return;
				}	frame.dispose();
			}
		});
		btnNewButton.setBounds(70, 397, 86, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(180, 397, 86, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(220, 235, 22, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(246, 235, 22, 24);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
