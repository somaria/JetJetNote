package com.gamecrawl.jetnote.data

import com.gamecrawl.jetnote.model.Note

class NotesDataSource {
    companion object {
        fun getNotes(): Any {

            return listOf(
                Note(title = "A good day", description = "We went on a vacation by the lake"),
                Note(title = "Android Compose", description = "Working on Android Compose course today"),
                Note(title = "Keep at it...", description = "Sometimes things just happen"),
                Note(title = "A movie day", description = "Watching a movie with family today"),
                Note(title = "A movie day", description = "Watching a movie with family today"),
                Note(title = "A movie day", description = "Watching a movie with family today"),
                Note(title = "A movie day", description = "Watching a movie with family today"),
                Note(title = "A movie day", description = "Watching a movie with family today"),
                Note(title = "A movie day", description = "Watching a movie with family today"),
                Note(title = "A movie day", description = "Watching a movie with family")
            )

        }

        val notes = mutableListOf<Note>()
    }

    fun getNotes(): List<Note> {
        return listOf(
            Note(title = "A good day", description = "We went on a vacation by the lake"),
            Note(title = "Android Compose", description = "Working on Android Compose course today"),
            Note(title = "Keep at it...", description = "Sometimes things just happen"),
            Note(title = "A movie day", description = "Watching a movie with family today"),
            Note(title = "A movie day", description = "Watching a movie with family today"),
            Note(title = "A movie day", description = "Watching a movie with family today"),
            Note(title = "A movie day", description = "Watching a movie with family today"),
            Note(title = "A movie day", description = "Watching a movie with family today"),
            Note(title = "A movie day", description = "Watching a movie with family today"),
            Note(title = "A movie day", description = "Watching a movie with family")
        )

    }
}