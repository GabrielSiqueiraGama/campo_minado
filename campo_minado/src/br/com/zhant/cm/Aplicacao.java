package br.com.zhant.cm;

import br.com.zhant.cm.modelo.Tabuleiro;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(10,10,10);
		tabuleiro.alterarMarcacao(0, 0);
		tabuleiro.abrir(1, 2);
		System.out.println(tabuleiro);
		
	}
	
}
