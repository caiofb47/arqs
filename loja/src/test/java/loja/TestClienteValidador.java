package loja;

import org.junit.Assert;

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

import br.unibh.loja.entidades.Cliente;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClienteValidador {
	
	private static Validator validator;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando o validador....");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	

	@Test
	public void testeValidacaoCliente1() {
		Cliente c = new Cliente(1L, "Caio", "caiologin", "123abc", "Batatas", "99999999999", "(31)33829019",
				"caiofb47@gmail.com", new Date(), new Date());
		
		System.out.println(c);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(c);
		for (ConstraintViolation<Cliente> i: constraintViolations) { // For each com downcast
		System.out.println(" Erro de Validacao: "+i.getMessage());
		}
		// Quantidade de  erros esperados
		Assert.assertEquals(0, constraintViolations.size() );
	}
	
	@Test
	public void testeValidacaoCliente2() {
		Cliente c = new Cliente(1L, "C@io", "c�io_l�gin", "123abc", "Batat/*as", "1234567asa89", "(3*/1)33829019",
				"caiofb47", new Date(), new Date());
		
		System.out.println(c);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate( c );
		for (ConstraintViolation<Cliente> i: constraintViolations) { // For each com downcast
		System.out.println(" Erro de Validacao: "+i.getMessage());
		}
		Assert.assertEquals(4, constraintViolations.size() );
	}
	
	

}
