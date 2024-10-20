package com.example.kdan__intern_test_tetris

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class LevelTest {

    @BeforeEach //每次測試前重置
    fun setUp(){
        Tetromino.tetromino_Xpos = arrayOf(0, 0, 0, 0)
        Tetromino.tetromino_Ypos = arrayOf(0, 0, 0, 0)
        Tetromino.speed = 500
        Tetromino.colorCode = 0
        Level.reset()
        Level.Z = mutableListOf(
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        )
    }

    @Test
    fun resetTest(){
        //Arrange

        //Act
        Level.reset()

        //Assert
        assertEquals(1, Level.level)
        assertEquals(0, Level.score)
        assertEquals(500, Tetromino.speed)
        for(i in 0..21){
            assertArrayEquals(arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Level.Z[i])
        }
    }

    @Test
    fun isGameOverTest_whenTetrominoIsAtTop_returnTure(){
        //Arrange
        Tetromino.tetromino_Xpos = arrayOf(0, 1, 1, 2)

        //Act
        val actual = Level.isGameOver()

        //Assert
        assertTrue(actual)
    }

    @Test
    fun isGameOverTest_whenTetrominoIsNotAtTop_returnFalse(){
        //Arrange
        Tetromino.tetromino_Xpos = arrayOf(2, 2, 3, 3)

        //Act
        val actual = Level.isGameOver()

        //Assert
        assertFalse(actual)
    }

    @Test
    fun isGameOverTest_whenTetrominoIsPartiallyTop_returnTure(){
        //Arrange
        Tetromino.tetromino_Xpos = arrayOf(1, 2, 2, 3)

        //Act
        val actual = Level.isGameOver()

        //Assert
        assertTrue(actual)
    }

    @Test
    fun gameOverTest_changeEveryExistedTetrominoToLightGray(){
        //Arrange
        for(i in 0..21){
            Level.Z[i][2] = 2
            Level.Z[i][3] = 3
            Level.Z[i][4] = 4
            Level.Z[i][5] = 5
            Level.Z[i][6] = 6
            Level.Z[i][7] = 7
            Level.Z[i][8] = 8
        }

        //Act
        Level.gameOver()

        //Assert
        for(i in 0..21){
            assertEquals(1, Level.Z[i][2])
            assertEquals(1, Level.Z[i][3])
            assertEquals(1, Level.Z[i][4])
            assertEquals(1, Level.Z[i][5])
            assertEquals(1, Level.Z[i][6])
            assertEquals(1, Level.Z[i][7])
            assertEquals(1, Level.Z[i][8])
        }
    }

    @Test
    fun checkRows_noFullRows_noChange() {
        //Arrange
        Level.Z[21] = Array(10) { 2 }
        Level.Z[21][9] = 0 // 不完整的行

        //Act
        Level.checkRows()

        //Assert
        assertEquals(0, Level.score)
        assertEquals(1, Level.level)
        assertEquals(500, Tetromino.speed)
        assertArrayEquals(Array(10) { if (it == 9) 0 else 2 }, Level.Z[21])
    }

    @Test
    fun checkRows_oneFullRow_rowRemovedAndScoreIncreased() {
        //Arrange
        Level.Z[21] = Array(10) { 2 }

        //Act
        Level.checkRows()

        //Assert
        assertEquals(1, Level.score)
        assertEquals(1, Level.level)
        assertEquals(500, Tetromino.speed)
        assertArrayEquals(Array(10) { 0 }, Level.Z[21])
    }

    @Test
    fun checkRows_tenFullRows_levelIncreasedAndSpeedDecreased() {
        //Arrange
        for (i in 12..21) {
            Level.Z[i] = Array(10) { 2 }
        }

        //Act
        Level.checkRows()

        //Assert
        assertEquals(10, Level.score)
        assertEquals(2, Level.level)
        assertEquals(400, Tetromino.speed)
        for (i in 12..21) {
            assertArrayEquals(Array(10) { 0 }, Level.Z[i])
        }
    }

    @Test
    fun removeRow_middleRow_upperRowsShiftDown() {
        // Arrange
        Level.Z[19] = Array(10) { 1 }
        Level.Z[20] = Array(10) { 2 }
        Level.Z[21] = Array(10) { 3 }

        // Act
        Level.removeRow(20)

        // Assert
        assertArrayEquals(Array(10) { 1 }, Level.Z[20])
        assertArrayEquals(Array(10) { 3 }, Level.Z[21])
        assertArrayEquals(Array(10) { 0 }, Level.Z[19])
    }

    @Test
    fun removeRow_topRow_onlyTopRowCleared() {
        //Arrange
        Level.Z[21] = Array(10) { 2 }

        //Act
        Level.removeRow(21)

        //Assert
        assertArrayEquals(Array(10) { 0 }, Level.Z[21])
        //检查其他行没有被影響
        for (i in 0..20) {
            assertArrayEquals(Array(10) { 0 }, Level.Z[i])
        }
    }

    @Test
    fun insertNewPieceTest(){
        //Arrange
        Tetromino.colorCode = 2
        Tetromino.tetromino_Xpos = arrayOf(0, 0, 0, 1)
        Tetromino.tetromino_Ypos = arrayOf(3, 4, 5, 4)

        //Act
        Level.insertNewPosition()

        //Assert
        assertEquals(2, Level.Z[Tetromino.tetromino_Xpos[0]][Tetromino.tetromino_Ypos[0]])
        assertEquals(2, Level.Z[Tetromino.tetromino_Xpos[1]][Tetromino.tetromino_Ypos[1]])
        assertEquals(2, Level.Z[Tetromino.tetromino_Xpos[2]][Tetromino.tetromino_Ypos[2]])
        assertEquals(2, Level.Z[Tetromino.tetromino_Xpos[3]][Tetromino.tetromino_Ypos[3]])
    }

    @Test
    fun removeOldPositionTest(){
        //Arrange
        Tetromino.colorCode = 2
        Tetromino.tetromino_Xpos = arrayOf(5, 5, 5, 5)
        Tetromino.tetromino_Ypos = arrayOf(5, 6, 7, 8)

        //Act
        Level.removeOldPosition()

        //Assert
        assertEquals(0, Level.Z[Tetromino.tetromino_Xpos[0]][Tetromino.tetromino_Ypos[0]])
        assertEquals(0, Level.Z[Tetromino.tetromino_Xpos[1]][Tetromino.tetromino_Ypos[1]])
        assertEquals(0, Level.Z[Tetromino.tetromino_Xpos[2]][Tetromino.tetromino_Ypos[2]])
        assertEquals(0, Level.Z[Tetromino.tetromino_Xpos[3]][Tetromino.tetromino_Ypos[3]])
    }
}