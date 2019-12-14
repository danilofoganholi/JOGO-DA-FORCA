fun estruturaPalavra(palavra:String, letra: Char?=null): String {
    var stringPalavra = "" //variavel que guardara a string no formato do jogo da forca

    var count = 0 //variavel contador para o while

    while (count < palavra.length){ //enquanto variavel contador for menor que o numero de caracteres da palavra

        stringPalavra += when(letra){ //verifica se a letra é igual a letra da palavra

                //se o palpite for igual a letra que esta sendo analisada concatenar essa letra
                palavra[count] -> if(count==0)"$letra" else " $letra" // se for a primeira letra mostrar sem espaço antes

                //se o palpite for diferente da letra que esta sendo analisada concatenar com traço
                else -> if (count==0)"_" else " _" //se for a primeira letra mostrar sem espaço antes
            }
        count ++ //acrescenta 1 a variavel contador para verificar a proxima letra da palavra
    }
    return stringPalavra //retorna a string no formato do jogo da forca com as letras acertadas
}