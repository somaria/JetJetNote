package com.gamecrawl.jetnote.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.gamecrawl.jetnote.data.NotesDataSource
import com.gamecrawl.jetnote.model.Note

class NoteViewModel: ViewModel() {

    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSource().getNotes())
    }

    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note> {
        return noteList
    }

}