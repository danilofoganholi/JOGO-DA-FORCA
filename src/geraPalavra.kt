fun geraPalavra(categoria:String): String{
    val randomNumber: Int = (0..2).random()//pega um numero aleatorio de 0 a 2
    //se categoria escolhida for frutas
    if (categoria=="Frutas"){
        if(randomNumber==0){
            return "morango"
        }else if(randomNumber==1){
            return "amora"
        }else{
            return "mirtilo"
        }
    //se categoria escolhida for categoria
    }else if(categoria=="Cidades") {
        if(randomNumber==0){
            return "lisboa"
        }else if(randomNumber==1){
            return "luanda"
        }else{
            return "londres"
        }
    //se categoria escolhida for nome proprio
    }else{
        if(randomNumber==0){
            return "vera"
        }else if(randomNumber==1){
            return "sara"
        }else{
            return "miguel"
        }
    }
}