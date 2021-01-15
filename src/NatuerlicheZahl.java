

public class NatuerlicheZahl {
	public static final NatuerlicheZahl NULL = new NatuerlicheZahl(0);
	public static final NatuerlicheZahl EINS = new NatuerlicheZahl(1);
	private int wert;


	public NatuerlicheZahl(int wert) {
		if (wert < 0) wert = 0;
		this.wert = Math.abs(wert);
	}

	public NatuerlicheZahl(NatuerlicheZahl andere){
		new NatuerlicheZahl(andere.wert);
	}

	public NatuerlicheZahl addiere(NatuerlicheZahl andere){
		return new NatuerlicheZahl(this.wert+ andere.wert);
	}

	public NatuerlicheZahl multipliziere(NatuerlicheZahl andere){
		return new NatuerlicheZahl(this.wert * andere.wert);
	}

	public int getWert() {
		return wert;
	}

	public boolean equals(NatuerlicheZahl andere){
		if (this.wert == andere.wert){
			return true;
		} else return false;
	}

	public String toString(){
		return Integer.toString(this.getWert());
	}

	public static void main(String[] args) {
		NatuerlicheZahl n = new NatuerlicheZahl(10);
		n = n.addiere(new NatuerlicheZahl(5));
		System.out.println(n);
		n = n.multipliziere(new NatuerlicheZahl(5));
		System.out.println(n);
		System.out.println(n.getWert());
		System.out.println(n.equals(new NatuerlicheZahl(75)));
	}






}














