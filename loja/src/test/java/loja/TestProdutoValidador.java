package loja;



import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.unibh.loja.entidades.Categoria;
import br.unibh.loja.entidades.Produto;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProdutoValidador {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando o Validador....");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testeValidacaoProduto1() {
		Categoria a = new Categoria(1L, "Computadores");
		Produto p = new Produto(1L, "Computador", "quenaotrava", a, new BigDecimal(10.00), "comeclipse");

		System.out.println(p);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(p);
		for (ConstraintViolation<Produto> i : constraintViolations) { // For each com downcast
			System.out.println(" Erro de Validacao: " + i.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoProduto2() {
		Categoria a = new Categoria(1L, "Computadores");
		Produto p = new Produto(1L, "Computador", "quenatrava", a, new BigDecimal(10.00), "comeclipse");

		System.out.println(p);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(p);
		for (ConstraintViolation<Produto> i : constraintViolations) { // For each com downcast
			System.out.println(" Erro de Validacao: " + i.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}
}
