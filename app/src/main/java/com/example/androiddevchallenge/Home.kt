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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate

@Composable
fun Home(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(Modifier.padding(16.dp)) {
            items(puppies) { puppy ->
                PuppyItem(navController, puppy)
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Composable
fun PuppyItem(navController: NavController, puppy: Puppy) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                showPuppyDetail(navController, puppy)
            }
    ) {
        Row {
            Image(
                painter = painterResource(puppy.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(72.dp, 72.dp)
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(text = puppy.name)
                // Text(text = "Puppy ${puppy.name}")
            }
        }
    }
}

fun showPuppyDetail(navController: NavController, puppy: Puppy) {
    navController.navigate("details/${puppy.id}")
}
