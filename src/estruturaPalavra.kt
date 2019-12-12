fun estruturaPalavra(palavra:String, letra: Char?=null): String {
    var stringPalavra = "" //variavel que guardara a string no formato do jogo da forca

    var count = 0 //variavel contador para o while

    while (count < palavra.length){ //enquanto variavel contador for menor que o numero de caracteres da palavra

        if (count == 0 ){//se for a primeira letra mostrar sem espaço antes

            stringPalavra += when(letra){ //verifica se a letra é igual a letra da palavra

                palavra[count] -> "$letra" // se for concatena a string letra com o resto da stringPalavra

                else -> "_" //caso não, concatena um traço com o resto da stringPalavra
            }
        }
        else{
            stringPalavra += when(letra){ //verifica se a letra é igual a letra da palavra

                palavra[count] -> " $letra" // se for concatena a string letra com o resto da stringPalavra

                else -> " _" //caso não, concatena um traço com o resto da stringPalavra
            }
        }

        count ++ //acrescenta 1 a variavel contador para verificar a proxima letra da palavra
    }
    return stringPalavra //retorna a string no formato do jogo da forca com as letras acertadas
}