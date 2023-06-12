package com.revaldi.calorify.Screen

import android.app.DatePickerDialog
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.revaldi.calorify.R
import android.widget.DatePicker
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.ui.platform.LocalContext
import com.revaldi.calorify.Data.UserViewModel
import com.revaldi.calorify.Navigation.Screen
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.time.LocalDate
import java.time.temporal.ChronoUnit


@Composable
fun BirthAndPlacePersonalization(navController: NavHostController,viewModel: UserViewModel){

    var selectedDate by remember { mutableStateOf("") }
    var selectedIndex by remember { mutableStateOf(-1) }
    var country by remember { mutableStateOf("") }
    var showDropdown by remember { mutableStateOf(false) }
    val countries = listOf("Indonesia", "United States", "United Kingdom", "Canada", "Australia")
    var age by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

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


        showDatePickerDialog { date,ageNow ->
            selectedDate = date
            age = ageNow
        }

        // Display selected date
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.align(Alignment.Start)) { Text(selectedDate) }
        Spacer(modifier = Modifier.height(71.dp))
        Text(
            text = "Where do you live?",
            color = Color(0xff3b3b3b),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Black)
        )
        Spacer(modifier = Modifier.height(21.dp))
        LargeDropdownMenu(
            label = "Select Country",
            items = countries,
            selectedIndex = selectedIndex,
            onItemSelected = { index, _ -> selectedIndex = index },
        )
        Spacer(modifier = Modifier.height(250.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { navController.navigate(Screen.HeightWeightPersonalization.route) },
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff6e7bfb)),
                modifier = Modifier
                    .width(144.dp)
                    .height(54.dp)

            ) {
                Text(
                    text = "Back",
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Black)
                )
            }

            Button(
                onClick = {
                    viewModel.birthday.value = selectedDate
                    viewModel.age.value = age.toString()
                    viewModel.nation.value = countries[selectedIndex]
                    navController.navigate(Screen.ActivityPersonalization.route) },
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff6f7cfc)),
                modifier = Modifier
                    .width(144.dp)
                    .height(54.dp)
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
fun showDatePickerDialog(onDateSelected: (String,Int) -> Unit) {
    val dialogState = rememberMaterialDialogState()
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
    var myDate by remember { mutableStateOf("") }
    MaterialDialog(
        dialogState = dialogState,
        buttons = {
            positiveButton("Ok")
            negativeButton("Cancel")
        }
    ) {
        datepicker { date ->
            val formattedDate = dateFormatter.format(date)
            onDateSelected(formattedDate, calculateAge(date))
            myDate = formattedDate
        }
    }

    Button(
        modifier = Modifier.width(340.dp).height(75.dp).border(0.5.dp, Color.Black, RoundedCornerShape(10.dp)),
        onClick = {
            dialogState.show()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
    ) {
        Text(if(myDate == "") "Select Date" else myDate, fontSize = 20.sp, textAlign = TextAlign.Center)
    }


}
fun calculateAge(date: LocalDate): Int {
    val currentDate = LocalDate.now()
    val years = ChronoUnit.YEARS.between(date, currentDate)
    return years.toInt()
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

    Box(
        modifier = modifier.height(IntrinsicSize.Min),
        contentAlignment = Alignment.Center

        ) {
        OutlinedTextField(
            label = { Text(label) },
            value = items.getOrNull(selectedIndex)?.let { selectedItemToString(it) } ?: "",
            enabled = enabled,
            modifier = Modifier.width(340.dp).height(75.dp),
            trailingIcon = {
                val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.ArrowDropDown
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

@Composable
fun LargeDropdownMenuItem(
    text: String,
    selected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val contentColor = when {
        !enabled -> MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
        selected -> MaterialTheme.colors.primary.copy(alpha = ContentAlpha.high)
        else -> MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.high)
    }

    CompositionLocalProvider(LocalContentColor provides contentColor) {
        Box(modifier = Modifier
            .clickable(enabled) { onClick() }
            .fillMaxWidth()
            .padding(16.dp)) {
            Text(
                text = text,
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}



@Preview
@Composable
fun BirthAndPlacePersonalizationPreview() {
    BirthAndPlacePersonalization(navController = rememberNavController(), viewModel = UserViewModel())
}



