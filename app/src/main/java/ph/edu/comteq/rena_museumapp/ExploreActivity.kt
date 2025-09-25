package ph.edu.comteq.rena_museumapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ph.edu.comteq.rena_museumapp.ui.theme.Rena_MuseumAppTheme

class ExploreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Rena_MuseumAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Explore(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Explore(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(40.dp)
        ) {
            // Heading
            Text(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(alignment = Alignment.Start),
                text = "Explore",
                color = Color.Yellow,
                fontFamily = playfairdisplayregular,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )

            // Divider
            HorizontalDivider(Modifier, DividerDefaults.Thickness, color = Color.Gray)

            // Subheading
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Upcoming Event",
                    color = Color.White,
                    fontFamily = playfairdisplayregular,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp
                )

                // Ticket Button instead of link
                Button(
                    onClick = {
                        val intent = Intent(context, TicketActivity::class.java)
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        "Book Ticket",
                        color = Color.Black,
                        fontFamily = playfairdisplayregular,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Event Card
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Image
                Image(
                    painter = painterResource(id = R.drawable.renaissance),
                    contentDescription = "Renaissance Exhibition",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Row(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .background(Color(0xFF2E2E2E))
                        .padding(18.dp)
                ) {
                    // Date
                    Column(
                        modifier = Modifier.padding(top = 40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "10",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontFamily = optima,
                            fontSize = 25.sp
                        )
                        Text(
                            "OCT",
                            color = Color.White,
                            fontFamily = optima,
                            fontSize = 18.sp
                        )
                    }

                    // Details
                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {
                        Text(
                            "Renaissance Exhibition",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "9:00 AM - 6:00 PM",
                            color = Color.White,
                            fontFamily = optima,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "Indulge in the rich tapestry of Renaissance art",
                            color = Color(0xFFD4AF37),
                            fontFamily = optima,
                            fontSize = 14.sp,
                            textDecoration = TextDecoration.Underline
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "+33 (0)1 23 45 67 89",
                            color = Color.White,
                            fontFamily = optima,
                            fontSize = 18.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                }

                // Visit Gallery button
                Button(
                    onClick = {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                ) {
                    Text(
                        "Visit Gallery",
                        color = Color.Black,
                        fontSize = 28.sp,
                        fontFamily = optima
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExplorePreview() {
    Rena_MuseumAppTheme {
        Explore()
    }
}
