//jogo da forca propriamente dito, com os palpites e os erros
fun jogoDaForca(categoria:Int, palavra:String):Boolean{
    var numErros = 0 //variavel para guardar o numero de erros

    var numeroTentativas = 0 //variavl para guardar o numero de tentativas

    var palavraMascarada = montaArrayPalavra(palavra)//monta o primeiro array da palavra apenas com null e espaço

    var estruturaPalavra = estruturaPalavra(palavraMascarada)//monta string com a estrutura da palavra sem nenhum palpite ainda

    val mostraboneco = perguntaBoneco() //pergunta se quer com boneco ou sem boneco da forca

    do{//enquanto o numero de erros for menor que 5 continuar a pedir palpites

        run {
            if (mostraboneco) {//se for true monstra o boneco se for false não monstra o boneco

                println(constroiBonecoForca(numErros)) //monstra o boneco
            }
            mostraJogo(categoria, numErros, estruturaPalavra)//mostra o menu do jogo da forca
        }//mostra boneco forca

        val palpite: Char = pegaPalpite()//pede e valida o palpite

        numeroTentativas++//acrescentar um ao numero de tentativas

        if (numOcorrencias(palavra,palpite)==null){ //se o palpite não tiver ocorrencias

            numErros ++ //acrescentar 1 ao numero de erros

            if (numErros<6) { //se o numero de erros for menor que 6

                println(">>> Errado. A letra '$palpite' nao aparece.") // mensagem de erro

            }else{//caso contrario (igual ou maior que 6)

                run {
                    if (mostraboneco) {//se for true monstra o boneco se for false não monstra o boneco

                        println(constroiBonecoForca(numErros)) //monstra o boneco
                    }
                    mostraJogo(categoria, numErros, estruturaPalavra)//mostra o menu do jogo da forca
                }//mostra boneco forca morto

                //aviso que perdeu o jogo pois atingiu o limite de erros
                println("*** PERDEU! A palavra era \"$palavra\" ***")

                validaEnter()//pede para digitar o enter

                return false//retorna false(derrota) e volta para o main
            }
        }else{//se o numero de ocorrencias for diferente de 0

            //colocar as ocorrencias na palavra
            palavraMascarada = preencheOcorrencias(palavra,palavraMascarada,palpite)

            //monta estrutura da palavra com as letras acertadas
            estruturaPalavra = estruturaPalavra(palavraMascarada)

            //mostra quantas vezes o palpite aparece na palavra
            println(">>> Certo. A letra '$palpite' aparece ${numOcorrencias(palavra,palpite)}X.")
        }

        if (null !in palavraMascarada){//verifica se todas as letras ja foram adivinhadas

            //mensagem de vitoria caso já tenha descoberto todas as letras
            println("*** GANHOU ao fim de $numeroTentativas tentativas! A palavra era \"$palavra\" ***")

            validaEnter()//pede para digitar o enter

            return true // retorna true(vitoria) e volta para o main
        }
    }while (numErros<6)//enquanto o numero de erros for menor que 6

    return false//retorna false(derrota) e volta para o main
}