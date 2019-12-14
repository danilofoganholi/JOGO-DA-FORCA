fun main () {
    var categoria = ""//declarando variavel que pegara o valor da categoria
    do {
        val opcao:Int = menuPrincipal()//pega e valida o primeira menu (retorna apenas 0,1 e 2)

        when (opcao){//se opção 1="Escolher categoria" ir para menu de categorias

            1->categoria = menuCategoria()//mostra o menu de categorias, valida a entrada de dados e retorna (Frutas, Cidades ou Nomes)

            2->{//se opcao 2="Iniciar jogo" verificar se já tem categoria escolhida

                if (categoria != "") {//se categoria ja foi escolhida iniciar jogo

                    var nome:String = pegaNome()//pega nome e retorna se for valido

                    val palavraJogo = geraPalavra(categoria)//gera a palavra a ser descoberta pela usuario no jogo da forca

                    jogoDaForca(categoria,palavraJogo)//FUNÇÃO DO JOGO PROPRIAMENTE DITO

                    categoria = "" //reset da categoria

                    nome = "" // reset do nome

                } else {//caso categoria não tenha sido escolhida ainda

                    println("Tem que escolher primeiro a categoria, tente novamente")//mensagem de erro
                }
            }
        }
    }while (opcao != 0)//enquanto opcao não for zero rodar o programa
}








