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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.example.kdan__intern_test_tetris.ui.theme.KDAN__intern_Test_TetrisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KDAN__intern_Test_TetrisTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CanvasView(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


val tetrominoSize = 75F
val blockSize = 80.dp
val width = 10 * blockSize
val height = 22 * blockSize

@Composable
fun CanvasView(name: String, modifier: Modifier = Modifier) {


    Column(modifier = Modifier.fillMaxSize(),
           horizontalAlignment = Alignment.CenterHorizontally) {
        Canvas(modifier = Modifier
            .padding(16.dp)
            .size(width, height)) {
        val Block = Paint()

        for(i in 2..21){
            for(j in 0..9){
                drawRect(color = Color.Red,
                         topLeft = Offset(x= Level.X[i][j], y = Level.Y[i][j]),
                         size = Size(tetrominoSize, tetrominoSize)
                )
            }
        }
   }
    }

}

