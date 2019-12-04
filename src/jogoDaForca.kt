fun jogoDaForca(categoria:String, palavra:String){
    var numErros = 0 //variavel para guardar o numero de erros

    var estruturaPalavra = estruturaPalavra(palavra , null)//pega a estrutura da palavra sem nenhum palpite ainda

    while (numErros<6){//enquanto o numero de erros for menor que 5 continuar a pedir palpites

        run {
            println("Categoria: $categoria | Erros: $numErros\n" +
                        "Palavra: $estruturaPalavra\n" +
                        "Introduza uma letra:"
            )
        }//print do menu do jogo da forca

        var palpiteString = "" //variavel que vai guardar o valor do palpite em string para ser validada

        var validaPalpite = false //variavel para guardar a validacao do palpite

        while (validaPalpite==false){ //enquanto o palpite não for valido continuar a pedi-lo

            palpiteString = readLine()?: "" // pedindo palpite

            validaPalpite = validaPalpite(palpiteString)//validando palpite

            if (validaPalpite==false){println("Letra invalida, tente novamente")}//se palpite invalido mostrar erro e pedir de novo
        }

        val palpiteChar:Char = palpiteString[0] //passando o palpite de string para char

        if (numOcorrencias(palavra,palpiteChar)==null){ //se o palpite não tiver ocorrencias

            numErros ++ //acrescentar 1 ao numero de erros

            estruturaPalavra = estruturaPalavra(palavra,null) //deixar a estrutura apenas com tracinhos

            if (numErros<6) { //se o numero de erros for menor que 6

                println(">>> Errado. A letra ‘$palpiteChar’ nao aparece.\n") // mensagem de erro

            }else{//caso contrario (igual ou maior que 6)

                println("*** PERDEU! A palavra era “$palavra” ***")//aviso que perdeu o jogo pois atingiu o limite de erros

                println("(prima enter para voltar ao menu)")//print de informação para voltar ao menu principal

                do {
                    val enter = readLine()?:" "//pega o valor digitado

                    if (enter!= ""){//se não for apenas um enter

                        println("Digito invalido, prima enter para voltar ao menu")}// mensagem de erro

                }while (enter!= "")//verifica se digitou apenas "enter"
            }
        }else{//se o numero de ocorrencias for diferente de 0

            estruturaPalavra = estruturaPalavra(palavra,palpiteChar)//monta estrutura da palavra com as letras acertadas

            println(">>> Certo. A letra ‘$palpiteChar’ aparece ${numOcorrencias(palavra,palpiteChar)}X.\n") //mostra quantas vezes o palpite aparece na palavra
        }
    }
}