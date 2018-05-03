package loja;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import br.unibh.loja.entidades.Categoria;
import br.unibh.loja.entidades.Cliente;
import br.unibh.loja.entidades.Produto;

public class Teste {
	
	//1) Criação e impressão de um objeto 
	@Test
	public void testCliente() {
		Cliente cli = new Cliente();

		// Preenchendo objeto
		cli.setId((long) 123456789);
		cli.setNome("Caio");
		cli.setLogin("caio");
		cli.setSenha("123");
		cli.setPerfil("oi");
		cli.setCpf("128005");
		cli.setTelefone("992237150");
		cli.setDataNascimento(new Date());
		cli.setDataCadastro(new Date());
		
		// Comparação
		assertEquals(cli.getId(), new Long (123456789));
		assertEquals(cli.getNome(),"Caio");
		assertEquals(cli.getLogin(),"caio");
		assertEquals(cli.getSenha(),"123");
		assertEquals(cli.getPerfil(),"oi");
		assertEquals(cli.getCpf(),"128005");
		assertEquals(cli.getTelefone(),"992237150");
		assertEquals(cli.getDataNascimento(),new Date());
		assertEquals(cli.getDataCadastro(),new Date());
		
		cli.toString();
		
	}
	
	@Test
	public void testCategoria(){
		Categoria cat = new Categoria();
		
		cat.setId(new Long (123));
		cat.setDescricao("OI");
		
		assertEquals(cat.getId(), new Long (123));
		assertEquals(cat.getDescricao(), "OI");
		
		cat.toString();
			
	}
	
	@Test
	public void testProduto(){
		
		Produto pro = new Produto ();
		
		Categoria cat = new Categoria();
		
		cat.setId(new Long (123));
		cat.setDescricao("OI");
		
		
		pro.setNome("abacaxi");
		pro.setDescricao("oi");
		pro.setCategoria(cat);
		pro.setPreco(new BigDecimal (123));
		pro.setFabricante("ashusa");
		
		assertEquals(pro.getNome(), "abacaxi");
		assertEquals(pro.getDescricao(),"oi");
		assertEquals(pro.getCategoria(), cat);
		assertEquals(pro.getPreco(),new BigDecimal(123));
		assertEquals(pro.getFabricante(), "ashusa");
		
		pro.toString();
		 //Casa
	}


}
