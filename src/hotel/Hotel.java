package hotel;

public class Hotel {

	private Recepcao minhaRecepcao;
	
	public Hotel() {
		minhaRecepcao = new Recepcao();
	}

	public void checkIn(String nome, String tipo, int idade, int dias, double valor) {
		minhaRecepcao.checkIn(nome, tipo, idade, dias, valor);
	}

	public void checkOut(String nome) {
		minhaRecepcao.checkOut(nome);
	}

	public int getNumDeHospedes() {
		return minhaRecepcao.getNumDeHospedes();
	}

	public double getLucroTotal() {
		return minhaRecepcao.getLucroTotal();
	}

	@Override
	public String toString() {
		return minhaRecepcao.toString();
	}

}
