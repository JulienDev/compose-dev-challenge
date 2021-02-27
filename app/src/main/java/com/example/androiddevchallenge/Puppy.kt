package com.example.androiddevchallenge

import java.io.Serializable

data class Puppy(
    val id: Int,
    val name: String,
    val imageRes: Int,
    var age: Int,
    val breed : String,
    var isAdopted: Boolean,
) : Serializable

val puppies = listOf(
    Puppy(0, "Hanako", R.drawable.spitz, 2, "Japanese spitz", false),
    Puppy(1, "Peps", R.drawable.border, 1, "Border collie", false),
    Puppy(2, "Polux", R.drawable.caniche, 3, "Caniche", false),
    Puppy(3, "Milou", R.drawable.fox, 4, "Fox", false),
)

fun List<Puppy>.findById(id : Int) : Puppy {
    return first { it.id == id }
}