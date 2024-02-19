package Chess.peças;

import Chess.Cor;
import Chess.PeçaDeXadrez;
import tabuleiro.Board;

public class Rei extends PeçaDeXadrez{

	public Rei(Board board, Cor cor) {
		super(board, cor);
	}
	
	@Override
	public String toString() {
		return "K";
	}

}
