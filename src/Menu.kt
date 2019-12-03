fun menu(): Int {
    var option = 5
    while (option !=0 && option !=1 && option !=2){
        //print do menu principal
        println(obtemMenu())
        //leitura da opção
        option = readLine()?.toIntOrNull()?: 5
        //mensagem de erro caso o número seja inválido
        if (option !=0 && option !=1 && option !=2){
            println("Opcao invalida, tente novamente")
        }
    }
    return option
}