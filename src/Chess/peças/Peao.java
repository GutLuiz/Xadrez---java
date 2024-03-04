package Chess.peças;

import Chess.Cor;
import Chess.PeçaDeXadrez;
import tabuleiro.Board;
import tabuleiro.Posiçao;

public class Peao extends PeçaDeXadrez {

	public Peao(Board board, Cor cor) {
		super(board, cor);

	}

	@Override
	public boolean[][] possivelMovimentos() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Posiçao p = new Posiçao(0, 0);
		
		if(getCor() == Cor.WHITE) {
			p.setValores(posiçao.getLinha() - 1 , posiçao.getColuna());
			if(getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posiçao.getLinha() - 2 , posiçao.getColuna());
			Posiçao p2 = new Posiçao (posiçao.getLinha() - 1 , posiçao.getColuna());
			if (getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p) && getBoard().posiçaoExistente(p2) && !getBoard().temUmaPeça(p)  && getContadorDeMovimento() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posiçao.getLinha() - 1 , posiçao.getColuna() - 1);
			if(getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posiçao.getLinha() - 1 , posiçao.getColuna() + 1);
			if(getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
		}
		else {
			p.setValores(posiçao.getLinha() + 1 , posiçao.getColuna());
			if(getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posiçao.getLinha() + 2 , posiçao.getColuna());
			Posiçao p2 = new Posiçao (posiçao.getLinha() + 1 , posiçao.getColuna());
			if (getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p) && getBoard().posiçaoExistente(p2) && !getBoard().temUmaPeça(p) && getContadorDeMovimento() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posiçao.getLinha() + 1 , posiçao.getColuna() - 1);
			if(getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posiçao.getLinha() + 1 , posiçao.getColuna() + 1);
			if(getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
		}
		
		return mat;
	}
	@Override
	public String toString() {
		return "P";
	}

}
