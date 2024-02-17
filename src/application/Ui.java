package application;

import Chess.PeçaDeXadrez;


//criando um metodo para imprimir um tabuleiro do formato que eu quero.

public class Ui {
	
	public static void printTabuleiro(PeçaDeXadrez[][] peças) {
		for(int i = 0 ; i < peças.length; i++) {
			System.out.print(8 - i + " ");
			for(int j = 0 ; j < peças.length; j++) {
				printPeça(peças[i][j]);	
			}
			System.out.println(); // para quebrar a linha
		}
		System.out.println("  a b  c d e f g h");
	}
	// criando um metodo auxiliar para imprimir uma peça:
	
	private static void printPeça(PeçaDeXadrez peça) {
		if(peça == null) {
			System.out.print("-");
		}
		else{
			System.out.print(peça);
		}
		System.out.print(" ");
	}
}
