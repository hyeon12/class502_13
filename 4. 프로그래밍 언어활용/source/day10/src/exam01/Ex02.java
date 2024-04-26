package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Transportation trans = Transportation.BUS;
        Enum<Transportation> trans2 = trans;

        switch(trans){
            //case Transportation.BUS ->이미 정의한 경우, 투입된 값으로!
            case BUS :
                System.out.println("버스");
                break;
            case SUBWAY:
                System.out.println("지하철");
                break;
            case TAXI:
                System.out.println("택시");
                break;
            default:
                System.out.println("대중교통 아님");
                break;
        }
    }
}
