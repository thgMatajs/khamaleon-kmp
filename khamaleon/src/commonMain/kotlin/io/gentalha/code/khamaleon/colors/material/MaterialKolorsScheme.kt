package io.gentalha.code.khamaleon.colors.material

import io.gentalha.code.khamaleon.colors.dynamiccolor.DynamicColor
import io.gentalha.code.khamaleon.colors.dynamiccolor.MaterialDynamicColors
import io.gentalha.code.khamaleon.colors.scheme.DynamicScheme

/**
 * A class that provides various color functions based on the given dynamic scheme.
 *
 * @property scheme The dynamic scheme used to generate colors.
 * @property isAmoled A flag indicating whether the device is AMOLED.
 * @param isExtendedFidelity A flag indicating whether extended fidelity is enabled.
 */
class MaterialKolorsScheme(
    private val scheme: DynamicScheme,
    private val isAmoled: Boolean = false,
    isExtendedFidelity: Boolean = false,
) {

    private val colors = MaterialDynamicColors(isExtendedFidelity, scheme)

    /**
     * Returns the highest surface color based on the given scheme.
     *
     * @see MaterialDynamicColors.highestSurface
     */
    fun highestSurface(): DynamicColor =
        colors.highestSurface(scheme)

    /**
     * Returns the primary palette key color.
     *
     * @see MaterialDynamicColors.primaryPaletteKeyColor
     */
    fun primaryPaletteKeyColor(): DynamicColor = colors.primaryPaletteKeyColor()

    /**
     * Returns the secondary palette key color.
     *
     * @see MaterialDynamicColors.secondaryPaletteKeyColor
     */
    fun secondaryPaletteKeyColor(): DynamicColor =
        colors.secondaryPaletteKeyColor()

    /**
     * Returns the tertiary palette key color.
     *
     * @see MaterialDynamicColors.tertiaryPaletteKeyColor
     */
    fun tertiaryPaletteKeyColor(): DynamicColor = colors.tertiaryPaletteKeyColor()

    /**
     * Returns the error palette key color.
     *
     * @see MaterialDynamicColors.errorPaletteKeyColor
     */
    fun errorPaletteKeyColor(): DynamicColor = colors.errorPaletteKeyColor()

    /**
     * Returns the neutral palette key color.
     *
     * @see MaterialDynamicColors.neutralPaletteKeyColor
     */
    fun neutralPaletteKeyColor(): DynamicColor = colors.neutralPaletteKeyColor()

    /**
     * Returns the neutral variant palette key color.
     *
     * @see MaterialDynamicColors.neutralVariantPaletteKeyColor
     */
    fun neutralVariantPaletteKeyColor(): DynamicColor =
        colors.neutralVariantPaletteKeyColor()

    /**
     * Returns the background color.
     *
     * @see MaterialDynamicColors.background
     */
    fun background(): DynamicColor =
        if (isAmoled && scheme.isDark) colors.inversePrimary()
        else colors.background()

    /**
     * Returns the on-background color.
     *
     * @see MaterialDynamicColors.onBackground
     */
    fun onBackground(): DynamicColor =
        if (isAmoled && scheme.isDark) colors.primary()
        else colors.onBackground()

    /**
     * Returns the surface color.
     *
     * @see MaterialDynamicColors.surface
     */
    fun surface(): DynamicColor =
        if (isAmoled && scheme.isDark) colors.inverseSurface()
        else colors.surface()

    /**
     * Returns the surface dim color.
     *
     * @see MaterialDynamicColors.surfaceDim
     */
    fun surfaceDim(): DynamicColor = colors.surfaceDim()

    /**
     * Returns the surface bright color.
     *
     * @see MaterialDynamicColors.surfaceBright
     */
    fun surfaceBright(): DynamicColor = colors.surfaceBright()

    /**
     * Returns the surface container lowest color.
     *
     * @see MaterialDynamicColors.surfaceContainerLowest
     */
    fun surfaceContainerLowest(): DynamicColor = colors.surfaceContainerLowest()

    /**
     * Returns the surface container low color.
     *
     * @see MaterialDynamicColors.surfaceContainerLow
     */
    fun surfaceContainerLow(): DynamicColor = colors.surfaceContainerLow()

    /**
     * Returns the surface container color.
     *
     * @see MaterialDynamicColors.surfaceContainer
     */
    fun surfaceContainer(): DynamicColor = colors.surfaceContainer()

    /**
     * Returns the surface container high color.
     *
     * @see MaterialDynamicColors.surfaceContainerHigh
     */
    fun surfaceContainerHigh(): DynamicColor = colors.surfaceContainerHigh()

    /**
     * Returns the surface container highest color.
     *
     * @see MaterialDynamicColors.surfaceContainerHighest
     */
    fun surfaceContainerHighest(): DynamicColor = colors.surfaceContainerHighest()

    /**
     * Returns the on-surface color.
     *
     * @see MaterialDynamicColors.onSurface
     */
    fun onSurface(): DynamicColor =
        if (isAmoled && scheme.isDark) colors.surfaceVariant()
        else colors.onSurface()

    /**
     * Returns the surface variant color.
     *
     * @see MaterialDynamicColors.surfaceVariant
     */
    fun surfaceVariant(): DynamicColor = colors.surfaceVariant()

    /**
     * Returns the on-surface variant color.
     *
     * @see MaterialDynamicColors.onSurfaceVariant
     */
    fun onSurfaceVariant(): DynamicColor = colors.onSurfaceVariant()

    /**
     * Returns the inverse surface color.
     *
     * @see MaterialDynamicColors.inverseSurface
     */
    fun inverseSurface(): DynamicColor = colors.inverseSurface()

    /**
     * Returns the inverse on-surface color.
     *
     * @see MaterialDynamicColors.inverseOnSurface
     */
    fun inverseOnSurface(): DynamicColor = colors.inverseOnSurface()

    /**
     * Returns the outline color.
     *
     * @see MaterialDynamicColors.outline
     */
    fun outline(): DynamicColor = colors.outline()

    /**
     * Returns the outline variant color.
     *
     * @see MaterialDynamicColors.outlineVariant
     */
    fun outlineVariant(): DynamicColor = colors.outlineVariant()

    /**
     * Returns the shadow color.
     *
     * @see MaterialDynamicColors.shadow
     */
    fun shadow(): DynamicColor = colors.shadow()

    /**
     * Returns the scrim color.
     *
     * @see MaterialDynamicColors.scrim
     */
    fun scrim(): DynamicColor = colors.scrim()

    /**
     * Returns the surface tint color.
     *
     * @see MaterialDynamicColors.surfaceTint
     */
    fun surfaceTint(): DynamicColor = colors.surfaceTint()

    /**
     * Returns the primary color.
     *
     * @see MaterialDynamicColors.primary
     */
    fun primary(): DynamicColor = colors.primary()

    /**
     * Returns the on-primary color.
     *
     * @see MaterialDynamicColors.onPrimary
     */
    fun onPrimary(): DynamicColor = colors.onPrimary()

    /**
     * Returns the primary container color.
     *
     * @see MaterialDynamicColors.primaryContainer
     */
    fun primaryContainer(): DynamicColor = colors.primaryContainer()

    /**
     * Returns the on-primary container color.
     *
     * @see MaterialDynamicColors.onPrimaryContainer
     */
    fun onPrimaryContainer(): DynamicColor = colors.onPrimaryContainer()

    /**
     * Returns the inverse primary color.
     *
     * @see MaterialDynamicColors.inversePrimary
     */
    fun inversePrimary(): DynamicColor = colors.inversePrimary()

    /**
     * Returns the secondary color.
     *
     * @see MaterialDynamicColors.secondary
     */
    fun secondary(): DynamicColor = colors.secondary()

    /**
     * Returns the on-secondary color.
     *
     * @see MaterialDynamicColors.onSecondary
     */
    fun onSecondary(): DynamicColor = colors.onSecondary()

    /**
     * Returns the secondary container color.
     *
     * @see MaterialDynamicColors.secondaryContainer
     */
    fun secondaryContainer(): DynamicColor = colors.secondaryContainer()

    /**
     * Returns the on-secondary container color.
     *
     * @see MaterialDynamicColors.onSecondaryContainer
     */
    fun onSecondaryContainer(): DynamicColor = colors.onSecondaryContainer()

    /**
     * Returns the tertiary color.
     *
     * @see MaterialDynamicColors.tertiary
     */
    fun tertiary(): DynamicColor = colors.tertiary()

    /**
     * Returns the on-tertiary color.
     *
     * @see MaterialDynamicColors.onTertiary
     */
    fun onTertiary(): DynamicColor = colors.onTertiary()

    /**
     * Returns the tertiary container color.
     *
     * @see MaterialDynamicColors.tertiaryContainer
     */
    fun tertiaryContainer(): DynamicColor = colors.tertiaryContainer()

    /**
     * Returns the on-tertiary container color.
     *
     * @see MaterialDynamicColors.onTertiaryContainer
     */
    fun onTertiaryContainer(): DynamicColor = colors.onTertiaryContainer()

    /**
     * Returns the error color.
     *
     * @see MaterialDynamicColors.error
     */
    fun error(): DynamicColor = colors.error()

    /**
     * Returns the on-error color.
     *
     * @see MaterialDynamicColors.onError
     */
    fun onError(): DynamicColor = colors.onError()

    /**
     * Returns the error container color.
     *
     * @see MaterialDynamicColors.errorContainer
     */
    fun errorContainer(): DynamicColor = colors.errorContainer()

    /**
     * Returns the on-error container color.
     *
     * @see MaterialDynamicColors.onErrorContainer
     */
    fun onErrorContainer(): DynamicColor = colors.onErrorContainer()

    /**
     * Returns the primary fixed color.
     *
     * @see MaterialDynamicColors.primaryFixed
     */
    fun primaryFixed(): DynamicColor = colors.primaryFixed()

    /**
     * Returns the primary fixed dim color.
     *
     * @see MaterialDynamicColors.primaryFixedDim
     */
    fun primaryFixedDim(): DynamicColor = colors.primaryFixedDim()

    /**
     * Returns the on-primary fixed color.
     *
     * @see MaterialDynamicColors.onPrimaryFixed
     */
    fun onPrimaryFixed(): DynamicColor = colors.onPrimaryFixed()

    /**
     * Returns the on-primary fixed variant color.
     *
     * @see MaterialDynamicColors.onPrimaryFixedVariant
     */
    fun onPrimaryFixedVariant(): DynamicColor = colors.onPrimaryFixedVariant()

    /**
     * Returns the secondary fixed color.
     *
     * @see MaterialDynamicColors.secondaryFixed
     */
    fun secondaryFixed(): DynamicColor = colors.secondaryFixed()

    /**
     * Returns the secondary fixed dim color.
     *
     * @see MaterialDynamicColors.secondaryFixedDim
     */
    fun secondaryFixedDim(): DynamicColor = colors.secondaryFixedDim()

    /**
     * Returns the on-secondary fixed color.
     *
     * @see MaterialDynamicColors.onSecondaryFixed
     */
    fun onSecondaryFixed(): DynamicColor = colors.onSecondaryFixed()

    /**
     * Returns the on-secondary fixed variant color.
     *
     * @see MaterialDynamicColors.onSecondaryFixedVariant
     */
    fun onSecondaryFixedVariant(): DynamicColor = colors.onSecondaryFixedVariant()

    /**
     * Returns the tertiary fixed color.
     *
     * @see MaterialDynamicColors.tertiaryFixed
     */
    fun tertiaryFixed(): DynamicColor = colors.tertiaryFixed()

    /**
     * Returns the tertiary fixed dim color.
     *
     * @see MaterialDynamicColors.tertiaryFixedDim
     */
    fun tertiaryFixedDim(): DynamicColor = colors.tertiaryFixedDim()

    /**
     * Returns the on-tertiary fixed color.
     *
     * @see MaterialDynamicColors.onTertiaryFixed
     */
    fun onTertiaryFixed(): DynamicColor = colors.onTertiaryFixed()

    /**
     * Returns the on-tertiary fixed variant color.
     *
     * @see MaterialDynamicColors.onTertiaryFixedVariant
     */
    fun onTertiaryFixedVariant(): DynamicColor = colors.onTertiaryFixedVariant()

    /**
     * Returns the control activated color.
     *
     * @see MaterialDynamicColors.controlActivated
     */
    fun controlActivated(): DynamicColor = colors.controlActivated()

    /**
     * Returns the control normal color.
     *
     * @see MaterialDynamicColors.controlNormal
     */
    fun controlNormal(): DynamicColor = colors.controlNormal()

    /**
     * Returns the control highlight color.
     *
     * @see MaterialDynamicColors.controlHighlight
     */
    fun controlHighlight(): DynamicColor = colors.controlHighlight()

    /**
     * Returns the text primary inverse color.
     *
     * @see MaterialDynamicColors.textPrimaryInverse
     */
    fun textPrimaryInverse(): DynamicColor = colors.textPrimaryInverse()

    /**
     * Returns the text secondary and tertiary inverse color.
     *
     * @see MaterialDynamicColors.textSecondaryAndTertiaryInverse
     */
    fun textSecondaryAndTertiaryInverse(): DynamicColor =
        colors.textSecondaryAndTertiaryInverse()

    /**
     * Returns the text primary inverse disable only color.
     *
     * @see MaterialDynamicColors.textPrimaryInverseDisableOnly
     */
    fun textPrimaryInverseDisableOnly(): DynamicColor =
        colors.textPrimaryInverseDisableOnly()

    /**
     * Returns the text secondary and tertiary inverse disabled color.
     *
     * @see MaterialDynamicColors.textSecondaryAndTertiaryInverseDisabled
     */
    fun textSecondaryAndTertiaryInverseDisabled(): DynamicColor =
        colors.textSecondaryAndTertiaryInverseDisabled()

    /**
     * Returns the text hint inverse color.
     *
     * @see MaterialDynamicColors.textHintInverse
     */
    fun textHintInverse(): DynamicColor = colors.textHintInverse()
}