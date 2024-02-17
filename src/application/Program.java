package application;

import Chess.PartidaDeXadrez;

public class Program {

	public static void main(String[] args) {
		PartidaDeXadrez partidadexadrez = new PartidaDeXadrez();
		Ui.printTabuleiro(partidadexadrez.getPeças());;
		
	}

}
