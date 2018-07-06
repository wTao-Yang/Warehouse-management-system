package model;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import jFrame.Login;
import jFrame.MainPanel;
import jFrame.Tip;

public class Table {
	 public JTable table = null;
	 public DefaultTableModel defaultModel = null;
	protected String gaicol; 
	 public static int row=1;
	 static String ss=null;
	 static String gai=null;
	 static String col=null;
	 
	public Table(int h){
		if(h==1){
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		try {
			   DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
			   ResultSet rs=conn.createStatement().executeQuery("select * from store ");
				
			   
				while(rs.next()){
				   String num= rs.getString("num");
				   String sName= rs.getString("SName");
				   String Scount= rs.getString("ThingsType");
				   int t =rs.getInt("scount");
				   Store s=new Store(num, sName, Scount, t);
				   al.add(s);
				   j++;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][4];
		int i=0;
		while(it.hasNext()){
			
			Store s=it.next();
			d[i][0]=s.getNum();
			d[i][1]=s.getSName();
			d[i][2]=s.getThingsType();
			d[i][3]=s.getScount();
			
			i++;
		}
		

        String[] n = { "产品编号", "名称", "产品类别", "数量" };
        // 创建一个默认的表格模型
        defaultModel = new DefaultTableModel(d,n);
        table = new JTable(defaultModel);
//        TableColumn t=table.getColumn("产品编号");
//        DefaultTableCellRenderer cellRanderer = new DefaultTableCellRenderer();
//        cellRanderer.setForeground(Color.RED); 
//        t.setCellRenderer(cellRanderer);
        Color c=new Color(202,235,216);
        table.setBackground(c);
        table.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent me){
        		row=table.getSelectedRow();
        	}
        	});
        table.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e) {
            	if(MainPanel.tt==0){
            	 col=table.getColumnName(0);
            	 gaicol=table.getColumnName(table.getSelectedColumn());
            	 ss=(String) table.getValueAt(table.getSelectedRow(), 0);
            	 gai=(String) table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()); 
            	 DBConnect db=new DBConnect();
     			Connection conn=db.getConnect();
     			String sql3=null;
     			String sqlgai=null;
     				
     				 sql3 = "select Store.* from Store where num='"+ss+"'";
     				 if(gaicol.equals("名称")) sqlgai="SName";
     				if(gaicol.equals("产品类别")) sqlgai="ThingsType";
     				if(gaicol.equals("数量")) sqlgai="scount";
     				if(gaicol.equals("产品编号")){
     					MainPanel.jt=new Table(1);
     					MainPanel.scrollPane.setViewportView(MainPanel.jt.table);
     					 Tip tt=new Tip(4);
     					 tt.frame.setVisible(true);
     					 return;
     				} 
     				Tip tt=new Tip(6);
   				 tt.frame.setVisible(true);
     			 try {
     					PreparedStatement staement2 =conn.prepareStatement(sql3,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
     					ResultSet st = staement2.executeQuery();
     					while(st.next()) {
     							st.updateString(sqlgai,gai);
     							st.updateRow();
     					}
     					st.close();}
     					catch (SQLException e1) {
     						// TODO 自动生成的 catch 块
     						e1.printStackTrace();
     					}
            }}
            });
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setRowHeight(45);
//      table.setBackground(Color.cyan);
        table.revalidate();
        }
        
		
		
	
	
	
	
	else if(h==2){
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		try {
			DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
				ResultSet rs=conn.createStatement().executeQuery("select * from record");
				

				while(rs.next()){
				   String num= rs.getString("num");
				   String sName= rs.getString("SName");
				   String Scount= rs.getString("ThingsType");
				   int t =rs.getInt("scount");
				   String In=rs.getString("INorOut");
				   String day=rs.getString("DDay");
				   String time=rs.getString("Ttime");
				   Store s=new Store(num, sName, Scount, t,In,day,time);
				   al.add(s);
				   j++;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][8];
		int i=0;
		while(it.hasNext()){
			
			Store s=it.next();
			d[i][0]=s.getNum();
			d[i][1]=s.getSName();
			d[i][2]=s.getThingsType();
			d[i][3]=s.getScount();
			d[i][4]=s.getInOrOut();
			d[i][5]=s.getDay();
			d[i][6]=s.getTime();
			d[i][7]=Login.userno;
			i++;
		}
		

        String[] n = { "产品编号", "名称", "产品类别", "数量","进/出","日期","时间","执行工号"};
        // 创建一个默认的表格模型
        defaultModel = new DefaultTableModel(d,n);
        defaultModel.addTableModelListener(table);
        table = new JTable(defaultModel);
        Color c=new Color(202,235,216);
        table.setBackground(c);
        table.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent me){
        		row=table.getSelectedRow();
        	}
        	});
        table.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e) {
            	if(MainPanel.tt==0){
            		MainPanel.jtr=new Table(2);
 					MainPanel.scrollPane.setViewportView(MainPanel.jtr.table);
 					 Tip tt=new Tip(4);
 					 tt.frame.setVisible(true);
 					 return;
            }}
            });
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setRowHeight(45);

        table.revalidate();
	}else if(h==3){
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		try {
			DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
				ResultSet rs=conn.createStatement().executeQuery("select * from admins");
				
			   
				while(rs.next()){
				   String wno= rs.getString("WorkNo");
				   String Name= rs.getString("Name");
				   String sex= rs.getString("Ssex");
				   String bir=rs.getString("bir");
				   String Phone=rs.getString("Phone");
				   
				   Store s=new Store(wno,Name,sex,bir,Phone);
				   al.add(s);
				   j++;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][5];
		int i=0;
		while(it.hasNext()){
			Store s=it.next();
			d[i][0]=s.getWno();
			d[i][1]=s.getName();
			d[i][2]=s.getSex();
			d[i][3]=s.getBir();
			d[i][4]=s.getPhone();
			i++;
		}
		
        String[] n = { "工号", "姓名", "性别", "出生日期","手机号码" };
        defaultModel = new DefaultTableModel(d,n);
        defaultModel.addTableModelListener(table);
        table = new JTable(defaultModel);
        Color c=new Color(202,235,216);
        table.setBackground(c);
        
        table.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent me){
        		row=table.getSelectedRow();
        	}
        	});
        table.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e) {
            	if(MainPanel.tt==0){
            	 col=table.getColumnName(0);
            	 gaicol=table.getColumnName(table.getSelectedColumn());
            	 ss=(String) table.getValueAt(table.getSelectedRow(), 0);
            	 gai=(String) table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()); 
            	 DBConnect db=new DBConnect();
     			Connection conn=db.getConnect();
     			String sql3=null;
     			String sqlgai=null;
     			
//     				
//     				 sql3 = "select Store.* from Store where WorkNo='"+ss+"'";
     				 if(gaicol.equals("姓名")) sqlgai="Name";
     				if(gaicol.equals("性别")) sqlgai="Ssex";
     				if(gaicol.equals("出生日期")) sqlgai="bir";
     				 if(gaicol.equals("手机号码")) sqlgai="Phone";
     				 if(gaicol.equals("工号")){
     					 MainPanel.admins=new Table(3);
     					 MainPanel.scrollPane.setViewportView(MainPanel.admins.table);
     					 Tip tt=new Tip(4);
     					 tt.frame.setVisible(true);
     					 return;
     				 }
     				
//     				 try {
//      					PreparedStatement staement2 =conn.prepareStatement("select WPassWord from admins where WorkNo='"+ss+"'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//      					ResultSet st = staement2.executeQuery();
//      					while(st.next()) {
//      							if(pwa.equals(st.getString("WPassWord"))){
//      								
//      							}
//      					}
//      					st.close();}
//      					catch (SQLException e1) {
//      						
//      						e1.printStackTrace();
//      					}
               				  
     				sql3="select admins.* from admins where WorkNo='"+ss+"'";
     				
     			 try {
     					PreparedStatement staement2 =conn.prepareStatement(sql3,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
     					ResultSet st = staement2.executeQuery();
     					while(st.next()) {
     						
  								st.updateString(sqlgai,gai);
     							st.updateRow();
     							Tip tt=new Tip(6);
     		   				    tt.frame.setVisible(true);
     		   			
  							
     					}
     					st.close();}
     					catch (SQLException e1) {
     						
     						e1.printStackTrace();
     					}
            }
            	 
            	}
            });
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setRowHeight(45);
//      table.setBackground(Color.cyan);
        table.revalidate();
	}
		
	}

	

	

	public void re() {
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		try {
			DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
				ResultSet rs=conn.createStatement().executeQuery("select * from store ");
				
			   
				while(rs.next()){
				   String num= rs.getString("num");
				   String sName= rs.getString("SName");
				   String Scount= rs.getString("ThingsType");
				   int t =rs.getInt("scount");
				   Store s=new Store(num, sName, Scount, t);
				   al.add(s);
				   j++;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][4];
		int i=0;
		while(it.hasNext()){
			
			Store s=it.next();
			d[i][0]=s.getNum();
			d[i][1]=s.getSName();
			d[i][2]=s.getThingsType();
			d[i][3]=s.getScount();
			
			i++;
		}
		

        String[] n = { "产品编号", "名称", "产品类别", "数量" };
        // 创建一个默认的表格模型
        defaultModel.setDataVector(d, n);
		
	}

	public void getsuc() {
		// TODO 自动生成的方法存根
		MainPanel.tt=1;
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		try {
			DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
				ResultSet rs=conn.createStatement().executeQuery("select * from store where ThingsType='成品'");
				
			   
				while(rs.next()){
				   String num= rs.getString("num");
				   String sName= rs.getString("SName");
				   String Scount= rs.getString("ThingsType");
				   int t =rs.getInt("scount");
				   Store s=new Store(num, sName, Scount, t);
				   al.add(s);
				   j++;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][4];
		int i=0;
		while(it.hasNext()){
			
			Store s=it.next();
			d[i][0]=s.getNum();
			d[i][1]=s.getSName();
			d[i][2]=s.getThingsType();
			d[i][3]=s.getScount();
			
			i++;
		}
		
        String[] n = { "产品编号", "名称", "产品类别", "数量" };
        // 创建一个默认的表格模型
        defaultModel.setDataVector(d, n);
		
	}

	public void getbs() {
		// TODO 自动生成的方法存根
		MainPanel.tt=1;
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		try {
			DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
				ResultSet rs=conn.createStatement().executeQuery("select * from store where ThingsType='半成品'");
				
			   
				while(rs.next()){
				   String num= rs.getString("num");
				   String sName= rs.getString("SName");
				   String Scount= rs.getString("ThingsType");
				   int t =rs.getInt("scount");
				   Store s=new Store(num, sName, Scount, t);
				   al.add(s);
				   j++;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][4];
		int i=0;
		while(it.hasNext()){
			
			Store s=it.next();
			d[i][0]=s.getNum();
			d[i][1]=s.getSName();
			d[i][2]=s.getThingsType();
			d[i][3]=s.getScount();
			
			i++;
		}
		
        String[] n = { "产品编号", "名称", "产品类别", "数量" };
        // 创建一个默认的表格模型
        defaultModel.setDataVector(d, n);
		
		
	}

	public void getcl() {
		// TODO 自动生成的方法存根
		MainPanel.tt=1;
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		try {
			DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
				ResultSet rs=conn.createStatement().executeQuery("select * from store where ThingsType='材料'");
				
			   
				while(rs.next()){
				   String num= rs.getString("num");
				   String sName= rs.getString("SName");
				   String Scount= rs.getString("ThingsType");
				   int t =rs.getInt("scount");
				   Store s=new Store(num, sName, Scount, t);
				   al.add(s);
				   j++;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][4];
		int i=0;
		while(it.hasNext()){
			
			Store s=it.next();
			d[i][0]=s.getNum();
			d[i][1]=s.getSName();
			d[i][2]=s.getThingsType();
			d[i][3]=s.getScount();
			
			i++;
		}
		
        String[] n = { "产品编号", "名称", "产品类别", "数量" };
        // 创建一个默认的表格模型
        defaultModel.setDataVector(d, n);
		
	}
	
	public void getadmins() {
		// TODO 自动生成的方法存根
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		try {
			DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
				ResultSet rs=conn.createStatement().executeQuery("select * from admins");
				
			   
				while(rs.next()){
				   String wno= rs.getString("WorkNo");
				   String Name= rs.getString("Name");
				   String sex= rs.getString("Ssex");
				   String bir=rs.getString("bir");
				   String Phone=rs.getString("Phone");
				   
				   Store s=new Store(wno,Name,sex,bir,Phone);
				   al.add(s);
				   j++;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][5];
		int i=0;
		while(it.hasNext()){
			Store s=it.next();
			d[i][0]=s.getWno();
			d[i][1]=s.getName();
			d[i][2]=s.getSex();
			d[i][3]=s.getBir();
			d[i][4]=s.getPhone();
			i++;
		}
		
        String[] n = { "工号", "姓名", "性别", "出生日期","手机号码" };
        // 创建一个默认的表格模型
        defaultModel.setDataVector(d, n);
		
	}
	
	public void getS(String s){
		MainPanel.tt=1;
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		int k=0;
		try {
			DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
				ResultSet rs=conn.createStatement().executeQuery("select * from store where num='"+s+"'");
				
			   
				while(rs.next()){
					k=rs.getRow()+1;
				   String num= rs.getString("num");
				   String sName= rs.getString("SName");
				   String Scount= rs.getString("ThingsType");
				   int t =rs.getInt("scount");
				   Store st=new Store(num, sName, Scount, t);
				   al.add(st);
				   j++;
				}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		if(k==0){
			Tip tt=new Tip(3);
			tt.frame.setVisible(true);
			return ;
		}
		
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][4];
		int i=0;
		while(it.hasNext()){
			
			Store st=it.next();
			d[i][0]=st.getNum();
			d[i][1]=st.getSName();
			d[i][2]=st.getThingsType();
			d[i][3]=st.getScount();
			
			i++;
		}
		
        String[] n = { "产品编号", "名称", "产品类别", "数量" };
        // 创建一个默认的表格模型
        defaultModel.setDataVector(d, n);
		
	}

	public void getR(String get) {
		// TODO 自动生成的方法存根
		MainPanel.tt=2;
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		int k=0;
		try {
			DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
				ResultSet rs=conn.createStatement().executeQuery("select * from record where num='"+get+"'");
				

				while(rs.next()){
					k=rs.getRow();
				   String num= rs.getString("num");
				   String sName= rs.getString("SName");
				   String Scount= rs.getString("ThingsType");
				   int t =rs.getInt("scount");
				   String In=rs.getString("INorOut");
				   String day=rs.getString("DDay");
				   String time=rs.getString("Ttime");
				   Store s=new Store(num, sName, Scount, t,In,day,time);
				   al.add(s);
				   j++;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(k==0){
			Tip tt=new Tip(3);
			tt.frame.setVisible(true);
		}
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][8];
		int i=0;
		while(it.hasNext()){
			
			Store s=it.next();
			d[i][0]=s.getNum();
			d[i][1]=s.getSName();
			d[i][2]=s.getThingsType();
			d[i][3]=s.getScount();
			d[i][4]=s.getInOrOut();
			d[i][5]=s.getDay();
			d[i][6]=s.getTime();
			d[i][7]=Login.userno;
			i++;
		}
		
//		Object[][] p = {
//                { "王鹏", new Integer(91), new Integer(1949), new Integer(1910) },
//                { "朱学莲", new Integer(82), new Integer(1969), new Integer(1510) },
//                { "梅婷", new Integer(47), new Integer(1957), new Integer(1040) },
//                { "赵龙", new Integer(61), new Integer(1957), new Integer(1180) },
//                { "李兵", new Integer(90), new Integer(1987), new Integer(1770) }, };
        String[] n = { "产品编号", "名称", "产品类别", "数量","进/出","日期","时间","管理人工号"};
        // 创建一个默认的表格模型
        defaultModel.setDataVector(d, n);
		
	}

	public void getadmins(String get) {
		// TODO 自动生成的方法存根
		MainPanel.tt=3;
		ArrayList<Store> al=new ArrayList<>();
		int j=0;
		int k=0;
		try {
			DBConnect DB=new DBConnect();
			   Connection conn=	DB.getConnect();
				ResultSet rs=conn.createStatement().executeQuery("select * from admins where WorkNo='"+get+"'");
				
			   
				while(rs.next()){
					k=rs.getRow();
				   String wno= rs.getString("WorkNo");
				   String Name= rs.getString("Name");
				   String sex= rs.getString("Ssex");
				   String bir=rs.getString("bir");
				   String Phone=rs.getString("Phone");
				   
				   Store s=new Store(wno,Name,sex,bir,Phone);
				   al.add(s);
				   j++;
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(k==0){
			Tip tt=new Tip(3);
			tt.frame.setVisible(true);
		}
		Iterator<Store> it=al.iterator();
		Object[][] d=new Object[j][5];
		int i=0;
		while(it.hasNext()){
			Store s=it.next();
			d[i][0]=s.getWno();
			d[i][1]=s.getName();
			d[i][2]=s.getSex();
			d[i][3]=s.getBir();
			d[i][4]=s.getPhone();
			i++;
		}
		
        String[] n = { "工号", "姓名", "性别", "出生日期","手机号码" };
        // 创建一个默认的表格模型
        defaultModel.setDataVector(d, n);
	}
	
}
