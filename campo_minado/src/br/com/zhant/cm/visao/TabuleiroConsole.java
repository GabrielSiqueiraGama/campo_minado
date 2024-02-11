package br.com.zhant.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.zhant.cm.excecao.ExplosaoException;
import br.com.zhant.cm.excecao.SairException;
import br.com.zhant.cm.modelo.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner scn = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {

		try {
			boolean continuar = true;
			
			while(continuar) {
				cicloDoJogo();
				System.out.println("Outra rodada? (S/n)");
				String resposta = scn.nextLine();
				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				}else {
					tabuleiro.reiniciar();
				}
			}
		} catch (SairException e) {
			System.out.println("Tchau");
		}finally {
			scn.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro.toString());
				
				String digitado = capturarValorDigitado("Digite (x,y): ");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
					.map(e -> Integer.parseInt(e.trim())).iterator();
				
				digitado = capturarValorDigitado("1 - Abrir \n2 - (Des)Marcar ");
				if("1".equalsIgnoreCase(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				}else if("2".equalsIgnoreCase(digitado)) {
					tabuleiro.alterarMarcacao(xy.next(), xy.next());
				}
			
			}
			System.out.println("==== ヾ(⌐■_■)ノ♪ =====");
			System.out.println("======================");
			System.out.println("======================");
			System.out.println("==== Você ganhou =====");
			System.out.println("======================");
			System.out.println("======================");
			System.out.println("づ｡◕‿‿◕｡)づ ==========");
		} catch (ExplosaoException e) {
			System.out.println(tabuleiro);

			System.out.println("===== (ಥ﹏ಥ) ========");
			System.out.println("======================");
			System.out.println("======================");
			System.out.println("==== Você perdeu =====");
			System.out.println("======================");
			System.out.println("======================");
			System.out.println("(×﹏×) ======== （x_x；）");
		}
		
	}

	private String capturarValorDigitado(String texto) {
		System.out.println(texto);
		String digitado = scn.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		return digitado;
	}
	
	
}
