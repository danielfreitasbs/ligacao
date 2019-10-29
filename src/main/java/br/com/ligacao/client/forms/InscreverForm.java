package br.com.ligacao.client.forms;

import java.util.Scanner;

import br.com.ligacao.persistence.model.InscritoEmAcao;

public class InscreverForm {

	/*private static Scanner dados = new Scanner(System.in);
	private static String nomeVoluntario;
	private static String emailVoluntario;
	private static String nomeAcao;
	private static String nomeProtomor;
	
	public static void main(String[] args) {
	
		System.out.println("Escreva seu nome:\n");
		nomeVoluntario = dados.nextLine();
		
		System.out.println("Escreva seu email:\n");
		emailVoluntario = dados.nextLine();
		
		System.out.println("Escreva o nome da ação:\n");
		nomeAcao = dados.nextLine();
		
		System.out.println("Escreva o nome do promotor da ação:\n");
		nomeProtomor = dados.nextLine();
		
	}*/
	
	public static InscritoEmAcao preencherForm() {
		
		InscritoEmAcao inscrito = new InscritoEmAcao("Joao das Neves", "joaoDasNeves@gmail.com", "Cuidar de Lobos", "Casa Stark");
		
		return inscrito;
	}
	
}
