package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Peca[][] tabuleiro = new Peca[8][8];                 // Declaração do array de tipo classe Peca
        boolean fimJogo = false;                               // Declaração de um bool para o fim de jogo

        insereDamas(tabuleiro);                             // Insere as damas no tabuleiro
        desenhaTabuleiro(tabuleiro);                        // Cria o tabuleiro

        do
        {
            System.out.println(" Jogador 1:");
            System.out.println();
            moveDama(tabuleiro);                        // chamamento do metodo
            desenhaTabuleiro(tabuleiro);                // Atualiza o tabuleiro

            System.out.println(" Jogador 2:");
            System.out.println();
            moveDama1(tabuleiro);                       // chamamento do metodo
            desenhaTabuleiro(tabuleiro);                // Atualiza o tabuleiro

        } while (fimJogo == false);

    }

    /**
     * Método que desenha o tabuleiro
     * @param tabuleiro1    Recebe o array de peças da main
     */
    static void desenhaTabuleiro(Peca[][] tabuleiro1)
    {

        int n = -1;             // Variável para a introdução dos números das colunas
        desenhaEspaco(40);      // Chamada do método para dar espaços no ecrã

        // Desenha as linhas das coordenadas
        System.out.print("  0    1    2    3    4    5    6    7   ");

        System.out.println();

        // Ciclo for que servem para o desenhar o tabuleiro e também desenha as colunas das coordenadas
        for (int i = 0; i < tabuleiro1.length; i++)
        {

            desenhaEspaco(40);          // Chamada do método para dar espaços no ecrã
            desenhaLinha(40);           // Chamada do método para dar espaços no ecrã
            desenhaEspaco(39);          // Chamada do método para dar espaços no ecrã


            System.out.print(n = n + 1);       // Desenha as colunas no tabuleiro

            // Ciclo for que servem para o desenhar o tabuleiro e também desenha as colunas das coordenadas
            for (int j = 0; j < tabuleiro1[0].length; j++)
            {
                // If para desenhar as paredes do tabuleiro, tendo em conta se existem damas nesses espaços ou não, se não tiver ele desenha as damas
                if (tabuleiro1[i][j] == null)
                {
                    System.out.print("|   |");
                }
                    else
                {
                    Peca dama = tabuleiro1[i][j];
                    System.out.print("| " + dama.getCor() + " |");
                }
            }
            System.out.println();
        }
    }

    /**
     * Método que desenha as damas e as insere no local correto dentro do tabuleiro
     * @param tabuleiro1    Recebe o array de peças da main
     */
    static void insereDamas(Peca[][] tabuleiro1)
    {
        for (int i = 0; i < tabuleiro1.length; i++)
        {
            for (int n = 0; n < tabuleiro1[0].length; n++)
            {
                tabuleiro1[i][n] = new Peca();

                // Desenha Peca
                if (i == 0 && n % 2 == 0)
                {
                    tabuleiro1[i][n].setCor('*');
                }

                // Desenha Peca
                if (i == 1 && n % 2 != 0)
                {
                    tabuleiro1[i][n].setCor('*');
                }

                // Desenha Peca
                if (i == 2 && n % 2 == 0)
                {
                    tabuleiro1[i][n].setCor('*');
                }

                // Desenha Peca
                if (i == 5 && n % 2 != 0)
                {
                    tabuleiro1[i][n].setCor('o');
                }

                // Desenha Peca
                if (i == 6 && n % 2 == 0)
                {
                    tabuleiro1[i][n].setCor('o');
                }

                // Desenha Peca
                if (i == 7 && n % 2 != 0)
                {
                    tabuleiro1[i][n].setCor('o');
                }
            }
        }
    }

    /**
     * Método para mover as damas com "*", ou seja as damas de cima do tabuleiro
     * @param tabuleiro1    Recebe o array de peças da main
     */
    public static void moveDama(Peca[][] tabuleiro1)
    {

        int linhaOrigem;                // Variável que guarda a linha do tabuleiro escolhida pelo utilizador
        int colunaOrigem;               // Variável que guarda a coluna do tabuleiro escolhida pelo utilizador
        String destino;                 // Variável que guarda a coodenada escolhida pelo utilizador, para mover a peça
        int validacao;                  // Proteção para se o que o utilizador introduzir não for o apropriado ao contexto. Por ex: A saída de uma peça do local de jogo ( o tabuleiro )

        // Declaração do scanner
        Scanner reader = new Scanner(System.in);

        // Ciclo que executa o código até que este seja concluido sem nenhum erro, utilizando a variável validação para a proteção dos dados
        do
        {
            validacao = 0;          // Sempre que o ciclo repetir a variável de repetição de código volta a 0 para evitar erros

            System.out.println(" Introduza a linha da peça que pretende");
            while(!reader.hasNextInt()) {
                System.out.println();
                System.out.println(" As coordenadas que introduziu não são válidas, por favor insira novas coordenadas ");
                System.out.println();
                System.out.println();
            }
            linhaOrigem = reader.nextInt();

            System.out.println(" Introduza a coluna da peça que pretende");
            while(!reader.hasNextInt()) {
                System.out.println();
                System.out.println(" As coordenadas que introduziu não são válidas, por favor insira novas coordenadas ");
                System.out.println();
                System.out.println();
            }
            colunaOrigem = reader.nextInt();

            // If que faz a proteção dos dados para se o utilizador introduzir um valor menor ou maior que os limites do array tabuleiro
            if (colunaOrigem < 0 || colunaOrigem > 7 || linhaOrigem < 0 || linhaOrigem > 7)
            {
                System.out.println();
                System.out.println(" Oops inseriu algo invalido. Por favor insira uma linha dentro dos limites do tabuleiro. ");
                System.out.println();
                System.out.println();
                validacao = 1;
            }
            else
            {
                // If que serve de proteção para que o jogador utilize peças adversárias, se o que for introduzido for uma peça sua então continua o jogo
                if (tabuleiro1[linhaOrigem][colunaOrigem].getCor() != '*')
                {
                    System.out.println();
                    System.out.println(" As coordenadas que introduziu não são válidas, por favor insira novas coordenadas ");
                    System.out.println();
                    System.out.println();
                    validacao = 1;
                }
                else{

                    System.out.println(" Selecione a direção da coordenada para a qual pretende mover a peça: Esquerda - E / Direita - D ");
                    destino = reader.next();

                    // If que executa o código de acordo com a cordenada introduzida pelo utilizador
                    if (destino.equals("e") || destino.equals("E"))
                    {
                        // If que é usado como proteção contra a escolha de uma coordenada em que a coluna é menor que 1, para que o programa não passe dos limites do array de peças
                        if (linhaOrigem <= 6 && colunaOrigem >= 1)
                        {
                            // If que é usado como proteção para o local para onde movermos a peça, neste caso não permite mover a peça para cima de uma peça da mesma equipa, ou seja não permite comer a peça da mesma equipa
                            if (tabuleiro1[linhaOrigem + 1][colunaOrigem - 1].getCor() != '*')
                            {
                                if (tabuleiro1[linhaOrigem + 1][colunaOrigem - 1].getCor() != 'o')
                                {
                                    tabuleiro1[linhaOrigem][colunaOrigem].setCor(' ');
                                    tabuleiro1[linhaOrigem + 1][colunaOrigem - 1].setCor('*');
                                }
                                else {
                                    // If que é usado como proteção contra a escolha de uma coordenada em que a coluna é menor que 2, para que o programa não passe dos limites do array de peças
                                    if (linhaOrigem + 2 <= 5 && colunaOrigem - 2 >= 2)
                                    {
                                        // If para comer uma peça adversária
                                        if (tabuleiro1[linhaOrigem + 1][colunaOrigem - 1].getCor() == 'o')
                                        {
                                            tabuleiro1[linhaOrigem][colunaOrigem].setCor(' ');
                                            tabuleiro1[linhaOrigem + 1][colunaOrigem - 1].setCor(' ');
                                            tabuleiro1[linhaOrigem + 2][colunaOrigem - 2].setCor('*');
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        // If que executa o código de acordo com a cordenada introduzida pelo utilizador
                        if (destino.equals("d") || destino.equals("D"))
                        {
                            // If que é usado como proteção contra a escolha de uma coordenada em que a coluna é maior que 6, para que o programa não passe dos limites do array de peças
                            if (linhaOrigem <= 6 && colunaOrigem <= 6)
                            {
                                // If que é usado como proteção para o local para onde movermos a peça, neste caso não permite mover a peça para cima de uma peça da mesma equipa, ou seja não permite comer a peça da mesma equipa
                                if (tabuleiro1[linhaOrigem + 1][colunaOrigem + 1].getCor() != '*')
                                {
                                    if (tabuleiro1[linhaOrigem + 1][colunaOrigem + 1].getCor() != 'o')
                                    {
                                        tabuleiro1[linhaOrigem][colunaOrigem].setCor(' ');
                                        tabuleiro1[linhaOrigem + 1][colunaOrigem + 1].setCor('*');
                                    }
                                }

                                // If que é usado como proteção contra a escolha de uma coordenada em que a coluna é menor que 2, para que o programa não passe dos limites do array de peças
                                if (linhaOrigem + 2 <= 5 && colunaOrigem + 2 <= 5)
                                {
                                    // If para comer uma peça adversária
                                    if (tabuleiro1[linhaOrigem + 1][colunaOrigem + 1].getCor() == 'o')
                                    {
                                        tabuleiro1[linhaOrigem][colunaOrigem].setCor(' ');
                                        tabuleiro1[linhaOrigem + 1][colunaOrigem + 1].setCor(' ');
                                        tabuleiro1[linhaOrigem + 2][colunaOrigem + 2].setCor('*');
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } while (validacao == 1);
    }

    /**
     * Método para mover as damas com "*", ou seja as damas de cima do tabuleiro
     * @param tabuleiro1    Recebe o array de peças da main
     */
    public static void moveDama1(Peca[][] tabuleiro1)
    {

        int linhaOrigem;                // Variável que guarda a linha do tabuleiro escolhida pelo utilizador
        int colunaOrigem;               // Variável que guarda a coluna do tabuleiro escolhida pelo utilizador
        String destino;                 // Variável que guarda a coodenada escolhida pelo utilizador, para mover a peça
        int validacao;              // Proteção para se o que o utilizador introduzir não for o apropriado ao contexto. Por ex: A saída de uma peça do local de jogo ( o tabuleiro )

        // Declaração do scanner
        Scanner reader = new Scanner(System.in);

        // Ciclo que executa o código até que este seja concluido sem nenhum erro, utilizando a variável validação para a proteção dos dados
        do
        {
            validacao = 0;          // Sempre que o ciclo repetir a variável de repetição de código volta a 0 para evitar erros

            System.out.println(" Introduza a linha da peça que pretende");
            while(!reader.hasNextInt()) {
                System.out.println();
                System.out.println(" As coordenadas que introduziu não são válidas, por favor insira novas coordenadas ");
                System.out.println();
                System.out.println();
            }
            linhaOrigem = reader.nextInt();

            System.out.println(" Introduza a coluna da peça que pretende");
            while(!reader.hasNextInt()) {
                System.out.println();
                System.out.println(" As coordenadas que introduziu não são válidas, por favor insira novas coordenadas ");
                System.out.println();
                System.out.println();
            }
            colunaOrigem = reader.nextInt();
            // If que faz a proteção dos dados para se o utilizador introduzir um valor menor ou maior que os limites do array tabuleiro
            if (colunaOrigem < 0 || colunaOrigem > 7 || linhaOrigem < 0 || linhaOrigem > 7)
            {
                System.out.println();
                System.out.println(" Oops inseriu algo invalido. Por favor insira uma linha dentro dos limites do tabuleiro. ");
                System.out.println();
                System.out.println();
                validacao = 1;
            }
            else
            {
                // If que serve de proteção para que o jogador utilize peças adversárias, se o que for introduzido for uma peça sua então continua o jogo
                if (tabuleiro1[linhaOrigem][colunaOrigem].getCor() != 'o')
                {
                    System.out.println();
                    System.out.println(" As coordenadas que introduziu não são válidas, por favor insira novas coordenadas ");
                    System.out.println();
                    System.out.println();
                    validacao = 1;
                }
                    else
                {
                    System.out.println(" Selecione a direção da coordenada para a qual pretende mover a peça: Esquerda - E / Direita - D ");
                    destino = reader.next();

                    // If que executa o código de acordo com a cordenada introduzida pelo utilizador
                    if (destino.equals("e") || destino.equals("E"))
                    {
                        // If que é usado como proteção contra a escolha de uma coordenada em que a coluna é menor que 1, para que o programa não passe dos limites do array de peças
                        if (linhaOrigem >= 1 && colunaOrigem >= 1)
                        {
                            // If que é usado como proteção para o local para onde movermos a peça, neste caso não permite mover a peça para cima de uma peça da mesma equipa, ou seja não permite comer a peça da mesma equipa
                            if (tabuleiro1[linhaOrigem - 1][colunaOrigem - 1].getCor() != 'o')
                            {
                                if (tabuleiro1[linhaOrigem - 1][colunaOrigem - 1].getCor() != '*')
                                {
                                    tabuleiro1[linhaOrigem][colunaOrigem].setCor(' ');
                                    tabuleiro1[linhaOrigem - 1][colunaOrigem - 1].setCor('o');
                                }

                                // If que é usado como proteção contra a escolha de uma coordenada em que a coluna é menor que 2, para que o programa não passe dos limites do array de peças
                                if (linhaOrigem - 2 >= 2 && colunaOrigem - 2 >= 2)
                                {
                                    // If para comer uma peça adversária
                                    if (tabuleiro1[linhaOrigem - 1][colunaOrigem - 1].getCor() == '*')
                                    {
                                        tabuleiro1[linhaOrigem][colunaOrigem].setCor(' ');
                                        tabuleiro1[linhaOrigem - 1][colunaOrigem - 1].setCor(' ');
                                        tabuleiro1[linhaOrigem - 2][colunaOrigem - 2].setCor('o');
                                    }
                                }
                            }
                        }
                        else
                        {
                            System.out.println();
                            System.out.println(" Oops inseriu algo invalido. Por favor insira coordenada dentro dos limites do tabuleiro. ");
                            System.out.println();
                            System.out.println();
                            validacao = 1;
                        }
                    }
                    else
                    {
                        // If que executa o código de acordo com a cordenada introduzida pelo utilizador
                        if (destino.equals("d") || destino.equals("D"))
                        {
                            // If que é usado como proteção contra a escolha de uma coordenada em que a coluna é maior que 6, para que o programa não passe dos limites do array de peças
                            if (linhaOrigem >= 1 && colunaOrigem <= 6)
                            {
                                // If que é usado como proteção para o local para onde movermos a peça, neste caso não permite mover a peça para cima de uma peça da mesma equipa, ou seja não permite comer a peça da mesma equipa
                                if (tabuleiro1[linhaOrigem - 1][colunaOrigem + 1].getCor() != 'o')
                                {
                                    if (tabuleiro1[linhaOrigem - 1][colunaOrigem + 1].getCor() != '*')
                                    {
                                        tabuleiro1[linhaOrigem][colunaOrigem].setCor(' ');
                                        tabuleiro1[linhaOrigem - 1][colunaOrigem + 1].setCor('o');
                                    }
                                }
                                    else
                                {
                                    // If que é usado como proteção contra a escolha de uma coordenada em que a coluna é menor que 2, para que o programa não passe dos limites do array de peças
                                    if (linhaOrigem - 2 >= 2 && colunaOrigem + 2 <= 5)
                                    {
                                        // If para comer uma peça adversária
                                        if (tabuleiro1[linhaOrigem - 1][colunaOrigem + 1].getCor() == '*')
                                        {
                                            tabuleiro1[linhaOrigem][colunaOrigem].setCor(' ');
                                            tabuleiro1[linhaOrigem - 1][colunaOrigem + 1].setCor(' ');
                                            tabuleiro1[linhaOrigem - 2][colunaOrigem + 2].setCor('o');
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } while (validacao == 1);
    }

    /**
     * Método que serve para meter linnhas
     * @param nLinha    Recebe o inteiro nLinhas
     */
    public static void desenhaLinha(int nLinha)
    {
        for (int i = 0; i < nLinha; i++)
        {
            System.out.print("-");
        }

        System.out.println();
    }

    /**
     * Método que serve para dar espaços
     * @param nEspaco   Recebe o inteiro nEspaco
     */
    public static void desenhaEspaco(int nEspaco)
    {
        // ciclo for para o numero de espaços
        for (int i = 0; i < nEspaco; i++)
        {
            System.out.print(" ");
        }
    }
}






