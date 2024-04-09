package com.patch4code.loglinemovieapp.features.settings.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.patch4code.loglinemovieapp.features.navigation.domain.model.Screen
import com.patch4code.loglinemovieapp.ui.theme.Beige

@Composable
fun EditProfileButton(navController: NavController){

    HorizontalDivider()
    TextButton(onClick = { navController.navigate(Screen.ProfileEditScreen.route) },
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape
    ) {
        Column (modifier = Modifier.padding(8.dp)){
            Row {
                Text(text = "Edit Profile", style = MaterialTheme.typography.titleMedium)
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null, modifier = Modifier.size(20.dp))
            }
            Text(text = "Customize your local Profile page. Set profile and banner images, update displayed name and bio, and select your top 4 favorite movies.",
                style = MaterialTheme.typography.bodyMedium,
                color = Beige
            )
        }
    }

}