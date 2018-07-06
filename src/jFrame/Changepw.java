package jFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import model.DBConnect;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Changepw {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Changepw window = new Changepw();
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
	public Changepw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 375, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("工号");
		lblNewLabel.setBounds(68, 42, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("原密码");
		lblNewLabel_1.setBounds(68, 94, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("新密码");
		lblNewLabel_2.setBounds(68, 143, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(179, 39, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Login.RLogin(textField.getText(), passwordField.getText())==true){
					 DBConnect db=new DBConnect();
						Connection conn=db.getConnect();
						String sql = "select admins.* from admins where WorkNo='"+textField.getText()+"'";
						
						 try {
								PreparedStatement staement =conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
								ResultSet set1 = staement.executeQuery();
								while(set1.next()) {
										set1.updateString("WPassWord",passwordField_1.getText());
									  	set1.updateRow();
									    
									}
								set1.close();
								conn.close();}
								catch (SQLException e1) {
									e1.printStackTrace();
								}
						 		
			
				}frame.dispose();}});
		btnNewButton.setBounds(68, 189, 86, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(179, 189, 86, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(179, 140, 86, 24);
		frame.getContentPane().add(passwordField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 94, 86, 24);
		frame.getContentPane().add(passwordField);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
