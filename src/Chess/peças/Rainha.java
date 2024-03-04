package Chess.peças;

import Chess.Cor;
import Chess.PeçaDeXadrez;
import tabuleiro.Board;
import tabuleiro.Posiçao;

public class Rainha extends PeçaDeXadrez {
	public Rainha(Board board, Cor cor) {
		super(board, cor);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possivelMovimentos() {
		boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Posiçao p = new Posiçao(0, 0);
	

		// acima:

		p.setValores(posiçao.getLinha() - 1, posiçao.getColuna());
		// repetindo enquanto tiver casas vazias:
		while (getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// esquerda:

		p.setValores(posiçao.getLinha(), posiçao.getColuna() - 1);
		// repetindo enquanto tiver casas vazias:
		while (getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Direita:

		p.setValores(posiçao.getLinha(), posiçao.getColuna() + 1);
		// repetindo enquanto tiver casas vazias:
		while (getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Baixo:

		p.setValores(posiçao.getLinha() + 1, posiçao.getColuna());
		// repetindo enquanto tiver casas vazias:
		while (getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Noroeste:

		p.setValores(posiçao.getLinha() - 1, posiçao.getColuna() - 1);
		// repetindo enquanto tiver casas vazias:
		while (getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() - 1, p.getColuna() - 1);
			;
		}
		if (getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		// Nordeste:

		p.setValores(posiçao.getLinha() - 1, posiçao.getColuna() + 1);
		// repetindo enquanto tiver casas vazias:
		while (getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() - 1, p.getColuna() + 1);
			;
		}
		if (getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Sudeste:

		p.setValores(posiçao.getLinha() + 1, posiçao.getColuna() + 1);
		// repetindo enquanto tiver casas vazias:
		while (getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() + 1, p.getColuna() + 1);
			;
		}
		if (getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		// Sudoeste:

		p.setValores(posiçao.getLinha() + 1, posiçao.getColuna() - 1);
		// repetindo enquanto tiver casas vazias:
		while (getBoard().posiçaoExistente(p) && !getBoard().temUmaPeça(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setValores(p.getLinha() + 1, p.getColuna() - 1);
			;
		}
		if (getBoard().posiçaoExistente(p) && existeUmOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;

		
		}
		return mat;
	}	
}
