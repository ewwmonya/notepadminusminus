package notes;

import java.util.Scanner;

public class Main {
    //## This main file is loop file to
    // keep the program running while the user is using it.
    //## This will also be the "router" file. Kind of like a
    // host in a restaurant.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NoteService noteService = new NoteService();

        while(true){
            System.out.println("1. Add Note");
            System.out.println("2. List Notes");
            System.out.println("3. List Note By Category");
            System.out.println("4. List Note By Id");
            System.out.println("5. Delete Note");
            System.out.println("0. Exit!");
            System.out.print("Please Enter Choice #: ");

            int choice = scanner.nextInt();
            scanner.nextLine();


            if (choice == 0){
                System.out.println("GoodBye...");
                scanner.close();
                break;
            }
            else if (choice == 1) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Body: ");
                String noteBody = scanner.nextLine();
                System.out.print("Category: ");
                String category = scanner.nextLine();
                Note inputNote = new Note(title, noteBody, category);
                noteService.addNote(inputNote);
            }
            else if (choice == 2)  {
                noteService.listNotes();
            }
            else if (choice == 3) {
                System.out.print("Enter Category String: ");
                String categoryInput = scanner.nextLine();
                noteService.listNotesByCategory(categoryInput);
            }
            else if (choice == 4) {
                System.out.print("Enter Note Id: ");
                int noteIdInput = scanner.nextInt();
                scanner.nextLine();
                noteService.listSingleNote(noteIdInput);
            }

            else if (choice == 5) {
                System.out.print("Enter Note Id to Delete: ");
                int noteIdInput = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Confirm that you would like to delete this Note!");
                System.out.print(" Type \" Yes \": ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Yes")) {
                noteService.deleteNote(noteIdInput);
                noteService.listNotes();
                }
            }
        }
    }
}