package Chess.peças;

import Chess.Cor;
import Chess.PeçaDeXadrez;
import tabuleiro.Board;
import tabuleiro.Posiçao;

public class Cavalo extends PeçaDeXadrez {
	public Cavalo(Board board, Cor cor) {
		super(board, cor);
	}

	@Override
	public String toString() {
		return "C";
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

	
		p.setValores(posiçao.getLinha() - 1, posiçao.getColuna() - 2);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		
		p.setValores(posiçao.getLinha()  - 2, posiçao.getColuna() - 1);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

	
		p.setValores(posiçao.getLinha() - 2, posiçao.getColuna() + 1);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
	
		p.setValores(posiçao.getLinha() - 1, posiçao.getColuna() + 2);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		
		p.setValores(posiçao.getLinha() + 1, posiçao.getColuna() + 2);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
	
		p.setValores(posiçao.getLinha() + 2, posiçao.getColuna() + 1);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValores(posiçao.getLinha() + 2, posiçao.getColuna() - 1);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValores(posiçao.getLinha() + 1, posiçao.getColuna() - 2);
		if (getBoard().posiçaoExistente(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		return mat;
	}
}
