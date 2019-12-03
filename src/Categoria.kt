fun categoria():String{
    var categoria: String = ""
    while (categoria!="Frutas" && categoria!="Cidades" && categoria!="Nomes" && categoria!="0"){
        //mostrar o menu de categorias
        run {
            println(
                ">>> Escolha a categoria" +
                        "\nA - Frutas" +
                        "\nB - Cidades" +
                        "\nC - Nomes proprio" +
                        "\n0 - Sair sem escolher categoria\n"
            )
        }
        //leitura da categoria
        categoria = readLine()!!
        //valida a categoria
        run {
            //atribui categoria correta de acordo com a opcao escolhida
            when (categoria) {
                // 'A' ou 'a' é FRUTAS
                "a", "A" -> categoria = "Frutas"
                //'B' ou 'b' é CIDADES
                "b", "B" -> categoria = "Cidades"
                //'C' ou 'c' é NOME
                "c", "C" -> categoria = "Nomes"
                //'0' sair sem escolher categoria
                "0" -> categoria = "0"
                //Se for qualquer outra coisa soltar mensagem de erro
                else -> println("Opcao invalida, tente novamente")
            }
        }
    }
    return categoria
}