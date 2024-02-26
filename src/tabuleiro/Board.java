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
		if (linhas < 1 || colunas < 1) { // exeçoes
			throw new TabuleiroExeçao("ERRO criando tabuleiro, e necessario que tenha uma linha e uma coluna!");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		this.peças = new Peça[linhas][colunas]; // A matriz de peças vai ser instanciada na quantidade de linhas e na
												// quantidade de colunas.
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	// criando um metodo pra retornar uma peça dada uma linha e uma coluna:

	public Peça peças(int linhas, int colunas) {
		if(!posiçaoExistente(linhas,colunas)) {
			throw new TabuleiroExeçao("Posiçao nao esta no quadro");
		}
		return peças[linhas][colunas];
	}

	// Retornando a peça pela posiçao:
	public Peça peça(Posiçao posiçao) {
		if(!posiçaoExistente(posiçao)) {
			throw new TabuleiroExeçao("Posicao nao esta no tabuleiro");
		}
		return peças[posiçao.getLinha()][posiçao.getColuna()];
	}

	// Nesse metodo voce vai ter que atribuir a peça que esta na posiçao da linha
	// tal e da coluna tal a posiçao que veio no argumento:
	public void lugarPeça(Peça peça, Posiçao posiçao) {
		if(temUmaPeça(posiçao)) {
			throw new TabuleiroExeçao("ja existe uma posicao" + posiçao);
		}
		
		peças[posiçao.getLinha()][posiçao.getColuna()] = peça;
		peça.posiçao = posiçao; // agora ela n esta mas nula pq ja tem um argumento.
	}
	
	public Peça RemoverPeça(Posiçao posiçao) {
		if(!posiçaoExistente(posiçao)) {
			throw new TabuleiroExeçao("Posicao nao esta no tabuleiro");
		}
		if(peça(posiçao) == null ) {
			return null;
		}
		Peça aux = peça(posiçao);
		aux.posiçao = null; // Essa peça nao tem mais posiçao
		peças[posiçao.getLinha()][posiçao.getColuna()] = null;
		return aux;
	}

	private boolean posiçaoExistente(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean posiçaoExistente(Posiçao posiçao) {
		return posiçaoExistente(posiçao.getLinha(), posiçao.getColuna());
	}

	public boolean temUmaPeça(Posiçao posiçao) {
		if(!posiçaoExistente(posiçao)) {
			throw new TabuleiroExeçao("Posicao nao esta no quadro");
		}
		return peça(posiçao) != null;
	}

}
