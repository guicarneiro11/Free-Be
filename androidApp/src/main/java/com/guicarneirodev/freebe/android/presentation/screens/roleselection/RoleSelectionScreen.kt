package com.guicarneirodev.freebe.android.presentation.screens.roleselection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guicarneirodev.freebe.android.R
import com.guicarneirodev.freebe.android.presentation.components.cards.RoleCard
import com.guicarneirodev.freebe.android.presentation.theme.MyApplicationTheme

@Composable
fun RoleSelectionScreen(
    onDriverSelected: () -> Unit,
    onCompanySelected: () -> Unit,
    onLoginClick : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.primaryContainer
                    )
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bem-vindo ao Free-Be",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Conectando caminhoneiros e empresas",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RoleCard(
                icon = painterResource(id = R.drawable.truck),
                title = "Sou Caminhoneiro",
                description = "Encontre cargas e otimize suas viagens",
                onClick = onDriverSelected
            )

            RoleCard(
                icon = painterResource(id = R.drawable.business),
                title = "Sou \nEmpresa",
                description = "Encontre \nmotoristas qualificados",
                onClick = onCompanySelected
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Ação para tela de login */ }
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Já possui uma conta? ",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
            Text(
                text = "Faça login",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RoleSelectionScreenPreview() {
    MyApplicationTheme {
        RoleSelectionScreen(
            onDriverSelected = { },
            onCompanySelected = { },
            onLoginClick = { }
        )
    }
}