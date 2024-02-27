package tabuleiro;

public abstract class Peça {

	protected  Posiçao posiçao; // Essa posiçao é protected, pois ela é uma posiçao simples de matriz, ela nao é
								// pra ser visivel para  uma certa posiçao no xadrez.
	private Board board;

	public Peça(Board board) {
		this.board = board;
		posiçao = null; // A Posiçao de inicio é nula.
	}

	protected Board getBoard() { // somente classe e sub classe do mesmo pacote podera acessar o tabuleiro de uma peça.
		return board;
	}
	
	//Um metodo concreto que utiliza o metodo abstrato: 
	public abstract boolean[][] possivelMovimentos();
	
	public boolean possivelMovimento(Posiçao posiçao) {
		return possivelMovimentos()[posiçao.getLinha()][posiçao.getColuna()];
	}
	
	// fazendo um metodo para testar se existe um possivel movimento:
	public boolean existeMovimentoPossivel() {
		boolean[][] mat = possivelMovimentos();
		for(int i = 0 ; i < mat.length; i ++) {
			for(int j = 0 ; j < mat.length; j ++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
