package loja;

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
import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCategoria {
	
	private static Validator validator;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando o validador....");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void testeValidacaoCategoria1() {
		Categoria c = new Categoria(1L, "Comida");
		
		System.out.println(c);
		Set<ConstraintViolation<Categoria>> constraintViolations = validator.validate( c );
		for (ConstraintViolation<Categoria> i: constraintViolations) { // For each com downcast
		System.out.println(" Erro de Validacao: "+i.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size() );
	}
	
	@Test
	public void testeValidacaoCategoria2() {
		Categoria c = new Categoria(1L, "Coda");
		
		System.out.println(c);
		Set<ConstraintViolation<Categoria>> constraintViolations = validator.validate( c );
		for (ConstraintViolation<Categoria> i: constraintViolations) { // For each com downcast
		System.out.println(" Erro de Validacao: "+i.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size() );
	}
	
	
	

}
