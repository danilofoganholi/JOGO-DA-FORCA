fun jogoDaForca(categoria:String, palavra:String){
    var numErros = 0 //variavel para guardar o numero de erros

    var estruturaPalavra = estruturaPalavra(palavra)//pega a estrutura da palavra sem nenhum palpite ainda

    do{//enquanto o numero de erros for menor que 5 continuar a pedir palpites

        mostraJogo(categoria,numErros,estruturaPalavra)//mostra o menu do jogo da forca

        val palpite: Char = pegaPalpite()

        if (numOcorrencias(palavra,palpite)==null){ //se o palpite não tiver ocorrencias

            numErros ++ //acrescentar 1 ao numero de erros

            if (numErros<6) { //se o numero de erros for menor que 6

                estruturaPalavra = estruturaPalavra(palavra,null) //deixar a estrutura apenas com tracinhos

                println(">>> Errado. A letra '$palpite' nao aparece.\n") // mensagem de erro

            }else{//caso contrario (igual ou maior que 6)

                //aviso que perdeu o jogo pois atingiu o limite de erros
                println("*** PERDEU! A palavra era \"$palavra\" ***")

                println("(prima enter para voltar ao menu)")//print de informação para voltar ao menu principal

                validaEnter()//valida se digitou apenas enter mesmo
            }
        }else{//se o numero de ocorrencias for diferente de 0

            //monta estrutura da palavra com as letras acertadas
            estruturaPalavra = estruturaPalavra(palavra,palpite)

            //mostra quantas vezes o palpite aparece na palavra
            println(">>> Certo. A letra '$palpite' aparece ${numOcorrencias(palavra,palpite)}X.\n")
        }
    }while (numErros<6)
}