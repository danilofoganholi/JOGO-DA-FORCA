//retorna o nome somente quando ele for valido
fun pegaNome(): String{
    do{
        println("Introduza o nome do jogador(a):")

        val nome = readLine()?:""//lendo o nome

        val validaNome = validaNome(nome)//valida o nome do jogador

        if (validaNome){//se validador do nome returnar true

            return nome //retorna o nome valido

        }else {//se retornar false, mostrar mensagem de erro e pedir de novo

            println("Nome invalido, tente novamente")//mensagem de erro para nome invalido
        }
    }while (!(validaNome))//enquanto nome for inválido pedir novamente
    return ""
}

//retorna o palpite apenas quando ele for valido
fun pegaPalpite(): Char{
    do{
        val palpiteString = readLine()?: "" // pedindo palpite

        val validaPalpite = validaPalpite(palpiteString)//validando palpite

        if (validaPalpite) return palpiteString[0] else println("Letra invalida, tente novamente")

    }while (!(validaPalpite))//enquanto o palpite for invalido continuar a pedi-lo
    return '1'
}

//pega o numero de ocorrencias de uma letra em uma palavra
fun numOcorrencias(palavra: String, letra: Char): Int? {
    var numeroOcorrencias = 0//iniciando variavel para guardar a quantidade de vezes que uma letra repete na palavra

    for (contador in 0..palavra.length-1){//enquanto não verificar todas as letras da palavra

        //se o palpite for igual a letra dentro da palavra acrescenta 1 no numero de ocorrencias
        if (letra.toUpperCase()==palavra[contador].toUpperCase()){numeroOcorrencias++}
    }
    return if(numeroOcorrencias==0) null else numeroOcorrencias //retorna null se tiver 0 ocorrenciais ou retorna a quantidades de ocorrencias
}

//pergunta se o usuario quer o jogo com ou sem boneco
fun perguntaBoneco():Boolean {
    var resposta = ""//declarando variavel da reposta
    do {
        println("Pretende visualizar o boneco da forca? (S/N)")//pergunta se quer com ou sem o boneco

        resposta = readLine()?.toUpperCase() ?: ""//le o que o usuario digita

        if (!(resposta=="S" || resposta == "N")) {//se for algo diferente de N ou S

            println("Resposta inálida.Digite apenas 'S' ou 'N'.\n")//mensagem de erro
        }
    } while (!(resposta=="S" || resposta == "N"))//enquanto nao for S ou N pedir novamente

    return resposta=="S"//retorna true se for 'S' ou false se for 'N'
}