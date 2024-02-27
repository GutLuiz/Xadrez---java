package Chess;

import tabuleiro.Board;
import tabuleiro.Peça;

public abstract class PeçaDeXadrez extends Peça {
	private Cor cor;

	// Deixando apenas o get para que ninguem possa modificar a cor. Somente
	// acessada
	public Cor getCor() {
		return cor;
	}

	public PeçaDeXadrez(Board board, Cor cor) {
		super(board);
		this.cor = cor;
	}

}
