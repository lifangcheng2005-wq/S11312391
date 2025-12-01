package tw.edu.pu.csim.joanna.s11312391

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.materialcore.screenHeightDp
import tw.edu.pu.csim.joanna.s11312391.R
import tw.edu.pu.csim.joanna.s11312391.ExamViewModel

private val IMAGE_SIZE = 100.dp

@Composable
fun ExamScreen(
    viewModel: ExamViewModel = viewModel()
) {

    val screenHeightPx = viewModel.screenHeightPx
    val density = LocalDensity.current.density

    val screenHeightDp = (screenHeightPx / density).dp

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
    }
}