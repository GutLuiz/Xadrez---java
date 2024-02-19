package Chess.peças;

import Chess.Cor;
import Chess.PeçaDeXadrez;
import tabuleiro.Board;

public class Torre extends PeçaDeXadrez {
	
	public Torre(Board board, Cor cor) {
		super(board, cor);
	}

	@Override
	public String toString() {
		return "R";
	}
}
