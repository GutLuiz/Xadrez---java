package tabuleiro;

public class Peça {

	protected Posiçao posiçao; // Essa posiçao é protected, pois ela é uma posiçao simples de matriz, ela nao é
								// pra ser visivel para a uma certa posiçao no xadrez.
	private Board board;

	public Peça(Board board) {
		this.board = board;
		posiçao = null; // A Posiçao da de inicio é nula.
	}

	protected Board getBoard() { // somente classe e sub classe do mesmo pacote podera acessar o tabuleiro de uma peça.
		return board;
	}
	
}
