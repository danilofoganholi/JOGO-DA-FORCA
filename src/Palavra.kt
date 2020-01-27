import java.io.File
import java.io.FileNotFoundException

//pega uma palavra aleatória dentro do id da categoria passado
fun geraPalavra(idCategoria: Int,nomeFicheiroPalavras: String):String?{
    try {
        val arrayArquivo = File(nomeFicheiroPalavras).readLines()//lendo arquivo categorias.txt se existir

        do{
            //pega um numero aleatorio até o limite de linhas que o array arquivo tem
            val randomNumber: Int = (1..arrayArquivo[0].toInt()).random()

            val parts = arrayArquivo[randomNumber].split(':')//divide a string no ':'

            if( parts[1].toInt()== idCategoria){//se o id pegado for igual ao id da categoria selecionada

                return parts[0]//retornar a palavra daquele id
            }

        }while (parts[1].toInt()!= idCategoria)//enquanto não for a categoria certa continuar

    } catch (e: FileNotFoundException) {
        return null//retorna null
    }
    return null
}

//converte um array em uma string da palavra a ser adivinhada, exemplo (BANANA = "_ a _ a _ a")
fun estruturaPalavra(palavraMascarada:Array<Char?>): String{

    var stringPalavra = ""//string que guardara a palavra

    for(i in 0 until palavraMascarada.size){//rodar toda a palavra e trocar por traços onde tiver letras

        if(palavraMascarada[i] != null){//se for diferente de null concatenar letra

            stringPalavra+= palavraMascarada[i]//concatena letras já acertadas

        }else{//caso contrario apenas concatenar traço

            stringPalavra+= "_"//concatena a traço a string
        }

        if (i != palavraMascarada.size-1){//concatenar o espaço menos quando for a ultima letra

            stringPalavra+=" "//espaço
        }
    }
    return stringPalavra//retorna a palavra
}

//monta a palavra mascarada em array
fun montaArrayPalavra(palavra:String):Array<Char?>{

    //inicializando array de nulls com a quantidade de letras que a palavra tiver
    val palavraMascarada : Array<Char?> =  Array((palavra.length)) { i -> null}

    var index = 0//guardara o index da letra que esta sendo analisada

    for(letra in palavra){//percorre cada letra da palavra
        when (letra.toUpperCase()){
            in 'A'..'Z' -> {}//se for de A á Z nao faz nada
            else-> palavraMascarada[index]=letra //caso seja algum caracter especial deixar ele
        }
        index++//ir para o proximo index
    }
    return palavraMascarada //retorna a palavra mascarada
}

//preenche as ocorrencias no array passado e retorna com as alterações feitas
fun preencheOcorrencias(palavra:String, palavraMascarada:Array<Char?>, letra: Char):Array<Char?>{

    var indice = 0//variavel que guarda o indice da letra que esta sendo analisada

    for( letraPalavra in palavra){//pegando letra por letra e comparando

        if ( letraPalavra.toUpperCase() == letra.toUpperCase() ){//se for igual ao palpite trocar no array o traço por letra

            palavraMascarada[indice]=letra.toLowerCase()//sempre substituir com letra minuscula
        }
        indice++//ir para o proximo indice
    }
    return palavraMascarada//retornar palavra com todas as ocorrencias da letra passada
}

//retorna o tamnha da maior palavra
fun maiorPalavra(nomesJogadores: Array<String?>): Int{

    var maiorPalavra = 0 //maior palavra

    for (index in 0 until nomesJogadores.size-1){//percorre o array comparando as palavras

        //se a palavra atual for maior que a proxima palavra
        if (nomesJogadores[index]?.length?:0 > nomesJogadores[index+1]?.length?:0){

            //verifica se a palavra atual é maior que a maior palavra registrada até o momento
            if(nomesJogadores[index]?.length ?:0 > maiorPalavra){

                //se for colocar o tamanho dela como a maior palavra
                maiorPalavra = nomesJogadores[index]?.length ?:0
            }
        }

        //para verificarmos a ultima palavra
        if (nomesJogadores[index]?.length?:0 < nomesJogadores[index+1]?.length?:0) {

            //verifica se a palavra atual é maior que a maior palavra registrada até o momento
            if (nomesJogadores[index + 1]?.length ?: 0 > maiorPalavra) {

                //se for colocar o tamanho dela como a maior palavra
                maiorPalavra = nomesJogadores[index + 1]?.length ?: 0
            }
        }
    }
    return maiorPalavra //retornar o tamanho da maior palavra
}