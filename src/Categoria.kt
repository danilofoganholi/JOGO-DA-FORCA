fun categoria():String{
    var categoria = ""
    while (categoria!="A" && categoria!="B" && categoria!="C" && categoria!="0"){
        //mostrar o menu de categorias
        println(">>> Escolha a categoria" +
                "\nA - Frutas" +
                "\nB - Cidades" +
                "\nC - Nomes proprio" +
                "\n0 - Sair sem escolher categoria\n")
        //leitura da opção
        categoria = readLine()!!
        //mensagem de erro caso a categoria seja inválido
        if (categoria!="A" && categoria!="B" && categoria!="C" && categoria!="0"){
            println("Opcao invalida, tente novamente")
        }else{break}
    }
    //se A é frutasa
    if (categoria == "A"){
        categoria= "Frutas"
    }
    //se A é frutasa
    else if (categoria == "B"){
        categoria= "Cidades"
    }
    //se A é frutasa
    else if (categoria == "C"){
        categoria = "NomesProprio"
    }
    else{
        categoria = "0"
    }
    return categoria
}