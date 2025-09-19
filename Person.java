public abstract class Person {
    private final int id;
    private final String name;
    private static int lastId = 0;

    public Person(String name){
        this.id = ++lastId;
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public abstract int getBorrowLimit();

}