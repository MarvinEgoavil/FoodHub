package com.example.foodhub.models

class Product {
    private var id: Int? = null
    var name: String? = null
    var description: String? = null
    var price: Int? = null
    var thumbnail: String? = null

    constructor()


    override fun toString(): String {
        return "Product(id=$id, name='$name', description='$description', price=$price, thumbnail='$thumbnail')"
    }

}