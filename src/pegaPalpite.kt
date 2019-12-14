fun pegaPalpite(): Char{
    do{
        val palpiteString = readLine()?: "" // pedindo palpite

        val validaPalpite = validaPalpite(palpiteString)//validando palpite

        if (validaPalpite) return palpiteString[0] else println("Letra invalida, tente novamente")

    }while (!(validaPalpite))//enquanto o palpite for invalido continuar a pedi-lo
    return '1'
}