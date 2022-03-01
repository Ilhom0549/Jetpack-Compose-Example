package uz.ilkhomkhuja.jetpackcomposeexample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.ilkhomkhuja.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                SimpleSliderComponent()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name!")
}

@Composable
fun SimpleText(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    Text(
        text = displayText,
        modifier = Modifier.padding(5.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE,
    )
}

@Composable
fun SimpleTextFieldComponent() {
    Surface(color = Color.Transparent, modifier = Modifier.padding(5.dp)) {
        var text by remember { mutableStateOf(TextFieldValue("Enter text here")) }
        TextField(
            value = text,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            onValueChange = {
                text = it
            }
        )
    }
}

@Composable
fun SimpleColumnComponent() {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = "Hello! I am Text 1", color = Color.Black)
        Text(text = "Hello! I am Text 2", color = Color.Green)
        Text(text = "Hello! I am Text 3", color = Color.Blue)
        Text(text = "Hello! I am Text 4", color = Color.DarkGray)
    }
}

val itemList = (0..50).toList()

@Composable
fun LazyColumnExample(name: List<Int>) {
    LazyColumn {
        this.items(name.size) {
            Text("Item is $it", color = Color.Blue)
        }
    }
}

private val countryList =
    mutableListOf("Uzbekistan", "India", "Pakistan", "China", "United States", "England")

private val listModifier = Modifier
    .fillMaxSize()
    .background(Color.White)
    .padding(10.dp)

private val textStyle = TextStyle(fontSize = 25.sp, color = Color.Black)

@Composable
fun SimpleListView() {
    LazyColumn(modifier = listModifier) {
        items(countryList) { country ->
            Text(text = country, style = textStyle)
        }
    }
}

@Composable
fun SimpleBoxComponent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(painterResource(R.drawable.ic_launcher_background), contentDescription = null)
        Text(
            modifier = Modifier.padding(start = 5.dp, top = 5.dp),
            text = "I am a text over Image",
            fontSize = 16.sp,
            color = Color.Red
        )
    }
}

@Composable
fun SimpleButtonComponent() {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text("Click Me")
    }
}

@Composable
fun SimpleCardComponent() {
    Card(
        elevation = 4.dp,
        backgroundColor = Color(0xFFFFA867.toInt()),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Simple Card",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun SimpleImageComponent() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(painterResource(R.drawable.ic_launcher_background), contentDescription = null)
    }
}

@Composable
fun AlertDialogComponent() {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Alert Dialog") },
            text = { Text("Hello! I am an Alert Dialog") },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        /* Do some other action */
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        /* Do some other action */
                    }
                ) {
                    Text("Dismiss")
                }
            },
            backgroundColor = Color.Black,
            contentColor = Color.White
        )
    }
}


@Composable
fun TopAppBarComponent() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = { Text("App Name") },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "")
            }
        }
    )
}

@Composable
fun BottomNavigationWithLabelComponent() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Blogs", "Profile")
    BottomNavigation(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        backgroundColor = Color.Black,
        contentColor = Color.Yellow
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                label = { Text(text = item) },
                icon = { Icon(Icons.Filled.Favorite,"") },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

@Composable
fun SimpleCheckboxComponent() {
    val checkedState = remember { mutableStateOf(true) }
    Row {
        Checkbox(
            checked = checkedState.value,
            modifier = Modifier.padding(16.dp),
            onCheckedChange = { checkedState.value = it },
        )
        Text(text = "Checkbox Example", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun SimpleSliderComponent() {
    var sliderValue by remember { mutableStateOf(0.4f) }
    Slider(
        value = sliderValue,
        modifier = Modifier.padding(8.dp),
        onValueChange = { newValue ->
            sliderValue = newValue
        }
    )
    Text(
        text = "Slider value: $sliderValue",
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun SimpleCircularProgressComponent() {
    CircularProgressIndicator(
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeExampleTheme {
       SimpleSliderComponent()
    }
}