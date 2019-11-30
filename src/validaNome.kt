fun validaNome(nome: String): Boolean {
    //declarando variavel que guardará o valor do indice se o nome tiver espaço
    var indiceEspaco = 0

    //verificando se tem espaço--- se houver espaço é porque tem pelo menos dois nomes
    for (i in 0 until  (nome.length)){
        if (nome[i].toString()==" "){
            indiceEspaco = i
        }
    }
    //se tiver pelo menos um espaço
    if (indiceEspaco > 0) {
        var primeiroNome= ""
        var segundoNome = ""
        //Formando o primeiro nome
        for (i in 0 until (indiceEspaco)) {
            primeiroNome = primeiroNome + nome[i].toString()
        }
        //Formando o segundo nome
        for (i in (indiceEspaco + 1) until nome.length) {
            segundoNome = segundoNome + nome[i].toString()
        }

        //verificando se o primeiro e o segundo nome tem o minimo de dois caracteres
        if (primeiroNome.length >=2 && segundoNome.length>=2) {
            //verificando se existe apenas caractéres válidos
            for (i in 0 until (nome.length)) {
                when (nome[i].toString()) {
                    in "A".."Z", in "a".."z"," " -> {}
                    else -> return false
                }
            }
        }else{
            return false // return false se o primeiro nome ou o segundo nome tiver menos que 2 caracteres
        }
    }else {
        //se não tiver nenhum espaço o nome é inválido
        return false
    }
    //caso passe pela validacao o nome é valido
    return true
}

