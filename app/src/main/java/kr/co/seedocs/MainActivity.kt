package kr.co.seedocs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kr.co.main.Main
import kr.co.ui.theme.SeeDocsTheme

class MainActivity : PermissionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SeeDocsTheme {
                Main()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        if (!checkStoragePermission())
            requestStoragePermission()
    }
}