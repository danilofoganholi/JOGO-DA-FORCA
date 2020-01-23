fun main () {
////////////////////////////////////////////////area de testes//////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var categoria: Pair<String,Int> = Pair("", -1) //declarando variavel que pegara o valor da categoria

    val nomesJogadores:Array<String?> = arrayOfNulls(20)//array que tera os nomes dos jogadores

    val jogosGanhosPerdidos:Array<Pair<Int,Int>?> = arrayOfNulls(20)//array com numero de vitorias e derrotas

    var estatistica = false//variavel que verifica se as estatisticas já foram lidas

    var nome = "" // variavel que guardará o nome do jogador

    var resultado = false // variavel que guardara o resultado do jogo

    do {
        val opcao:Int = menuPrincipal()//pega e valida o primeira menu (retorna apenas 0,1,2,3,4,5)

        when (opcao){//se opção 1="Escolher categoria" ir para menu de categorias

            1->categoria = menuCategoria()//mostra o menu de categorias e valida a entrada de dados

            2->{//se opcao 2="Iniciar jogo" verificar se já tem categoria escolhida

                if (categoria.first != "" && categoria.second!=-1 && estatistica) {//se categoria ja foi escolhida iniciar jogo

                    nome = pegaNome()//pega nome e retorna se for valido

                    //gera a palavra a ser descoberta pela usuario no jogo da forca
                    val palavraJogo = geraPalavra(categoria.second,"palavras.txt")

                    if(palavraJogo!=null) {
                        resultado= jogoDaForca(categoria.second,palavraJogo)//FUNÇÃO DO JOGO PROPRIAMENTE DITO

                        categoria = Pair("", -1) //reset da categoria
                    }else{
                        println("Erro ao gerar palavra para o jogo, por favor tente novamente.")
                    }

                } else {//caso categoria não tenha sido escolhida ainda ou não tenha lido as estatisticas

                    if (categoria.first== ""){

                        println("Tem que escolher primeiro a categoria, tente novamente")//nao escolheu a categoria ainda

                    }else{//se as estatisticas ainda for false

                        println("Tem que ler primeiro as estatisticas, tente novamente")//nao leu as estatisticas ainda
                    }
                }
            }

            3->{
                if(nome != ""){//se nome for diferente de "" significa que o usuaria já jogou
                    atribuidorPontos(resultado,nome,nomesJogadores,jogosGanhosPerdidos)
                }

                //divide o array jogosGanhosPerdidos em dois arrays, um com apenas vitorias e outro apenas derrotas
                val jogos: Pair<Array<Int>,Array<Int>> = divideArray(jogosGanhosPerdidos)

                println(constroiGrafico(nomesJogadores,jogos.first,jogos.second))//constroi grafico
                validaEnter()

                for( index in 0 until jogos.first.size){//reorganizando o array de jogos ganhos pela sequencia correta

                    jogosGanhosPerdidos[index]=Pair(jogos.first[index],jogos.second[index])
                }
            }

            4->{
                leFicheiroEstatisticas("estatisticas.txt", nomesJogadores, jogosGanhosPerdidos)
                validaEnter()
                estatistica = true // para marcar que ja foi lido as estatisticas
            }

            5->{
                for (nome in nomesJogadores){
                    if(nome != null){
                        atribuidorPontos(resultado,nome,nomesJogadores,jogosGanhosPerdidos)
                    }
                }

                val arrayJogos: Array<Pair<Int,Int>> = tiraNullArrayjogosGanhosPerdidos(jogosGanhosPerdidos)

                gravaFicheiroEstatisticas("estatisticas.txt",nomesJogadores ,arrayJogos)
                validaEnter()
            }
        }
    }while (opcao != 0)//enquanto opcao não for zero rodar o programa
}