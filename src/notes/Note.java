package notes;


public class Note {
    //## What is a note in real life?
    // A note is a quick way make tag
    // or reference for a task or body of text
    // This can also be catted out. Lit, Math, History, Ect...

    //## What does a note hold
    // A note holds text the title
    // and a body of text

    //Note = Data model

    // Basically Types in TypeScript ^_^
    private String title;
    private String noteBody;
    private String category;
    private int    noteId;
    Note( String title, String noteBody,String category){
        if (!title.isEmpty() && !noteBody.isEmpty() && !category.isEmpty()) {
            this.title = title;
            this.noteBody = noteBody;
            this.category = category;
        }
    }
    public void setNoteId (int noteId) {
        this.noteId = noteId;
    }
    public String setNoteBody (String noteBodyInput) {
        this.noteBody = noteBodyInput;
        return noteBodyInput;
    }
    public int getNoteId () {
        return noteId;
    }
    public String getCategory(){
        return category;
    }
    @Override
    public String toString() {
        return "[" + noteId + "] " + title + " (" + category + ") "+ " "  + noteBody;
    }

}
