package tw.edu.pu.csim.joanna.s11312391

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import tw.edu.pu.csim.joanna.s11312391.ExamScreen
import tw.edu.pu.csim.joanna.s11312391.ExamViewModel
import tw.edu.pu.csim.joanna.s11312391.ui.theme.S11312391Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(
                androidx.core.view.WindowInsetsCompat.Type.systemBars()
            )
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        setContent {
            val examViewModel: ExamViewModel = viewModel()

            val context = LocalContext.current
            val displayMetrics = context.resources.displayMetrics
            val screenWidthPx = displayMetrics.widthPixels
            val screenHeightPx = displayMetrics.heightPixels
            examViewModel.updateScreenSize(screenWidthPx, screenHeightPx)

            S11312391Theme {
                ExamScreen(viewModel = examViewModel)
            }
        }
    }
}