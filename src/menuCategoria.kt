fun menuCategoria():String{
    do{
        println(obtemMenuCategoria())//mostrar o menu de categorias

        val categoria = readLine()?: "0"//leitura da categoria

        when (categoria) {//atribui categoria correta de acordo com a opcao escolhida

            "a", "A" -> return "Frutas"// 'A' ou 'a' é FRUTAS

            "b", "B" -> return "Cidades"//'B' ou 'b' é CIDADES

            "c", "C" -> return "Nomes"//'C' ou 'c' é NOME

            "0" -> return "" //'0' sair sem escolher categoria

            else -> println("Opcao invalida, tente novamente")//Se for qualquer outra coisa soltar mensagem de erro
        }
    }while (categoria!="Frutas" && categoria!="Cidades" && categoria!="Nomes" && categoria!="0")
    return ""
}