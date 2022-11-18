package com.anonymous.bowlingscore

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ScoreParserTest {

    @Test
    fun `should return representation for simple frame`(){
        val parser = ScoreParser()
        val frame = Frame(2,4)

        val result = parser.getRepresentation(frame)
        assertThat(result).isEqualTo("2 4")
    }

    @Test
    fun `should return representation for spare`(){
        val parser = ScoreParser()
        val frame = Frame(2,8)

        val result = parser.getRepresentation(frame)
        assertThat(result).isEqualTo("2 /")
    }
}