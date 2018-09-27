package com.greemand.msgshareapp.models

data class Hobby(var title : String)

object Supplier {
    val hobbies = listOf(
            Hobby("Reading"),
            Hobby("Ultimate Frisbee"),
            Hobby("Programming"))
}