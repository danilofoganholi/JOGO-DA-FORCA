fun categoria():String{
    var categoria = ""
    while (categoria!="Frutas" && categoria!="Cidades" && categoria!="Nomes" && categoria!="0"){
        //mostrar o menu de categorias
        run {
            println(
                "\n>>> Escolha a categoria\n\n" +
                        "A - Frutas\n" +
                        "B - Cidades\n" +
                        "C - Nomes proprios\n" +
                        "0 - Sair sem escolher categoria\n"
            )
        }
        categoria = readLine()?: "0"//leitura da categoria
        //valida a categoria
        run {
            //atribui categoria correta de acordo com a opcao escolhida
            when (categoria) {
                "a", "A" -> categoria = "Frutas"// 'A' ou 'a' é FRUTAS
                "b", "B" -> categoria = "Cidades"//'B' ou 'b' é CIDADES
                "c", "C" -> categoria = "Nomes"//'C' ou 'c' é NOME
                "0" -> categoria = return "" //'0' sair sem escolher categoria
                else -> println("Opcao invalida, tente novamente")//Se for qualquer outra coisa soltar mensagem de erro
            }
        }
    }
    return categoria
}