package com.revaldi.calorify.Screen

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.revaldi.calorify.R


@Composable
fun BirthAndPlacePersonalization(navController: NavHostController) {
    var dateOfBirth by remember { mutableStateOf("28/10/2001") }
    var country by remember { mutableStateOf("Indonesia") }
    var showDatePicker by remember { mutableStateOf(false) }
    var showDropdown by remember { mutableStateOf(false) }
    val countries = listOf("Indonesia", "United States", "United Kingdom", "Canada", "Australia")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(390.dp)
            .padding(start = 8.dp, end = 7.dp, top = 12.dp, bottom = 30.dp)
    ) {
        Spacer(modifier = Modifier.height(77.dp))
        Text(
            text = "When were you born?",
            color = Color(0xff3b3b3b),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Black)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "We will calculate your calorie needs",
            color = Color(0xff3b3b3b),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.width(298.dp)
        )
        Spacer(modifier = Modifier.height(45.dp))
        Button(
            onClick = { showDatePicker = true },
            modifier = Modifier
                .width(342.dp)
                .height(75.dp)
                .clip(shape = RoundedCornerShape(15.dp))
        ) {
            Box(
                modifier = Modifier
                    .size(51.dp)
                    .background(color = Color(0xfff2f3ff))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_android),
                    contentDescription = "Outline/General/Calendar",
                    tint = Color(0xff6f7cfc),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Date",
                    color = Color.Black,
                    style = TextStyle(fontSize = 14.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = dateOfBirth,
                    color = Color.Black,
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_android),
                contentDescription = "Outline/Interface/Caret down",
                tint = Color.Black,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.height(71.dp))
        Text(
            text = "Where do you live?",
            color = Color(0xff3b3b3b),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Black)
        )
        Spacer(modifier = Modifier.height(21.dp))
        Button(
            onClick = { showDropdown = true },
            modifier = Modifier
                .width(342.dp)
                .height(75.dp)
                .clip(shape = RoundedCornerShape(15.dp))
        ) {
            Box(
                modifier = Modifier
                    .size(51.dp)
                    .background(color = Color(0xfff2f3ff))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_android),
                    contentDescription = "Outline/Navigation/Location",
                    tint = Color(0xff6f7cfc),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Country",
                    color = Color.Black,
                    style = TextStyle(fontSize = 14.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = country,
                    color = Color.Black,
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_android),
                contentDescription = "Outline/Interface/Caret down",
                tint = Color.Black,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.height(304.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Handle back button click here */ },
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff6e7bfb)),
                modifier = Modifier.padding(horizontal = 50.dp, vertical = 15.dp)
            ) {
                Text(
                    text = "Back",
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Black)
                )
            }

            Button(
                onClick = { /* Handle next button click here */ },
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff6f7cfc)),
                modifier = Modifier.padding(horizontal = 50.dp, vertical = 15.dp)
            ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Black)
                )
            }
        }
    }
}


@Composable
fun <T> LargeDropdownMenu(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String,
    notSetLabel: String? = null,
    items: List<T>,
    selectedIndex: Int = -1,
    onItemSelected: (index: Int, item: T) -> Unit,
    selectedItemToString: (T) -> String = { it.toString() },
    drawItem: @Composable (T, Boolean, Boolean, () -> Unit) -> Unit = { item, selected, itemEnabled, onClick ->
        LargeDropdownMenuItem(
            text = item.toString(),
            selected = selected,
            enabled = itemEnabled,
            onClick = onClick,
        )
    },
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier.height(IntrinsicSize.Min)) {
        OutlinedTextField(
            label = { Text(label) },
            value = items.getOrNull(selectedIndex)?.let { selectedItemToString(it) } ?: "",
            enabled = enabled,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                val icon = if (expanded) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropDown
                Icon(icon, contentDescription = null)
            },
            onValueChange = { },
            readOnly = true,
        )
        // Transparent clickable surface on top of OutlinedTextField
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp)
                .clip(MaterialTheme.shapes.small)
                .clickable(enabled = enabled) { expanded = true },
            color = Color.Transparent,
        ) {}
    }
    if (expanded) {
        Dialog(
            onDismissRequest = { expanded = false },
        ) {
            MyTheme {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                ) {
                    val listState = rememberLazyListState()
                    if (selectedIndex > -1) {
                        LaunchedEffect("ScrollToSelected") {
                            listState.scrollToItem(index = selectedIndex)
                        }
                    }
                    LazyColumn(modifier = Modifier.fillMaxWidth(), state = listState) {
                        if (notSetLabel != null) {
                            item {
                                LargeDropdownMenuItem(
                                    text = notSetLabel,
                                    selected = false,
                                    enabled = false,
                                    onClick = { },
                                )
                            }
                        }
                        itemsIndexed(items) { index, item ->
                            val selectedItem = index == selectedIndex
                            drawItem(
                                item,
                                selectedItem,
                                true
                            ) {
                                onItemSelected(index, item)
                                expanded = false
                            }
                            if (index < items.lastIndex) {
                                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LargeDropdownMenuItem(
    text: String,
    selected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val contentColor = when {
        !enabled -> MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
        selected -> MaterialTheme.colors.primary
        else -> MaterialTheme.colors.onSurface
    }
    CompositionLocalProvider(LocalContentColor provides contentColor) {
        Box(
            modifier = Modifier
                .clickable(enabled = enabled) { onClick() }
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 16.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.body1,
            )
        }
    }
}

@Composable
fun MyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(
            primary = Color(0xff6f7cfc),
            onPrimary = Color.White,
            surface = Color.White,
            onSurface = Color(0xff3b3b3b)
        ),
        typography = MaterialTheme.typography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}
