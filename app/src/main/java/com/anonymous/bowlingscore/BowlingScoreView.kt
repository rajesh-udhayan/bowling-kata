package com.anonymous.bowlingscore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource

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
            Column {
                game?.let {
                    repeat(GAME_LENGTH) { index ->
                        Text(
                            modifier = Modifier.testTag("frame${index}_tag"),
                            text = "Frame ${index + 1} Rolls: ${
                                viewModel.getFrameScore(
                                    index,
                                    it
                                ) ?: ""
                            } Score: ${viewModel.parseScore(index, it)}"
                        )
                    }
                    Text(
                        modifier = Modifier.testTag("total_tag"),
                        text = "Total: ${viewModel.getGameScore(it)}"
                    )
                }
                Row {
                    Button(modifier = Modifier.testTag("simulate_btn_tag"),
                        onClick = {
                            viewModel.addRoll()
                        }) {
                        Text("Simulate Roll")
                    }
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