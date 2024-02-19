package tabuleiro;

/*
  Um tabuleiro deve ter:
  - Quantidade de linhas 
  - Quantidade de colunas 
  - E uma matriz de peças.
 */
public class Board {
	private int linhas;
	private int colunas;
	private Peça[][] peças;
	
	public Board(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.peças = new Peça[linhas][colunas]; // A matriz de peças vai ser instanciada na quantidade de linhas e na quantidade de colunas. 
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
	// criando um metodo pra retornar uma peça dada uma linha e uma coluna:
	
	public Peça peças(int linhas, int colunas) {
		return peças[linhas][colunas];
	}
	
	// Retornando a peça pela posiçao:
	public Peça peças(Posiçao posiçao) {
		return peças[posiçao.getLinha()][posiçao.getColuna()];
	}
	
	// Nesse metodo voce vai ter que atribuir a peça que esta na posiçao da linha tal e da coluna tal a posiçao que veio no argumento:
	public void lugarPeça(Peça peça, Posiçao posiçao) {
		peças[posiçao.getLinha()][posiçao.getColuna()] = peça;
		peça.posiçao = posiçao; // agora ela n esta mas nula pq ja tem um argumento.
	}
	
	
}
