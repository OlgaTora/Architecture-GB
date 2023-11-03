package lesson6.database;

import lesson6.domain.Note;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class NotesTable {

    private static Random random = new Random();

    private Collection<NotesRecord> records;

    public Collection<NotesRecord> getRecords() {
        prepareRecords();
        return records;
    }

    private void prepareRecords() {
        if (records == null) {
            records = new ArrayList<>();
            int recordCount = random.nextInt(5, 11);
            for (int i = 0; i < recordCount; i++) {
                records.add(new NotesRecord("title #" + (i + 1), "details #" + (i + 1)));
            }
        }
    }

    public boolean addRecord(Note note) {
        return records.add(new NotesRecord(note.getTitle(), note.getDetails()));
    }

    public boolean removeRecord(Note note) {
        for (NotesRecord notesRecord : this.records) {
            if (notesRecord.getId() == note.getId()) {
                return records.remove(notesRecord);
            }
        }
        return false;
    }

    public boolean editRecord(Note note) {
        for (NotesRecord notesRecord : this.records) {
            if (notesRecord.getId() == note.getId()) {
                notesRecord.setTitle(note.getTitle());
                notesRecord.setDetails(note.getDetails());
                return true;
            }
        }
        return false;
    }
}