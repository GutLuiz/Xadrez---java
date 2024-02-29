package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Chess.PartidaDeXadrez;
import Chess.PeçaDeXadrez;
import Chess.XadrezExceçao;
import Chess.XadrezPosiçao;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidadexadrez = new PartidaDeXadrez();
		List<PeçaDeXadrez> capturadas = new ArrayList<>();
		while(true) {
			try {
				Ui.limparTela();
				Ui.printDoJogo(partidadexadrez, capturadas);
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
				
				if(peçaCap != null) { // se a peça capturada for diferente de nulo, siginifica que tem uma peça capturada
					capturadas.add(peçaCap);
				}
				
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
