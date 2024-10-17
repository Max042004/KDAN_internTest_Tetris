package com.example.kdan__intern_test_tetris


import android.R.attr.height
import android.R.attr.width
import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.waterfallPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
                    TetrisGame(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}


@Composable
fun TetrisGame(modifier: Modifier = Modifier) {
    var gameState by remember { mutableIntStateOf(0) }
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


    Column(modifier = Modifier) {
        Row(){
            CanvasView(gameState = gameState, modifier = modifier.wrapContentSize())
            Column {
                Spacer(modifier = Modifier.size(80.dp))
                Text(text = "Best")
                Text(text = Level.score.toString())
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(modifier = Modifier.fillMaxSize()){
            Column(horizontalAlignment = Alignment.CenterHorizontally){
                Row{
                    Image(modifier = Modifier
                        .clickable {
                            if (MoveLeft.isMovableLeft()) {
                                MoveLeft.moveLeft()
                                gameState++
                            }
                        }
                        .size(70.dp),
                        painter = painterResource(id = R.drawable.move_left), contentDescription = "move_left")
                    Spacer(modifier = Modifier.size(35.dp))
                    Image(modifier = Modifier
                        .clickable {
                            if (MoveRight.isMovableRight()) {
                                MoveRight.moveRight()
                                gameState++
                            }
                        }
                        .size(size = 70.dp),
                        painter = painterResource(id = R.drawable.move_right), contentDescription = "move_right")
                }
                Spacer(modifier = Modifier.size(5.dp))
                Image(modifier = Modifier
                    .clickable {
                        if (!Falling.willLanding(1)) {
                            Falling.fallingStep()
                            gameState++
                        }
                    }
                    .size(size = 70.dp),
                    painter = painterResource(id = R.drawable.move_down), contentDescription = "move_down")
            }
            Spacer(modifier = Modifier.size(80.dp))
            Column{
                Spacer(modifier = Modifier.size(35.dp))
                Image(modifier = Modifier
                    .clickable {
                        if (Rotate.isRotable()) {
                            Rotate.doRotate()
                            gameState++
                        }
                    }
                    .size(size = 70.dp),
                    painter = painterResource(id = R.drawable.rotate), contentDescription = "rotate")
            }

        }
    }
}



@Composable
fun CanvasView(gameState: Int, modifier: Modifier = Modifier) {
    var temp:Int = 0
    val context = LocalContext.current
    val tetrominoSize = 75F
    val blockSize = (tetrominoSize+5).pxToDp(context)
    val width = 10 * blockSize
    val height = 23 * blockSize
    Box(modifier = Modifier.size(width = width.dp, height = height.dp)){
        Canvas(modifier = Modifier
            .wrapContentSize()) {
            for(i in 0..21){
                for(j in 0..9){
                    temp = gameState % 9
                    var tetrominoColor:Color = Color.Red
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
                        topLeft = Offset(x= Level.X[i][j], y = Level.Y[i][j] + tetrominoSize), //y + tetrominoSize是為了將map向下降
                        size = Size(tetrominoSize, tetrominoSize)
                    )
                }
            }
        }
    }
}

fun Float.pxToDp(context: Context): Float =
    (this / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))



