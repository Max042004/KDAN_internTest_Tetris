package com.example.kdan__intern_test_tetris

class Level {
    companion object {
        var score = 0
        var level = 1

        // NON VARIABLES X coordinates - for drawing
        // first two level is hidden
        //原本的寫法只有10*20，我把它改成10*22，所以X,Y array才會有幾行註解，而在螢幕上面多的兩行用來顯示新生成tetromino
        val X = arrayOf(
            //arrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
            //arrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
            arrayOf(0f, 80f, 160f, 240f, 320f, 400f, 480f, 560f, 640f, 720f),
        )

        // NON VARIABLES Y coordinates - for drawing
        // first two level is hidden
        val Y = arrayOf(
            //arrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
            //arrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
            arrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
            arrayOf(80f, 80f, 80f, 80f, 80f, 80f, 80f, 80f, 80f, 80f),
            arrayOf(160f, 160f, 160f, 160f, 160f, 160f, 160f, 160f, 160f, 160f),
            arrayOf(240f, 240f, 240f, 240f, 240f, 240f, 240f, 240f, 240f, 240f),
            arrayOf(320f, 320f, 320f, 320f, 320f, 320f, 320f, 320f, 320f, 320f),
            arrayOf(400f, 400f, 400f, 400f, 400f, 400f, 400f, 400f, 400f, 400f),
            arrayOf(480f, 480f, 480f, 480f, 480f, 480f, 480f, 480f, 480f, 480f),
            arrayOf(560f, 560f, 560f, 560f, 560f, 560f, 560f, 560f, 560f, 560f),
            arrayOf(640f, 640f, 640f, 640f, 640f, 640f, 640f, 640f, 640f, 640f),
            arrayOf(720f, 720f, 720f, 720f, 720f, 720f, 720f, 720f, 720f, 720f),
            arrayOf(800f, 800f, 800f, 800f, 800f, 800f, 800f, 800f, 800f, 800f),
            arrayOf(880f, 880f, 880f, 880f, 880f, 880f, 880f, 880f, 880f, 880f),
            arrayOf(960f, 960f, 960f, 960f, 960f, 960f, 960f, 960f, 960f, 960f),
            arrayOf(1040f, 1040f, 1040f, 1040f, 1040f, 1040f, 1040f, 1040f, 1040f, 1040f),
            arrayOf(1120f, 1120f, 1120f, 1120f, 1120f, 1120f, 1120f, 1120f, 1120f, 1120f),
            arrayOf(1200f, 1200f, 1200f, 1200f, 1200f, 1200f, 1200f, 1200f, 1200f, 1200f),
            arrayOf(1280f, 1280f, 1280f, 1280f, 1280f, 1280f, 1280f, 1280f, 1280f, 1280f),
            arrayOf(1360f, 1360f, 1360f, 1360f, 1360f, 1360f, 1360f, 1360f, 1360f, 1360f),
            arrayOf(1440f, 1440f, 1440f, 1440f, 1440f, 1440f, 1440f, 1440f, 1440f, 1440f),
            arrayOf(1520f, 1520f, 1520f, 1520f, 1520f, 1520f, 1520f, 1520f, 1520f, 1520f),
            arrayOf(1600f, 1600f, 1600f, 1600f, 1600f, 1600f, 1600f, 1600f, 1600f, 1600f),
            arrayOf(1680f, 1680f, 1680f, 1680f, 1680f, 1680f, 1680f, 1680f, 1680f, 1680f),
        )

        // VARIABLE Z - if(value == 1111) draw outside the canvas, else inside
        // first two level is hidden
        //the value represent the color
        var Z = mutableListOf(
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

        // reset level
        fun reset() {
            level = 1
            score = 0
            Tetromino.speed = 500

            Tetromino.next2Shape = (1..7).random()
            Tetromino.next3Shape = (1..7).random()
            Tetromino.next4Shape = (1..7).random()

            // level clear
            for (i in 0..21) {
                for (j in 0..9) {
                    Z[i][j] = 0
                }
            }
        }

        // if tetromino cant entered
        fun isGameOver(): Boolean {
            for (i in Tetromino.tetromino_Xpos) {
                if (i < 2) {
                    return true
                }
            }
            return false
        }

        fun gameOver(){
            for (i in 0..21) {
                for (j in 0..9) {
                    if(Z[i][j] != 0){
                        Z[i][j] = 1
                    }
                }
            }
        }

        fun checkRows() {
            for ((index, i) in Z.withIndex()) {
                if (i[0] > 1 &&
                    i[1] > 1 &&
                    i[2] > 1 &&
                    i[3] > 1 &&
                    i[4] > 1 &&
                    i[5] > 1 &&
                    i[6] > 1 &&
                    i[7] > 1 &&
                    i[8] > 1 &&
                    i[9] > 1
                ) {
                    removeRow(index)
                    score += 1
                    if (score % 10 == 0) {
                        level++
                        Tetromino.speed -= 50
                    }

                }
            }
        }

        fun removeRow(index: Int) {
            // clean that row
            for (i in 0..9)
                Z[index][i] = 0
            // correct remained rows
            for (i in index downTo 2)
                Z[i] = Z[i - 1].also { Z[i - 1] = Z[i] } // swap
        }

        fun insertNewPosition() {
            Z[Tetromino.tetromino_Xpos[0]][Tetromino.tetromino_Ypos[0]] = Tetromino.colorCode
            Z[Tetromino.tetromino_Xpos[1]][Tetromino.tetromino_Ypos[1]] = Tetromino.colorCode
            Z[Tetromino.tetromino_Xpos[2]][Tetromino.tetromino_Ypos[2]] = Tetromino.colorCode
            Z[Tetromino.tetromino_Xpos[3]][Tetromino.tetromino_Ypos[3]] = Tetromino.colorCode
        }

        fun removeOldPosition() {
            Z[Tetromino.tetromino_Xpos[0]][Tetromino.tetromino_Ypos[0]] = 0
            Z[Tetromino.tetromino_Xpos[1]][Tetromino.tetromino_Ypos[1]] = 0
            Z[Tetromino.tetromino_Xpos[2]][Tetromino.tetromino_Ypos[2]] = 0
            Z[Tetromino.tetromino_Xpos[3]][Tetromino.tetromino_Ypos[3]] = 0
        }
    }
}