package models;

public class MonHoc {
	private String maMH;
	private String tenMH;
	private TinChi tinchi;
	private TheLoai theloai;
	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonHoc(String maMH, String tenMH, TinChi tinchi, TheLoai theloai) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.tinchi = tinchi;
		this.theloai = theloai;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public TinChi getTinchi() {
		return tinchi;
	}
	public void setTinchi(TinChi tinchi) {
		this.tinchi = tinchi;
	}
	public TheLoai getTheloai() {
		return theloai;
	}
	public void setTheloai(TheLoai theloai) {
		this.theloai = theloai;
	}
	
	
}
