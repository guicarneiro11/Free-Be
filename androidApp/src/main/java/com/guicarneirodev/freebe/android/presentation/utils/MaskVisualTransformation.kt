package com.guicarneirodev.freebe.android.presentation.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class MaskVisualTransformation(private val mask: String) : VisualTransformation {
    private val specialCharacters = setOf('-', '.', '/', '(', ')', ',', ' ')

    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        var maskIndex = 0
        text.forEach { char ->
            while (maskIndex < mask.length && mask[maskIndex] in specialCharacters) {
                out += mask[maskIndex]
                maskIndex++
            }
            if (maskIndex < mask.length) {
                out += char
                maskIndex++
            }
        }

        return TransformedText(
            AnnotatedString(out),
            object : OffsetMapping {
                override fun originalToTransformed(offset: Int): Int {
                    var transformedOffset = offset
                    var maskPos = 0
                    var realPos = 0
                    while (maskPos < mask.length && realPos < offset) {
                        if (mask[maskPos] in specialCharacters) {
                            transformedOffset++
                        }
                        maskPos++
                        realPos++
                    }
                    return transformedOffset
                }

                override fun transformedToOriginal(offset: Int): Int {
                    var originalOffset = offset
                    var maskPos = 0
                    while (maskPos < offset && maskPos < mask.length) {
                        if (mask[maskPos] in specialCharacters) {
                            originalOffset--
                        }
                        maskPos++
                    }
                    return originalOffset
                }
            }
        )
    }
}