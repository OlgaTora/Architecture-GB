package lesson6.presentation.queries.controllers;

import lesson6.application.interfaces.NoteEditor;
import lesson6.domain.Note;
import lesson6.presentation.queries.controllers.Controller;

import java.util.Optional;

public class NotesController extends Controller {

    private final NoteEditor noteEditor;

    public NotesController(NoteEditor noteEditor) {
        this.noteEditor = noteEditor;
    }

    //TODO: \notes\all
    public void routeGetAll() {
        System.out.println("Список заметок:");
        noteEditor.printAll();
    }

    public void routeAdd(String title, String details) {
        Note note = new Note(title, details);
        noteEditor.add(note);
        System.out.printf("Добавлена новая заметка %s:\n", title);
    }

    public void routeRemove(int idNote) {
        Optional<Note> optNote = noteEditor.getById(idNote);
        if (optNote.isPresent()) {
            Note note = optNote.get();
            String title = note.getTitle();
            noteEditor.remove(note);
            System.out.printf("Удалена заметка %s\n", title);
        } else {
            System.out.println("Нет такой заметки");
        }
    }
    public void routeEdit(int idNote, String title, String details) {
        Optional<Note> optNote = noteEditor.getById(idNote);
        if (optNote.isPresent()) {
            Note note = optNote.get();
            note.setTitle(title);
            note.setDetails(details);
            noteEditor.edit(note);
            System.out.printf("Изменена заметка №%d\n", idNote);
        } else {
            System.out.println("Нет такой заметки");
        }
    }
}
