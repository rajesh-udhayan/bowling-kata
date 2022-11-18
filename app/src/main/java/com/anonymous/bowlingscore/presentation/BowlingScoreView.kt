package com.anonymous.bowlingscore.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anonymous.bowlingscore.R

const val GAME_LENGTH = 10

@Composable
fun BowlingScoreView(viewModel: MainViewModel) {
    val game by viewModel.gameState.observeAsState()

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
            Column(Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                game?.let {
                    repeat(GAME_LENGTH) { index ->
                        Text(
                            modifier = Modifier.testTag("frame${index}_tag"),
                            text = "Frame ${index + 1} " +
                                    "Rolls: ${viewModel.parseScore(index, it)} " +
                                    "Score: ${viewModel.getFrameScore(index, it) ?: ""}",
                            style = TextStyle(fontSize = 20.sp)
                        )
                        Spacer(Modifier.size(4.dp))
                    }
                    Spacer(Modifier.size(12.dp))
                    Text(
                        modifier = Modifier.testTag("total_tag"),
                        text = "Total: ${viewModel.getGameScore(it)}",
                        style = TextStyle(fontSize = 24.sp)
                    )
                }
                Row {
                    Button(modifier = Modifier.testTag("simulate_btn_tag"),
                        onClick = {
                            viewModel.addRoll()
                        }) {
                        Text("Simulate Roll")
                    }
                    Spacer(Modifier.size(8.dp))
                    Button(modifier = Modifier.testTag("new_game_btn_tag"),
                        onClick = {
                            viewModel.startNewGame()
                        }) {
                        Text("New Game")
                    }
                }
            }
        }
    }

}