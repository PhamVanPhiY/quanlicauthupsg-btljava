package QuanLiDoiBongView;



public class CauThu  {
	private String hotencauthu,quoctich,vitri;
	private int soao;
	private double tienluong;
	
	public CauThu() {
		super();
	}
	
	public CauThu(String hotencauthu, String quoctich, String vitri, int soao, double tienluong) {
		super();
		this.hotencauthu = hotencauthu;
		this.quoctich = quoctich;
		this.vitri = vitri;
		this.soao = soao;
		this.tienluong = tienluong;
	}

	public String getHotencauthu() {
		return hotencauthu;
	}
	public void setHotencauthu(String hotencauthu) {
		this.hotencauthu = hotencauthu;
	}
	public String getQuoctich() {
		return quoctich;
	}
	public void setQuoctich(String quoctich) {
		this.quoctich = quoctich;
	}
	public String getVitri() {
		return vitri;
	}
	public void setVitri(String vitri) {
		this.vitri = vitri;
	}
	public int getSoao() {
		return soao;
	}
	public void setSoao(int soao) {
		this.soao = soao;
	}
	public double getTienluong() {
		return tienluong;
	}
	public void setTienluong(double tienluong) {
		this.tienluong = tienluong;
	}

}
