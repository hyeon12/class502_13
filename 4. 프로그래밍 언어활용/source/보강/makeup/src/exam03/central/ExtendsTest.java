package exam03.central;

public class ExtendsTest {
    public static void main(String[] args) {
        Building building = new Building();
        //하위 클래스가 상위 클래스의 자료형으로 자동 형변환(다형성)

        System.out.println("---------Building---------");
        System.out.println(building.ownbuilding);
        System.out.println(building.ownFloor5);
        System.out.println(building.own502);
        //자동 형변환되어 상위클래스의 자원을 사용할 수 있다!

        System.out.println("---------Floor5---------");
        Floor5 floor5 = building;
        System.out.println(floor5.ownFloor5);
        System.out.println(floor5.own502);
        //Floor5형으로 제한 -> 하위클래스 Building 자원 사용 불가

        System.out.println("---------Clazz502---------");
        Clazz502 clazz502 = building;
        System.out.println(clazz502.own502);
        //Clazz502형으로 제한 -> 하위클래스 Building, Floor5 자원 사용 불가
    }
}
