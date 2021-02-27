/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import java.io.Serializable

data class Puppy(
    val id: Int,
    val name: String,
    val imageRes: Int,
    var age: Int,
    val breed: String,
    var isAdopted: Boolean,
) : Serializable

val puppies = listOf(
    Puppy(0, "Hanako", R.drawable.spitz, 2, "Japanese spitz", false),
    Puppy(1, "Peps", R.drawable.border, 1, "Border collie", false),
    Puppy(2, "Polux", R.drawable.caniche, 3, "Caniche", false),
    Puppy(3, "Milou", R.drawable.fox, 4, "Fox", false),
)

fun List<Puppy>.findById(id: Int): Puppy {
    return first { it.id == id }
}
