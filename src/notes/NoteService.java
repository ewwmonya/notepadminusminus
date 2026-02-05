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


    public void addNote(Note note) {
        note.setNoteId(nextId);
        nextId++;
        noteBook.add(note);

    }
    public void deleteNote(int noteId) {
        Note found = null;
        for (Note note: noteBook) {
                if (note.getNoteId() == noteId) {
                    found = note;
                    break;
                }
        }
        if (found == null) {
            noNotesAreFound();
        }
        else {
            noteBook.remove(found);
            System.out.println("Note " + "[ " + found + " ] deleted");
        }
    }

    public void listNotes (){
        if (noteBook.isEmpty()){
            noNotesAreFound();
        }
        else {
        for (Note note: noteBook) {
            System.out.println(note);
        }
        }
    }
    public void listSingleNote(int noteId){
        Note found = null;
        for (Note note: noteBook){
            if (note.getNoteId() == noteId){
                found = note;
                break;
            }
        }
        if (found == null) {
            noNotesAreFound();
        }
        else {
            System.out.println(found);
        }
    }
    public void listNotesByCategory (String categorySearch){
        for(Note note: noteBook){
                if(note.getCategory().equals(categorySearch)) {
                    System.out.println(note);
                }
                else {
                    noNotesAreFound();
                    break;

                }
        }
    }
    public void noNotesAreFound() {
        System.out.println("No Records Found!");
    }
}
