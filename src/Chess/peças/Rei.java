package Chess.peças;

import Chess.Cor;
import Chess.PeçaDeXadrez;
import tabuleiro.Board;
import tabuleiro.Posiçao;

public class Rei extends PeçaDeXadrez {

	public Rei(Board board, Cor cor) {
		super(board, cor);
	}

	@Override
	public String toString() {
		return "R";
	}

	// metodo auxiliar:
	private boolean podeMover(Posiçao posiçao) {
		PeçaDeXadrez p = (PeçaDeXadrez) getBoard().peça(posiçao);
		return p == null || p.getCor() != getCor();
	}

	@Override
	public boolean[][] possivelMovimentos() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Posiçao p = new Posiçao(0, 0);

		// acima:
		p.setValores(posiçao.getLinha() - 1, posiçao.getColuna());
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// abaixo:

		p.setValores(posiçao.getLinha() + 1, posiçao.getColuna());
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// esquerda:
		p.setValores(posiçao.getLinha(), posiçao.getColuna() - 1);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// esquerda:
		p.setValores(posiçao.getLinha(), posiçao.getColuna() + 1);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// noroeste:
		p.setValores(posiçao.getLinha() - 1, posiçao.getColuna() - 1);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// nordeste
		p.setValores(posiçao.getLinha() - 1, posiçao.getColuna() + 1);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// sudoeste:
		p.setValores(posiçao.getLinha() + 1, posiçao.getColuna() - 1);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// sudeste
		p.setValores(posiçao.getLinha() + 1, posiçao.getColuna() + 1);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		return mat;
	}
}
