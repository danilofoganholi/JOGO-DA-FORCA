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

    var stringPalavra = ""

    for(i in 0..palavraMascarada.size-1){

        if(palavraMascarada[i] != null){//se for diferente de null concatenar letra
            stringPalavra+= palavraMascarada[i]
        }else{//caso contrario apenas concatenar traço
            stringPalavra+= "_"
        }

        if (i != palavraMascarada.size-1){//concatenar o espaço menos quando for a ultima letra
            stringPalavra+=" "
        }
    }
    return stringPalavra
}

//monta a palavra mascarada em array
fun montaArrayPalavra(palavra:String):Array<Char?>{
    //inicializando array de nulls com a quantidade de letras que a palavra tiver
    val palavraMascarada : Array<Char?> =  Array((palavra.length), { i -> null})

    var index = 0//guardara o index da letra que esta sendo analisada

    for(letra in palavra){
        when (letra.toUpperCase()){
            in 'A'..'Z' -> {}
            else-> palavraMascarada[index]=letra
        }
        index++
    }
    return palavraMascarada
}

//preenche as ocorrencias no array passado e retorna com as alterações feitas
fun preencheOcorrencias(palavra:String, palavraMascarada:Array<Char?>, letra: Char):Array<Char?>{

    var indice = 0//variavel que guarda o indice da letra que esta sendo analisada

    for( letraPalavra in palavra){
        if ( letraPalavra.toUpperCase() == letra.toUpperCase() ){
            palavraMascarada[indice]=letra.toLowerCase()
        }
        indice++
    }
    return palavraMascarada
}

//retorna o tamnha da maior palavra
fun maiorPalavra(nomesJogadores: Array<String?>): Int{
    var maiorPalavra = 0
    for (index in 0 until nomesJogadores.size-1){

        if (nomesJogadores[index]!=null && nomesJogadores[index+1]!=null){
            if (nomesJogadores[index]?.length?:0 > nomesJogadores[index+1]?.length?:0){
                if(nomesJogadores[index]!!.length>maiorPalavra){
                    maiorPalavra = nomesJogadores[index]!!.length
                }
            }
        }else if (nomesJogadores[index]!=null && nomesJogadores[index+1]==null){
            if(nomesJogadores[index]!!.length>maiorPalavra){
                maiorPalavra = nomesJogadores[index]!!.length
            }
        }
    }

    return maiorPalavra
}