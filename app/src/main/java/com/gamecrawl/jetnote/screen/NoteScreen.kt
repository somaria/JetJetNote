package com.gamecrawl.jetnote.ui.theme

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gamecrawl.jetnote.R
import com.gamecrawl.jetnote.components.NoteButton
import com.gamecrawl.jetnote.components.NoteInputText
import com.gamecrawl.jetnote.model.Note
import java.time.format.DateTimeFormatter

@Composable
fun NoteScreen(notes: List<Note>, onAddNote: (Note) -> Unit, onRemoveNote: (Note) -> Unit) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(6.dp),
    ) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = null
                )
            },
            backgroundColor = Color(0xFFF5F5F5),
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                text = title,
                label = "Title",
                onTextChange = {
                    if (it.all { it.isLetter() || it.isWhitespace() })
                        title = it
                },
                modifier = Modifier.padding(6.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            NoteInputText(
                text = description,
                label = "Add A Note",
                onTextChange = {
                    if (it.all { it.isLetter() || it.isWhitespace() })
                        description = it
                },
                modifier = Modifier.padding(6.dp)
            )
            NoteButton(
                text = "Save",
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        Log.d("NoteScreen", "Saving note")
                        onAddNote(Note(title = title, description = description))
                        title = ""
                        description = ""
                        Toast.makeText(context, "Note saved", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.d("NoteScreen", "Not saving note")
                    }
                }, modifier = Modifier.padding(6.dp)
            )
        }

        Divider()
        LazyColumn(
            modifier = Modifier.padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(notes) { note ->
                NoteRow(note = note, onNoteClick = {
                    Log.d("NoteScreen", "Clicked note ${note}")
                    onRemoveNote(note)
                })
            }
        }

    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClick: (Note) -> Unit,
) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(1f),
        color = Color(0xFFF5F5F5),
        elevation = 5.dp,
    ) {
        Column(modifier = Modifier
            .clickable { onNoteClick(note) }
            .padding(horizontal = 14.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.Start) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
            Text(text = note.description, style = MaterialTheme.typography.subtitle1)
            Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), style = MaterialTheme.typography.subtitle2)
        }
    }

}