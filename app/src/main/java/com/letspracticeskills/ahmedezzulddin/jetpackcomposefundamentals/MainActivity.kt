package com.letspracticeskills.ahmedezzulddin.jetpackcomposefundamentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column( // Linear Layout // Vertical
                modifier = Modifier.fillMaxSize(),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

//                MyText(my_text.value)
//                MyTextField()
//                MyOutLinedTextField()
//                MyButton()
//                MyGroupRadioButton()
//                MyFloatingActionButton()
//                MyProgress()
//                MyAlertDialog()
            }
        }
    }


}

@Composable
fun MyText(text: String) {
    Text(
        text = text,
        color = Color.Blue,
        fontSize = 24.sp
    ) // TextView
}


@Composable
fun MyTextField() {

    val textValue = remember {
        mutableStateOf("")
    }

    TextField(
        value = textValue.value,
        onValueChange = { text ->
            textValue.value = text
        },

        label = {
            Text(text = stringResource(id = R.string.text_field))
        }
    )
}


@Composable
fun MyOutLinedTextField() {

    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = { text ->
            textValue.value = text
        },

        label = { Text(text = stringResource(id = R.string.out_lined_text_field)) },

        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = colorResource(id = R.color.black),
            focusedBorderColor = colorResource(id = R.color.teal_700)
        )
    )
}


val my_text = mutableStateOf("")

@Composable
fun MyButton() {

    Button(
        onClick = {
            my_text.value = "This is my text"
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.teal_200)),
        border = BorderStroke(
            4.dp,
            color = colorResource(id = R.color.purple_200)
        ),
    ) {
        Text(
            text = stringResource(id = R.string.my_button),
            color = Color.Yellow
        )
    }
}


@Composable
fun MyGroupRadioButton() {

    val radioButtons = listOf(0, 1, 2)

    val selectedButton = remember {
        mutableStateOf(radioButtons.first())
    }

    Column {
        radioButtons.forEach { index ->
            val isSelected = index == selectedButton.value
            val colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(id = R.color.purple_200),
                unselectedColor = colorResource(id = R.color.black),
                disabledColor = colorResource(id = R.color.purple_700)
            )

            RadioButton(
                selected = isSelected,
                colors = colors,
                onClick = { selectedButton.value = index },
            )
        }
    }


}


@Composable
fun MyFloatingActionButton() {

    FloatingActionButton(
        onClick = { /*TODO*/ },
        contentColor = Color.Yellow,
        content = {
            Icon(Icons.Filled.Favorite, stringResource(id = R.string.my_fab))
        }
    )

}

@Composable
fun MyProgress() {

    CircularProgressIndicator(
        color = colorResource(id = R.color.teal_200),
        strokeWidth = 2.dp
    )

    LinearProgressIndicator(progress = 0.3F)
}


@Composable
fun MyAlertDialog() {

    val shouldShowDialog = remember {
        mutableStateOf(true)
    }


    if (shouldShowDialog.value) {

        AlertDialog(
            title = { Text(text = "Title Alert Dialog") },
            text = { Text(text = "Text Alert Dialog") },

            onDismissRequest = {
                shouldShowDialog.value = false
            },
            confirmButton = {
                Button(
                    onClick = { shouldShowDialog.value = false
                    }
                ) {
                    Text(text = "Confirm")
                }
            },

            dismissButton = {
                Button(
                    onClick = { shouldShowDialog.value = false },


                    ) {
                    Text(text = "Cancel")
                }
            }

        )
    }

}


////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////