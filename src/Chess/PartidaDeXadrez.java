package Chess;

import Chess.peças.Rei;
import Chess.peças.Torre;
import tabuleiro.Board;
import tabuleiro.Posiçao;

public class PartidaDeXadrez {
	private Board board;

	// colocando a dimensao do xadrez na classe adequada, pois nessa classe tera as
	// regras da partida!
	public PartidaDeXadrez() {
		board = new Board(9, 9);
		initialSetup();
	}

	// fazendo um metodo para retornar um matriz correspondente a essa partida:
	public PeçaDeXadrez[][] getPeças() {

		PeçaDeXadrez[][] mat = new PeçaDeXadrez[board.getLinhas()][board.getColunas()];
		for (int i = 1; i < board.getLinhas(); i++) {
			for (int j = 1; j < board.getColunas(); j++) {
				mat[i][j] = (PeçaDeXadrez) board.peças(i, j);
			}
		}
		return mat;
	}
	
	//Metodo para iniciar a partida colocando as peças no tabuleiro:
	private void initialSetup() {
		board.lugarPeça(new Torre(board,Cor.WHITE), new Posiçao(2, 1));
		board.lugarPeça(new Rei(board, Cor.BLACK), new Posiçao(0,4));
		board.lugarPeça(new Rei(board, Cor.WHITE), new Posiçao(7,4));
	}
}
