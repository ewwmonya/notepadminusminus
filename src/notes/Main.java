package notes;

public class Main {
    //## This main file is loop file to
    // keep the program running while the user is using it.
    //## This will also be the "router" file. Kind of like a
    // host in a restaurant.
    public static void main(String[] args) {


        NoteService noteService = new NoteService();
        Note note = new Note( "Title1", "Note Body", "Construction");
        Note note1 = new Note( "Title2", "Note Body2", "Construction");
        Note note2 = new Note( "Title3", "Note Body3", "IT");
        Note note3 = new Note( "Title4", "Note Body4", "IT");
        Note note4 = new Note( "Title5", "Note Body5", "IT");
        noteService.addNote(note);
        noteService.addNote(note1);
        noteService.addNote(note2);
        noteService.addNote(note3);
        noteService.addNote(note4);
    }
}