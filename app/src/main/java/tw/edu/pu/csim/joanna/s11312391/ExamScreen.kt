package tw.edu.pu.csim.joanna.s11312391

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import tw.edu.pu.csim.joanna.s11312391.R
import tw.edu.pu.csim.joanna.s11312391.ExamViewModel


@Composable
fun ExamScreen(
    viewModel: ExamViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF000)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.happy),
            contentDescription = "考試Logo",
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = "瑪利亞基金會服務大考驗",
            fontSize = 14.sp,
            color = Color.DarkGray
        )

        Text(
            text = "作者：${viewModel.studentInfo}",
            fontSize = 14.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "螢幕大小：${viewModel.screenWidthPx}.0 * ${viewModel.screenHeightPx}.0",
            fontSize = 14.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "成績：${viewModel.score} 分",
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}