package com.anonymous.bowlingscore

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ScoreParserTest {

    lateinit var parser: ScoreParser
    
    @Before
    fun setUp(){
        parser = ScoreParser()
    }
    
    @Test
    fun `should return representation for simple frame`(){
        val frame = Frame(2,4)

        val result = parser.getRepresentation(frame)
        assertThat(result).isEqualTo("2 4")
    }

    @Test
    fun `should return representation for spare`(){
        val frame = Frame(2,8)

        val result = parser.getRepresentation(frame)
        assertThat(result).isEqualTo("2 /")
    }

    @Test
    fun `should return representation for strike`(){
        val frame = Frame(10,null)

        val result = parser.getRepresentation(frame)
        assertThat(result).isEqualTo("x")
    }

    @Test
    fun `should return representation for single roll`(){
        val frame = Frame(4,null)

        val result = parser.getRepresentation(frame)
        assertThat(result).isEqualTo("4")
    }
}