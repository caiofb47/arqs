package loja;

import static org.junit.Assert.*;

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
import br.unibh.loja.entidades.Cliente;
import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testCliente {
	
	private static Validator validator;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando o validador....");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void testeValidacaoCliente1() {
		Cliente c = new Cliente();
		c.setId((long) 123456789);
		c.setNome("Caio");
		c.setLogin("caiofb47");
		c.setSenha("123abcdef");
		c.setPerfil("oi");
		c.setCpf("12345678910");
		c.setTelefone("992237150");
		c.setDataNascimento(new Date());
		c.setDataCadastro(new Date());
		
		System.out.println(c);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(c);
		for (ConstraintViolation<Cliente> i: constraintViolations) { // For each com downcast
		System.out.println(" Erro de Validacao: "+i.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size() );
	}
	
	@Test
	public void testeValidacaoCliente2() {
		Cliente c = new Cliente();
		c.setId((long) 123456789);
		c.setNome("Caio");
		c.setLogin("caio");
		c.setSenha("123");
		c.setPerfil("oi");
		c.setCpf("128005");
		c.setTelefone("992237150");
		c.setDataNascimento(new Date());
		c.setDataCadastro(new Date());
		
		System.out.println(c);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate( c );
		for (ConstraintViolation<Cliente> i: constraintViolations) { // For each com downcast
		System.out.println(" Erro de Validacao: "+i.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size() );
	}
	
	

}
