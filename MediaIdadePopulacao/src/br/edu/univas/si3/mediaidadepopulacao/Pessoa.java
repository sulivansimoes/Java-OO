package br.edu.univas.si3.mediaidadepopulacao;

public abstract class Pessoa {
	
	private String nome;
	private int cpf;
	private int idade;
	private char sexo;
	
	Pessoa(String nome, int cpf, int idade,char sexo){
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	int getIdade(){
		return idade;
	}
	
	char getSexo(){
		return sexo;
	}
	
	int getCpf(){
		return cpf;
	}
}
