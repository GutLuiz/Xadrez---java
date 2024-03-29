package application.explanation;

public class ExplicaçãoDasClasses {

	
	
					--------> EXPLICAÇÕES DE CADA CLASSE DO PROJETO: <-------
		
		//PACOTE TABULEIRO:
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

		//PACOTE CHESS:
		classe COR: 
		= Declaração das cores do projeto (Branco, Preto)
		
		classe PeçaDeXadrez:
		= ela é uma classe abstrata que se extende a classe Peça(do pacote tabuleiro)
		= tem uma declaraçao de uma variavel privada da classe Cor chamada cor
		= tem somente seu getCor, para que ninguem possa modificar a cor, somente acessada.
		= tem um construtor com parametros, Board board (do pacote tabuleiro) e Cor cor, com o super da classe board.
		= tem um metodo existeUmOponente, para saber se tem um oponente na direçao da peça, com isso ele faz uma variavel p que é feito um downcasting da peça (com um parametro da posiçao), depois ele retorna uma peça que se nao é nula e que seja de cor diferente da mesma, sendo assim adversaria.

		Classe XadrezExceçao:
		Nessa classe tem somente um String msg pra quando der qualquer exceçao ele mostra uma mensagem que voce colocou, vale lembrar tambem que ele é uma sub classe do TabuleiroExceçao
		
		Classe XadrezPosiçao:
		Ela é responsavel por representar uma posiçao no tabuleiro de xadrez.
		= Tem os atributos privados coluna e linha.
		= Tem o construtor que recebe como parametro a coluna e a linha da posiçao no tabuleiro de xadrez.
		= Antes de atribuir os valores aos atributos, o progroma verifica se os valores estao dentro dos limites validos do tabuleiro, caso ao contrario lança uma exceçao do tipo XadrezExceçao.
		= Tem um metodo toPosiçao que converte a posiçao do tabuleiro de xadrez para a posiçao do tabuleiro padrao.
		= Tem outro metodo lugarDaPosiçao que é estatico, retorna um objeto XadrezPosiçao a partir de uma posição do tabuleiro padrao
		= E no final tem o ultimo metodo toString retorna uma representaçao em string da posiçao no formato "coluna + linha" (exemplo: a2 b7).
		
		
		Classe PartidaDeXadrez:
		Nessa classe é a uma das principais para o progroma acontecer:
			= ele tem os atributos:
				- Board board
				- int turno
				- Cor jogadorVez
				- Boolean check
				- boolean checkMate
				- PeçaDeXadrez enPassantVulneravel
				- PeçaDeXadrez promoçao

			= Ele tem as listas:
				- peçasDoTabuleiro : Essa lista controla as peças que estão no tabuleiro
				- peçasCapturadas: Essa lista controla as peças que foram capturadas.
			= Ele tem o construtor PartidaDeXadrez que inicia:
				- Mostrando o tabuleiro (8,8)
				- Começando com o turno = 1 (primeira jogada de cada jogador)
				- falando quem é o primeiro que começa a jogar (JogadorVez = branco)
				- Inicando o setup = colocando as peças distribuidas de maneira certa.
			= Ele tem todos os gets dos atributos.

			= Ele tem um metodo chamado "getPeças" que rettorna uma matriz que representa o esttado atual de todas as peças de xadrez no tabuleiro.
					== PeçaDeXadrez[][] mat = new PeçaDeXadrez[board.getLinhas()][board.getColunas()]:
						- Cria uma nova matriz "mat" com o mesmo tamanho do tabuleiro em que o jogo esta sendo jogado.
					== for (int i = 0; i < board.getLinhas(); i++):
						- Itera sobre as linhas do tabuleiro.
					== for (int j = 0; j < board.getColunas(); j++):
						- Itera sobre as colunas do tabuleiro.