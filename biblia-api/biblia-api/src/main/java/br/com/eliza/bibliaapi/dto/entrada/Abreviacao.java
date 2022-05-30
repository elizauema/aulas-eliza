package br.com.eliza.bibliaapi.dto.entrada;

public class Abreviacao {
	
	private String pt;
	private String en;
	public String getPt() {
		return pt;
	}
	public void setPt(String pt) {
		this.pt = pt;
	}
	public String getEn() {
		return en;
	}
	public void setEn(String en) {
		this.en = en;
	}
	@Override
	public String toString() {
		return "Abreviacao [pt=" + pt + ", en=" + en + "]";
	}
}
