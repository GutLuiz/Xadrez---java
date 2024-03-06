package Chess.peças;

import Chess.Cor;
import Chess.PartidaDeXadrez;
import Chess.PeçaDeXadrez;
import tabuleiro.Board;
import tabuleiro.Posiçao;

public class Rei extends PeçaDeXadrez {
	private PartidaDeXadrez partidadexadrez;
	
	public Rei(Board board, Cor cor , PartidaDeXadrez partidadexadrez) {
		super(board, cor);
		this.partidadexadrez = partidadexadrez;
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
	
	private boolean testeTorreCast(Posiçao posiçao) {
		PeçaDeXadrez p = (PeçaDeXadrez)getBoard().peça(posiçao);
		return p != null && p instanceof Torre && p.getCor() == getCor() && p.getContadorDeMovimento() == 0;
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
		
		// Movimento especial da torre pequena :
		if(getContadorDeMovimento() == 0 && !partidadexadrez.getCheck()) {
			// Se o rei esta do lado da torre;
			Posiçao posT1 = new Posiçao(posiçao.getLinha(), posiçao.getColuna() + 3);
			if(testeTorreCast(posT1)) {
				Posiçao p1 =  new Posiçao(posiçao.getLinha(), posiçao.getColuna() + 1);
				Posiçao p2 =  new Posiçao(posiçao.getLinha(), posiçao.getColuna() + 2);
				if(getBoard().peça(p1) == null && getBoard().peça(p2) == null) {
					mat[posiçao.getLinha()][posiçao.getColuna() + 2] = true;
				}
			}
			
			Posiçao posT2 = new Posiçao(posiçao.getLinha(), posiçao.getColuna() - 4);
			if(testeTorreCast(posT2)) {
				Posiçao p1 =  new Posiçao(posiçao.getLinha(), posiçao.getColuna() - 1);
				Posiçao p2 =  new Posiçao(posiçao.getLinha(), posiçao.getColuna() - 2);
				Posiçao p3 =  new Posiçao(posiçao.getLinha(), posiçao.getColuna() - 3);

				if(getBoard().peça(p1) == null && getBoard().peça(p2) == null && getBoard().peça(p3) == null) {
					mat[posiçao.getLinha()][posiçao.getColuna() - 2] = true;
				}
			}
			
		}
		
		
		return mat;
	}
}
