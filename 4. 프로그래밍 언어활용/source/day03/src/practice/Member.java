package practice;

public class Member extends java.lang.Object {
    String id;
    String name;
    String addr; // 3개의 멤버변수
    Member(){} // 기본 생성자

    Member(String new_id, String new_name, String addr){
        id = new_id;
        name = new_name;
        addr = addr;
        System.out.println();
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
