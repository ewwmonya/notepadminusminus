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
            System.out.println("5. Update Note");
            System.out.println("6. Delete Note");
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
                System.out.println(noteService.addNote(inputNote));
            }
            else if (choice == 2)  {
                System.out.println(noteService.listNotes());
            }
            else if (choice == 3) {
                System.out.print("Enter Category String: ");
                String categoryInput = scanner.nextLine();
                System.out.println(noteService.listNotesByCategory(categoryInput));
            }
            else if (choice == 4) {
                System.out.print("Enter Note Id: ");
                int noteIdInput = scanner.nextInt();
                scanner.nextLine();
                System.out.println(noteService.listSingleNote(noteIdInput));
            }
            else if (choice == 5) {
                System.out.print("Enter Note Id to Update: ");
                int noteIdInput = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Text for body: ");
                String newNoteText = scanner.nextLine();
                System.out.println(noteService.updateNote(noteIdInput, newNoteText));
            }

            else if (choice == 6) {
                System.out.print("Enter Note Id to Delete: ");
                int noteIdInput = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Confirm that you would like to delete this Note!");
                System.out.print(" Type \" Yes \": ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Yes")) {
                    System.out.println(noteService.deleteNote(noteIdInput));
                    System.out.println(noteService.listNotes());
                }
            }
        }
    }
}