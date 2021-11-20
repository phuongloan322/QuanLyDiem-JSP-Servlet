package models;

public class NienKhoa {
	private String maNK;
	private String tenNK;
	public NienKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NienKhoa(String maNK, String tenNK) {
		super();
		this.maNK = maNK;
		this.tenNK = tenNK;
	}
	public String getMaNK() {
		return maNK;
	}
	public void setMaNK(String maNK) {
		this.maNK = maNK;
	}
	public String getTenNK() {
		return tenNK;
	}
	public void setTenNK(String tenNK) {
		this.tenNK = tenNK;
	}
	
	
}
