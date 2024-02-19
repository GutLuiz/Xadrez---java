package application;

import Chess.PartidaDeXadrez;

public class Program {

	public static void main(String[] args) {
		System.out.println("bem vindo!");
		System.out.println();
		
		PartidaDeXadrez partidadexadrez = new PartidaDeXadrez();
		Ui.printTabuleiro(partidadexadrez.getPeças());;
		
	}

}
