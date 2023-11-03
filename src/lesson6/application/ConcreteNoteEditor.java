package lesson6.application;

import lesson6.application.interfaces.NoteEditor;
import lesson6.application.interfaces.NotesDatabaseContext;
import lesson6.application.interfaces.NotesPresenter;
import lesson6.domain.Note;

import java.util.Collection;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter presenter;

    public ConcreteNoteEditor(
            NotesPresenter presenter,
            NotesDatabaseContext dbContext) {
        this.dbContext = dbContext;
        this.presenter = presenter;
    }

    @Override
    public boolean add(Note item) {
        return dbContext.addNote(item);
    }

    @Override
    public boolean edit(Note item) {
        return dbContext.editNote(item);
    }

    @Override
    public boolean remove(Note item) {
        return dbContext.removeNote(item);
    }

    @Override
    public Optional<Note> getById(Integer idNote) {
        for (Note note : dbContext.getAll()) {
            if (idNote == note.getId()) {
                return Optional.of(note);
            }
        }return Optional.empty();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        presenter.printAll(getAll());
    }

}
