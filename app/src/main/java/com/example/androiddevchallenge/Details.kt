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

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, puppyId: Int) {
    val puppy = puppies.findById(puppyId)
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = puppy.name) },
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                                .clickable {
                                    navController.popBackStack()
                                },
                        )
                    }
                )
            },
            content = { DetailsContent(puppy) }
        )
    }
}

@Composable
fun DetailsContent(puppy: Puppy) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            content = {
                Image(
                    painter = painterResource(puppy.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

                AdoptButton(puppy)

                Surface(Modifier.padding(16.dp)) {
                    Column {
                        Text(text = "Breed : ${puppy.breed}")
                        Text(text = "Age : ${puppy.age}")
                    }
                }
            }
        )
    }
}

@Composable
fun AdoptButton(puppy: Puppy) {
    var isAdopted by remember { mutableStateOf(puppy.isAdopted) }
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = {
            puppy.isAdopted = true
            isAdopted = true
        },
        enabled = !isAdopted
    ) {
        val text = if (isAdopted) {
            "Too late ! ${puppy.name} is already adopted"
        } else {
            "Adopt me"
        }
        Text(text)
    }
}
