package com.example.kdan__intern_test_tetris


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.example.kdan__intern_test_tetris.ui.theme.KDAN__intern_Test_TetrisTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KDAN__intern_Test_TetrisTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Level.reset()
                    //Tetromino.newPiece()
                    //Level.insertNewPosition()
                    TetrisGame(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun TetrisGame(modifier: Modifier = Modifier) {
    var gameState by remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        Tetromino.newPiece()
        Level.insertNewPosition()
        while (true) {
            if(Falling.willLanding(1)){
                Level.checkRows()
                if(Level.isGameOver()){
                    Level.reset()
                }
                Tetromino.newPiece()
                Level.insertNewPosition()
            }
            else{
                Falling.fallingStep()
            }
            delay(500) // wait 0.5 second
            gameState++ // 重新渲染
        }
    }
    CanvasView(gameState = gameState, modifier = modifier)
}


val tetrominoSize = 75F
val blockSize = 80.dp
val width = 10 * blockSize
val height = 22 * blockSize

@Composable
fun CanvasView(gameState: Int, modifier: Modifier = Modifier) {
    var temp:Int = 0
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Canvas(modifier = Modifier
            .padding(16.dp)
            .size(width, height)) {
            for(i in 0..21){
                for(j in 0..9){
                    var tetrominoColor:Color = Color.Red
                    temp = gameState % 9
                    when (Level.Z[i][j]) {
                        0 -> tetrominoColor = Color.Transparent
                        1 -> {
                            tetrominoColor = Color.LightGray      // shadow
                        }
                        2 -> tetrominoColor = Color.Cyan      // I
                        3 -> tetrominoColor = Color.Yellow     // O
                        4 -> tetrominoColor = Color.Magenta    // T
                        5 -> tetrominoColor = Color.Blue       // J
                        6 -> tetrominoColor = Color.DarkGray   // L
                        7 -> tetrominoColor = Color.Red     // S
                        8 -> tetrominoColor = Color.Green       // Z
                    }
                    drawRect(color = tetrominoColor,
                        topLeft = Offset(x= Level.X[i][j], y = Level.Y[i][j]+ tetrominoSize), //y + tetrominoSize是為了將map向下降
                        size = Size(tetrominoSize, tetrominoSize)
                    )
                }
            }
        }
    }
}

