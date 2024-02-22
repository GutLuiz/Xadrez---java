package application;

import java.util.Scanner;

import Chess.PartidaDeXadrez;
import Chess.PeçaDeXadrez;
import Chess.XadrezPosiçao;

public class Program {

	public static void main(String[] args) {
		System.out.println("bem vindo!");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidadexadrez = new PartidaDeXadrez();
		while(true) {
			Ui.printTabuleiro(partidadexadrez.getPeças());
			System.out.println();
			System.out.print("Fonte: ");
			XadrezPosiçao fonte = Ui.lerXadrezPosiçao(sc);
			
			System.out.println();
			
			System.out.print("Destino: ");
			XadrezPosiçao destino = Ui.lerXadrezPosiçao(sc);
			
			PeçaDeXadrez peçaCap = partidadexadrez.MovimentoXadrez(fonte, destino);
		}
		
		
	}

}
