package loja;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.unibh.loja.entidades.Categoria;
import br.unibh.loja.entidades.Produto;
import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testProduto {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando o validador....");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testeValidacaoProduto1() {
		Produto p = new Produto();
		Categoria c = new Categoria();

		// Populando categoria
		c.setId(new Long(123));
		c.setDescricao("OI");

		// Populando Produto
		p.setNome("abacaxi");
		p.setDescricao("oi");
		p.setCategoria(c);
		p.setPreco(new BigDecimal(123));
		p.setFabricante("ashusa");

		System.out.println(p);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(p);
		for (ConstraintViolation<Produto> i : constraintViolations) { // For each com downcast
			System.out.println(" Erro de Validacao: " + i.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoProduto2() {
		Produto p = new Produto();
		Categoria c = new Categoria();

		// Populando categoria
		c.setId(new Long(123));
		c.setDescricao("");

		// Populando Produto
		p.setNome("abacaxi");
		p.setDescricao("");
		p.setCategoria(c);
		p.setPreco(new BigDecimal(123));
		p.setFabricante("ashusa");

		System.out.println(p);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(p);
		for (ConstraintViolation<Produto> i : constraintViolations) { // For each com downcast
			System.out.println(" Erro de Validacao: " + i.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}
}
