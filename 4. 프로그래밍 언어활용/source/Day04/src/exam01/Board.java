package exam01;

public class Board {
    //private static Board instance = new Board();
    // 클래스로드 시점부터 객체 생성 (static) -> 사용안해도 자동 생성되어 자원이 낭비됨!
    // -> 필요할 때만 생성하고, 이후로는 공유하고 싶을때는?
    // -> 처음부터 값을 넣지 말고 아래와 같이 변수 선언만 하고, 필요할 때 가져와야 한다!

    private static Board instance; // 변수 선언만!

    static {
        System.out.println("객체생성과 관련없이, 처음부터 실행!! ");
    }

    private Board() {} // 현재 상태로는 외부에서 사용할 수 없음!

    public static Board getInstance() { //static을 써서 외부 사용 가능!
        if (instance == null) { // 필요한 시점 최소 1번만 생성 (이후 공유)
            instance = new Board();
        }

        return instance;
    }
}