package br.edu.univas.si3.mediaidadepopulacao;

import java.util.ArrayList;

public class Populacao {

	
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
	public void addPessoa(Pessoa pessoa) throws KeyDuplicateException{
		for(Pessoa p : pessoas){
			if(p.getCpf() == pessoa.getCpf()){
				throw new KeyDuplicateException("Chave duplicada. CPF já existe, informe outro número de CPF."); /*Lançando exceção criada.*/
			}
		}
		pessoas.add(pessoa);
	}
	
	public void removerPessoa(Pessoa pessoa){
		for(Pessoa p : pessoas){
			if(p.getCpf() == pessoa.getCpf()){
				pessoas.remove(p);
			}
		}
	}
	
		
	public int getMediaIdadeHomem(){

		int countHomem =0;
		int somaIdadeHomem =0;
		
		for(Pessoa p : pessoas){
			if(p.getSexo() == 'H'){  
				countHomem++;
				somaIdadeHomem += p.getIdade(); /*sum of men age*/
			}
		}
		return (countHomem != 0) ? somaIdadeHomem/countHomem  : 0;
	}
	
	public int getMediaIdadeMulher(){
		
		int countMulher = 0;
		int somaIdadeMulher = 0;
		
		for(Pessoa p : pessoas){
			if(p.getSexo() == 'M'){  
				countMulher++;
				somaIdadeMulher += p.getIdade();	/*sum of women age*/
			}
		}
		return (countMulher != 0) ? somaIdadeMulher/countMulher : 0;
	}
	 
	public int getMediaIdadeGeral(){
		
		if(this.getMediaIdadeHomem() != 0 && this.getMediaIdadeMulher() != 0){
			return  (this.getMediaIdadeHomem()+this.getMediaIdadeMulher())/2;
		}else{
			return (this.getMediaIdadeHomem()+this.getMediaIdadeMulher());
		}
	}
	
	public ArrayList<Pessoa> getPessoa(){
		return pessoas;
	}
}
