package kh.roponpov.fullandroidappdevelopment.features.aba_dashboard.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import kh.roponpov.fullandroidappdevelopment.R
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigator
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigatorImpl
import kh.roponpov.fullandroidappdevelopment.core.ui.theme.FullAndroidAppDevelopmentTheme
import kh.roponpov.fullandroidappdevelopment.features.aba_dashboard.models.ShortcutFunctionModel

@Composable
fun ABADashboardView(
    navigator: AppNavigator,
) {
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // TOP APP BAR
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    alignment = Alignment.End,
                    space = 5.dp,
                )
            ) {
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(R.drawable.ic_notification),
                    contentDescription = "Notification Icon"
                )
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            color = MaterialTheme.colorScheme.error,
                            shape = MaterialTheme.shapes.small
                        )
                        .padding(5.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_qr_code),
                        tint = MaterialTheme.colorScheme.onPrimary,
                        contentDescription = "QR Code Icon"
                    )
                }

            }

            // Profile
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = CircleShape,
                        )
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = MaterialTheme.colorScheme.error
                            ),
                        model = stringResource(R.string.profile_url),
                        contentDescription = "Android Icon"
                    )
                }

                Column() {
                    Text(
                        text = "Good afternoon!",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "Justin Rock",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Balance Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(24.dp),
                    )
                    .padding(16.dp)
            ) {
                Column() {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .height(30.dp)
                                .width(120.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ){}

                        Box(
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(5.dp)
                        ){
                            Image(
                                modifier = Modifier.fillMaxSize(),
                                painter = painterResource(R.drawable.ic_visibility),
                                contentDescription = "Visibility Icon"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            alignment = Alignment.CenterHorizontally,
                            space = 5.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .padding(
                                    horizontal = 8.dp,
                                    vertical = 2.dp
                                )
                        ){
                            Text(
                                text = "Default",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }

                        Text(
                            text = "USD",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                            ) {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(R.drawable.ic_received),
                                    contentDescription = "Received Icon"
                                )
                            }

                            Text(
                                text = "Receive",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }

                        // ===================== //
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        shape = CircleShape
                                    )
                                    .padding(5.dp)
                            ) {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(R.drawable.ic_send),
                                    contentDescription = "Send Icon"
                                )
                            }

                            Text(
                                text = "Send",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }

                        VerticalDivider(
                            modifier = Modifier.height(16.dp)
                        )

                        // ===================== //
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .padding(5.dp)
                            ) {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(R.drawable.ic_analytics),
                                    contentDescription = "Analytics Icon"
                                )
                            }

                            Text(
                                text = "Analytics",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }

                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            // Shortcut Functions
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val shortcutFunctions = listOf(
                    ShortcutFunctionModel(
                        label = "Accounts",
                        icon = R.drawable.ic_accounts
                    ),
                    ShortcutFunctionModel(
                        label = "Cards",
                        icon = R.drawable.ic_cards
                    ),
                    ShortcutFunctionModel(
                        label = "ABA Scan",
                        icon = R.drawable.ic_aba_scan
                    ),
                    ShortcutFunctionModel(
                        label = "Favorites",
                        icon = R.drawable.ic_favorites
                    ),
                )

                items(shortcutFunctions.count()) {
                    val shortcutFunction = shortcutFunctions[it]

                    Box(
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colorScheme.error,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .padding(
                                vertical = 8.dp,
                                horizontal = 16.dp,
                            )
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Image(
                                modifier = Modifier.size(35.dp),
                                painter = painterResource(shortcutFunction.icon),
                                contentDescription = "Icon"
                            )
                            Text(
                                text = shortcutFunction.label,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // LIST OF FUNCTION
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Box(

            ){

            }
        }
    }
}

@Preview
@Composable
fun ABADashboardViewPreview() {
    FullAndroidAppDevelopmentTheme {
        val navController = rememberNavController()
        
        ABADashboardView(
            navigator = AppNavigatorImpl(
                navController = navController
            )
        )
    }
}