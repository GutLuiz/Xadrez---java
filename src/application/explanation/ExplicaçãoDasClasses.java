package application.explanation;

public class ExplicaçãoDasClasses {

	/*
	
					--------> EXPLICAÇÕES DE CADA CLASSE NO PROJETO: <-------

		classe BOARD:
		= tem declaraçoes de variaveis, int coluna e linha e tambem tem a variavel Peça (da classe Peça) que é uma matriz de objetos do tipo "Peça".
		= No construtor dessa classe tem um IF, nessa condiçao de verificaçao que esta sendo usada para garantir que o tabuleiro seja criado com dimensões validas.
		= No construtotr tambem é possivel observar que a matriz peças vai ser instanciada pela quantidade de linhas e na quantidads de colunas se passar da verificação.
		= Ha tambem um metodo que retorna uma peça em uma determinada posição do tabuleiro, indentificada pelas coordenadas (linhas e colunas), esse metodo permite acessar e retornar a peça localizada em uma posição especifica.
		= Existe tambem uma sobrecarga do metodo anterior, mas desssa vez ele recebe um objeto do tipo "Posição" em vez de coordenadas individuais.
		= Ha  outro metodo que tem a funçao de colocar uma peça em uma determinada posição do tabuleiro.
		= Ha outro metodo que verifica uma posição (nas coordenadas linha e coluna) esta dentros dos limites do tabuleiro.
		= Ha outro metodo que verifica se a posição dada por um objeto esta dentro dos limites do tabuleiro.
		= E ha um ultimo metodo que verifica se tem uma peça em uma determinada posição do tabuleiro.
		
		classe PEÇA:
		= Tem uma declaração privada de uma variavel board (da classe Board)
		= No construtor da classe ele recebe um parameto do tipo Board que é o tabueleiro que a peça pertencera.
		= E tem um get do board que é protected pq somente a classe e a sub classe do mesmo pacote pode acessar o tabuleiro de uma peça. 
		
		classe COR: 
		= Declaração das cores do projeto (Branco, Preto)
}
