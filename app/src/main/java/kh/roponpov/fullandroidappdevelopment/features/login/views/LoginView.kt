package kh.roponpov.fullandroidappdevelopment.features.login.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kh.roponpov.fullandroidappdevelopment.R
import kh.roponpov.fullandroidappdevelopment.core.ui.components.AppOrDivider
import kh.roponpov.fullandroidappdevelopment.features.login.views.sections.FormLoginSection
import kh.roponpov.fullandroidappdevelopment.features.login.views.sections.WelcomeSection

@Composable
fun LoginView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.secondary
            )
    ) {
        //////////////////////////////
        //// LOGIN HEADER SECTION ////
        //////////////////////////////
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary
                )
                .padding(32.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.Bottom
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(R.drawable.ic_android_icon),
                        tint = MaterialTheme.colorScheme.onPrimary,
                        contentDescription = "Android Icon"
                    )
                    Text(
                        "ANDROID MASTERS",
                        style = MaterialTheme.typography.labelLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Normal,
                        )
                    )

                }

                Text(
                    "Full Android App\nDevelopment",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                    )
                )

                Text(
                    "Master the art of mobile engineering.",
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Normal,
                    )
                )

            }
        }

        /////////////////////////
        //// WELCOME SECTION ////
        /////////////////////////
        WelcomeSection()

        ////////////////////////////
        //// FORM LOGIN SECTION ////
        ////////////////////////////
        FormLoginSection(navController)

        //////////////////////////////
        //// OR JOIN WITH SECTION ////
        //////////////////////////////
        AppOrDivider(
            text = "OR JOIN WITH",
            paddingValues = PaddingValues(
                32.dp
            )
        )

        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            ),
            elevation = null,
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onPrimary.copy(
                    alpha = 0.5f
                )
            ),
            shape = RoundedCornerShape(12.dp),
            onClick = {}
        ) {
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(18.dp),
                    painter = painterResource(R.drawable.ic_google_logo),
                    contentDescription = "Google Icon"
                )
                Text(
                    "Continue with Google",
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
        }



    }
}

@Composable
@Preview
fun PreviewLoginView(){
    LoginView(rememberNavController())
}