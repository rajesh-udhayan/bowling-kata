package com.anonymous.bowlingscore

import org.junit.Test

class ScoreParserTest {

    @Test
    fun `should return score for simple frame`(){
        val parser = ScoreParser()
        val frame = Frame(2,4)

        val result = parser.getRepresentation(frame)
        com.google.common.truth.Truth.assertThat(result).isEqualTo("2 4")
    }
}