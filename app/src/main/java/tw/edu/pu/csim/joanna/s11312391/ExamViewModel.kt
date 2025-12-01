package tw.edu.pu.csim.joanna.s11312391

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf // 新增：用於 Int 狀態
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.random.Random

// 服務圖示資源 ID (假設 R.drawable 包含這些資源)
val serviceIconIds = listOf(
    R.drawable.service0, // 使用您先前範例中的 role0~3 來保持一致
    R.drawable.service1,
    R.drawable.service2,
    R.drawable.service3
)

class ExamViewModel : ViewModel() {
    // 修正：必須使用 mutableStateOf 才能讓 Compose 追蹤螢幕尺寸
    var screenWidthPx by mutableIntStateOf(0)
        private set
    var screenHeightPx by mutableIntStateOf(0)
        private set

    val studentInfo: String = "資管二B 程莉芳"

    // 修正：必須使用 mutableStateOf 才能讓分數更新並顯示
    var score by mutableIntStateOf(0)

    fun updateScreenSize(width: Int, height: Int) {
        screenWidthPx = width
        screenHeightPx = height
    }

    // 修正：必須使用 mutableFloatStateOf 才能讓 Compose 追蹤動畫位置
    var fallingX by mutableFloatStateOf(0f)
    var fallingY by mutableFloatStateOf(0f)

    // 修正：圖示的大小 (px)，使用 Int 或 Float，這裡使用 Float 以利計算
    val fallingImageSizePx = 300f // 假設為 300px

    // 當前隨機產生的服務圖示資源 ID (已正確使用 mutableStateOf)
    var currentServiceIconId by mutableStateOf(serviceIconIds[0])
        private set

    // 掉落速度 (px/0.1s)
    val dropSpeedPx = 20f

    /**
     * 隨機產生服務圖示並重設位置
     */
    fun resetFallingIcon(initialX: Float) {
        currentServiceIconId = serviceIconIds.random() // 隨機選圖示
        fallingY = 0f
        fallingX = initialX
    }

    /**
     * 更新掉落 Y 軸位置
     */
    fun updateFallingY() {
        fallingY += dropSpeedPx
    }

    /**
     * 更新 X 軸位置 (拖曳)
     */
    fun updateFallingX(newX: Float) {
        val minX = 0f
        // 確保 maxX 是 Float，以便與 newX 比較
        val maxX = screenWidthPx.toFloat() - fallingImageSizePx
        fallingX = newX.coerceIn(minX, maxX)
    }

    // (可選) 新增一個更新分數的函式，方便未來使用
    fun updateScore(newScore: Int) {
        score = newScore
    }
}