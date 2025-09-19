public class Student extends Person{
    final int borrowLimit = 3;

    public Student(String name){
        super(name);
    }

    public int getBorrowLimit(){
        return this.borrowLimit;
    }

}
