package models;

public class TheLoai {
	private String maTL;
	private String tenTL;
	public TheLoai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TheLoai(String maTL, String tenTL) {
		super();
		this.maTL = maTL;
		this.tenTL = tenTL;
	}
	public String getMaTL() {
		return maTL;
	}
	public void setMaTL(String maTL) {
		this.maTL = maTL;
	}
	public String getTenTL() {
		return tenTL;
	}
	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}
	
	
}
