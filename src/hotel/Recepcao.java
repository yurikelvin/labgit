package hotel;

import java.util.ArrayList;
import java.util.Iterator;

public class Recepcao {

	private ArrayList<Estadia> estadias;
	private final String FIM_DE_LINHA = System.lineSeparator();
	
	public Recepcao() {
		estadias = new ArrayList<>();
	}
	
	public void checkIn(String nome, String tipo, int idade, int dias, double valor) {
		estadias.add(new Estadia(nome, tipo, idade, dias, valor));
	}
	
	public void checkOut(String nome) {
		Iterator<Estadia> it = estadias.iterator();
		while(it.hasNext()) {
			Estadia estadiaPesquisada = it.next();
			if(estadiaPesquisada.getNome().equals(nome)) {
				it.remove();
			}
		}
		
	}
	
	public int getNumDeHospedes() {
		return estadias.size();
	}
	
	public double getLucroTotal() {
		double soma = 0;
		Iterator<Estadia> it = estadias.iterator();
		while(it.hasNext()) {
			Estadia estadiaPesquisada = it.next();
			double valorAtual = estadiaPesquisada.getValor() * estadiaPesquisada.getDias();
			soma += valorAtual;
		}
		
		return soma;
	}
	
	@Override
	public String toString() {
		String minhasEstadias = "Estadias" + FIM_DE_LINHA;
		for(Estadia estadia: estadias) {
			minhasEstadias += estadia;
			
		}
		return minhasEstadias;
	}
}