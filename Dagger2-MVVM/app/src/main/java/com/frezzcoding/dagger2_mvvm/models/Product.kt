package com.frezzcoding.dagger2_mvvm.models



import java.io.Serializable

class Product : Serializable{
    var unique : Int = 0;
    var id : Int = 0
    var url:String
    var name:String
    var description:String
    var encode : String
    var price : Double

    constructor(id : Int, url : String, name : String, description : String, encode : String, price : Double){
        this.id = id
        this.url = url
        this.name = name
        this.description = description
        this.encode = encode
        this.price = price
    }


    constructor() : this(0, "","", "", "", 0.0)

}