package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Chess.Cor;
import Chess.PartidaDeXadrez;
import Chess.PeçaDeXadrez;
import Chess.XadrezPosiçao;

//criando um metodo para imprimir um tabuleiro do formato que eu quero.

public class Ui {
	// cores do texto:
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	// cores do fundo:
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// codigo para limpar a tela no prompt:
	public static void limparTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static XadrezPosiçao lerXadrezPosiçao(Scanner sc) {
		try {
			// ler a coluna e a linha:

			String s = sc.nextLine();
			char coluna = s.charAt(0);
			int linha = Integer.parseInt(s.substring(1));
			return new XadrezPosiçao(coluna, linha);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Error em adicionar a posicao. valido ate a1 a h8");
		}
	}

	public static void printDoJogo(PartidaDeXadrez partida, List<PeçaDeXadrez> capturadas) {
		printTabuleiro(partida.getPeças());
		printDasPeçasCapturadas(capturadas);
		System.out.println();
		System.out.println("Turno: " + partida.getTurno());
		if (!partida.getCheckMate()) {
			System.out.println("Esperando jogador: " + partida.getJogadorVez());
			if (partida.getCheck()) {
				System.out.println("CHECK!");
			}
		}
		else {
			System.out.println("CHECKMATE!");
			System.out.println("Vencedor: " + partida.getJogadorVez());
		}
	}

	public static void printTabuleiro(PeçaDeXadrez[][] peças) {
		for (int i = 0; i < peças.length; i++) {
			System.out.print(8 - i + " ");
			for (int j = 0; j < peças.length; j++) {
				printPeça(peças[i][j], false);
			}
			System.out.println(); // para quebrar a linha
		}
		System.out.println("  a b c d e f g h");
	}

	// sobrecarba do tabbuleiro (para colocar cores nos possiveis movimentos):
	public static void printTabuleiro(PeçaDeXadrez[][] peças, boolean[][] possivelMovimentos) {
		for (int i = 0; i < peças.length; i++) {
			System.out.print(8 - i + " ");
			for (int j = 0; j < peças.length; j++) {
				printPeça(peças[i][j], possivelMovimentos[i][j]);
			}
			System.out.println(); // para quebrar a linha
		}
		System.out.println("  a b c d e f g h");
	}
	// criando um metodo auxiliar para imprimir uma peça:

	private static void printPeça(PeçaDeXadrez piece, boolean background) {
		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (piece == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if (piece.getCor() == Cor.WHITE) {
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
			}
		}
		System.out.print(" ");
	}

	private static void printDasPeçasCapturadas(List<PeçaDeXadrez> capturada) {
		List<PeçaDeXadrez> branca = capturada.stream().filter(x -> x.getCor() == Cor.WHITE)
				.collect(Collectors.toList()); // filtrando a lista
		List<PeçaDeXadrez> preto = capturada.stream().filter(x -> x.getCor() == Cor.BLACK).collect(Collectors.toList()); // filtrando
																															// a
																															// lista
		System.out.println("Pecas caputradas: ");
		System.out.print("Brancas: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(branca.toArray())); // Imprimindo um array de valores
		System.out.print(ANSI_RESET);
		System.out.print("Preto: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(preto.toArray()));
		System.out.print(ANSI_RESET);

	}
}
