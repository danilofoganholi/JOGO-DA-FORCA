fun geraPalavra(categoria:String):String {
    val randomNumber: Int = (0..2).random()//pega um numero aleatorio de 0 a 2

    return when(categoria){
        //se categoria escolhida for frutas
        "Frutas" ->{when(randomNumber){//depedendo do randomNumber terá uma fruta diferente
            0-> "morango"
            1-> "amora"
            else -> "mirtilo"
        }}
        //se categoria escolhida for cidades
        "Cidades"->{when(randomNumber){//depedendo do randomNumber terá uma cidade diferente
            0-> "lisboa"
            1-> "luanda"
            else-> "londres"
        }}
        //se categoria escolhida for nomes
        else ->{when(randomNumber){//depedendo do randomNumber terá uma nome diferente
            0-> "vera"
            1-> "sara"
            else-> "miguel"
        }}
    }
}