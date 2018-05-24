package loja;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.unibh.loja.entidades.Produto;

public class testProduto {

	@Test
	public void testProduto(){
		BigDecimal A = new BigDecimal(10.8);
		Produto p = new Produto();
		Produto q = new Produto();
		
		// Comparando se da igual
		assertEquals(true,p.equals(q));
		
	}
	
}
