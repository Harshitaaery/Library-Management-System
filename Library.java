import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private List<Book> books;
    private List<Person> people;
    private Map<Person, List<Book>> borrowedBooks;

    public List<Book> getBooks() 
    { 
    return new ArrayList<>(books); 
    }

    public List<Person> getPeople() 
    { 
    return new ArrayList<>(people); 
    }

    public Library(){
        books = new ArrayList<>();
        people = new ArrayList<>();
        borrowedBooks = new HashMap<>();
    }

    public void addBook(Book obj){
        for (int i = 0; i < books.size(); i++) {
        Book b = books.get(i);
        if (b.getId() == obj.getId()) {
            System.out.println("Book with ID " + obj.getId() + " already exists!");
            return;
        }
        }
        books.add(obj);
    }

    public void addPerson(Person obj){
        for (int i = 0; i < people.size(); i++) {
        Person p = people.get(i);
        if (p.getId() == obj.getId()) {
            System.out.println("Person with ID " + obj.getId() + " already exists!");
            return;
        }
    }
    people.add(obj);
    }

    public boolean borrowBook(Person p, Book b) {
    if (!people.contains(p)) {
        System.out.println("Person not registered in the library.");
        return false;
    }

    if (!books.contains(b)) {
        System.out.println("This book does not belong to this library.");
        return false;
    }

    if (b.isBorrowed()) {
        System.out.println("Sorry, the book is already borrowed.");
        return false;
    }

    borrowedBooks.putIfAbsent(p, new ArrayList<>());
    if (borrowedBooks.get(p).size() >= p.getBorrowLimit()) {
        System.out.println(p.getName() + " has reached their borrow limit.");
        return false;
    }

    b.borrowBook();
    borrowedBooks.get(p).add(b);
    System.out.println(p.getName() + " borrowed " + b.getTitle());
    return true;
    }
    
public boolean returnBook(Person p, Book b) {
    if (!borrowedBooks.containsKey(p)) {
        System.out.println("Person not found or has not borrowed any books.");
        return false;
    }

    List<Book> personBooks = borrowedBooks.get(p);
    if (!personBooks.contains(b)) {
        System.out.println("No such book found for " + p.getName());
        return false;
    }

    b.returnBook();
    personBooks.remove(b);
    if (personBooks.isEmpty()) {
        borrowedBooks.remove(p);
    }

    System.out.println(p.getName() + " returned " + b.getTitle());
    return true;
}

}
