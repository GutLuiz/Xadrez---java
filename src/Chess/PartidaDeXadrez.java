package Chess;

import Chess.peças.Rei;
import Chess.peças.Torre;
import tabuleiro.Board;
import tabuleiro.Peça;
import tabuleiro.Posiçao;

public class PartidaDeXadrez {
	private Board board;

	// colocando a dimensao do xadrez na classe adequada, pois nessa classe tera as
	// regras da partida!
	public PartidaDeXadrez() {
		board = new Board(8, 8);
		initialSetup();
	}

	// fazendo um metodo para retornar um matriz correspondente a essa partida:
	public PeçaDeXadrez[][] getPeças() {

		PeçaDeXadrez[][] mat = new PeçaDeXadrez[board.getLinhas()][board.getColunas()];
		for (int i = 0; i < board.getLinhas(); i++) {
			for (int j = 0; j < board.getColunas(); j++) {
				mat[i][j] = (PeçaDeXadrez) board.peças(i, j);
			}
		}
		return mat;
	}

	public PeçaDeXadrez MovimentoXadrez(XadrezPosiçao posiçaoFonte, XadrezPosiçao posiçaoDestino) {
		// covertando as duas posições para posições da matriz:
		Posiçao fonte = posiçaoFonte.toPosiçao();
		Posiçao destino = posiçaoDestino.toPosiçao();

		// fazendo uma operaçao para validar a posiçao de origem:
		validaçaoDaPosiçaoFonte(fonte);
		Peça peçaCapturada = fazerMover(fonte, destino);
		return (PeçaDeXadrez) peçaCapturada; // fazendo um downcasting pois a peçaCapturada era do tipo Peça.
	}

	private void validaçaoDaPosiçaoFonte(Posiçao posiçao) {
		if (board.peça(posiçao) == null) {
			throw new XadrezExceçao("Não existe uma peça na posiçao de origem ");
		}
		if(board.peça(posiçao).existeMovimentoPossivel() == false) {
			throw new XadrezExceçao("Nao existe possibilidade de movimentacao da peca");
		}
	}

	private Peça fazerMover(Posiçao fonte, Posiçao destino) {
		Peça p = board.RemoverPeça(fonte);
		Peça peçaCapturada = board.RemoverPeça(destino);
		board.lugarPeça(p, destino);
		return peçaCapturada;
	}

	private void lugarDaNovaPeça(char coluna, int linha, PeçaDeXadrez peça) {
		board.lugarPeça(peça, new XadrezPosiçao(coluna, linha).toPosiçao());
	}

	// Metodo para iniciar a partida colocando as peças no tabuleiro:
	private void initialSetup() {
		lugarDaNovaPeça('c', 1, new Torre(board, Cor.WHITE));
		lugarDaNovaPeça('c', 2, new Torre(board, Cor.WHITE));
		lugarDaNovaPeça('d', 2, new Torre(board, Cor.WHITE));
		lugarDaNovaPeça('e', 2, new Torre(board, Cor.WHITE));
		lugarDaNovaPeça('e', 1, new Torre(board, Cor.WHITE));
		lugarDaNovaPeça('d', 1, new Rei(board, Cor.WHITE));

		lugarDaNovaPeça('c', 7, new Torre(board, Cor.BLACK));
		lugarDaNovaPeça('c', 8, new Torre(board, Cor.BLACK));
		lugarDaNovaPeça('d', 7, new Torre(board, Cor.BLACK));
		lugarDaNovaPeça('e', 7, new Torre(board, Cor.BLACK));
		lugarDaNovaPeça('e', 8, new Torre(board, Cor.BLACK));
		lugarDaNovaPeça('d', 8, new Rei(board, Cor.BLACK));
	}
}
