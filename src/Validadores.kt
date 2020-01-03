//valida o nome
fun validaNome(nome: String): Boolean {
    var indiceEspaco = 0 //declarando variavel que guardará o valor do indice se o nome tiver espaço

    var count = 0 //variavel contador

    run {
        if (nome.length != 0) {//se o nome não tiver nenhum caracter, não verificar se tem espaco
            do {
                if (nome[count].toString() == " ") {//se o caractere for igual a um espaço

                    indiceEspaco = count //atribuir o indice onde o espaço esta na string

                    count = nome.length//forçar a saida do loop, pois só nos interessa o primeiro espaço
                }
                count++ //acrescenta 1 no count para verificar o proximo caractere do nome

            } while (count < nome.length)//enquanto não tiver passado por todas os caracteres
        }
    }//verificando se tem espaço--- se houver espaço é porque tem pelo menos dois nomes

    if (indiceEspaco > 0) {//se tiver pelo menos um espaço

        var primeiroNome= "" //declarando a variavel que guardara o primeiro nome

        var segundoNome = "" //declarando a variavel que guardara o resto do nome

        run {
            count = 0 //reset na variavel count para usar no proximo while

            while (count < indiceEspaco) {//enquanto o contador for menor do que o indice do espaço ir passando de letra em letra e concatenando-as

                primeiroNome += nome[count].toString() //contatenando os caracteres

                count++ // acrescentando 1 para verificar a proxima letra
            }
        }//Formando o primeiro nome


        run {
            count = indiceEspaco + 1 //agora o contador começa do indice do espaço em diante, ou seja mais 1

            while (count < nome.length) {//enquanto o contador for menor do que o tamanho do nome ir passando de letra em letra e concatenando-as

                segundoNome += nome[count].toString() //contatenando os caracteres

                count++ // acrescentando 1 para verificar a proxima letra
            }
        }//Formando o segundo nome

        if (primeiroNome.length >=2 && segundoNome.length>=2) {//verificando se o primeiro e o segundo nome tem no minimo dois caracteres

            run {
                count = 0 //reset na variavel count para usar no proximo while

                do{
                    when (nome[count].toString()) {//pegando letra por letra e verificando se tem apenas catacteres validos

                        in "A".."Z", in "a".."z"," " -> {} //não faz nada caso seja valido

                        else -> return false //caso contrario retorna false pois tem caracter invalido
                    }
                    count ++ //acrescenta 1 para verificar as demais letras do nome

                }while (count <= (nome.length-1))//enquanto count menor que o tamanho do nome

            }//verificando se existe apenas caractéres válidos

            return true //caso passe por tudo sem retornar false o nome é valido

        }else return false // return false se o primeiro nome ou o segundo nome tiver menos que 2 caracteres

    }else return false //se não tiver nenhum espaço o nome é inválido
}

//valida se o usuario digitou enter
fun validaEnter(){
    do {
        println("(prima enter para voltar ao menu)")//print de informação para voltar ao menu principal

        val enter = readLine()?:" "//pega o valor digitado

        if (enter!= ""){//se não for apenas um enter

            println("Digito invalido")}// mensagem de erro

    }while (enter!= "")//verifica se digitou apenas "enter"
}

//valida se o palpite inserido é valido
fun validaPalpite(palpite:String): Boolean{
    return if (palpite.length==1){ // verifica se o palpite tem apenas uma letra
        when (palpite){
            in "a".."z",in "A".."Z"-> true // se estiver de 'a' a 'z' retorna true
            else -> false //caso seja caracteres especiais ou numeros retorna false
        }
    }else false //caso tenha mais de uma letra retorna false
}