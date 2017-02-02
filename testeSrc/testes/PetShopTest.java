/*
 * Gabriel Silva Vinha - Monitoria de LP2 - 2016.1
 */

package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import hotel.Animal;
import hotel.Estadia;
import hotel.Hotel;
import hotel.Recepcao;

public class PetShopTest {

	private Hotel hotel;
	
	@Before
	public void setUp(){
		this.hotel = new Hotel();
	}
	
	@Test
	public void testAnimal(){
		try{
			Animal frederico = new Animal("Frederico Mercury", "Cachorro", 12);
			Animal paola = new Animal("Paola Bracho", "Cobra", 10);
			Animal toto = new Animal("Toto", "Cachorro", 3);
			
			assertEquals(paola.getTipo(), "Cobra");
		//	assertEquals(freddie.getNome(), "Freddie");
			assertNotEquals(toto.getIdade(), 5000);
			
			Animal gabriel = new Animal("Gabriel", "Gato", 18);
		}catch(Exception e){
			fail(); //Nao deve lancar excecao
		}
		
	}
	
	@Test
	public void testAnimalExceptions(){
		try{
			Animal invalido = new Animal("", "Pterodactil", 1000);
		}catch(Exception e){
			assertEquals("Nome de um animal nao pode ser nulo ou vazio", e.getMessage());
		}
		try{
			Animal invalido = new Animal("Denis", null, 12);
		}catch(Exception e){
			assertEquals("Tipo de um animal nao pode ser nulo ou vazio", e.getMessage());
		}
		try{
			Animal invalido = new Animal("Snoopy", "Cachorro", -12);
		}catch(Exception e){
			assertEquals("Idade de um animal nao pode ser abaixo de 0", e.getMessage());
		}
	}
	
	@Test
	public void testEstadia(){
		try{
			Estadia estadiaFrederico = new Estadia("Frederico Mercury", "Cachorro", 12, 70, 900.0);
			Estadia estadiaPaola = new Estadia("Paola Bracho", "Cobra", 10, 1, 10.0);
			Estadia estadiaToto = new Estadia("Toto", "Cachorro", 3, 90, 800.0);
		}catch(Exception e){
			fail(); //Nao deve lancar excecao
		}
	}
	
	@Test
	public void testeRecepcao(){
		try{
			Recepcao recepcao = new Recepcao();
			recepcao.checkIn("Frederico Mercury", "Cachorro", 12, 70, 900.0);
			
			assertEquals(1, recepcao.getNumDeHospedes());
			assertEquals(63000.0, recepcao.getLucroTotal(), 0.001);
			
			recepcao.checkIn("Paola Bracho", "Cobra", 10, 1, 10.0);
			recepcao.checkIn("Toto", "Cachorro", 3, 90, 800.0);
			recepcao.checkIn("Gabriel", "Gato", 18, 3, 1000.0);
			
			assertEquals(4, recepcao.getNumDeHospedes(), 0.05);
			assertEquals(138010.0, recepcao.getLucroTotal(), 0.05);
			
			recepcao.checkOut("Frederico Mercury");
			recepcao.checkOut("Toto");
			recepcao.checkOut("Gabriel");
			
			assertEquals(1, recepcao.getNumDeHospedes());
			

		}catch(Exception e){
			fail(); //Nao deve lancar excecao
		}
	}
	
	@Test
	public void testeHotel(){
		try{
			hotel.checkIn("Frederico Mercury", "Cachorro", 12, 70, 900.0);
			
			assertEquals(1, hotel.getNumDeHospedes());
			assertEquals(63000.0, hotel.getLucroTotal(), 0.001);
			
			hotel.checkOut("Frederico Mercury");
			
			assertEquals(0, hotel.getNumDeHospedes());
			assertEquals(0, hotel.getLucroTotal(), 0.001);
			
			hotel.checkIn("Jerry", "Rato", 9, 3, 120.0);
			

		}catch(Exception e){
			fail(); //Nao deve lancar excecao
		}
	}
}
