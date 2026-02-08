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

    public Note addNote(Note note) {
        note.setNoteId(nextId);
        nextId++;
        noteBook.add(note);
        return  note;
    }
    public Note updateNote(int noteID, String noteInput){
        Note found = findNoteById(noteID);
        if (found == null){
            return null;
        }
        else {
            found.setNoteBody(noteInput);
            return found;
        }
    }
    public String deleteNote(int noteId) {
        Note found = findNoteById(noteId);
        if (found == null) {
            return null;
        }
        else {
            noteBook.remove(found);
            return "Success";
        }
    }

    public ArrayList<Note> listNotes (){
    return noteBook;
    }


    public Note listSingleNote(int noteId){
        return findNoteById(noteId);
    }
    public Note listNotesByCategory (String categorySearch) {
        boolean categoryFound = false;
        for (Note note : noteBook) {
            if (note.getCategory().equalsIgnoreCase(categorySearch)) {
                categoryFound = true;
                return note;
            }
        }

        return null;
    }




}
