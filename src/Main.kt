fun main () {
////////////////////////////////////////////////area de testes//////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var categoria: Pair<String,Int> = Pair("", 0) //declarando variavel que pegara o valor da categoria

    val nomesJogadores:Array<String?> = arrayOfNulls(20)//array que tera os nomes dos jogadores

    val jogosGanhosPerdidos:Array<Pair<Int,Int>?> = arrayOfNulls(20)//array com numero de vitorias e derrotas

    var estatistica = false//variavel que verifica se as estatisticas já foram lidas

    do {
        val opcao:Int = menuPrincipal()//pega e valida o primeira menu (retorna apenas 0,1,2,3,4,5)

        when (opcao){//se opção 1="Escolher categoria" ir para menu de categorias

            1->categoria = menuCategoria()//mostra o menu de categorias e valida a entrada de dados

            2->{//se opcao 2="Iniciar jogo" verificar se já tem categoria escolhida

                if (categoria.first != "" && categoria.second!=0) {//se categoria ja foi escolhida iniciar jogo

                    val nome:String = pegaNome()//pega nome e retorna se for valido

                    //gera a palavra a ser descoberta pela usuario no jogo da forca
                    val palavraJogo = geraPalavra(categoria.second,"palavras.txt")

                    if(palavraJogo!=null) {
                        jogoDaForca(categoria.second,palavraJogo)//FUNÇÃO DO JOGO PROPRIAMENTE DITO

                        categoria = Pair("", 0) //reset da categoria
                    }else{
                        println("Erro ao gerar palavra para o jogo, por favor tente novamente.")
                    }

                } else {//caso categoria não tenha sido escolhida ainda ou não tenha lido as estatisticas
                    if (!estatistica){//se as estatisticas ainda for false

                        println("\nTem que ler primeiro as estatisticas, tente novamente")//nao leu as estatisticas ainda
                    }else{
                        println("Tem que escolher primeiro a categoria, tente novamente")//nao escolheu a categoria ainda
                    }
                }
            }

            3->{
                //divide o array jogosGanhosPerdidos em dois arrays, um com apenas vitorias e outro apenas derrotas
                val jogos: Pair<Array<Int>,Array<Int>> = divideArray(jogosGanhosPerdidos)

                //constroi grafico
                println(constroiGrafico(nomesJogadores,jogos.first,jogos.second))
            }

            4->estatistica = leFicheiroEstatisticas("estatisticas.txt", nomesJogadores, jogosGanhosPerdidos)


            5->{
                //gravaFicheiroEstatisticas("estatisticas.txt",nomesJogadores ,jogosGanhosPerdidos)
            }
        }
    }while (opcao != 0)//enquanto opcao não for zero rodar o programa
}
