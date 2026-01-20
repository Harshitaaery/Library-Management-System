import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try{
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    lib.addBook(new Book(title, author));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter member name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter type (1=Student, 2=Teacher): ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    if (type == 1) lib.addPerson(new Student(name));
                    else if (type == 2) lib.addPerson(new Teacher(name));
                    else System.out.println("Invalid type.");
                    break;

                case 3:
                    System.out.print("Enter member id: ");
                    int borrowId = sc.nextInt();
                    System.out.print("Enter book id: ");
                    int borrowBookId = sc.nextInt();
                    sc.nextLine();
                    Person borrower = lib.getPeople().stream().filter(p -> p.getId() == borrowId).findFirst().orElse(null);
                    Book bookToBorrow = lib.getBooks().stream().filter(b -> b.getId() == borrowBookId).findFirst().orElse(null);
                    if (borrower != null && bookToBorrow != null) lib.borrowBook(borrower, bookToBorrow);
                    else System.out.println("Member or Book not found.");
                    break;

                case 4:
                    System.out.print("Enter member id: ");
                    int returnId = sc.nextInt();
                    System.out.print("Enter book id: ");
                    int returnBookId = sc.nextInt();
                    sc.nextLine();
                    Person returner = lib.getPeople().stream().filter(p -> p.getId() == returnId).findFirst().orElse(null);
                    Book bookToReturn = lib.getBooks().stream().filter(b -> b.getId() == returnBookId).findFirst().orElse(null);
                    if (returner != null && bookToReturn != null) lib.returnBook(returner, bookToReturn);
                    else System.out.println("Member or Book not found.");
                    break;

                case 5:
                    System.out.println("--- All Books ---");
                    for (Book b : lib.getBooks()) {
                        String status = b.isBorrowed() ? "Borrowed" : "Available";
                        System.out.println(b.getId() + ": " + b.getTitle() + " by " + b.getAuthor() + " [" + status + "]");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine();
        }
    }

        sc.close();
    }
}
