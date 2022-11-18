package com.anonymous.bowlingscore

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource

const val GAME_LENGTH = 10

@Composable
fun BowlingScoreView(viewModel: MainViewModel){
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(id = R.string.app_name)
                        )
                    }
                )
            }
        ) {
                Column {
                    repeat(GAME_LENGTH){
                        Text(modifier = Modifier.testTag("frame${it}_tag"),
                            text = "Frame  Rolls:  Score: ")
                    }
                    Text(modifier = Modifier.testTag("total_tag"),
                        text = "Total: ")
                    Button(modifier = Modifier.testTag("simulate_btn_tag"),
                        onClick = {
                    }){
                        Text("Simulate Roll")
                    }
                }
        }
    }
}