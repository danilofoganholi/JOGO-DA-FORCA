fun numOcorrencias(palavra: String, palpite: Char): Int? {
    var numeroOcorrencias = 0//iniciando variavel para guardar a quantidade de vezes que uma letra repete na palabra

    var contador = 0//variavel contador

    while (contador < palavra.length){//enquanto não verificar todas as letras da palavra

        if (palpite==palavra[contador]){numeroOcorrencias++}//se 0 palpite for igual a letra dentro da palavra acrescenta 1 no numero de ocorrencias

        contador++ //acresenta 1 na variavel contador para verificar a proxima letra da palavra
    }
    return if(numeroOcorrencias==0) null else numeroOcorrencias //retorna null se tiver 0 ocorrenciais ou retorna a quantidades de ocorrencias
}