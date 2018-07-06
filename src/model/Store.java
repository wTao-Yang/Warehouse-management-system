package model;

public class Store {
   private 	String  num;
	private String SName;
	private int scount;
	private String ThingsType;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String day;
	private String time;
	private String InOrOut;
	
	
	
	public Store(String num, String sName, String thingsType, int scount) {
		super();
		this.num = num;
		this.SName = sName;
		this.scount = scount;
		this.ThingsType = thingsType;
	}
	public Store(String num, String sName, String thingsType, int t,String in, String day, String time) {
		// TODO 自动生成的构造函数存根
		super();
		this.num = num;
		this.SName = sName;
		this.ThingsType = thingsType;
		this.scount=t;
		this.InOrOut=in;
		this.day=day;
		this.time=time;
	}
	
	   public String getWno() {
		return wno;
	}
	public void setWno(String wno) {
		this.wno = wno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBir() {
		return bir;
	}
	public void setBir(String bir) {
		this.bir = bir;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	   String wno;
	   String Name;
	   String sex;
	   String bir;
	   String Phone;
	   
	   public Store(String wno2, String name2, String sex2, String bir2, String phone2) {
		this.wno=wno2;
		this.Name=name2;
		this.sex=sex2;
		this.bir=bir2;
		this.Phone=phone2;
	}
	
	
	
	public String getInOrOut() {
		return InOrOut;
	}
	public void setInOrOut(String inOrOut) {
		InOrOut = inOrOut;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public int getScount() {
		return scount;
	}
	public void setScount(int scount) {
		this.scount = scount;
	}
	public String getThingsType() {
		return ThingsType;
	}
	public void setThingsType(String thingsType) {
		ThingsType = thingsType;
	}
}
