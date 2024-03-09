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
		while (!partidadexadrez.getCheckMate()) {
			try {
				Ui.limparTela();
				Ui.printDoJogo(partidadexadrez, capturadas);
				System.out.println();
				System.out.print("Fonte: ");
				XadrezPosiçao fonte = Ui.lerXadrezPosiçao(sc);

				boolean[][] possivelMovimentos = partidadexadrez.possivelMovimentos(fonte);
				Ui.limparTela();
				Ui.printTabuleiro(partidadexadrez.getPeças(), possivelMovimentos);

				System.out.println();

				System.out.print("Destino: ");
				XadrezPosiçao destino = Ui.lerXadrezPosiçao(sc);

				PeçaDeXadrez peçaCap = partidadexadrez.MovimentoXadrez(fonte, destino);

				if (peçaCap != null) { // se a peça capturada for diferente de nulo, siginifica que tem uma peça
										// capturada
					capturadas.add(peçaCap);
				}
				if (partidadexadrez.getPromoçao() != null) {
					System.out.print("Entre com a peca promovida (B/T/C/Q): ");
					String tipo = sc.nextLine().toUpperCase();
					while (!tipo.equals("B") && !tipo.equals("T") && !tipo.equals("C") && !tipo.equals("Q")) {
						System.out.print("valor invalido! Entre com a peca promovida (B/T/C/Q): ");
						tipo = sc.nextLine().toUpperCase();
					}
					partidadexadrez.trocarPeça(tipo);
				}

			} catch (XadrezExceçao e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}

		}
		Ui.limparTela();
		Ui.printDoJogo(partidadexadrez, capturadas);

	}

}
