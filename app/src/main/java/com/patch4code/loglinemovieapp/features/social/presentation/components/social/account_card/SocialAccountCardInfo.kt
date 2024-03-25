package com.patch4code.loglinemovieapp.features.social.presentation.components.social.account_card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.patch4code.loglinemovieapp.datastore.StoreUserData

@Composable
fun SocialAccountCardInfo(savedLoginData: StoreUserData){

    Text(text = "Account", style = MaterialTheme.typography.titleMedium)
    Row (verticalAlignment = Alignment.CenterVertically){
        Icon(imageVector = Icons.Default.AccountBox, contentDescription = null, modifier = Modifier.size(50.dp))
        Column (modifier = Modifier.padding(8.dp)){
            Text(text = "${savedLoginData.getUsername.collectAsState(initial = "").value}")
            Text(text = "${savedLoginData.getEmail.collectAsState(initial = "").value}")
        }
    }
    Spacer(modifier = Modifier.padding(8.dp))
}