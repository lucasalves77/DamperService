package com.lucas.damper


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.lucas.damper.Mensagens.chatMessage
import com.lucas.damper.ui.theme.DamperTheme
import com.lucas.damperapp.MainLayout

/*class MainChatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DamperTheme {
                val navController = rememberNavController()
                chatMessage(navController = navController)
            }
        }
    }
}
*/