
public class Teacher extends Person{
    final int borrowLimit = 5;

    public Teacher(String name){
        super(name);
    }

    public int getBorrowLimit(){
        return this.borrowLimit;
    }

}