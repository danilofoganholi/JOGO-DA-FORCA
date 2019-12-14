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