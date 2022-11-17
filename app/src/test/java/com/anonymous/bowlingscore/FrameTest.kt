package com.anonymous.bowlingscore

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class FrameTest {

    @Test
    fun `should return true for spare`(){
        val frame = Frame(2,8)

        assertThat(frame.isSpare).isTrue()
        assertThat(frame.isStrike).isFalse()
    }
}