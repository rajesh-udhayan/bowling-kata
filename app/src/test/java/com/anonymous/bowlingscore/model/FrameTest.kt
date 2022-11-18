package com.anonymous.bowlingscore.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FrameTest {

    @Test
    fun `should return true for spare`(){
        val frame = Frame(2,8)

        assertThat(frame.isSpare).isTrue()
        assertThat(frame.isStrike).isFalse()
    }

    @Test
    fun `should return false when not a spare`(){
        val frame = Frame(2,7)

        assertThat(frame.isSpare).isFalse()
    }

    @Test
    fun `should return true for strike`(){
        val frame = Frame(10,null)

        assertThat(frame.isStrike).isTrue()
        assertThat(frame.isSpare).isFalse()
    }


    @Test
    fun `should return false when not a strike`(){
        val frame = Frame(9,null)

        assertThat(frame.isStrike).isFalse()
    }
}