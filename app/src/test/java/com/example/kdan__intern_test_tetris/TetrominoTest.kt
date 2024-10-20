package com.example.kdan__intern_test_tetris

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest

class TetrominoTest {
    @Test
    @RepeatedTest(100)
    fun newPieceTest(){
        //arrange
        val validShapes = listOf("I", "O", "T", "J", "L", "S", "Z")

        //act
        Tetromino.newPiece()

        //assert
        assertEquals(1, Tetromino.shapeDirection)
        assertTrue(Tetromino.actualShape in validShapes)
        assertTrue(Tetromino.colorCode in 2..8)
        when(Tetromino.nextShape){
            1 -> {
                assertArrayEquals(arrayOf(0, 0, 0, 0), Tetromino.tetromino_Xpos)
                assertArrayEquals(arrayOf(3, 4, 5, 6), Tetromino.tetromino_Ypos)
            }
            2 -> {
                assertArrayEquals(arrayOf(0, 0, 1, 1), Tetromino.tetromino_Xpos)
                assertArrayEquals(arrayOf(4, 5, 4, 5), Tetromino.tetromino_Ypos)
            }
            3 -> {
                assertArrayEquals(arrayOf(0, 0, 0, 1), Tetromino.tetromino_Xpos)
                assertArrayEquals(arrayOf(3, 4, 5, 4), Tetromino.tetromino_Ypos)
            }
            4 -> {
                assertArrayEquals(arrayOf(0, 0, 0, 1), Tetromino.tetromino_Xpos)
                assertArrayEquals(arrayOf(3, 4, 5, 5), Tetromino.tetromino_Ypos)
            }
            5 -> {
                assertArrayEquals(arrayOf(0, 0, 0, 1), Tetromino.tetromino_Xpos)
                assertArrayEquals(arrayOf(3, 4, 5, 3), Tetromino.tetromino_Ypos)
            }
            6 -> {
                assertArrayEquals(arrayOf(0, 0, 1, 1), Tetromino.tetromino_Xpos)
                assertArrayEquals(arrayOf(4, 5, 3, 4), Tetromino.tetromino_Ypos)
            }
            7 -> {
                assertArrayEquals(arrayOf(0, 0, 1, 1), Tetromino.tetromino_Xpos)
                assertArrayEquals(arrayOf(3, 4, 4, 5), Tetromino.tetromino_Ypos)
            }
        }


    }

}