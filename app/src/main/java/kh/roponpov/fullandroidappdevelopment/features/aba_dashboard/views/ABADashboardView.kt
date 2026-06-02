package kh.roponpov.fullandroidappdevelopment.features.aba_dashboard.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import kh.roponpov.fullandroidappdevelopment.R
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigator
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigatorImpl
import kh.roponpov.fullandroidappdevelopment.core.ui.theme.FullAndroidAppDevelopmentTheme
import kh.roponpov.fullandroidappdevelopment.features.aba_dashboard.models.ShortcutFunctionModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ABADashboardView(
    navigator: AppNavigator,
) {
    val listState = rememberLazyListState()

    val collapseRange = 120f

    val collapseProgress by remember {
        derivedStateOf {
            val offset = listState.firstVisibleItemScrollOffset.toFloat()
            val index = listState.firstVisibleItemIndex

            val raw = if (index > 0) collapseRange else offset
            (raw / collapseRange).coerceIn(0f, 1f)
        }
    }

    val headerHeight = lerp(56.dp, 35.dp, collapseProgress)
    val textAlpha = 1f - collapseProgress
    val iconScale = lerp(1f, 0.7f, collapseProgress)

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

    val rowFunctions = listOf(
        ShortcutFunctionModel(
            label = "Payments",
            icon = R.drawable.ic_payments
        ),
        ShortcutFunctionModel(
            label = "Mini Apps",
            icon = R.drawable.ic_min_apps
        ),
        ShortcutFunctionModel(
            label = "Gift Zone",
            icon = R.drawable.ic_gift_zone
        ),
        ShortcutFunctionModel(
            label = "Transfers",
            icon = R.drawable.ic_transfers
        ),
    )



    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFFE9E9E9)
                    )
                    .padding(
                        vertical = 16.dp,
                        horizontal = 16.dp
                    )
                    .fillMaxWidth()
                    .height(headerHeight)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {

                    // Profile section
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(lerp(56.dp, 35.dp, collapseProgress))
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .border(
                                        width = 2.dp,
                                        shape = CircleShape,
                                        color = MaterialTheme.colorScheme.error
                                    ),
                                model = stringResource(R.string.profile_url),
                                contentDescription = null
                            )
                        }

                        Column(
                            modifier = Modifier.graphicsLayer {
                                alpha = textAlpha
                                scaleY = iconScale
                            }
                        ) {
                            Text(
                                "Good afternoon!",
                                fontSize = lerp(16.sp, 10.sp, collapseProgress)
                            )
                            Text(
                                "Ropon Pov",
                                fontWeight = FontWeight.Bold,
                                fontSize = lerp(18.sp, 12.sp, collapseProgress)
                            )
                        }
                    }

                    // right icons
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(R.drawable.ic_messenger),
                            contentDescription = "Messenger Icon"
                        )
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(R.drawable.ic_notification),
                            contentDescription = "Notification Icon"
                        )
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(R.drawable.ic_kh_qr),
                            contentDescription = "KHQR Icon"
                        )
                    }
                }
            }
        }
    ) { paddingValue ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize()
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp
                    )
                )
        ) {
            // TOP APP BAR
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFE9E9E9),
                            shape = RoundedCornerShape(
                                bottomStart = 24.dp,
                                bottomEnd = 24.dp,
                            )
                        )
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .clip(
                            shape = RoundedCornerShape(
                                topStart = 24.dp, topEnd = 24.dp
                            )
                        )
                ) {

                    // Balance Card
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colorScheme.error,
                                shape = RoundedCornerShape(24.dp),
                            )
                            .padding(16.dp)
                    ) {
                        Column {
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
                                ) {}

                                Box(
                                    modifier = Modifier
                                        .height(30.dp)
                                        .width(30.dp)
                                        .background(
                                            color = MaterialTheme.colorScheme.onPrimary,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(5.dp)
                                ) {
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
                                ) {
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


                    shortcutFunctions.chunked(2).forEach { rowItems ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            rowItems.forEach { item ->
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .background(
                                            color = MaterialTheme.colorScheme.onPrimary,
                                            shape = RoundedCornerShape(16.dp)
                                        )
                                        .padding(
                                            vertical = 8.dp,
                                            horizontal = 16.dp
                                        )
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Image(
                                            modifier = Modifier.size(35.dp),
                                            painter = painterResource(item.icon),
                                            contentDescription = item.label
                                        )

                                        Text(
                                            text = item.label,
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }

                            // Fill the second column if odd number of items
                            if (rowItems.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    LazyRow(
                        modifier = Modifier
                            .clip(
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(rowFunctions.count()) {
                            val rowFunction = rowFunctions[it]

                            Box(
                                modifier = Modifier
                                    .background(
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .padding(
                                        vertical = 12.dp,
                                        horizontal = 20.dp,
                                    )
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(
                                        alignment = Alignment.CenterHorizontally,
                                        space = 10.dp
                                    )
                                ) {
                                    Image(
                                        modifier = Modifier.size(25.dp),
                                        painter = painterResource(rowFunction.icon),
                                        contentDescription = rowFunction.label
                                    )
                                    Text(
                                        text = rowFunction.label,
                                        style = MaterialTheme.typography.labelMedium
                                    )
                                }
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        HorizontalDivider(
                            modifier = Modifier
                                .width(80.dp)
                                .clip(
                                    shape = MaterialTheme.shapes.large
                                ),
                            thickness = 5.dp
                        )
                    }
                }
            }


            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "News & Promotions",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(24.dp)
                            )
                    ) {

                    }
                }
            }
            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "News & Promotions",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(24.dp)
                            )
                    ) {

                    }
                }
            }
            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "News & Promotions",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(24.dp)
                            )
                    ) {

                    }
                }
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