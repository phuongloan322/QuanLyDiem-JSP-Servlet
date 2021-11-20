package models;

public class SinhVien {
	private String maSV;
	private String tenSV;
	private String diachi;
	private int sdt;
	private String email;
	private Lop lop;
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SinhVien(String maSV, String tenSV, String diachi, int sdt, String email, Lop lop) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.lop = lop;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Lop getLop() {
		return lop;
	}
	public void setLop(Lop lop) {
		this.lop = lop;
	}
	
	
}
