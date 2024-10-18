package com.example.kdan__intern_test_tetris

class Tetromino {
    companion object {
        var tetromino_Xpos = arrayOf(0)
        var tetromino_Ypos = arrayOf(0)

        var actualShape = ""
        var colorCode: Int = 0
        var nextShape = 0
        var next2Shape = 0
        var next3Shape = 0
        var next4Shape = 0
        var shapeDirection = 0
        var speed: Long = 500

        //在新增新方塊的座標，在game map最上方
        fun newPiece() {
            nextShape = (1..7).random()
            when (nextShape) {
                1 -> {
                    actualShape = "I"
                    shapeDirection = 1
                    colorCode = 2
                    tetromino_Xpos = arrayOf(0, 0, 0, 0)
                    tetromino_Ypos = arrayOf(3, 4, 5, 6)
                    //  .  .  .  0  1  2  3  .  .  .
                    //  .  .  .  .  .  .  .  .  .  .
                }

                2 -> {
                    actualShape = "O"
                    colorCode = 2
                    shapeDirection = 1
                    tetromino_Xpos = arrayOf(0, 0, 1, 1)
                    tetromino_Ypos = arrayOf(4, 5, 4, 5)
                    //  .  .  .  .  0  1  .  .  .  .
                    //  .  .  .  .  2  3  .  .  .  .
                }

                3 -> {
                    actualShape = "T"
                    colorCode = 4
                    shapeDirection = 1
                    tetromino_Xpos = arrayOf(0, 0, 0, 1)
                    tetromino_Ypos = arrayOf(3, 4, 5, 4)

                    //  .  .  .  0  1  2  .  .  .  .
                    //  .  .  .  .  3  .  .  .  .  .
                }

                4 -> {
                    actualShape = "J"
                    colorCode = 5
                    shapeDirection = 1
                    tetromino_Xpos = arrayOf(0, 0, 0, 1)
                    tetromino_Ypos = arrayOf(3, 4, 5, 5)

                    //  .  .  .  0  1  2  .  .  .  .
                    //  .  .  .  .  .  3  .  .  .  .
                }

                5 -> {
                    actualShape = "L"
                    shapeDirection = 1
                    colorCode = 6
                    tetromino_Xpos = arrayOf(0, 0, 0, 1)
                    tetromino_Ypos = arrayOf(3, 4, 5, 3)

                    //  .  .  .  0  1  2  .  .  .  .
                    //  .  .  .  3  .  .  .  .  .  .
                }

                6 -> {
                    actualShape = "S"
                    shapeDirection = 1
                    colorCode = 7
                    tetromino_Xpos = arrayOf(0, 0, 1, 1)
                    tetromino_Ypos = arrayOf(4, 5, 3, 4)

                    //  .  .  .  .  0  1  .  .  .  .
                    //  .  .  .  2  3  .  .  .  .  .
                }

                7 -> {
                    actualShape = "Z"
                    shapeDirection = 1
                    colorCode = 8
                    tetromino_Xpos = arrayOf(0, 0, 1, 1)
                    tetromino_Ypos = arrayOf(3, 4, 4, 5)

                    //  .  .  .  0  1  .  .  .  .  .
                    //  .  .  .  .  2  3  .  .  .  .
                }
            }
        }
    }
}