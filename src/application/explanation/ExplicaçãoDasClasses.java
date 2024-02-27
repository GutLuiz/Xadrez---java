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
		= Ha outro metodo que tem a funçao de remover uma peça, nele antes de tudo tem a verificaçao defensiva mostrando se tem nao alguma posiçao existente é pra mostrar um exceçao, em seguida eu faço um outro if mostrando uma peça na determinada posiçao for nulo era pra simplismente retornar nulo, mas se isso nao acontecer eu faço o procedimento da retirada da peça do tabuleiro, depois e so colocar tudo em nulo que indica que nao tem mais peça na posiçao especificada pela matriz.
		= Ha  outro metodo que tem a funçao de colocar uma peça em uma determinada posição do tabuleiro.
		= Ha outro metodo que verifica uma posição (nas coordenadas linha e coluna) esta dentros dos limites do tabuleiro.
		= Ha outro metodo que verifica se a posição dada por um objeto esta dentro dos limites do tabuleiro.
		= E ha um ultimo metodo que verifica se tem uma peça em uma determinada posição do tabuleiro.
		
		classe PEÇA:
		= Tem uma declaração privada de uma variavel board (da classe Board)
		= No construtor da classe ele recebe um parameto do tipo Board que é o tabueleiro que a peça pertencera.
		= E tem um get do board que é protected pq somente a classe e a sub classe do mesmo pacote pode acessar o tabuleiro de uma peça. 
		= Tem um metodo abstrato (com isso a classe fica abstrata tambem) boleano sobre os posiveis movimentos de uma peça com uma matriz
		= Tem um outro metodo que é concreto que utiliza esse metodo abastrato que retorna os possiveis movimentos na matriz (linha e coluna)
		= Tem o ultimo metodo que é pra testar se existe um movimento possivel que se passar do FOR retorna o verdeiro para programa.
				
		
		classe Posiçao:
		=Tem duas declaraçoes privadas int e coluna.
		=Tem seu construtor e seus gets e sets
		=Tem um metodo toString para imprimir a posiçao no terminal
		
		classe TabuleiroExceçao:
		= Nessa classe extenda um RuntimeException pra que qualquer tipo de exceçao tenha uma mensagem.
		= Tem um construtor com um parametro de msg do tipo String e um super recebendo essa msg.

		
		classe COR: 
		= Declaração das cores do projeto (Branco, Preto)
}
