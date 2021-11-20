package models;

public class TinChi {
	private String maTC;
	private int soTC;
	public TinChi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TinChi(String maTC, int soTC) {
		super();
		this.maTC = maTC;
		this.soTC = soTC;
	}
	public String getMaTC() {
		return maTC;
	}
	public void setMaTC(String maTC) {
		this.maTC = maTC;
	}
	public int getSoTC() {
		return soTC;
	}
	public void setSoTC(int soTC) {
		this.soTC = soTC;
	}
	
}
