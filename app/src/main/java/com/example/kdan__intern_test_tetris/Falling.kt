package com.example.kdan__intern_test_tetris

class Falling {
    companion object {
        fun fallingStep() {

            Tetromino.tetromino_Xpos[0] += 1
            Tetromino.tetromino_Xpos[1] += 1
            Tetromino.tetromino_Xpos[2] += 1
            Tetromino.tetromino_Xpos[3] += 1

            // remove old position
            Level.Z[Tetromino.tetromino_Xpos[0] - 1][Tetromino.tetromino_Ypos[0]] = 0
            Level.Z[Tetromino.tetromino_Xpos[1] - 1][Tetromino.tetromino_Ypos[1]] = 0
            Level.Z[Tetromino.tetromino_Xpos[2] - 1][Tetromino.tetromino_Ypos[2]] = 0
            Level.Z[Tetromino.tetromino_Xpos[3] - 1][Tetromino.tetromino_Ypos[3]] = 0

            // insert new position
            Level.Z[Tetromino.tetromino_Xpos[0]][Tetromino.tetromino_Ypos[0]] = Tetromino.colorCode
            Level.Z[Tetromino.tetromino_Xpos[1]][Tetromino.tetromino_Ypos[1]] = Tetromino.colorCode
            Level.Z[Tetromino.tetromino_Xpos[2]][Tetromino.tetromino_Ypos[2]] = Tetromino.colorCode
            Level.Z[Tetromino.tetromino_Xpos[3]][Tetromino.tetromino_Ypos[3]] = Tetromino.colorCode

            //TetrominoGhost.setGhost()
        }
    }
}