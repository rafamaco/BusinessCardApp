package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        ComposeQuadrantApp()
    }
}

@Composable
fun ComposeQuadrantApp() {
    var backgroundColor = Color(0xFFA2B5A0)
    Column(
        Modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        Row (
            Modifier
                .weight(2.5f)
        ){
            ComposableImageCard(
                title = "Android Developer Extraordinarie",
                fullName = "Jennifer Doe",
                modifier = Modifier.weight(1f)
            )
        }
        Row (Modifier.weight(1f)){
            ComposableInfoCard(
                phone = "+11 (123) 444 555 666",
                socialMedia = "@socialMediaHandle",
                email = "email@doemail.com",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ComposableImageCard(
    title: String,
    fullName: String,
    modifier: Modifier = Modifier
){
    var textColor = Color(0xFF008000)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.android_logo) ,
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .background(Color.DarkGray)
        )
        Text(
            text = fullName,
            textAlign = TextAlign.Justify,
            fontSize = 50.sp
        )
        Text(
            text = title,
            textAlign = TextAlign.Justify,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}

@Composable
private fun ComposableInfoCard(
    phone: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (            modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp)){
            Image(
                painter = painterResource(id = R.drawable.ic_phone),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
            )
            Text(
                text = phone,
                textAlign = TextAlign.Justify,
                fontSize = 20.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp)

        ){
            Image(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
            )
            Text(
                text = socialMedia,
                textAlign = TextAlign.Justify,
                fontSize = 20.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row (
            modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp)){
            Image(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
            )
            Text(
                text = email,
                textAlign = TextAlign.Justify,
                fontSize = 20.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

