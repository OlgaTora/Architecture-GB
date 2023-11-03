package lesson6.application.interfaces;

import lesson6.domain.Note;

public interface NoteEditor extends Editor<Note, Integer>{

    void printAll();
}
