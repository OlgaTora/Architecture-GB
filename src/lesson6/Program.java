package lesson6;

import lesson6.application.ConcreteNoteEditor;
import lesson6.application.interfaces.NoteEditor;
import lesson6.application.interfaces.NotesDatabaseContext;
import lesson6.database.NotesDatabase;
import lesson6.infrastructure.persistance.Database;
import lesson6.infrastructure.persistance.DatabaseContext;
import lesson6.presentation.queries.controllers.NotesController;
import lesson6.presentation.queries.views.NotesConsolePresenter;

public class Program {

    /**
     * CQRS
     *
     * @param args
     */
    public static void main(String[] args) {
        Database database = new NotesDatabase();
        NotesDatabaseContext context = new DatabaseContext(database);
        NotesConsolePresenter notesConsolePresenter = new NotesConsolePresenter();
        NoteEditor noteEditor = new ConcreteNoteEditor(notesConsolePresenter, context);

        NotesController notesController = new NotesController(noteEditor);

        notesController.routeGetAll();
        notesController.routeAdd("title #111", "details #111");
        notesController.routeGetAll();
        notesController.routeRemove(10004);
        notesController.routeGetAll();
        notesController.routeEdit(10003, "title #222", "details #222");
        notesController.routeGetAll();
    }
}
