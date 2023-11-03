package lesson6.infrastructure.persistance;

import lesson6.application.interfaces.NotesDatabaseContext;
import lesson6.database.NotesDatabase;
import lesson6.database.NotesRecord;
import lesson6.domain.Note;
import lesson6.infrastructure.persistance.entityconfiguration.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseContext extends DbContext implements NotesDatabaseContext {

    public Collection<Note> getAll(){
        Collection<Note> notes = new ArrayList<>();
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            notes.add(new Note(
                    record.getId(),
                    record.getTitle(),
                    record.getDetails()
            ));
        }
        return notes;
    }

    @Override
    public boolean addNote(Note note) {
        return ((NotesDatabase) database).getNotesTable().addRecord(note);
    }

    @Override
    public boolean removeNote(Note note) {
        return ((NotesDatabase) database).getNotesTable().removeRecord(note);
    }

    @Override
    public boolean editNote(Note note) {
        return ((NotesDatabase) database).getNotesTable().editRecord(note);
    }


    public DatabaseContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }
}
