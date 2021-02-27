package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
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
            }, content = { DetailsContent(puppy) }
        )
    }
}

@Composable
fun DetailsContent(puppy: Puppy) {
    Surface(color = MaterialTheme.colors.background) {
        Column(content = {
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
        })

    }
}

@Composable
fun AdoptButton(puppy: Puppy) {
    var isAdopted by remember { mutableStateOf(puppy.isAdopted) }
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp), onClick = {
            puppy.isAdopted = true
            isAdopted = true
        }, enabled = !isAdopted
    ) {
        val text = if (isAdopted) {
            "Too late ! ${puppy.name} is already adopted"
        } else {
            "Adopt me"
        }
        Text(text)
    }
}