fun pegaNome(): String{
    //inicializando variaveis
    var nome = ""
    var validaNome: Boolean = false

    while (validaNome==false){//enquanto nome for inválido pedir novamente

        println("Introduza o nome do jogador(a):")

        nome = readLine()!!//lendo o nome

        validaNome = validaNome(nome)//valida o nome do jogador

        if (validaNome == false){//se for invalido print erro

            println("Nome invalido, tente novamente")//mensagem de erro para nome invalido
        }
    }
    return nome
}