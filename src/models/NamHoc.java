package models;

public class NamHoc {
	private String maNH;
	private String tenNH;
	public NamHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NamHoc(String maNH, String tenNH) {
		super();
		this.maNH = maNH;
		this.tenNH = tenNH;
	}
	public String getMaNH() {
		return maNH;
	}
	public void setMaNH(String maNH) {
		this.maNH = maNH;
	}
	public String getTenNH() {
		return tenNH;
	}
	public void setTenNH(String tenNH) {
		this.tenNH = tenNH;
	}
	
	
}
