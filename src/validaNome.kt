fun validaNome(nome: String): Boolean {
    var indiceEspaco = 0 //declarando variavel que guardará o valor do indice se o nome tiver espaço

    var count: Int = 0 //variavel contador
    //verificando se tem espaço--- se houver espaço é porque tem pelo menos dois nomes
    run {
        do {
            if (nome[count].toString() == " ") {
                indiceEspaco = count
                count = nome.length
            }
            count++
        } while (count < nome.length)
    }

    if (indiceEspaco > 0) {//se tiver pelo menos um espaço
        var primeiroNome= ""
        var segundoNome = ""

        //Formando o primeiro nome
        run {
            count = 0
            while (count <= indiceEspaco) {
                primeiroNome = primeiroNome + nome[count].toString()
                count++
            }
        }
        //Formando o segundo nome
        run {
            count = 0
            while ((indiceEspaco + 1) <= nome.length) {
                segundoNome = segundoNome + nome[count].toString()
                count++
            }
        }
        if (primeiroNome.length >=2 && segundoNome.length>=2) {//verificando se o primeiro e o segundo nome tem o minimo de dois caracteres
            //verificando se existe apenas caractéres válidos
            run {
                count = 0
                while ((indiceEspaco+1) <= nome.length){
                    when (nome[count].toString()) {
                        in "A".."Z", in "a".."z"," " -> {}
                        else -> return false
                    }
                    count ++
                }
            }
        }else{
            return false // return false se o primeiro nome ou o segundo nome tiver menos que 2 caracteres
        }
    }else {
        return false //se não tiver nenhum espaço o nome é inválido
    }
    return true //caso passe por tudo sem retornar false o nome é valido
}

