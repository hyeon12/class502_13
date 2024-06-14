package exam03.central;

public class ExtendsTest2 {
    public static void main(String[] args) {
        Floor5 floor5 = new Building();

        //Floor5의 내용물이 담긴 것!
        //건물 가진 것 같지만, 자료형이 Floor5라 5층밖에 못써!
        //건물주가 5층 주인으로 위장한 상태
        System.out.println(floor5.own502);
        System.out.println(floor5.ownFloor5);

        //건물주가 사실은 내가 건물주다!
        //어? 의심스러운데... 정말... 진짜 원래 건물주가 맞는지...?
        //상위->하위로 가는거니까 출처(건물주)가 맞는지 확인해야해!
        //체크가 필요한 것 => instanceof 로 원래 출처 체크
        if(floor5 instanceof Building){
            //체크했는데 어? 원래 건물주(Building) 맞네
            //그럼 강제형변환 시켜주자~
            Building newBuilding = (Building)floor5;
            System.out.println(newBuilding.ownbuilding);
            //사용가능!!!!
        }



        Clazz502 clazz502 = new Floor5();
        System.out.println(clazz502.own502);
    }
}
