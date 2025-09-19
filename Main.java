public class Main{
    public static void main(String[] args) {
        Library lib = new Library();
        Book b1 = new Book(101, "Basics of Java", "King K");
        Book b2 = new Book(102, "OOP Principles", "Aery");
        lib.addBook(b1);
        lib.addBook(b2);
        Student s1 = new Student("Kat");
        Teacher t1 = new Teacher("JP");

        lib.addPerson(s1);
        lib.addPerson(t1);

        lib.borrowBook(s1,b1);
        lib.borrowBook(t1,b2);

        lib.borrowBook(t1,b1);

        lib.returnBook(t1,b2);
        lib.returnBook(s1,b1);
    }
}