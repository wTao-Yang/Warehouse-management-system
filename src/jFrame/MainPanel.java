package jFrame;

import java.awt.EventQueue;
import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import model.DBConnect;
import model.ExcelExporter;
import model.Table;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.UIManager;


public class MainPanel {

	JFrame frame;
	private static In in;
	public static Table jt; 
	public static Table jtr;
	public static Table admins;
	private static Out outt;
	public static JScrollPane scrollPane ;
	public static int tt=0;
	static int noww=1;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel window = new MainPanel();
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
	public MainPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("楷体", Font.BOLD, 25));
		frame.setTitle("\u4ED3\u5E93\u7BA1\u7406\u7CFB\u7EDF");
//		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Desktop\\\u6211\u7684\u4F5C\u4E1A\\\u6570\u636E\u5E93\u8BFE\u7A0B\u8BBE\u8BA1\\4.jpg"));
//		frame.getContentPane().setForeground(Color.WHITE);
//		frame.getContentPane().setBackground(Color.WHITE);
//		frame.setUndecorated(true);
		frame.setBounds(100, 100, 1360, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setBackground(UIManager.getColor("text"));
//		frame.show();
//	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
	    
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1892, 88);
	
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		jt=new Table(1);
		scrollPane = new JScrollPane(jt.table);
		scrollPane.setBounds(226, 159, 930, 593);
		scrollPane.setToolTipText("");
		frame.getContentPane().add(scrollPane);
		
		
		JButton btnNewButton = new JButton("人员管理");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				noww=3;
				admins=new Table(3);
				scrollPane.setViewportView(admins.table);
			}
		});
		btnNewButton.setBounds(596, 13, 99, 62);
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("出入库记录");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				noww=2;
				jtr=new Table(2);
				scrollPane.setViewportView(jtr.table);
			}
		});
		btnNewButton_3.setBounds(483, 13, 99, 62);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("仓库界面");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noww=1;
				jt=new Table(1);
				scrollPane.setViewportView(jt.table);
			}
		});
		btnNewButton_4.setBounds(16, 13, 99, 62);
		panel.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1155, 88, 205, 750);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("当前管理人信息");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel_1.setBounds(14, 58, 191, 52);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("工号");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(14, 123, 74, 29);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("姓名");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(14, 193, 74, 29);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("性别");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(14, 268, 74, 29);
		panel_2.add(lblNewLabel_4);
		
		
		
		JLabel lblNewLabel_5 = new JLabel(Login.userno);
		lblNewLabel_5.setBounds(102, 125, 116, 24);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(Login.Name);
		lblNewLabel_6.setBounds(102, 195, 111, 24);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(""+Login.Ssex);
		lblNewLabel_7.setBounds(102, 270, 111, 24);
		panel_2.add(lblNewLabel_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 88, 226, 915);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("仓库信息");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 35));
		lblNewLabel.setBounds(14, 13, 231, 39);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("成品");
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noww=1;
				scrollPane.setViewportView(jt.table);
				jt.getsuc();
				jt.table.updateUI();
			}
		});
		btnNewButton_5.setBounds(14, 77, 182, 45);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("半成品");
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noww=1;
				scrollPane.setViewportView(jt.table);
				jt.getbs();
				jt.table.updateUI();
			}
		});
		btnNewButton_6.setBounds(14, 148, 182, 45);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("材料");
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noww=1;
				scrollPane.setViewportView(jt.table);
				jt.getcl();
				jt.table.updateUI();
			}
		});
		btnNewButton_7.setBounds(14, 218, 182, 45);
		panel_1.add(btnNewButton_7);
		
//		jt=new Table();
//		JScrollPane scrollPane = new JScrollPane(jt.table);
//		scrollPane.setBounds(283, 101, 1383, 889);
//		scrollPane.setToolTipText("");
//		frame.getContentPane().add(scrollPane);
		
		
		JButton btnNewButton_1 = new JButton("商品录入");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    noww=1;
				 	in=new In();
				 	in.frame.setVisible(true);
			        jt.table.revalidate();
			}
		});
		
		
		btnNewButton_1.setBounds(129, 13, 99, 62);
		panel.add(btnNewButton_1);
		
		
		
		JButton btnNewButton_2 = new JButton("出库");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noww=1;
				 outt = new Out(0);
			 	outt.frame.setVisible(true);
	            jt.table.revalidate();
			}
		});
		btnNewButton_2.setBounds(370, 13, 99, 62);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_8 = new JButton("添加人员");
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPeople ad=new AddPeople();
				ad.frame.setVisible(true);
				
			}
		});
		btnNewButton_8.setBounds(709, 13, 113, 62);
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("删除管理");
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(noww==1){
				String s=(String) jt.defaultModel.getValueAt(Table.row, 0);
						deleteStore(s);
						jt.defaultModel.removeRow(Table.row);
						tt=0;
					}
				else if(noww==3){
					String s=(String) admins.defaultModel.getValueAt(Table.row, 0);
					deleteadmins(s);
					admins.defaultModel.removeRow(Table.row);
					tt=0;
				}
			
			}});
		btnNewButton_9.setBounds(836, 13, 113, 62);
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_11 = new JButton("导出表格");
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 	FileDialog fd=new FileDialog(frame,"Excel",FileDialog.SAVE);
				    fd.setLocation(400, 250);
				    fd.setVisible(true);
				    String stringfile = fd.getDirectory()+fd.getFile()+".xls";
				    ExcelExporter exp = new ExcelExporter(); 
				    Tip td;
				    if(noww==1){
                    try {
						exp.exportTable(jt.table,new File(stringfile));
						if(fd.getFile()!=null){
						td=new Tip(5);
						td.frame.setVisible(true);}
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				                    }
				    else if(noww==2){
				    	try {
							exp.exportTable(jtr.table, new File(stringfile));
							if(fd.getFile()!=null){
								td=new Tip(5);
								td.frame.setVisible(true);}
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}	
				    }
				    else if(noww==3){
				    	try {
							exp.exportTable(admins.table,new File(stringfile));
							if(fd.getFile()!=null){
								td=new Tip(5);
								td.frame.setVisible(true);}
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
				    }
		
				    }
			
		});
		btnNewButton_11.setBounds(963, 13, 113, 62);
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("修改密码");
		btnNewButton_12.setBackground(Color.WHITE);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Changepw cp=new Changepw();
				cp.frame.setVisible(true);
			}
		});
		btnNewButton_12.setBounds(1217, 13, 113, 62);
		panel.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("重新登录");
		btnNewButton_13.setBackground(Color.WHITE);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login l=new Login();
				l.frame.setVisible(true);
			}
		});
		btnNewButton_13.setBounds(1090, 13, 113, 62);
		panel.add(btnNewButton_13);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(226, 88, 930, 69);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("\u8BF7\u8F93\u5165\u4EA7\u54C1\u7F16\u53F7\u6216\u5DE5\u53F7");
		textField.setBounds(14, 13, 127, 24);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_10 = new JButton("查找");
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String get=textField.getText();
				if(noww==1){
					
					scrollPane.setViewportView(jt.table);
					
					jt.getS(get);
					
					jt.table.updateUI();
					MainPanel.tt=0;
				}
				else if(noww==2){
					
					scrollPane.setViewportView(jtr.table);
					jtr.getR(get);
					jtr.table.updateUI();
					MainPanel.tt=0;
				}
				else if(noww==3){
					
					scrollPane.setViewportView(admins.table);
					admins.getadmins(get);
					admins.table.updateUI();
					MainPanel.tt=0;
				}
			}
		});
		btnNewButton_10.setBounds(164, 12, 113, 27);
		panel_3.add(btnNewButton_10);
		
		JButton btnNewButton_14 = new JButton("入库");
		btnNewButton_14.setBackground(Color.WHITE);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noww=1;
				 outt = new Out(1);
			 	outt.frame.setVisible(true);
	            jt.table.revalidate();
			}
		});
		btnNewButton_14.setBounds(243, 13, 113, 62);
		panel.add(btnNewButton_14);
		btnNewButton.setOpaque(false);
		btnNewButton_1.setOpaque(false);
		btnNewButton_2.setOpaque(false);
		btnNewButton_3.setOpaque(false);
		btnNewButton_4.setOpaque(false);
		btnNewButton_5.setOpaque(false);
		btnNewButton_6.setOpaque(false);
		btnNewButton_7.setOpaque(false);
		btnNewButton_8.setOpaque(false);
		btnNewButton_9.setOpaque(false);
		btnNewButton_10.setOpaque(false);
		btnNewButton_11.setOpaque(false);
		btnNewButton_12.setOpaque(false);
		btnNewButton_13.setOpaque(false);
		btnNewButton_14.setOpaque(false);
		panel.setOpaque(false);
		
		
		panel_1.setOpaque(false);
		panel_2.setOpaque(false);
		panel_3.setOpaque(false);
		scrollPane.setOpaque(false);
		jt.table.setOpaque(false);
		
		ImageIcon image=new ImageIcon(getClass().getResource("/res/t01656137f980df0dc3.jpg"));
		JLabel jlb=new JLabel(image);
//		设置标签大小位置
		jlb.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
//		得到第二层面板并将标签放在上面
		frame.getLayeredPane().add(jlb,new Integer(Integer.MIN_VALUE));
		JPanel contentPanel=(JPanel)frame.getContentPane(); 
		//设置透明
		contentPanel.setOpaque(false);
		 	
	}
	
	 public static void insert(){
		    tt=1;
		    DBConnect db=new DBConnect();
			Connection conn=db.getConnect();
			int flag=0;
			String num=(String) outt.getD()[0];
			int scount= Integer.parseInt(((String)outt.getD()[1]).trim());
			String sql = "select Store.* from Store";
			 String SName=null;
			 String ThingsType=null;
			
			 try {
					PreparedStatement staement =conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet set1 = staement.executeQuery();
					while(set1.next()) {
						if(set1.getString("num").replace(" ","").equals(num)){
							SName=set1.getString("SName");
							ThingsType=set1.getString("ThingsType");
							flag=set1.getRow();
							scrollPane.setViewportView(jt.table);
							jt.table.setValueAt(set1.getInt("scount")+scount, flag-1, 3);
							set1.updateInt("scount",set1.getInt("scount")+scount);
						    set1.updateRow();
						    jt.table.revalidate();
						}
					}
					set1.close();}
					catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			 if(flag==0){
					Tip t=new Tip(1);
					t.frame.setVisible(true);
					return;
				}
			if(flag==0){
			try {
				scrollPane.setViewportView(jt.table);
				int rs=conn.createStatement().executeUpdate("Insert Store(num,SName,ThingsType,scount) values('"+num+"','"+SName+"','"+ThingsType+"',"+scount+")");
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		 int n=jt.defaultModel.getRowCount();	
		 jt.defaultModel.insertRow(n,in.getD());
         jt.table.revalidate();
         }	
			try {
				 Calendar ca = Calendar.getInstance();
				 int year = ca.get(Calendar.YEAR);//获取年份
			     int month=ca.get(Calendar.MONTH);//获取月份 
			     int day=ca.get(Calendar.DATE);//获取日
			     int minute=ca.get(Calendar.MINUTE);//分 
			     int hour=ca.get(Calendar.HOUR);//小时 
			     int second=ca.get(Calendar.SECOND);//秒
			     String dat=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
				 java.util.Date date=new java.util.Date();
			     SimpleDateFormat tim=new SimpleDateFormat("HH:mm:ss");
			     String t=tim.format(date);
				int rse=conn.createStatement().executeUpdate("Insert record(num,SName,ThingsType,scount,INOrOut,DDay,Ttime,WorkNo) values('"+num+"','"+SName+"','"+ThingsType+"',"+scount+",'In','"+dat+"','"+t+"','"+Login.userno+"')");}
				catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			tt=0;
		}

			
	 public static void inserts(){
			tt=1;
		    DBConnect db=new DBConnect();
			Connection conn=db.getConnect();
			int flag=0;
			String num=(String) in.getD()[0];
			String SName=(String) in.getD()[1];
			String ThingsType=(String) in.getD()[2];
		
			String sql = "select Store.* from Store";
			PreparedStatement staement;
			try {
				staement = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet set1 = staement.executeQuery();
				while(set1.next()) {
				if(set1.getString("num").replace(" ","").equals(num)){
					Tip j=new Tip(2);
					j.frame.setVisible(true);
				    jt.table.revalidate();
				    return;
				}
			}
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			try {
				scrollPane.setViewportView(jt.table);
				int rs=conn.createStatement().executeUpdate("Insert Store(num,SName,ThingsType,scount) values('"+num+"','"+SName+"','"+ThingsType+"',"+0+")");
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		 int n=jt.defaultModel.getRowCount();	
		 jt.defaultModel.insertRow(n,in.getD());
         jt.table.revalidate();
         
	 }

	 public static void delete(){
		 	tt=1;
		    DBConnect db=new DBConnect();
			Connection conn=db.getConnect();
			int flag=0;
			String num=(String) outt.getD()[0];
			int scount= Integer.parseInt(((String)outt.getD()[1]).trim());
			String sql = "select Store.* from Store";
			 String SName=null;
			 String ThingsType=null;
			
			 try {
					PreparedStatement staement =conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet set1 = staement.executeQuery();
					while(set1.next()) {
						if(set1.getString("num").replace(" ","").equals(num)){
							SName=set1.getString("SName");
							ThingsType=set1.getString("ThingsType");
							flag=set1.getRow();
							scrollPane.setViewportView(jt.table);
							jt.table.setValueAt(set1.getInt("scount")-scount, flag-1, 3);
							set1.updateInt("scount",set1.getInt("scount")-scount);
						    set1.updateRow();
						    jt.table.revalidate();
						}
					}
					set1.close();}
					catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			if(flag==0){
				Tip t=new Tip(1);
				t.frame.setVisible(true);
				return;
			}
			try {
				
				 Calendar ca = Calendar.getInstance();
				 int year = ca.get(Calendar.YEAR);//获取年份
			     int month=ca.get(Calendar.MONTH);//获取月份 
			     int day=ca.get(Calendar.DATE);//获取日
			     int minute=ca.get(Calendar.MINUTE);//分 
			     int hour=ca.get(Calendar.HOUR);//小时 
			     int second=ca.get(Calendar.SECOND);//秒
			     String dat=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
				 java.util.Date date=new java.util.Date();
				 SimpleDateFormat tim=new SimpleDateFormat("HH:mm:ss");
			     String t=tim.format(date);
				int rse=conn.createStatement().executeUpdate("Insert record(num,SName,ThingsType,scount,INOrOut,DDay,Ttime,WorkNo) values('"+num+"','"+SName+"','"+ThingsType+"',"+scount+",'Out','"+dat+"','"+t+"','"+Login.userno+"')");}
				catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			tt=0;
	 }
	 
	 public static void deleteadmins(String s){
		 tt=1;
		 DBConnect db=new DBConnect();
			Connection conn=db.getConnect();
			String sql = "delete from admins where WorkNo='"+s+"'";
		
			
					 try {
							PreparedStatement staement1 =conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							int se1 = staement1.executeUpdate();
							if(se1==1) {
								System.out.println("删除成功");
							}
								}
							catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
					
	 }
	 
	 public static void deleteStore(String s){
		 tt=1;
		 DBConnect db=new DBConnect();
			Connection conn=db.getConnect();
			String sql = "delete from store where num='"+s+"'";
					 try {
							PreparedStatement staement1 =conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							int se1 = staement1.executeUpdate();
							if(se1==1) {
								System.out.println("删除成功");
							}
								}
							catch (SQLException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						
		 
	 }
	
	 }

