package com.greemand.msgshareapp

data class Hobby(var title : String)

object Supplier {
    val hobbies = listOf<Hobby>(
            Hobby("Reading"),
            Hobby("Ultimate Frisbee"),
            Hobby("Programming"))
}