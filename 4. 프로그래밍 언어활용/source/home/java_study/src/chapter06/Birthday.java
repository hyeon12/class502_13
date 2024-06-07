package chapter06;

public class Birthday {
    int day;
    int month;
    int year;

    public void setYear(int year){
        this.year = year;
    }

    public void printThis(){
        System.out.println(this);
    }

    public static void main(String[] args) {
        Birthday bday = new Birthday();
        bday.setYear(2000);
        System.out.println(bday);
        bday.printThis();
    }
}
