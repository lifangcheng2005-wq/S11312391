package tw.edu.pu.csim.joanna.s11312391

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ExamViewModel : ViewModel() {
    var screenWidthPx by mutableStateOf(0)
        private set

    var screenHeightPx by mutableStateOf(0)
        private set

    val studentInfo: String = "資管二B 程莉芳"

    var score by mutableStateOf(0)

    fun updateScreenSize(width: Int, height: Int) {
        screenWidthPx = width
        screenHeightPx = height
    }
    fun updateScore(newScore: Int) {
        score = newScore
    }
}