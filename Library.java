import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    public List<Book> books;
    public List<Person> people;
    public Map<Person, List<Book>> borrowedBooks;

    public Library(){
        books = new ArrayList<>();
        people = new ArrayList<>();
        borrowedBooks = new HashMap<>();
    }

    public void addBook(Book obj){
        books.add(obj);
    }

    public void addPerson(Person obj){
        people.add(obj);
    }

    
    public void returnBook(Person p, Book b){
        if(borrowedBooks.get(p) == null){
            System.out.println("Person not found");
        }
        else if (borrowedBooks.get(p).contains(b)){
            borrowedBooks.get(p).remove(b);
            b.returnBook();
        }
        else System.out.println("No such book found");    }

}
