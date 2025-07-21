package com.example.contactsandroomdatabase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        title = { Text(text = "Add contact") },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = state.firstName,
                    onValueChange = {
                        onEvent(ContactEvent.SetFirstName(it))
                    },
                    placeholder = { Text("First name") }
                )
                TextField(
                    value = state.lastName,
                    onValueChange = {
                        onEvent(ContactEvent.SetLastName(it))
                    },
                    placeholder = { Text("Last name") }
                )
                TextField(
                    value = state.phoneNumber,
                    onValueChange = {
                        onEvent(ContactEvent.SetPhoneNumber(it))
                    },
                    placeholder = { Text("Phone number") }
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onEvent(ContactEvent.SaveContact)
            }) {
                Text("Save")
            }
        },
        onDismissRequest = {
            onEvent(ContactEvent.HideDialog)
        }
    )
}