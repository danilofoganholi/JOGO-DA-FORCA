fun main () {
////////////////////////////////////////////////area de testes//////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var categoria = 0//declarando variavel que pegara o valor da categoria
    do {
        val opcao:Int = menuPrincipal()//pega e valida o primeira menu (retorna apenas 0,1,2,3,4,5)

        when (opcao){//se opção 1="Escolher categoria" ir para menu de categorias

            1->categoria = menuCategoria()//mostra o menu de categorias, valida a entrada de dados e retorna (Frutas, Cidades ou Nomes)

            2->{//se opcao 2="Iniciar jogo" verificar se já tem categoria escolhida

                if (categoria != 0) {//se categoria ja foi escolhida iniciar jogo

                    val nome:String = pegaNome()//pega nome e retorna se for valido

                    //pergunta se quer com boneco ou sem boneco da forca
                    val boneco = perguntaBoneco()

                    //gera a palavra a ser descoberta pela usuario no jogo da forca
                    val palavraJogo = geraPalavra(categoria,"palavras.txt")

                    if(palavraJogo!=null) {
                        jogoDaForca(categoria,palavraJogo,boneco)//FUNÇÃO DO JOGO PROPRIAMENTE DITO
                        categoria = 0 //reset da categoria
                    }else{
                        println("Erro ao gerar palavra para o jogo, por favor tente novamente.")
                    }

                } else {//caso categoria não tenha sido escolhida ainda

                    println("Tem que escolher primeiro a categoria, tente novamente")//mensagem de erro
                }
            }

            3->{}

            4->{}

            5->{}
        }
    }while (opcao != 0)//enquanto opcao não for zero rodar o programa
}
