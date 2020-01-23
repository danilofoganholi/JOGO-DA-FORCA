//constroi o boneco com a quantidade de erros passado
fun constroiBonecoForca(numErros:Int): String{

   if (numErros==0){
       return forca()
   }else if(numErros==1){
       return cabeca()
   }else if(numErros==2){
       return corpo()
   }else if(numErros==3){
       return bracoEsquerdo()
   }else if(numErros==4){
       return bracoDireito()
   }else if(numErros==5){
       return pernaEsquerda()
   }else{
       return pernaDireita()
   }
}

//constroi o grafico dos jogadores
fun constroiGrafico(nomesJogadores: Array<String?>, jogosGanhos: Array<Int>, jogosPerdidos: Array<Int>) : String {

    colocaEmOrdem(pontosJogadores(jogosGanhos,jogosPerdidos),nomesJogadores,jogosPerdidos,jogosGanhos)

    val maiorPalavra = maiorPalavra(nomesJogadores)
    val blocoCinza = '\u2B1C'
    val blocoPreto = '\u2B1B'
    var count = 0 // variavel rotativa
    var grafico = " "
    var graficoFinal = "\n------ ESTATISTICAS ------\n"
    var espaco = ""
    if(jogosGanhos.isNotEmpty()) {
        if (jogosGanhos.size > 0) {
            for (i in count..jogosGanhos.size - 1) {// busca o nome dos jogares no primeiro array
                if (nomesJogadores[count] != null) {

                    for (j in 0 until jogosGanhos[count]) { // Acrescenta Blocos pretos no grafico
                        grafico = "${grafico}${blocoPreto}"
                    }
                    for (h in 0 until jogosPerdidos[count]) { // Acrescenta blocos cinzas no grafico
                        grafico = "${grafico}${blocoCinza}"
                    }
                    for (numerosEspacos in 0 until maiorPalavra - (nomesJogadores[count]?.length
                        ?: 0)) { //acrescenta espaços no grafico final
                        espaco += " "
                    }
                    graficoFinal += "${espaco}${nomesJogadores[count]}${grafico}\n" // monta graficofinal
                }
                run {
                    count++
                    grafico = " "
                    espaco = ""

                }// Reseta as variaveis
            }
        } else {
            return "\n------ ESTATISTICAS ------\n" +
                    "Ainda ninguem jogou\n" +
                    "--------------------------" // Caso ninguém tenha jogado ainda apresenta essa mensagem
        }
    }else {
        return "\n------ ESTATISTICAS ------\n" +
                "Ainda ninguem jogou\n" +
                "--------------------------" // Caso ninguém tenha jogado ainda apresenta essa mensagem
    }

    return "$graficoFinal--------------------------"
}

// Essa função calcula os pontos dos jogadores para saber as posições corretas
fun pontosJogadores(jogosGanhos: Array<Int>, jogosPerdidos: Array<Int>) : Array<Int>{
    val pontosGanhos : Array<Int> = Array(jogosGanhos.size){0}
    for (i in 0..jogosGanhos.size-1){
        val pontos = (jogosGanhos[i]*2)-(jogosPerdidos[i])
        pontosGanhos[i] = pontos
    }

    return pontosGanhos
}

fun colocaEmOrdem(pontosGanhos : Array<Int> ,nomesJogadores : Array<String?>, jogosPerdidos : Array<Int>, jogosGanhos: Array<Int> ){

    for(passador in 0 until (pontosGanhos.size-1)) {
        for (posicaoatual in 0 until (pontosGanhos.size-1)){
            if (pontosGanhos[posicaoatual]<pontosGanhos[posicaoatual+1]){
                run {
                    val temporariaPontosGanhos = pontosGanhos[posicaoatual]
                    pontosGanhos[posicaoatual] = pontosGanhos[posicaoatual + 1]
                    pontosGanhos[posicaoatual + 1] = temporariaPontosGanhos
                } //Coloca em ordem os Pontos ganhos
                run {
                    val temporariaJogosPerdidos = jogosPerdidos[posicaoatual]
                    jogosPerdidos[posicaoatual] = jogosPerdidos[posicaoatual + 1]
                    jogosPerdidos[posicaoatual + 1] = temporariaJogosPerdidos
                }//Coloca em ordem os jogos perdidos

                run { if (nomesJogadores[posicaoatual]!=null) {
                    val temporariaNomes = nomesJogadores[posicaoatual]
                    nomesJogadores[posicaoatual] = nomesJogadores[posicaoatual + 1]
                    nomesJogadores[posicaoatual + 1] = temporariaNomes
                }// Coloca em ordem os nomes dos jogadores
                }
                run {
                    val temporariaJogosGanhos = jogosGanhos[posicaoatual]
                    jogosGanhos[posicaoatual] = jogosGanhos[posicaoatual + 1]
                    jogosGanhos[posicaoatual + 1] = temporariaJogosGanhos
                }// Coloca em ordem os nomes dos jogadores
            }
        }
    }
}

fun divideArray(jogosGanhosPerdidos: Array<Pair<Int,Int>?>): Pair<Array<Int>,Array<Int>>{

    var numeroJogadores = 0//varialvel que guardará a quantidade de jogadores que ja tem registro

    for(item in jogosGanhosPerdidos){//verifica item por item para saber se é jogador ou null

        if (item !=null){//se nao for null acrescenta no numero de jogadores
            numeroJogadores++
        }
    }
    val jogosGanhos: Array<Int> = Array(numeroJogadores,{0}) //criando array para pegar apenas a quantidade de vitorias
    val jogosPerdidos: Array<Int> = Array(numeroJogadores,{0}) //criando array para pegar apenas a quantidade de derrotas

    for (index in 0..numeroJogadores-1){
        jogosGanhos[index]= jogosGanhosPerdidos[index]?.first!!
        jogosPerdidos[index]= jogosGanhosPerdidos[index]?.second!!
    }

    return Pair(jogosGanhos,jogosPerdidos)
}

fun forca():String{
    return "_ _ _ _ _ \n|/       |\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|_____________"
}

fun cabeca():String{
    return "_ _ _ _ _ \n|/    ___|___\n|     \\ ◆◆ /\n|      \\ ~ /\n|       \\_/\n|\n|\n|\n|\n|\n|\n|\n|\n|\n|_____________"
}

fun corpo():String{
    return "_ _ _ _ _ \n|/    ___|___\n|     \\ ◆◆ /\n|      \\ ^ /\n|       \\_/" +
            "\n|       / \\\n|      /   \\\n|     |     |\n|      \\   /\n|       \\_/\n|\n|\n|\n|\n|_____________"
}

fun bracoEsquerdo():String{
    return "_ _ _ _ _ \n|/    ___|___\n|     \\ ◆◆ /\n|   ⨇ \\ ~ /\n|   \\ \\ \\_/" +
            "\n|    \\ \\/ \\\n|     \\/   \\\n|     |     |\n|      \\   /\n|       \\_/\n|\n|\n|\n|\n|_____________"
}

fun bracoDireito():String{
    return "_ _ _ _ _ \n|/    ___|___\n|     \\ ◆◆ /\n|   ⨇ \\ # / ⨇\n|   \\ \\ \\_/ / /" +
            "\n|    \\ \\/ \\/ /\n|     \\/   \\/\n|     |     |\n|      \\   /\n|       \\_/\n|\n|\n|\n|\n|_____________"
}

fun pernaEsquerda():String{
    return "_ _ _ _ _ \n|/    ___|___\n|     \\ ◇◇ /\n|   ⨇ \\ ~ / ⨇\n|   \\ \\ \\_/ / /" +
            "\n|    \\ \\/ \\/ /\n|     \\/   \\/\n|     |     |\n" +
            "|      \\   /\n|      /\\_/\n|      ||\n|      ||\n|    __||\n|   |___|\n|_____________"
}

fun pernaDireita():String{
    return "_ _ _ _ _ \n|/    ___|___\n|     \\ ✕✕ /\n|   ⨇ \\ □ / ⨇\n|   \\ \\ \\_/ / /" +
            "\n|    \\ \\/ \\/ /\n|     \\/   \\/\n|     |death|\n" +
            "|      \\   /\n|      /\\_/\\\n|      || ||\n|      || ||\n|    __|| ||__\n|   |___| |___|\n|_____________"
}

fun tiraNullArrayjogosGanhosPerdidos(jogosGanhosPerdidos:Array<Pair<Int,Int>?>):Array<Pair<Int,Int>>{
    var quantidadeDeVitoriasDerrotas = 0
    for (i in jogosGanhosPerdidos){
        if (i!=null){
            quantidadeDeVitoriasDerrotas++
        }
    }
    val arraySemNull:Array<Pair<Int,Int>>  = Array(quantidadeDeVitoriasDerrotas, { i -> Pair(i,i)})

    for(index in 0..arraySemNull.size-1){
        if (jogosGanhosPerdidos[index]!= null){
            arraySemNull[index]= jogosGanhosPerdidos[index]!!
        }
    }
    return arraySemNull
}

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