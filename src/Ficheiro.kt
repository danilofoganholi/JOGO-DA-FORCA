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

    /*Lê o ficheiro com o nome indicado e
    preenche os arrays nomesJogadores e
    jogosGanhosPerdidos com os valores que
    constam no ficheiro. Os arrays que são
    passados à função estarão inicializados a
    null.*/

    return true
}

//procura o jogador e passa a posição em que ele esta
fun procuraJogador(nomesJogadores:Array<String?>, nome: String): Int{

    /*Retorna a posição onde se encontra o
    nome do jogador indicado ou a próxima
    “livre” caso não encontre.
    Exemplos (pseudo-código):
    procuraJogador([null,null],”Ana”) -> 0
    procuraJogador([“Ana”,null],”Ana”) -> 0
    procuraJogador([“Ana”,null],”Sara”) -> 1
    Caso não encontre o nome indicado e já
    não haja posições livres, deve retornar -1.*/

    return 0
}

fun gravaFicheiroEstatisticas(nomeFicheiro:String,nomesJogadores:Array<String?>,jogosGanhosPerdidos:Array<Pair<Int,Int>>):Boolean{

    /*Grava as estatísticas atuais num ficheiro
    com o nome indicado, tendo em conta os
    dois arrays que lhe são passados. O array
    jogosGanhosPerdidos contém pares
    (Pair) de inteiros, em que o primeiro
    elemento é o número de jogos ganhos e o
    segundo elemento é o número de jogos
    perdidos. Retorna true se a gravação teve
    sucesso ou false caso contrário. No caso
    de ainda não haver jogadores o ficheiro
    deverá ficar vazio. O ficheiro deverá ter o
    formato indicado na secção Ficheiro de
    estatísticas .*/

    return false
}