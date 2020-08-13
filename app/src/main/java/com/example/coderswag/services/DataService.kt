package com.example.coderswag.services

import com.example.coderswag.model.Category
import com.example.coderswag.model.Product

object DataService {

    val categories = listOf(
        Category("SHIRTS","shirtimage"),
        Category("HOODIES","hoodieimage"),
        Category("HATS","hatimage"),
        Category("DIGITAL","digitalgoodsimage")


    )

    val hats = listOf(
        Product("Devslopes Graphic beanie","180 Rs.", "hat1"),
        Product("Devslopes Graphic beanie","175 Rs.", "hat2"),
        Product("Devslopes Graphic beanie","100 Rs.", "hat3"),
        Product("Devslopes Graphic beanie","250 Rs.", "hat4")
    )

    val shirts = listOf(
        Product("Devslopes Shirt Black","1800 Rs." , "shirt1"),
        Product("Devslopes Badge Light Gray","1000 Rs." , "shirt2"),
        Product("Devslopes Shirt Red","187 Rs." , "shirt3"),
        Product("Devslopes Hustle","800 Rs." , "shirt4"),
        Product("KickFlip Studios","990 Rs." , "shirt5")
    )

    val hoodies = listOf(
        Product("Devslopes Hoodie Gray","500 Rs.", "hoodie1"),
        Product("Devslopes Hoodie Red","1500 Rs.", "hoodie2"),
        Product("Devslopes  Gray Hoodie ","600 Rs.", "hoodie3"),
        Product("Devslopes Hoodie Black","780 Rs.", "hoodie4")
    )


}