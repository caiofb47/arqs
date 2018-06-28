package loja;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import br.unibh.loja.entidades.Categoria;
import br.unibh.loja.entidades.Cliente;
import br.unibh.loja.entidades.Produto;

public class Teste {

	// 1) Criacao e impressão de um objeto
//	@Test
	public void testCliente() {
		Cliente cli = new Cliente(1L, "Caio", "caio_login", "123abc", "Batatas", "123456789", "(31)33829019",
				"caiofb47@gmail.com", new Date(), new Date());
		Long a = (long) 1;
		// Comparaao
		assertEquals(cli.getId(), a);
		assertEquals(cli.getNome(), "Caio");
		assertEquals(cli.getLogin(), "caio");
		assertEquals(cli.getSenha(), "123");
		assertEquals(cli.getPerfil(), "oi");
		assertEquals(cli.getCpf(), "128005");
		assertEquals(cli.getTelefone(), "992237150");
		assertEquals(cli.getDataNascimento(), new Date());
		assertEquals(cli.getDataCadastro(), new Date());

		cli.toString();

	}

	//@Test
	public void testCategoria() {
		Categoria cat = new Categoria(1L, "Comida");

		cat.setId(new Long(123));
		cat.setDescricao("OI");

		assertEquals(cat.getId(), new Long(123));
		assertEquals(cat.getDescricao(), "OI");

		cat.toString();

	}

	//@Test
	public void testProduto() {

		Categoria cat = new Categoria(1L, "Computadores");
		Produto pro = new Produto(1L, "Computador", "quenaotrava", cat, new BigDecimal(10.00), "comeclipse");

		cat.setId(new Long(123));
		cat.setDescricao("OI");

		pro.setNome("abacaxi");
		pro.setDescricao("oi");
		pro.setCategoria(cat);
		pro.setPreco(new BigDecimal(123));
		pro.setFabricante("ashusa");

		assertEquals(pro.getNome(), "abacaxi");
		assertEquals(pro.getDescricao(), "oi");
		assertEquals(pro.getCategoria(), cat);
		assertEquals(pro.getPreco(), new BigDecimal(123));
		assertEquals(pro.getFabricante(), "ashusa");

		pro.toString();
	}

}
