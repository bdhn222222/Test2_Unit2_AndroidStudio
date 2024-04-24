package com.example.test2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test2.ui.theme.Test2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace( modifier: Modifier = Modifier) {
    var currentIndex by remember{ mutableIntStateOf(0) }
    val imgArray = arrayOf(
        ImageDesc(R.drawable.img_4454, "Image 1", "Hanh Nguyen -", " 2024"),
        ImageDesc(R.drawable.img_4455, "Image 2", "Hanh Nguyen 1 -", " 2021"),
        ImageDesc(R.drawable.img_4456, "Image 3", "Hanh Nguyen 2 -", " 2022"),
        ImageDesc(R.drawable.img_4457, "Image 4", "Hanh Nguyen 3 -", " 2023"),
        ImageDesc(R.drawable.img_4458, "Image 5", "Hanh Nguyen 4 -", " 2021"),
        ImageDesc(R.drawable.img_4459, "Image 6", "Hanh Nguyen 5 -", " 2022"),
    )
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.height(24.dp))
        Box(Modifier.background(Color.White).shadow(4.dp)) {
            Image(
                painter = painterResource(id = imgArray[currentIndex].imageID),
                contentDescription = imgArray[currentIndex].desc,
                Modifier.width(240.dp)
                    .padding(16.dp),
                contentScale = ContentScale.Fit
            )
        }
        Spacer(Modifier.height(48.dp))
        Column (
            Modifier
                .width(300.dp)
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                .background(color = Color(red = 230, green = 235, blue = 232))
        ){
            Text(imgArray[currentIndex].desc)
            Row(){
                Text(imgArray[currentIndex].author,
                    fontWeight = FontWeight.Bold
                )
                Text(imgArray[currentIndex].year)
            }
        }
        Spacer(Modifier.weight(1f))
        Row (){
            Button(
                onClick = {
                    currentIndex--
                    if(currentIndex<0){
                        currentIndex = imgArray.size -1
                    }
                },
                Modifier
                    .weight(2f)
                    .padding(16.dp)
            ){
                Text("Previous")
            }
            Button(
                onClick =
                {
                    currentIndex++
                    if(currentIndex > imgArray.size){
                        currentIndex = 0
                    }
                },
                Modifier
                    .weight(2f)
                    .padding(16.dp)
            ) {
                Text("Next")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Test2Theme {
        ArtSpace()
    }
}