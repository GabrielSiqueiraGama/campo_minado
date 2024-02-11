package br.com.zhant.cm;

import br.com.zhant.cm.modelo.Tabuleiro;
import br.com.zhant.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(3,3,1);
		
		new TabuleiroConsole(tabuleiro);
		
		System.out.println(tabuleiro);
		
	}
	
}
