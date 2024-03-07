package Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Chess.peças.Bispo;
import Chess.peças.Cavalo;
import Chess.peças.Peao;
import Chess.peças.Rainha;
import Chess.peças.Rei;
import Chess.peças.Torre;
import tabuleiro.Board;
import tabuleiro.Peça;
import tabuleiro.Posiçao;

public class PartidaDeXadrez {
	private Board board;
	private int turno;
	private Cor jogadorVez;
	private boolean check;
	private boolean checkMate;
	private PeçaDeXadrez enPassantVulneravel;

	private List<Peça> peçasDoTabuleiro = new ArrayList<>(); // lista que controla as peças que estão no tabuleiro
	private List<Peça> peçasCapturadas = new ArrayList<>(); // lista que controla as peças que ja foram capturadas

	// colocando a dimensao do xadrez na classe adequada, pois nessa classe tera as
	// regras da partida!
	public PartidaDeXadrez() {
		board = new Board(8, 8);
		turno = 1;
		jogadorVez = Cor.WHITE;
		initialSetup();
	}

	public int getTurno() {
		return turno;
	}

	public Cor getJogadorVez() {
		return jogadorVez;
	}

	public boolean getCheck() {
		return check;
	}

	public boolean getCheckMate() {
		return checkMate;
	}
	
	public PeçaDeXadrez getEnPassantVulneravel() {
		return enPassantVulneravel;
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

	// metodo para imprimir as posiçoes possiveis a partir de uma posiçao de origem:
	public boolean[][] possivelMovimentos(XadrezPosiçao posiçaoFonte) {
		Posiçao posiçao = posiçaoFonte.toPosiçao();
		validaçaoDaPosiçaoFonte(posiçao);
		return board.peça(posiçao).possivelMovimentos();
	}

	public PeçaDeXadrez MovimentoXadrez(XadrezPosiçao posiçaoFonte, XadrezPosiçao posiçaoDestino) {
		// covertando as duas posições para posições da matriz:
		Posiçao fonte = posiçaoFonte.toPosiçao();
		Posiçao destino = posiçaoDestino.toPosiçao();
		validaçaoDaPosiçaoFonte(fonte); // fazendo uma operaçao para validar a posiçao de origem:
		validaçaoDaPosiçaoDestino(fonte, destino);
		Peça peçaCapturada = fazerMover(fonte, destino);
		// teste se o proprio jogador se colocou em check:

		if (TesteCheck(jogadorVez)) {
			DesfazerMovimento(fonte, destino, peçaCapturada);
			throw new XadrezExceçao("Voce nao pode se colocar em check");
		}
		
		PeçaDeXadrez peçaMoveu = (PeçaDeXadrez)board.peça(destino);
		

		check = (TesteCheck(oponente(jogadorVez))) ? true : false;

		// Teste se o jogador esta em checkMate:
		if (TesteCheckMate(oponente(jogadorVez))) {
			checkMate = true;
		} else {
			ProximoTurno();
		}
		
		// especial movimento en passant:
		if(peçaMoveu instanceof Peao && (destino.getLinha() == fonte.getLinha() -2 || fonte.getLinha() == destino.getLinha() + 2)) {
			enPassantVulneravel = peçaMoveu;
		}
		else {
			enPassantVulneravel = null;
		}

		return (PeçaDeXadrez) peçaCapturada; // fazendo um downcasting pois a peçaCapturada era do tipo Peça.
	}

	private void validaçaoDaPosiçaoFonte(Posiçao posiçao) {
		if (board.peça(posiçao) == null) {
			throw new XadrezExceçao("Não existe uma peça na posiçao de origem ");
		}
		if (jogadorVez != ((PeçaDeXadrez) board.peça(posiçao)).getCor()) {
			throw new XadrezExceçao("A peca escolhida nao e sua.");

		}
		if (board.peça(posiçao).existeMovimentoPossivel() == false) {
			throw new XadrezExceçao("Nao existe possibilidade de movimentacao da peca");
		}
	}

	private void validaçaoDaPosiçaoDestino(Posiçao fonte, Posiçao destino) {
		if (!board.peça(fonte).possivelMovimento(destino)) { // se pra peça de origem a posiçao de destino n for um
																// movimento possivel, singnifica que eu n posso mexer
																// pra la.
			throw new XadrezExceçao("Essa peca nao pode se mover para la.");
		}
	}

	private Peça fazerMover(Posiçao fonte, Posiçao destino) {
		PeçaDeXadrez p = (PeçaDeXadrez) board.RemoverPeça(fonte);
		p.AumentarContador();
		Peça peçaCapturada = board.RemoverPeça(destino);
		board.lugarPeça(p, destino);

		if (peçaCapturada != null) {
			peçasDoTabuleiro.remove(peçaCapturada);
			peçasCapturadas.add(peçaCapturada);
		}
		// especial movimento torre pequena:
		if (p instanceof Rei && destino.getColuna() == fonte.getColuna() + 2) {
			Posiçao fonteT = new Posiçao(destino.getLinha(), fonte.getColuna() + 3);
			Posiçao destinoT = new Posiçao(destino.getLinha(), fonte.getColuna() + 1);
			PeçaDeXadrez torre = (PeçaDeXadrez) board.RemoverPeça(fonteT);
			board.lugarPeça(torre, destinoT);
			torre.AumentarContador();
		}

		// especial movimento torre grande:
		if (p instanceof Rei && destino.getColuna() == fonte.getColuna() - 2) {
			Posiçao fonteT = new Posiçao(destino.getLinha(), fonte.getColuna() - 4);
			Posiçao destinoT = new Posiçao(destino.getLinha(), fonte.getColuna() - 1);
			PeçaDeXadrez torre = (PeçaDeXadrez) board.RemoverPeça(fonteT);
			board.lugarPeça(torre, destinoT);
			torre.AumentarContador();
		}

		return peçaCapturada;
	}

	// metodo para desfazer o movimento, pois o jogador nao pode fazer um movimento
	// que deixa o rei exposto ao check
	private void DesfazerMovimento(Posiçao fonte, Posiçao destino, Peça peçaCapturada) {
		PeçaDeXadrez p = (PeçaDeXadrez) board.RemoverPeça(destino);
		p.DiminuirContador();
		board.lugarPeça(p, fonte);

		if (peçaCapturada != null) {
			board.lugarPeça(peçaCapturada, destino);
			peçasCapturadas.remove(peçaCapturada);
			peçasDoTabuleiro.add(peçaCapturada);

		}
		// especial movimento torre pequena:
		if (p instanceof Rei && destino.getColuna() == fonte.getColuna() + 2) {
			Posiçao fonteT = new Posiçao(destino.getLinha(), destino.getColuna() + 3);
			Posiçao destinoT = new Posiçao(destino.getLinha(), destino.getColuna() + 1);
			PeçaDeXadrez torre = (PeçaDeXadrez) board.RemoverPeça(destinoT);
			board.lugarPeça(torre, fonteT);
			torre.DiminuirContador();
		}

		// especial movimento torre grande:
		if (p instanceof Rei && destino.getColuna() == fonte.getColuna() - 2) {
			Posiçao fonteT = new Posiçao(destino.getLinha(), destino.getColuna() - 4);
			Posiçao destinoT = new Posiçao(destino.getLinha(), destino.getColuna() - 1);
			PeçaDeXadrez torre = (PeçaDeXadrez) board.RemoverPeça(destinoT);
			board.lugarPeça(torre, fonteT);
			torre.DiminuirContador();
		}
	}

	private void ProximoTurno() {
		turno++;
		jogadorVez = (jogadorVez == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
	}

	private Cor oponente(Cor cor) {
		return (cor == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
	}

	private PeçaDeXadrez Rei(Cor cor) {
		List<Peça> list = peçasDoTabuleiro.stream().filter(x -> ((PeçaDeXadrez) x).getCor() == cor)
				.collect(Collectors.toList());

		for (Peça p : list) {
			if (p instanceof Rei) {
				return (PeçaDeXadrez) p;
			}
		}
		throw new RuntimeException("Nao existe o rei da " + cor + " no tabuleiro");
	}

	// Metodo para o check:
	private boolean TesteCheck(Cor cor) {
		Posiçao posiçaoDoRei = Rei(cor).getXadrezPosiçao().toPosiçao();
		List<Peça> peçasDoOponente = peçasDoTabuleiro.stream().filter(x -> ((PeçaDeXadrez) x).getCor() == oponente(cor))
				.collect(Collectors.toList());
		for (Peça p : peçasDoOponente) {
			boolean[][] mat = p.possivelMovimentos();
			if (mat[posiçaoDoRei.getLinha()][posiçaoDoRei.getColuna()]) {
				return true;
			}
		}
		return false;

	}

	private boolean TesteCheckMate(Cor cor) {
		if (!TesteCheck(cor)) {
			return false;
		}
		List<Peça> list = peçasDoTabuleiro.stream().filter(x -> ((PeçaDeXadrez) x).getCor() == cor)
				.collect(Collectors.toList());
		for (Peça p : list) {
			boolean[][] mat = p.possivelMovimentos();
			// se ele encontrar algum movimento que tire do check retornar falso se nao
			// retonar o verdadeiro depois do for.
			for (int i = 0; i < board.getLinhas(); i++) {
				for (int j = 0; j < board.getColunas(); j++) {
					if (mat[i][j]) {
						Posiçao fonte = ((PeçaDeXadrez) p).getXadrezPosiçao().toPosiçao();
						Posiçao destino = new Posiçao(i, j);
						Peça peçacap = fazerMover(fonte, destino);
						boolean testeCheck = TesteCheck(cor);
						DesfazerMovimento(fonte, destino, peçacap);
						if (!testeCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private void lugarDaNovaPeça(char coluna, int linha, PeçaDeXadrez peça) {
		board.lugarPeça(peça, new XadrezPosiçao(coluna, linha).toPosiçao());
		peçasDoTabuleiro.add(peça);
	}

	// Metodo para iniciar a partida colocando as peças no tabuleiro:
	private void initialSetup() {

		lugarDaNovaPeça('a', 1, new Torre(board, Cor.WHITE));
		lugarDaNovaPeça('b', 1, new Cavalo(board, Cor.WHITE));
		lugarDaNovaPeça('c', 1, new Bispo(board, Cor.WHITE));
		lugarDaNovaPeça('d', 1, new Rainha(board, Cor.WHITE));
		lugarDaNovaPeça('e', 1, new Rei(board, Cor.WHITE, this));
		lugarDaNovaPeça('f', 1, new Bispo(board, Cor.WHITE));
		lugarDaNovaPeça('g', 1, new Cavalo(board, Cor.WHITE));
		lugarDaNovaPeça('h', 1, new Torre(board, Cor.WHITE));
		lugarDaNovaPeça('a', 2, new Peao(board, Cor.WHITE,this));
		lugarDaNovaPeça('b', 2, new Peao(board, Cor.WHITE,this));
		lugarDaNovaPeça('c', 2, new Peao(board, Cor.WHITE,this));
		lugarDaNovaPeça('d', 2, new Peao(board, Cor.WHITE,this));
		lugarDaNovaPeça('e', 2, new Peao(board, Cor.WHITE,this));
		lugarDaNovaPeça('f', 2, new Peao(board, Cor.WHITE,this));
		lugarDaNovaPeça('g', 2, new Peao(board, Cor.WHITE,this));
		lugarDaNovaPeça('h', 2, new Peao(board, Cor.WHITE,this));

		lugarDaNovaPeça('a', 8, new Torre(board, Cor.BLACK));
		lugarDaNovaPeça('b', 8, new Cavalo(board, Cor.BLACK));
		lugarDaNovaPeça('c', 8, new Bispo(board, Cor.BLACK));
		lugarDaNovaPeça('d', 8, new Rainha(board, Cor.BLACK));
		lugarDaNovaPeça('e', 8, new Rei(board, Cor.BLACK, this));
		lugarDaNovaPeça('f', 8, new Bispo(board, Cor.BLACK));
		lugarDaNovaPeça('g', 8, new Cavalo(board, Cor.BLACK));
		lugarDaNovaPeça('h', 8, new Torre(board, Cor.BLACK));
		lugarDaNovaPeça('a', 7, new Peao(board, Cor.BLACK,this));
		lugarDaNovaPeça('b', 7, new Peao(board, Cor.BLACK,this));
		lugarDaNovaPeça('c', 7, new Peao(board, Cor.BLACK,this));
		lugarDaNovaPeça('d', 7, new Peao(board, Cor.BLACK,this));
		lugarDaNovaPeça('e', 7, new Peao(board, Cor.BLACK,this));
		lugarDaNovaPeça('f', 7, new Peao(board, Cor.BLACK,this));
		lugarDaNovaPeça('g', 7, new Peao(board, Cor.BLACK,this));
		lugarDaNovaPeça('h', 7, new Peao(board, Cor.BLACK,this));

	}
}
