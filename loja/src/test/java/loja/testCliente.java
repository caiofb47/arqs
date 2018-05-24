package loja;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import br.unibh.loja.entidades.Cliente;

public class testCliente {
	
	@Test
	public void testCreateCliente(){
		// Datas
		Date i = new Date();
		Cliente c = new Cliente((long)123456789,"Caio","caiofb47","12345678","Olá","12345678901","33334444","caiofb47@gmail.com",i,i);
		Cliente d = new Cliente((long)123456789,"Caio","caiofb47","12345678","Olá","12345678901","33334444","caiofb47@gmail.com",i,i);
		
		// Comparando se da igual
		assertEquals(true,c.equals(d));
	}
	
	

}
