package com.sample.romancalculation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sample.romancalculation.ui.theme.RomanCalculationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RomanCalculationTheme {
                InitializeSearchContainer()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InitializeSearchContainer() {
    var ediTextInfo by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){

        Row(modifier =  Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            TextField(value = ediTextInfo, onValueChange = {ediTextInfo = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0F)
                    .border(width = 1.dp, color = Color.Blue, shape = RoundedCornerShape(2.dp)),
                label = {
                    Text(text ="Enter a Number", fontSize = 12.sp, color = colorResource(id = R.color.black))
                }, colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White, textColor = colorResource(id = R.color.teal_200)
                ))
            Button(onClick = {
                Log.e("GTM","Value from EditText -> $ediTextInfo")
                             }, modifier = Modifier.padding(start = 16.dp), shape = RoundedCornerShape(2.dp)) {
                Text(text="Translate")
            }
        }
        
        Text(
            text = "Result Hsitory",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = Color.DarkGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ViewCheck() {
    InitializeSearchContainer()
}