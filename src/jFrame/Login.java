package jFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import model.DBConnect;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Login {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	protected MainPanel MainPanel;
	public static String userno=null;
	static String Name=null;
	static String Ssex=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 450, 278);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		textField = new JTextField();
		textField.setBounds(155, 54, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("�ʺ�");
		lblNewLabel.setBounds(56, 57, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("����");
		lblNewLabel_1.setBounds(56, 125, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 122, 86, 24);
		frame.getContentPane().add(passwordField);
		
		JButton Login = new JButton("��¼");
		Login.setBackground(Color.WHITE);
		Login.addActionListener(null);
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String no=textField.getText();
				String pw=passwordField.getText();
				
				if(RLogin(no, pw)==true){
					userno=no;
					MainPanel m=new MainPanel();
					m.frame.setVisible(true);
					frame.dispose();}
				else 
				{
					Tip t=new Tip(1);
					t.frame.setVisible(true);
				}
			}
		});
		Login.setBounds(277, 53, 113, 27);
		frame.getContentPane().add(Login);
		
		JButton btnNewButton_1 = new JButton("ע��");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zhuche z=new Zhuche();
				z.frame.setVisible(true);
			}
		});
		
		btnNewButton_1.setBounds(277, 121, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("zku\u4ED3\u5E93\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_2.setForeground(new Color(143, 188, 143));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 30));
		lblNewLabel_2.setBounds(56, 169, 280, 48);
		frame.getContentPane().add(lblNewLabel_2);
		
		ImageIcon image=new ImageIcon(getClass().getResource("/res/201003250855562215.jpg"));
		JLabel jlb=new JLabel(image);
//		���ñ�ǩ��Сλ��
		jlb.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
//		�õ��ڶ�����岢����ǩ��������
		frame.getLayeredPane().add(jlb,new Integer(Integer.MIN_VALUE));
		JPanel contentPanel=(JPanel)frame.getContentPane();
		//����͸��
		contentPanel.setOpaque(false);
	}
	
	public static boolean RLogin(String no,String pw) {
		 boolean bol=false;
		 DBConnect conn=new DBConnect();
		 conn.getConnect();
	  String sql = "select admins.* from admins where WorkNo='"+no+"' and WPassWord='"+pw+"'";
	  
	  try {
		PreparedStatement staement =conn.conn.prepareStatement(sql);
		ResultSet set1 = staement.executeQuery();
		if (set1.next()) {
			String Name1 = set1.getString("Name");
			String Ssex1 = set1.getString("Ssex");
			Name=Name1;
			Ssex=Ssex1;
			bol=true;
		}
		set1.close();
		conn.closeConnect(conn.conn);
		staement.close();
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	return bol; 
	  
	  
	 }
}
