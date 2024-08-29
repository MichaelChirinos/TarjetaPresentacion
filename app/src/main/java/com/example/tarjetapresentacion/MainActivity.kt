package com.example.tarjetapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaPresentacionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TarjetaPresentacionApp()
                }
            }
        }
    }
}

@Composable
fun TarjetaPresentacionApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3E9E4)),
        color = Color.Transparent
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Sección superior
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(3f) // Toma el espacio disponible
            ) {
                // Box para envolver la imagen y darle un fondo negro
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(100.dp) // Tamaño del fondo cuadrado
                        .background(Color.Black) // Fondo negro
                ) {
                    Image(
                        painter = painterResource(R.drawable.android_logo),
                        contentDescription = null,
                        modifier = Modifier.size(90.dp) // Tamaño de la imagen dentro del fondo
                    )
                }

                Text(
                    text = stringResource(R.string.jennifer_doe),
                    fontSize = 40.sp,
                    modifier = Modifier.padding(top = 16.dp),
                    color = Color.Black // Color de texto negro
                )
                Text(
                    text = stringResource(R.string.sub_title),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black // Color de texto negro
                )
            }

            // Sección inferior
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.weight(1f)
            ) {
                ContactInfo(iconRes = R.drawable.phone_24dp_5f6368, contactDetail = stringResource(R.string.number))
                ContactInfo(iconRes = R.drawable.share_24dp_5f6368, contactDetail = stringResource(R.string.androiddev))
                ContactInfo(iconRes = R.drawable.email_24dp_5f6368, contactDetail = stringResource(R.string.mail))
            }
        }
    }
}



@Composable
fun ContactInfo(iconRes: Int, contactDetail: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = contactDetail,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 8.dp),
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetaPresentacionTheme {
        TarjetaPresentacionApp()
    }
}