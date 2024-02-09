package br.com.zhant.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.zhant.cm.excecao.ExplosaoException;

public class Campo {

	private boolean minado;
	private boolean aberto;
	private boolean marcado = false;
	
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
			} if(vizinhacaSegura()) {
				vizinhos.forEach(v -> v.abrir());
				return true;
			}
			return false;
		}
		boolean vizinhacaSegura() {
			return vizinhos.stream().noneMatch(v -> v.minado);
		}
		void minar() {
			minado = true;
		}
		public boolean isMarcado() {
			return marcado;
		}
		public boolean isAberto() {
			return aberto;
		}
		public boolean isFechado() {
			return !aberto;
		}

		public int getLinha() {
			return linha;
		}

		public int getColuna() {
			return coluna;
		}
		boolean objetivoAlcancado() {
			boolean desvendado = !minado && aberto;
			boolean protegido = minado && marcado;
			return desvendado || protegido;
		}
		long minasNaVizinhanca() {
			return vizinhos.stream().filter(v -> v.minado).count();
		}
		void reinciar() {
			aberto = false;
			minado = false;
			marcado = false;
		}
		public String toString() {
			if(marcado) {
				return "x";
			}else if(aberto && minado) {
				return "*";
			}else if(aberto && minasNaVizinhanca() >0) {
				return Long.toString(minasNaVizinhanca());
			}else if(aberto) {
				return " ";
			}else {
				return "?";
			}
		}
}
