package br.com.zhant.cm;

import br.com.zhant.cm.modelo.Tabuleiro;
import br.com.zhant.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,3);
		
		new TabuleiroConsole(tabuleiro);
		
		System.out.println(tabuleiro);
		
	}
	
}
