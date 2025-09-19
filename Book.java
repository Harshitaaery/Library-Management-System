public class Book{
    private final int id;
    private final String title;
    private final String author;
    private boolean borrowed;


    public Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public String getTitle(){
        return this.title;
    }

    public int getId(){
        return this.id;
    }

    public String getAuthor(){
        return this.author;
    }

    public boolean isBorrowed(){
        return this.borrowed;
    }

    public void borrowBook(){
        if(this.borrowed)
        {
            System.out.println("Book unavailable");
        }
        else this.borrowed = true;
    }

    public void returnBook(){
        if(!this.borrowed)
        {
            System.out.println("Book already returned");
        }
        else this.borrowed = false;
    }

}