fun pegaPalpite(): Char{
    var palpiteString = "" //variavel que vai guardar o valor do palpite em string para ser validada

    var validaPalpite = false //variavel para guardar a validacao do palpite

    while (validaPalpite==false){ //enquanto o palpite não for valido continuar a pedi-lo

        palpiteString = readLine()?: "" // pedindo palpite

        validaPalpite = validaPalpite(palpiteString)//validando palpite

        if (validaPalpite==false){println("Letra invalida, tente novamente")}//se palpite invalido mostrar erro e pedir de novo
    }

    return palpiteString[0] //passando o palpite de string para char e retornando ele
}