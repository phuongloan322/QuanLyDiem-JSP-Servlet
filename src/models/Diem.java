package models;

import org.apache.commons.math3.analysis.function.Sin;

public class Diem {
	private int maBD;
	private float diem1;
	private float diem2;
	private float diem3;
	private float tongDiem;
	private GiangVien giangVien;
	private SinhVien sinhVien;
	private MonHoc monHoc;
	private TinChi tinChi;
	private TheLoai theLoai;
	private hocky hocky;
	private NamHoc namHoc;
	Lop lop;
	public Diem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Diem(int maBD, float diem1, float diem2, float diem3, float tongDiem, GiangVien giangVien, SinhVien sinhVien,
			MonHoc monHoc, TinChi tinChi, TheLoai theLoai, models.hocky hocky, NamHoc namHoc, Lop lop) {
		super();
		this.maBD = maBD;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.tongDiem = tongDiem;
		this.giangVien = giangVien;
		this.sinhVien = sinhVien;
		this.monHoc = monHoc;
		this.tinChi = tinChi;
		this.theLoai = theLoai;
		this.hocky = hocky;
		this.namHoc = namHoc;
		this.lop = lop;
	}
	public int getMaBD() {
		return maBD;
	}
	public void setMaBD(int maBD) {
		this.maBD = maBD;
	}
	public float getDiem1() {
		return diem1;
	}
	public void setDiem1(float diem1) {
		this.diem1 = diem1;
	}
	public float getDiem2() {
		return diem2;
	}
	public void setDiem2(float diem2) {
		this.diem2 = diem2;
	}
	public float getDiem3() {
		return diem3;
	}
	public void setDiem3(float diem3) {
		this.diem3 = diem3;
	}
	public float getTongDiem() {
		return tongDiem;
	}
	public void setTongDiem(float tongDiem) {
		this.tongDiem = tongDiem;
	}
	public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	public SinhVien getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	public MonHoc getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	public TinChi getTinChi() {
		return tinChi;
	}
	public void setTinChi(TinChi tinChi) {
		this.tinChi = tinChi;
	}
	public TheLoai getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}
	public hocky getHocky() {
		return hocky;
	}
	public void setHocky(hocky hocky) {
		this.hocky = hocky;
	}
	public NamHoc getNamHoc() {
		return namHoc;
	}
	public void setNamHoc(NamHoc namHoc) {
		this.namHoc = namHoc;
	}
	public Lop getLop() {
		return lop;
	}
	public void setLop(Lop lop) {
		this.lop = lop;
	}
}
