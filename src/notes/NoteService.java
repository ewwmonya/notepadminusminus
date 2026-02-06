package notes;

import java.util.ArrayList;

public class NoteService {
    // # This is where the Notes are.
    // Notes are an object that is made from the notes file
    // this is basically the folder that is a notebook.
    // This can organize by subject or what we will call `Category`

    //* Since the Notebook is made of
    // `types` NOTES, we make an
    // array of NOTES. So in the class we make our
    // class make an array of the notes. Also, to make everything lowercase.


    ArrayList<Note> noteBook = new ArrayList<>();
    int nextId = 1;

    private Note findNoteById(int noteId){
        Note foundNote = null;
        for(Note note: noteBook){
            if (note.getNoteId() == noteId){
                foundNote = note;
            }
        }
        return foundNote;
    }

    public void addNote(Note note) {
        note.setNoteId(nextId);
        nextId++;
        noteBook.add(note);

    }
    public void deleteNote(int noteId) {
        Note found = findNoteById(noteId);
        if (found == null) {
            noNotesAreFound();
        }
        else {
            noteBook.remove(found);
            System.out.println("Note " + "[ " + found.getNoteId() + " ] deleted");
        }
    }

    public void listNotes (){
        for (Note note: noteBook) {
            System.out.println(note);
        }
        if (noteBook.isEmpty()){
            noNotesAreFound();
        }
        System.out.println("\n" + "___End Of List___" + "\n" );
    }
    public void listSingleNote(int noteId){
        Note found = findNoteById(noteId);
        if (found == null) {
            noNotesAreFound();
        }
        else {
            System.out.println(found);
        }
    }
    public void listNotesByCategory (String categorySearch) {
        boolean categoryFound = false;
        for (Note note : noteBook) {
            if (note.getCategory().equalsIgnoreCase(categorySearch)) {
                categoryFound = true;
                System.out.println(note);
            }
        }
        if (!categoryFound){
            noNotesAreFound();
        }
    }
    public void noNotesAreFound() {
        System.out.println("No Records Found!");
    }
}
