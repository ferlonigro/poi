package tragamonedas;

public class Tragamonedas {

	private Tambor t1;
	private Tambor t2;
	private Tambor t3;

	public Tragamonedas(Tambor t1, Tambor t2, Tambor t3) {
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
	}

	public void activar() {
		t1.girar();
		t2.girar();
		t3.girar();	
	}

	public boolean entregaPremio() {
		return t1.valor() == t2.valor() && t1.valor() == t3.valor();
	}

	public int getValor1() {
		return t1.valor();
	}
	
	public int getValor2() {
		return t2.valor();
	}
	
	public int getValor3() {
		return t3.valor();
	}
	
	

}
