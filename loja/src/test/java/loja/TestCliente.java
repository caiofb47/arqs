package loja;

import java.util.Date;
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

import br.unibh.loja.entidades.Cliente;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCliente {
	
	private static Validator validator;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando o validador....");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void testeValidacaoCliente1() {
		Cliente c = new Cliente(1L, "Caio", "caiologin", "abcde", "Batatas", "22288844452", "(31)33829019",
				"caiofb47@gmail.com", new Date(), new Date());
		System.out.println(c);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(c);
		for (ConstraintViolation<Cliente> i: constraintViolations) { // For each com downcast
		System.out.println(" Erro de Validacao: "+i.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size() );
	}
	
	@Test
	public void testeValidacaoCliente2() {
		Cliente c = new Cliente(1L, "Caio", "cáió_lògin", "12 3abc", "Bata tas", "123456789", "( 31)33829 019",
				"caiofb47@gmail.com", new Date(), new Date());
		
		System.out.println(c);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate( c );
		for (ConstraintViolation<Cliente> i: constraintViolations) { // For each com downcast
		System.out.println(" Erro de Validacao: "+i.getMessage());
		}
		Assert.assertEquals(2, constraintViolations.size() );
	}
	
	

}
