package com.example.shopping

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.ui.theme.ShoppingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   background()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable

fun background() {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.gradient_bg),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxSize()
                .blur(6.dp),
            contentScale = ContentScale.Crop
        )
    }

    Column (
        Modifier
            .fillMaxSize()
            .padding(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Header()

        Amazon()
        myntra()
        Flipkart()
    }
}

@Composable
fun Header() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Web Page Surfer", fontSize = 36.sp, fontWeight = FontWeight.ExtraBold)
        Text(text = "Choose any of your choice!", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun Amazon() {
    val borderWidth = 6.dp
    Row {
        Image(painter = painterResource(id = R.drawable.amazon),
            contentDescription = "amazon logo",
            contentScale  = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .border(
                    BorderStroke(borderWidth, Color.Red),
                CircleShape
            )
        )

        val context = LocalContext.current
        val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/")) }

        Button(onClick = { context.startActivity(intent) }) {
            Text(text = "Open Amazon ")
        }
    }
}

@Composable
fun myntra() {
    val borderWidth = 4.dp
    Row {
        Image(painter = painterResource(id = R.drawable.myntra),
            contentDescription = "myntra logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .border(
                    BorderStroke(borderWidth, Color.Red),
                    CircleShape
                )
        )

        val context = LocalContext.current
        val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.myntra.com/")) }

        Button(onClick = { context.startActivity(intent) }) {
            Text(text = "Open Myntra ")
        }
    }
}

@Composable
fun Flipkart() {
    val borderWidth = 4.dp
    Row {
        Image(painter = painterResource(id = R.drawable.flipkart),
            contentDescription = "Flipkart logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .border(
                    BorderStroke(borderWidth, Color.Red),
                    CircleShape
                )
        )
        val context = LocalContext.current
        val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flipkart.com/")) }

        Button(onClick = { context.startActivity(intent) }) {
            Text(text = "Open Flipkart ")
        }
    }
}