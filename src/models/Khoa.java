package models;

public class Khoa {
	private String maKhoa;
	private String tenKhoa;
	private String lienheKhoa;
	public Khoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Khoa(String maKhoa, String tenKhoa, String lienheKhoa) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.lienheKhoa = lienheKhoa;
	}
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public String getLienheKhoa() {
		return lienheKhoa;
	}
	public void setLienheKhoa(String lienheKhoa) {
		this.lienheKhoa = lienheKhoa;
	}
	
	
}
