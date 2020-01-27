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

    } catch (e: FileNotFoundException) {//caso o arquivo nao seja encontrado

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

            return posicao//retorna posicao

         // compara o nome com a posicao se forem iguais retorna a posicao
        } else if (nome.toUpperCase() == nomesJogadores[posicao]?.toUpperCase() ?: "") {

            return posicao//retorna posicao
        }
    }
    return -1 // caso não acharem nenhum nome igual e nenhum null retorna o -1
}

//grava no ficheiro passado as estatisticas do array
fun gravaFicheiroEstatisticas(nomeFicheiro:String,nomesJogadores:Array<String?>,jogosGanhosPerdidos:Array<Pair<Int,Int>>):Boolean{

    try {
        val writer = File(nomeFicheiro).printWriter()//pega arquivo para escrever

        for (posicao in 0 until jogosGanhosPerdidos.size) {//monta linha por linha

            val linha = "${nomesJogadores[posicao]}:${jogosGanhosPerdidos[posicao].first}" +
                    ":${jogosGanhosPerdidos[posicao].second}" //montando linha no padrão correto

            if (posicao != jogosGanhosPerdidos.size-1){//se nao for a ultima posição

                //se a posição atual e a proxima forem diferentes de null
                if (nomesJogadores[posicao]!=null && nomesJogadores[posicao+1]!=null){

                    writer.println(linha)//escreve a linha e deixa o ponteiro na linha de baixo

                }else{
                    writer.print(linha)//escreve a linha deixando o ponteiro na mesma
                }
            }else{//caso seja a ultma posição

                if (nomesJogadores[posicao] != null){//verifica se a ultima posicao é diferente de null

                    writer.print(linha)//escreve a linha deixando o ponteiro na mesma
                }
            }
        }
        writer.close()//escrever em arquivo

        println("Estatisticas gravadas com sucesso") //aviso de sucesso

        return true //retorna true

    }catch (e: FileNotFoundException) {//caso o ficheiro nao exita

        return false //retorna falso
    }
}