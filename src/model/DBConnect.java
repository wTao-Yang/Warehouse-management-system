package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;//Á¬½Ó

import jFrame.Login;
import jFrame.Tip;
public class DBConnect {
	public Connection conn = null;
 public Connection getConnect() {
 
  
  try {
   Class.forName("com.mysql.jdbc.Driver");
   conn = DriverManager.getConnection(
     "jdbc:mysql://localhost:3306/wms?useUnicode=true&characterEncoding=utf-8&useSSL=true", "root",
     "123456");
   System.out.println("ok");
  } catch (ClassNotFoundException e) {
   e.printStackTrace();
  } catch (SQLException e) {
   e.printStackTrace();
  }
  return conn;
 }//¹Ø±Õ 
 public void closeConnect(Connection conn) {
  if (conn != null) {
   try {
    conn.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  }
 }
 
 public static void main(String[] args) {
	DBConnect dbConnect=new DBConnect();
	dbConnect.getConnect();
}

}
