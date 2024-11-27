package com.guicarneirodev.freebe.android.presentation.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guicarneirodev.freebe.android.presentation.theme.MyApplicationTheme
import com.guicarneirodev.freebe.android.R

@Composable
fun RoleCard(
    icon: Painter,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoleCardPreview() {
    MyApplicationTheme {
        RoleCard(
            icon = painterResource(id = R.drawable.truck),
            title = "Sou Caminhoneiro",
            description = "Encontre cargas e otimize suas viagens",
            onClick = { }
        )
    }
}
