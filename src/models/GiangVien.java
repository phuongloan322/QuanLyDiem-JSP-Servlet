package models;

public class GiangVien {
	private String maGV;
	private String tenGV;
	private String diachi;
	private int sdt;
	private String email;
	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GiangVien(String maGV, String tenGV, String diachi, int sdt, String email) {
		super();
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
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
	
	
}
