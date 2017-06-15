package br.edu.univas.si3.mediaidadepopulacao;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestesSystem {

	/*Parameters to Allocation:
	 * 						   Homem:  Homem (<Nome>,<CPF>,<Idade>); 
	 *						   Mulher: Mulher(<Nome>,<CPF>,<Idade>);						
	 *																 */

	@Test
	public void testAddPessoa() {
		
		Populacao cadastro = new Populacao();
		Mulher m1 = new Mulher("m1", 1234, 10);
		Mulher m2 = new Mulher("m2", 1235, 16);
		
		try {
			cadastro.addPessoa(m1);
			cadastro.addPessoa(m2);
		} catch (KeyDuplicateException e) {
			fail("Erro! Não era para entrar no catch próximo a linha 24, método testAddPessoa.\n"+ e.getMessage());
			e.printStackTrace();
		}
		
		assertEquals(2, cadastro.getPessoa().size());	
		
		Homem h1 = new Homem("h1", 1236, 10);
		Homem h2 = new Homem("h2", 1237, 16);
		
		try {
			cadastro.addPessoa(h1);
			cadastro.addPessoa(h2);
		} catch (KeyDuplicateException e) {
			fail("Erro! Não era para entrar no catch próximo a linha 37, método testAddPessoa. \n" + e.getMessage());
			e.printStackTrace();
		}		
		
		assertEquals(4, cadastro.getPessoa().size());
}
	
	@Test
	public void testRemoverPessoa() {
		
		Populacao cadastro = new Populacao();
		Mulher m1 = new Mulher("m1", 1234, 10);
		Mulher m2 = new Mulher("m2", 1235, 16);
		Homem  h1 = new Homem ("h1", 1236, 10);
				
		try {
			cadastro.addPessoa(m1);
			cadastro.addPessoa(m2);
			cadastro.addPessoa(h1);
		} catch (KeyDuplicateException e) {
			fail("Erro! Não era para entrar no catch próximo a linha 57, método testAddPessoa.\n"+ e.getMessage());
			e.printStackTrace();
		}
		
		assertEquals(3,cadastro.getPessoa().size());
		
		cadastro.removerPessoa(m2);		
		assertEquals(2,cadastro.getPessoa().size());
		
		cadastro.removerPessoa(m1);		
		assertEquals(1,cadastro.getPessoa().size());
		
}
	
	@Test
	public void testkeyDuplicate() { /*Chave duplicada*/
		Populacao cadastro = new Populacao();
		Mulher m1 = new Mulher("m1", 1234, 10);
		Mulher m2 = new Mulher("m2", 1235, 16);
		Homem  h1 = new Homem ("h1", 1236, 10);
		Homem  h2 = new Homem ("h2", 1234, 16);
		try {
			cadastro.addPessoa(m1);
			cadastro.addPessoa(h1);
			cadastro.addPessoa(m2);
			cadastro.addPessoa(h2);
		} catch (KeyDuplicateException e) {
			System.out.println("Correto! Era para entrar no catch próximo a linha 84, método testkeyDuplicate.\n"+ e.getMessage());
		}
}
			
	@Test
	public void testCalculoMediaIdades() {
		
		Populacao cadastro = new Populacao();
		Mulher m1 = new Mulher("m1", 1234, 10);
		Mulher m2 = new Mulher("m2", 1235, 16);
		
		try {
			cadastro.addPessoa(m1);
			cadastro.addPessoa(m2);
		} catch (KeyDuplicateException e) {
			fail("Erro! Não era para entrar no catch próximo a linha 99 , método testCalculoMediaIdades.\n"+ e.getMessage());
			e.printStackTrace();
		}

		assertEquals(13,cadastro.getMediaIdadeMulher());
		assertEquals(13,cadastro.getMediaIdadeGeral());
		assertEquals(0 ,cadastro.getMediaIdadeHomem());
		
		Homem h1 = new Homem("h1", 1236, 10);
		Homem h2 = new Homem("h2", 1237, 16);
		
		try {
			cadastro.addPessoa(h1);
			cadastro.addPessoa(h2);
		} catch (KeyDuplicateException e) {
			fail("Erro! Não era para entrar no catch próximo a linha 114, método testCalculoMediaIdades. \n" + e.getMessage());
			e.printStackTrace();
		}
				
		assertEquals(13,cadastro.getMediaIdadeHomem());
		assertEquals(13,cadastro.getMediaIdadeGeral());
		assertEquals(13,cadastro.getMediaIdadeMulher());		
		
		/*Testa valores depois de remover pessoa da Populacao*/
		cadastro.removerPessoa(h1);
		assertEquals(16,cadastro.getMediaIdadeHomem());
		assertEquals(14,cadastro.getMediaIdadeGeral()); 
		assertEquals(13,cadastro.getMediaIdadeMulher());				
	}			
}
