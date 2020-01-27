//constroi o boneco com a quantidade de erros passado
fun constroiBonecoForca(numErros:Int): String{
    return when (numErros) {
        //apenas a forca
        0 -> "_ _ _ _ _ \n|/       |\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|_____________"

        //forca+cabeca
        1 -> "_ _ _ _ _ \n|/    ___|___\n|     \\ ◆◆ /\n|      \\ ~ /\n|       \\_/\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|_____________"

        //forca+cabeca+corpo
        2 -> "_ _ _ _ _ \n|/    ___|___\n|     \\ ◆◆ /\n|      \\ ^ /\n|       \\_/" +
                "\n|       / \\\n|      /   \\\n|     |     |\n|      \\   /\n|       \\_/\n|\n|\n|\n|\n|_____________"

        //forca+cabeca+corpo+braco esquerdo
        3 -> "_ _ _ _ _ \n|/    ___|___\n|     \\ ◆◆ /\n|   ⨇ \\ ~ /\n|   \\ \\ \\_/" +
                "\n|    \\ \\/ \\\n|     \\/   \\\n|     |     |\n|      \\   /\n|       \\_/\n|\n|\n|\n|\n|_____________"

        //forca+cabeca+corpo+braco esquerdo+braco direito
        4 -> "_ _ _ _ _ \n|/    ___|___\n|     \\ ◆◆ /\n|   ⨇ \\ # / ⨇\n|   \\ \\ \\_/ / /" +
                "\n|    \\ \\/ \\/ /\n|     \\/   \\/\n|     |     |\n|      \\   /\n|       \\_/\n|\n|\n|\n|\n|_____________"

        //forca+cabeca+corpo+braco esquerdo+braco direito+perna esquerda
        5 -> "_ _ _ _ _ \n|/    ___|___\n|     \\ ◇◇ /\n|   ⨇ \\ ~ / ⨇\n|   \\ \\ \\_/ / /" +
                "\n|    \\ \\/ \\/ /\n|     \\/   \\/\n|     |     |\n" +
                "|      \\   /\n|      /\\_/\n|      ||\n|      ||\n|    __||\n|   |___|\n|_____________"

        //forca+cabeca+corpo+braco esquerdo+braco direito+perna esquerda+perna direita
        else -> "_ _ _ _ _ \n|/    ___|___\n|     \\ ✕✕ /\n|   ⨇ \\ □ / ⨇\n|   \\ \\ \\_/ / /" +
                "\n|    \\ \\/ \\/ /\n|     \\/   \\/\n|     |death|\n" +
                "|      \\   /\n|      /\\_/\\\n|      || ||\n|      || ||\n|    __|| ||__\n|   |___| |___|\n|_____________"
    }
}

//constroi o grafico dos jogadores
fun constroiGrafico(nomesJogadores: Array<String?>, jogosGanhos: Array<Int>, jogosPerdidos: Array<Int>) : String {

    colocaEmOrdem(nomesJogadores,jogosPerdidos,jogosGanhos)//coloca em ordem de acordo com os pontos calculados

    val blocoCinza = '\u2B1C' //bloco de derrota
    val blocoPreto = '\u2B1B' //bloco de vitoria
    val maiorPalavra = maiorPalavra(nomesJogadores)

    var graficoFinal = "\n------ ESTATISTICAS ------\n"//inicio da construcao do grafico

    if (jogosGanhos.isNotEmpty()) {//se o array jogosGanhos nao for vazio é porque já tem dados salvos anteriormente

        for (indice in jogosGanhos.indices) {// busca o nome dos jogares no primeiro array

            if (nomesJogadores[indice] != null) {//se o nome for diferente de null

                //coloca a quantidade de espaços para alinhar a direita
                val espaço = espacos(maiorPalavra,nomesJogadores[indice]?.length?:0)
                graficoFinal +="${espaço}${nomesJogadores[indice]}" //acrescenta ao gráfico o espaco mais o nome do jogador

                for (j in 1..jogosGanhos[indice]) {//acresenta a quantidade de vitórias
                    graficoFinal += blocoPreto
                }
                for (k in 1..jogosPerdidos[indice]) {//acresenta a quantidade de derrotas
                    graficoFinal += blocoCinza
                }
                graficoFinal += "\n"//ir para a proxima linha
            }
        }
        graficoFinal += "--------------------------"//fechar a construcao do grafico

    } else {//caso nao tenha nenhuma vitória é porque nao tem nenhum registro ainda

        graficoFinal = "\n------ ESTATISTICAS ------\n" +
                "Ainda ninguem jogou\n" +
                "--------------------------" // Caso ninguém tenha jogado ainda apresenta essa mensagem
    }
    return graficoFinal//retornar grafico final

}

// coloca em ordem os jogadores de acordo com os pontos calculados
fun colocaEmOrdem(nomesJogadores : Array<String?>, jogosPerdidos : Array<Int>, jogosGanhos: Array<Int> ){

    for(posicao in 0..jogosGanhos.size-2){//ir até antepenultima posição

        for (index in 0..jogosGanhos.size-2){

            //se a quantidade de pontos do proximo for maior, trocar os dois de lugar
            if ((jogosGanhos[index]*2)-jogosPerdidos[index]<(jogosGanhos[index+1]*2)-jogosPerdidos[index+1]){

                run {//Coloca em ordem os Pontos ganhos

                    val temporariaJogosGanhos = jogosGanhos[index] //guarda o valor
                    jogosGanhos[index] = jogosGanhos[index + 1] //troca o valor
                    jogosGanhos[index + 1] = temporariaJogosGanhos // devolve o valor salvo
                }
                run {//Coloca em ordem os jogos perdidos

                    val temporariaJogosPerdidos = jogosPerdidos[index]//guarda o valor
                    jogosPerdidos[index] = jogosPerdidos[index + 1]//troca o valor
                    jogosPerdidos[index + 1] = temporariaJogosPerdidos// devolve o valor salvo
                }

                run {// Coloca em ordem os nomes dos jogadores

                    val temporariaNomes = nomesJogadores[index]//guarda o valor
                    nomesJogadores[index] = nomesJogadores[index + 1]//troca o valor
                    nomesJogadores[index + 1] = temporariaNomes// devolve o valor salvo

                }
            }
        }
    }
}

//transforma o par de vitorias e derrotas em dois arrays separados
fun divideArray(jogosGanhosPerdidos: Array<Pair<Int,Int>?>): Pair<Array<Int>,Array<Int>>{

    var numeroJogadores = 0//varialvel que guardará a quantidade de jogadores que ja tem registro

    for(item in jogosGanhosPerdidos){//verifica item por item para saber se é jogador ou null

        if (item !=null){//se nao for null acrescenta no numero de jogadores
            numeroJogadores++
        }
    }
    val jogosGanhos: Array<Int> = Array(numeroJogadores,{0}) //criando array para pegar apenas a quantidade de vitorias

    val jogosPerdidos: Array<Int> = Array(numeroJogadores,{0}) //criando array para pegar apenas a quantidade de derrotas

    for (index in 0 until numeroJogadores){ //rodar ate o penultimo index

        jogosGanhos[index]= jogosGanhosPerdidos[index]?.first?:0 //atribuindo as vitorias

        jogosPerdidos[index]= jogosGanhosPerdidos[index]?.second?:0 // atribuindo as derrotas
    }

    return Pair(jogosGanhos,jogosPerdidos)
}

//tirar todos os valores null do array de jogosGanhosPerdidos
fun tiraNullArrayjogosGanhosPerdidos(jogosGanhosPerdidos:Array<Pair<Int,Int>?>):Array<Pair<Int,Int>>{

    var quantidadeDeVitoriasDerrotas = 0 //variavel que guardará o tamanho do array a ser construido

    for (item in jogosGanhosPerdidos){//percorre o array
        if (item!=null){ // se nao for null
            quantidadeDeVitoriasDerrotas++//acrescenta um
        }
    }
    //cria o array que guardara apenas valores nao nulls
    val arraySemNull:Array<Pair<Int,Int>>  = Array(quantidadeDeVitoriasDerrotas, { i -> Pair(i,i)})

    for(index in 0 until arraySemNull.size){ //percorre o array trocando os valores

        if (jogosGanhosPerdidos[index]!= null){//se nao for null, quarda valor no novo array

            arraySemNull[index]= jogosGanhosPerdidos[index]!!//coloca valor no novo array
        }
    }
    return arraySemNull//retorna array sem null
}

//atribui pontos quando o jogador acaba o jogo
fun atribuidorPontos(resultado:Boolean,nome:String,nomesJogadores:Array<String?>,jogosGanhosPerdidos:Array<Pair<Int,Int>?>){
    val indexSalvamento = procuraJogador(nomesJogadores,nome)//onde salvaremos os dados do jogo

    nomesJogadores[indexSalvamento]= nome//salvando nome no index de salvamento

    //atribuindo pontos para salvar
    if(resultado){//se o resultado for true o usuario ganhou o jogo

        if(jogosGanhosPerdidos[indexSalvamento]==null){ //se for null é o primeiro jogo dele

            jogosGanhosPerdidos[indexSalvamento] = Pair(1,0)//atribuindo primeiro ponto de vitoria

        }else{//se não for null é porque ele já tinha um dado salvo, teremos que somar ao dado antigo

            jogosGanhosPerdidos[indexSalvamento]= Pair((jogosGanhosPerdidos[indexSalvamento]?.first ?:0) +1
                , jogosGanhosPerdidos[indexSalvamento]?.second ?:0) //somando uma vitoria
        }
    }else{//se o resultado for false o usuario perdeu o jogo

        if(jogosGanhosPerdidos[indexSalvamento]==null){//se for null é o primeiro jogo dele

            jogosGanhosPerdidos[indexSalvamento] = Pair(0,1)//atribuindo primeiro ponto de derrota

        }else{//se não for null é porque ele já tinha um dado salvo, teremos que somar ao dado antigo

            jogosGanhosPerdidos[indexSalvamento]= Pair((jogosGanhosPerdidos[indexSalvamento]?.first ?:0)
                , (jogosGanhosPerdidos[indexSalvamento]?.second ?:0) +1)//somando uma derrota
        }
    }
}

//acrescenta a quantidade de espaços com relação a maior palavra e o nome atual
fun espacos(maiorPalavra : Int, nomeAtualTamanho : Int):String{

    val espacosVezes = maiorPalavra - nomeAtualTamanho//quantidade de espaços a ser colocada antes do nome

    var espaco = ""//quantidade de espaço para ser colocada

    for (i in 0 until espacosVezes){//numero de repetições

        espaco += " "//concatenador de espacos
    }
    return espaco//devolve a quantidade de espaços necessaria para alinhar a direita
}