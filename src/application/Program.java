package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Chess.PartidaDeXadrez;
import Chess.PeçaDeXadrez;
import Chess.XadrezExceçao;
import Chess.XadrezPosiçao;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidadexadrez = new PartidaDeXadrez();
		while(true) {
			try {
				Ui.limparTela();
				Ui.printDoJogo(partidadexadrez);
				System.out.println();
				System.out.print("Fonte: ");
				XadrezPosiçao fonte = Ui.lerXadrezPosiçao(sc);
				
				boolean[][] possivelMovimentos = partidadexadrez.possivelMovimentos(fonte);
				Ui.limparTela();
				Ui.printTabuleiro(partidadexadrez.getPeças(),possivelMovimentos);		
				
				System.out.println();
				
				System.out.print("Destino: ");
				XadrezPosiçao destino = Ui.lerXadrezPosiçao(sc);
				
				PeçaDeXadrez peçaCap = partidadexadrez.MovimentoXadrez(fonte, destino);
				
			}
			catch(XadrezExceçao e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
		}
		
		
	}

}
