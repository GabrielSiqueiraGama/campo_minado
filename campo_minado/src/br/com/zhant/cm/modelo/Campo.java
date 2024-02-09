package br.com.zhant.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.zhant.cm.excecao.ExplosaoException;

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
	
	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = colunaDiferente && linhaDiferente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaLinha + deltaColuna;
		
			if(deltaGeral == 1 && !diagonal) {
				vizinhos.add(vizinho);
				return true;
			}else if(deltaGeral == 2 && diagonal) {
				vizinhos.add(vizinho);
				return true;
			}else {
				return false;
			}
		}
		
		void alterarMarcacao(){
			if(!aberto) {
				marcado = !marcado;
			}
		}
		
		boolean abrir() {
			if(!aberto && !marcado) {
				aberto = true;
			}if(minado) {
				throw new ExplosaoException();
			}
			if(vizinhacaSegura()) {
				vizinhos.forEach(v -> v.abrir());
				return true;
			}
		return false;
		}
		boolean vizinhacaSegura() {
			return vizinhos.stream().noneMatch(v -> v.minado);
		}
		public boolean isMarcado() {
			return marcado;
		}
}
