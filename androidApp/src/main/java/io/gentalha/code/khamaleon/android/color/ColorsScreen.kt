package io.gentalha.code.khamaleon.android.color

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.gentalha.code.khamaleon.colors.dynamiccolor.DynamicColor
import io.gentalha.code.khamaleon.colors.getColors
import io.gentalha.code.khamaleon.colors.material.MaterialKolorsScheme
import io.gentalha.code.khamaleon.colors.material.PaletteStyle
import io.gentalha.code.khamaleon.colors.material.ktx.isValidHexDecimalColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorScreen() {
    var hexColor by remember { mutableStateOf("#999999") }
    var isDarkMode by remember { mutableStateOf(true) }
    var selectedPaletteStyle by remember { mutableStateOf(PaletteStyle.Fidelity) }
    var isHexColorValid by remember { mutableStateOf(true) }
    var dynamicColor by remember {
        mutableStateOf(
            getColors(
                hexColor,
                isDarkMode,
                selectedPaletteStyle
            )
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Dynamic Colors",
                        color = dynamicColor.onBackground().toColor(),
                        fontSize = 16.sp
                    )
                },
                actions = {
                    IconToggleButton(
                        checked = isDarkMode,
                        onCheckedChange = {
                            isDarkMode = it
                            dynamicColor = getColors(hexColor, isDarkMode, selectedPaletteStyle)
                        }
                    ) {
                        val iconColor = dynamicColor.onBackground().toColor()
                        Icon(
                            imageVector = if (isDarkMode) Icons.Filled.DarkMode else Icons.Filled.LightMode,
                            contentDescription = if (isDarkMode) "Dark Mode" else "Light Mode",
                            tint = iconColor
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = dynamicColor.background().toColor()
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    dynamicColor
                        .background()
                        .toColor()
                )
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HexColorTextField(
                    modifier = Modifier.weight(1f),
                    hexColor = hexColor,
                    onHexColorChange = { hexColor = it },
                    onIsHexColorValid = { isHexColorValid = it },
                    dynamicColorScheme = dynamicColor,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        dynamicColor = getColors(hexColor, isDarkMode, selectedPaletteStyle)
                    },
                    enabled = isHexColorValid,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = dynamicColor.primary().toColor(),
                        disabledContainerColor = dynamicColor.inversePrimary().toColor()
                    )
                ) {
                    DynamicText("Atualizar", dynamicColor.primary())

                    // green: #6aa84f blue: #2986cc purple: #674ea7
                }
            }
            PaletteStyleChips(
                selectedStyle = selectedPaletteStyle,
                onStyleSelected = {
                    selectedPaletteStyle = it
                    dynamicColor = getColors(hexColor, isDarkMode, selectedPaletteStyle)
                },
                dynamicColor = dynamicColor
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        dynamicColor
                            .background()
                            .toColor()
                    )
            ) {
                items(items = dynamicColor.getAllColors()) { colorItem ->
                    ContainerColor(
                        colorName = colorItem.name,
                        colorContainer = colorItem.color
                    )
                }
            }
        }
    }

}

@Composable
fun ContainerColor(
    colorName: String,
    colorContainer: DynamicColor,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorContainer.toColor())
            .padding(horizontal = 8.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        DynamicText(colorName, colorContainer)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PaletteStyleChips(
    selectedStyle: PaletteStyle,
    onStyleSelected: (PaletteStyle) -> Unit,
    dynamicColor: MaterialKolorsScheme
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp)
    ) {
        items(PaletteStyle.entries.toTypedArray()) { style ->
            val colorContainer = if (style == selectedStyle) {
                dynamicColor.primary()
            } else {
                dynamicColor.surface()
            }
            Chip(
                onClick = { onStyleSelected(style) },
                colors = ChipDefaults.chipColors(
                    backgroundColor = colorContainer.toColor()
                )
            ) {
                Text(style.name, color = getTextColor(colorContainer))
            }
        }
    }
}

@Composable
fun HexColorTextField(
    modifier: Modifier,
    hexColor: String,
    onHexColorChange: (String) -> Unit,
    onIsHexColorValid: (Boolean) -> Unit,
    dynamicColorScheme: MaterialKolorsScheme
) {
    var isHexColorValid by remember { mutableStateOf(true) }

    Column(modifier = modifier) {
        TextField(
            value = hexColor,
            onValueChange = {
                isHexColorValid = it.isValidHexDecimalColor()
                onIsHexColorValid(isHexColorValid)
                onHexColorChange(it)
            },
            label = { DynamicText("Hex Color", dynamicColorScheme.background()) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            textStyle = TextStyle(color = dynamicColorScheme.onBackground().toColor()),
            colors = TextFieldDefaults.colors(
                cursorColor = dynamicColorScheme.onBackground().toColor(),
                focusedIndicatorColor = if (isHexColorValid) Color.Unspecified else dynamicColorScheme.error()
                    .toColor(),
                unfocusedIndicatorColor = if (isHexColorValid) Color.Unspecified else dynamicColorScheme.error()
                    .toColor()
            ),
            isError = !isHexColorValid
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (!isHexColorValid) {
            Text("Invalid hex color code", color = dynamicColorScheme.error().toColor())
        }
    }
}

@Composable
fun DynamicText(
    text: String,
    colorContainer: DynamicColor
) {
    Text(
        text = text,
        color = getTextColor(colorContainer)
    )
}

@Composable
private fun getTextColor(colorContainer: DynamicColor) =
    if (colorContainer.toColor().isDark()) Color.White else Color.Black

data class ColorItem(
    val name: String,
    val color: DynamicColor
)

fun MaterialKolorsScheme.getAllColors(): List<ColorItem> {
    return listOf(
        ColorItem(primary().name, primary()),
        ColorItem(onPrimary().name, onPrimary()),
        ColorItem(primaryContainer().name, primaryContainer()),
        ColorItem(onPrimaryContainer().name, onPrimaryContainer()),
        ColorItem(inversePrimary().name, inversePrimary()),
        ColorItem(primaryPaletteKeyColor().name, primaryPaletteKeyColor()),
        ColorItem(secondary().name, secondary()),
        ColorItem(onSecondary().name, onSecondary()),
        ColorItem(secondaryContainer().name, secondaryContainer()),
        ColorItem(onSecondaryContainer().name, onSecondaryContainer()),
        ColorItem(secondaryPaletteKeyColor().name, secondaryPaletteKeyColor()),
        ColorItem(tertiary().name, tertiary()),
        ColorItem(onTertiary().name, onTertiary()),
        ColorItem(tertiaryContainer().name, tertiaryContainer()),
        ColorItem(onTertiaryContainer().name, onTertiaryContainer()),
        ColorItem(tertiaryPaletteKeyColor().name, tertiaryPaletteKeyColor()),
        ColorItem(error().name, error()),
        ColorItem(onError().name, onError()),
        ColorItem(errorContainer().name, errorContainer()),
        ColorItem(onErrorContainer().name, onErrorContainer()),
        ColorItem(errorPaletteKeyColor().name, errorPaletteKeyColor()),
        ColorItem(neutralVariantPaletteKeyColor().name, neutralVariantPaletteKeyColor()),
        ColorItem(background().name, background()),
        ColorItem(onBackground().name, onBackground()),
        ColorItem(surface().name, surface()),
        ColorItem(onSurface().name, onSurface()),
        ColorItem(surfaceVariant().name, surfaceVariant()),
        ColorItem(onSurfaceVariant().name, onSurfaceVariant()),
        ColorItem(surfaceDim().name, surfaceDim()),
        ColorItem(surfaceBright().name, surfaceBright()),
        ColorItem(surfaceContainerLowest().name, surfaceContainerLowest()),
        ColorItem(surfaceContainer().name, surfaceContainer()),
        ColorItem(surfaceContainerHigh().name, surfaceContainerHigh()),
        ColorItem(surfaceContainerHighest().name, surfaceContainerHighest()),
        ColorItem(surfaceTint().name, surfaceTint()),
        ColorItem(highestSurface().name, highestSurface()),
        ColorItem(outline().name, outline()),
        ColorItem(outlineVariant().name, outlineVariant()),
        ColorItem(inverseSurface().name, inverseSurface()),
        ColorItem(inverseOnSurface().name, inverseOnSurface()),
        ColorItem(scrim().name, scrim()),
        ColorItem(primaryFixed().name, primaryFixed()),
        ColorItem(primaryFixedDim().name, primaryFixedDim()),
        ColorItem(onPrimaryFixed().name, onPrimaryFixed()),
        ColorItem(onPrimaryFixedVariant().name, onPrimaryFixedVariant()),
        ColorItem(secondaryFixed().name, secondaryFixed()),
        ColorItem(secondaryFixedDim().name, secondaryFixedDim()),
        ColorItem(onSecondaryFixed().name, onSecondaryFixed()),
        ColorItem(onSecondaryFixedVariant().name, onSecondaryFixedVariant()),
        ColorItem(tertiaryFixed().name, tertiaryFixed()),
        ColorItem(tertiaryFixedDim().name, tertiaryFixedDim()),
        ColorItem(onTertiaryFixed().name, onTertiaryFixed()),
        ColorItem(onTertiaryFixedVariant().name, onTertiaryFixedVariant()),
        ColorItem(controlActivated().name, controlActivated()),
        ColorItem(controlNormal().name, controlNormal()),
        ColorItem(controlHighlight().name, controlHighlight()),
        ColorItem(textPrimaryInverse().name, textPrimaryInverse()),
        ColorItem(textSecondaryAndTertiaryInverse().name, textSecondaryAndTertiaryInverse()),
        ColorItem(textPrimaryInverseDisableOnly().name, textPrimaryInverseDisableOnly()),
        ColorItem(
            textSecondaryAndTertiaryInverseDisabled().name,
            textSecondaryAndTertiaryInverseDisabled()
        ),
        ColorItem(textHintInverse().name, textHintInverse()),
    )
}