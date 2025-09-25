package ph.edu.comteq.rena_museumapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ph.edu.comteq.rena_museumapp.ui.theme.Rena_MuseumAppTheme

class TicketActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rena_MuseumAppTheme {
                TicketScreen()
            }
        }
    }
}

@Composable
fun TicketScreen() {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var quantity by remember { mutableStateOf(TextFieldValue("")) }
    var ticketInfo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Museum Ticket Booking", fontSize = 28.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Your Name") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Number of Tickets") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )


        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (name.text.isNotEmpty() && quantity.text.isNotEmpty()) {
                    ticketInfo = "🎟 Ticket for ${name.text}\n" +
                            "Tickets: ${quantity.text}\n" +
                            "Booking ID: MUSEUM-${(1000..9999).random()}"
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
        ) {
            Text("Confirm Booking", color = Color.Black, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (ticketInfo.isNotEmpty()) {
            Text(
                text = ticketInfo,
                fontSize = 18.sp,
                color = Color.DarkGray
            )
        }
    }
}
