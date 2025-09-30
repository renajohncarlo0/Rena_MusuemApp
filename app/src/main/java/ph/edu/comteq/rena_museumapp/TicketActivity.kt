package ph.edu.comteq.rena_museumapp

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text
import ph.edu.comteq.rena_museumapp.ui.theme.Rena_MuseumAppTheme
import java.time.Instant
import java.time.Duration

class TicketActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rena_MuseumAppTheme {
                Ticketing(name = "Museum Ticketing")            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ticketing(name: String, modifier: Modifier = Modifier){
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().
        plus(Duration.ofDays(2)).toEpochMilli(),
        selectableDates = object: SelectableDates{
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis >= Instant.now()
                    .plus(Duration.ofDays(1)).toEpochMilli()
            }
        }

    )
    Column(
        modifier = modifier.background(Color.Black)
    ){
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ){
            // Header
            Box(
                modifier  = Modifier.fillMaxWidth().height(230.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = ph.edu.comteq.rena_museumapp.R.drawable.ticketimage),
                    contentDescription = "Logo",
                    contentScale = ContentScale.Crop
                )
                // black overlay
                Box(
                    modifier  = Modifier.fillMaxWidth().height(230.dp)
                        .background(Color.Black.copy(alpha = 0.7f))
                )
                Text(
                    text = "Official\nTicketing Service",
                    fontSize = 32.sp,
                    fontFamily = playfairdisplayregular,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 36.sp
                )
            }
            // inner container for date and ticket types
            Column (
                modifier  = Modifier.fillMaxWidth().fillMaxHeight()
            ){
                DatePicker(
                    modifier = Modifier.padding(10.dp).fillMaxWidth(),
                    state = datePickerState,
                    title = null,
                    showModeToggle = false,
                    headline = {
                        Text (
                            "1. Date to visit"
                        )
                    }
                )
                // general admission ticket

                // free tickets
            }
        }
        // bottom bar for totals
        Row(
            modifier  = Modifier.fillMaxWidth().height(80.dp)
                .background(Color(0xFFd29f1b))
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                "Total: P500",
                fontSize = 26.sp,
                fontFamily = playfairdisplayregular,
                color = Color.Black,
            )
            Button(
                modifier = Modifier.padding(5.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ){
                Text(
                    "Checkout",
                    fontSize = 20.sp,
                    fontFamily = playfairdisplayregular,
                    color = Color(color = 0xFFd29f1b)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TicketingPreview(){
    Rena_MuseumAppTheme{}
    Ticketing(name = "Museum Preview")
}