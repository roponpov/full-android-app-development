package kh.roponpov.fullandroidappdevelopment.features.login.views.sections

import android.widget.RadioButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import kh.roponpov.fullandroidappdevelopment.core.ui.components.AppTextField
import kh.roponpov.fullandroidappdevelopment.features.login.views.LoginView

@Composable
fun FormLoginSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        AppTextField(
            label = "",
            value = "",
            placeholder = "Email Address",
            onValueChange = {},
        )

        AppTextField(
            label = "",
            value = "",
            placeholder = "Password",
            onValueChange = {},
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(20.dp),
                colors = CheckboxDefaults.colors(
                    uncheckedColor = MaterialTheme.colorScheme.onPrimary
                ),
                checked = false,
                onCheckedChange = {}
            )
            Text(
                "Remember me",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Forget password?",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }

        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(vertical = 14.dp),
            onClick = {}
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ){
                Text(
                    "Login to Dashboard",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Arrow Forward"
                )
            }
        }


    }
}

@Composable
@Preview
fun PreviewFormLoginSection(){
    LoginView(rememberNavController())
}