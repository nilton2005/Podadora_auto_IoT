package androidlead.weatherappui.ui.screen.components

import androidlead.weatherappui.R
import androidlead.weatherappui.ui.theme.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Definimos la paleta de colores en tonos verdes
val ColorBackground = Color(0xFFE8F5E9)
val ColorSurface = Color(0xFFC8E6C9)
val ColorPrimary = Color(0xFF66BB6A)
val ColorPrimaryVariant = Color(0xFF43A047)
val ColorSecondary = Color(0xFF81C784)
val ColorTextPrimary = Color(0xFF388E3C)
val ColorTextSecondary = Color(0xFF2E7D32)
val ColorAirQualityIconTitle = Color(0xFF1B5E20)
val ColorImageShadow = Color(0xFF1B5E20)
val ColorGradient1 = Color(0xFFA5D6A7)
val ColorGradient2 = Color(0xFF66BB6A)
val ColorGradient3 = Color(0xFF2E7D32)

data class AirQualityItem(val icon: Int, val title: String, val value: String)

@Composable
fun AirQuality(
    modifier: Modifier = Modifier,
    initialData: List<AirQualityItem> = listOf()
) {
    var data by remember { mutableStateOf(initialData) }

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        color = ColorSurface
    ) {
        Column(
            modifier = Modifier.padding(vertical = 18.dp, horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AirQualityHeader { newData ->
                data = data + newData
            }

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                maxItemsInEachRow = 3,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                data.forEach { item ->
                    AirQualityInfo(data = item, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun AirQualityHeader(
    modifier: Modifier = Modifier,
    onAddData: (AirQualityItem) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_air_quality_header),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = ColorAirQualityIconTitle
            )
            Text(
                text = "Air Quality",
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                color = ColorTextPrimary
            )
        }
        RefreshButton { onAddData(AirQualityItem(R.drawable.ic_new_data, "New Data", "Value")) }
    }
}

@Composable
private fun RefreshButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        color = ColorSurface,
        shape = CircleShape,
        modifier = modifier
            .size(32.dp)
            .customShadow(color = Color.Black, alpha = 0.15f, shadowRadius = 16.dp, borderRadius = 32.dp, offsetY = 4.dp)
            .clickable { onClick() }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_refresh),
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                colorFilter = ColorFilter.tint(ColorPrimary)
            )
        }
    }
}

@Composable
private fun AirQualityInfo(
    modifier: Modifier = Modifier,
    data: AirQualityItem
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painterResource(data.icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = ColorAirQualityIconTitle
        )
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.labelSmall,
                color = ColorTextPrimaryVariant
            )
            Text(
                text = data.value,
                style = MaterialTheme.typography.labelSmall,
                color = ColorTextPrimary
            )
        }
    }
}

@Composable
fun ActionBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ControlButton()
        LocationInfo(modifier = Modifier.padding(top = 10.dp), location = "Testeo")
        ProfileButton()
    }
}

@Composable
private fun ControlButton(
    modifier: Modifier = Modifier
) {
    Surface(
        color = ColorSurface,
        shape = CircleShape,
        modifier = modifier
            .size(48.dp)
            .customShadow(color = Color.Black, alpha = 0.15f, shadowRadius = 16.dp, borderRadius = 48.dp, offsetY = 4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_control),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(ColorPrimaryVariant)
            )
        }
    }
}

@Composable
private fun ProfileButton(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .border(width = 1.5.dp, color = ColorSurface, shape = CircleShape)
            .customShadow(color = ColorImageShadow, alpha = 0.7f, shadowRadius = 12.dp, borderRadius = 48.dp, offsetY = 6.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = null,
            modifier = modifier.fillMaxSize().clip(CircleShape)
        )
    }
}

@Composable
private fun LocationInfo(
    modifier: Modifier = Modifier,
    location: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_location_pin),
                contentDescription = null,
                modifier = Modifier.height(18.dp),
                contentScale = ContentScale.FillHeight,
                colorFilter = ColorFilter.tint(ColorPrimaryVariant)
            )
            Text(
                text = location,
                style = MaterialTheme.typography.titleLarge,
                color = ColorTextPrimary,
                fontWeight = FontWeight.Bold
            )
        }
        ProgressBar()
    }
}

@Composable
private fun ProgressBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.25f to ColorGradient2,
                    1f to ColorGradient3
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(vertical = 2.dp, horizontal = 10.dp)
    ) {
        Text(
            text = "Updating •",
            style = MaterialTheme.typography.labelSmall,
            color = ColorTextSecondary.copy(alpha = 0.7f)
        )
    }
}

