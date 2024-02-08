package br.com.zhant.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private boolean minado;
	private boolean aberto;
	private boolean marcado;
	
	private final int linha;
	private final int coluna;
	
	private List<Campo> vizinhos = new ArrayList<>(); 
	
	public Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
}
