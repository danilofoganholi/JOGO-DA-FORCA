import java.io.*

//pega as categorias que estão no ficheiro indicado
fun leFicheiroCategorias(nomeFicheiro:String): Array<String>{
    try {
        val arrayArquivo = File(nomeFicheiro).readLines()//lendo arquivo categorias.txt se existir

        //inicializando array strings
        val arrayCategoria: Array<String> = Array(arrayArquivo[0].toInt(), { i -> i.toString()})

        for ( line in 1..arrayArquivo[0].toInt()){//linha por linha menos a primeira

            val parts = arrayArquivo[line].split(':')// partir a linha no caracter separador

            // converter para os tipos esperados
            val idCategoria = parts[0].toInt()
            val palavra = parts[1]

            arrayCategoria[idCategoria] = palavra//colocando palavra no lugar certo
        }

        return arrayCategoria//retorna array com palavras na ordem

    } catch (e: FileNotFoundException) {

        return emptyArray()//retorna array vazio
    }
}

//pega as estaticas que estão no ficheiro indicado
fun leFicheiroEstatisticas(nomeFicheiro:String, nomesJogadores: Array<String?>,jogosGanhosPerdidos:Array<Pair<Int,Int>?>): Boolean{

    try {
        val arrayArquivo = File(nomeFicheiro).readLines()//lendo arquivo de estatistica se existir

        if(arrayArquivo.isNotEmpty()){
            for (line in 0..arrayArquivo.size-1){//linha por linha

                val parts = arrayArquivo[line].split(':')// partir a linha no caracter separador


                val nomeJogador = parts[0] //nome dos jogadores
                val numeroVitorias = parts[1].toInt() // numero de vitorias
                val numeroDerrotas = parts[2].toInt() //numero de derrotas

                nomesJogadores[line] = nomeJogador//colocando o nome no array de nomes de jogador

                jogosGanhosPerdidos[line] = Pair(numeroVitorias,numeroDerrotas) //jogos ganhos e perdidos
            }

            if (validaArrays(nomesJogadores,jogosGanhosPerdidos)){//se os arrays tiverem um formato valido

                println("Estatisticas lidas com sucesso")//mensagem que deu tudo certo

                return true//retorna array com palavras na ordem

            }else{
                println("Erro na leitura do ficheiro de estatisticas")

                return true//retorna array vazio
            }
        }else{
            println("Ainda nao foram gravadas estatisticas")//mensagem que de erro

            return true//retorna array vazio
        }

    } catch (e: FileNotFoundException) {
        println("Ainda nao foram gravadas estatisticas")//mensagem que de erro

        return false//retorna array vazio
    }
}

//procura o jogador e passa a posição em que ele esta
fun procuraJogador(nomesJogadores:Array<String?>, nome: String): Int{

    for (posicao in 0..nomesJogadores.size - 1) {// verifica nomes
        if (nomesJogadores[posicao] == null) {// se o primeiro for null já return a posicao vaga
            return posicao

            // compara o nome com a posicao se forem iguais retorna a posicao
        } else if (nome.toUpperCase() == nomesJogadores[posicao]?.toUpperCase() ?: "") {
            return posicao
        }
    }
    return -1 // caso não acharem nenhum nome igual e nenhum null retorna o -1
}

//grava no ficheiro passado as estatisticas do array
fun gravaFicheiroEstatisticas(nomeFicheiro:String,nomesJogadores:Array<String?>,jogosGanhosPerdidos:Array<Pair<Int,Int>>):Boolean{

    try {
        val writer = File(nomeFicheiro).printWriter()

        for (posicao in 0 until jogosGanhosPerdidos.size) {
            if (nomesJogadores[posicao] != null) {
                writer.println("${nomesJogadores[posicao]}:${jogosGanhosPerdidos[posicao].first}" +
                        ":${jogosGanhosPerdidos[posicao].second}")
            } else {
                writer.print("${nomesJogadores[posicao]}:${jogosGanhosPerdidos[posicao].first}" +
                        ":${jogosGanhosPerdidos[posicao].second}")
            }
        }
        writer.close()
        println("Estatisticas gravadas com sucesso")
        return true
    }catch (e: FileNotFoundException) {
        return false
    }



}

