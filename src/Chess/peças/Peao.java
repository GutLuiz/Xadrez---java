package Chess.peças;

import Chess.Cor;
import Chess.PartidaDeXadrez;
import Chess.PeçaDeXadrez;
import tabuleiro.Board;
import tabuleiro.Posiçao;

public class Peao extends PeçaDeXadrez {
	
	private PartidaDeXadrez partidadexadrez;

	public Peao(Board board, Cor cor, PartidaDeXadrez partidadexadrez) {
		super(board, cor);
		this.partidadexadrez = partidadexadrez;
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
			
			// especial movimento en Passant branco:
			if(posiçao.getLinha() == 3) {
				Posiçao esquerda = new Posiçao(posiçao.getLinha(), posiçao.getColuna() - 1);
				if(getBoard().posiçaoExistente(esquerda) && existeUmOponente(esquerda) && getBoard().peça(esquerda) == partidadexadrez.getEnPassantVulneravel()) {
					mat[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
				}
				Posiçao direita = new Posiçao(posiçao.getLinha(), posiçao.getColuna() + 1);
				if(getBoard().posiçaoExistente(direita) && existeUmOponente(direita) && getBoard().peça(direita) == partidadexadrez.getEnPassantVulneravel()) {
					mat[direita.getLinha() - 1][direita.getColuna()] = true;
				}
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
			
			// especial movimento en Passant Preto:
			if(posiçao.getLinha() == 4) {
				Posiçao esquerda = new Posiçao(posiçao.getLinha(), posiçao.getColuna() - 1);
				if(getBoard().posiçaoExistente(esquerda) && existeUmOponente(esquerda) && getBoard().peça(esquerda) == partidadexadrez.getEnPassantVulneravel()) {
					mat[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
				}
				Posiçao direita = new Posiçao(posiçao.getLinha(), posiçao.getColuna() + 1);
				if(getBoard().posiçaoExistente(direita) && existeUmOponente(direita) && getBoard().peça(direita) == partidadexadrez.getEnPassantVulneravel()) {
					mat[direita.getLinha() + 1][direita.getColuna()] = true;
				}
			}
		}
		
		return mat;
	}
	@Override
	public String toString() {
		return "P";
	}

}
