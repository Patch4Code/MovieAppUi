package com.patch4code.loglinemovieapp.features.settings.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.patch4code.loglinemovieapp.features.settings.presentation.screen_settings.SettingsViewModel

@Composable
fun CountryPickerDialog(openCountryPickerDialog: MutableState<Boolean>, selectedCountryCode: String?, settingsViewModel: SettingsViewModel){

    if (!openCountryPickerDialog.value) return

    val context = LocalContext.current

    Dialog(onDismissRequest = { openCountryPickerDialog.value = false }) {
        Surface(modifier = Modifier.width(300.dp),
            shape = RoundedCornerShape(10.dp)
        ) {

            Column(modifier = Modifier.padding(10.dp)) {

                Text(text = "Select Country")

                Spacer(modifier = Modifier.padding(10.dp))

                LazyColumn(modifier = Modifier.height(400.dp)){
                    item{
                        settingsViewModel.getCountriesList().forEach {country->
                            Row (verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = country.countryCode == selectedCountryCode,
                                    onClick = {
                                        settingsViewModel.setCountry(country.countryCode)
                                        openCountryPickerDialog.value = false
                                        Toast.makeText(context, "Country Changed", Toast.LENGTH_SHORT).show()
                                    }
                                )
                                Text(text = "${country.flagCode} ${country.countryName}")
                            }
                        }

                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}