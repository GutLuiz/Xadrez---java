package Chess;

import tabuleiro.Board;
import tabuleiro.Peça;
import tabuleiro.Posiçao;

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
	
	protected boolean existeUmOponente(Posiçao posiçao) {
		PeçaDeXadrez p = (PeçaDeXadrez)getBoard().peça(posiçao);
		return p != null && p.getCor() != cor; // retorna uma peça que n e nula e que seja de cor diferente da mesma, sendo assim, uma cor adversaria.
	}
}
