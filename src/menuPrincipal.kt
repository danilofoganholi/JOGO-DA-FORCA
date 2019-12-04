fun menuPrincipal():Int{
    do{
        println(obtemMenu()) //mostra do menu principal

        val option = readLine()?.toIntOrNull()?: 3//leitura da opção

        if (option !=0 && option !=1 && option !=2){//se o número for inválido

            println("Opcao invalida, tente novamente")//motra mensagem de erro

        }else return option//se o numero for valido retornar ele mesmo

    }while (option !=0 && option !=1 && option !=2)//enquanto o numero não for valido mostrar menu novamente e pedir nova digitacao
    return 0
}