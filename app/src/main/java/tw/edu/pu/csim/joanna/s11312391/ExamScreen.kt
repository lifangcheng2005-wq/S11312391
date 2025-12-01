package tw.edu.pu.csim.joanna.s11312391

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import tw.edu.pu.csim.joanna.s11312391.R
import tw.edu.pu.csim.joanna.s11312391.ExamViewModel

private val IMAGE_SIZE = 100.dp
private val FALLING_ICON_SIZE = 100.dp

@Composable
fun ExamScreen(
    viewModel: ExamViewModel = viewModel()
) {

    val screenHeightPx = viewModel.screenHeightPx
    val screenWidthPx = viewModel.screenWidthPx
    val density = LocalDensity.current.density
    val screenHeightDp = (screenHeightPx / density).dp

    val fallingY_dp = (viewModel.fallingY / density).dp
    val fallingX_dp = (viewModel.fallingX / density).dp

    val screenWidthDp = (screenWidthPx / density).dp
    val initialX_px = (screenWidthPx / 2f) - (viewModel.fallingImageSizePx / 2f)

    LaunchedEffect(Unit) {
        viewModel.resetFallingIcon(initialX_px) // 初始設定位置和圖示
        while (true) {
            delay(100) // 延遲 0.1 秒
            viewModel.updateFallingY() // 向下移動 20px

            // 碰撞檢測：如果圖示底部 Y 軸位置 >= 螢幕高度
            val bottomEdgeY = viewModel.fallingY + viewModel.fallingImageSizePx // 圖示底部 Y 軸
            if (bottomEdgeY >= screenHeightPx) {
                viewModel.resetFallingIcon(initialX_px) // 碰撞後重設
            }
        }
    }
    val draggableState = rememberDraggableState { delta ->
        // delta 是 Compose 提供的水平移動量 (in px)
        viewModel.updateFallingX(viewModel.fallingX + delta)
    }

    val halfScreenHeightDp = screenHeightDp / 2

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF000))
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.happy),
                contentDescription = "考試Logo",
                modifier = Modifier.size(200.dp)
            )

            Text(
                text = "瑪利亞基金會服務大考驗",
                fontSize = 14.sp,
                color = Color.Black
            )

            Text(
                text = "作者：${viewModel.studentInfo}",
                fontSize = 14.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "螢幕大小：${viewModel.screenWidthPx}.0 * ${viewModel.screenHeightPx}.0",
                fontSize = 14.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "成績：${viewModel.score} 分",
                fontSize = 14.sp,
                color = Color.Black
            )
        }

        Image(
            painter = painterResource(id = R.drawable.role0),
            contentDescription = "嬰幼兒",
            modifier = Modifier
                .size(IMAGE_SIZE)
                .align(Alignment.TopStart)
                .offset(y = halfScreenHeightDp - IMAGE_SIZE)
        )

        Image(
            painter = painterResource(id = R.drawable.role1),
            contentDescription = "兒童",
            modifier = Modifier
                .size(IMAGE_SIZE)
                .align(Alignment.TopEnd)
                .offset(y = halfScreenHeightDp - IMAGE_SIZE)
        )

        Image(
            painter = painterResource(id = R.drawable.role2),
            contentDescription = "成人",
            modifier = Modifier
                .size(IMAGE_SIZE)
                .align(Alignment.BottomStart)
        )

        Image(
            painter = painterResource(id = R.drawable.role3),
            contentDescription = "一般民眾",
            modifier = Modifier
                .size(IMAGE_SIZE)
                .align(Alignment.BottomEnd)
        )
        Image(
            painter = painterResource(id = viewModel.currentServiceIconId),
            contentDescription = "掉落的服務圖示",
            modifier = Modifier
                .offset(x = fallingX_dp, y = fallingY_dp)
                .size(FALLING_ICON_SIZE)
                .draggable(
                    state = draggableState,
                    orientation = androidx.compose.foundation.gestures.Orientation.Horizontal,
                )
        )
    }
}