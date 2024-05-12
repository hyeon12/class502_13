package exam;

public class Ex03 {
   public int solution(int[] array, int n) {
            int target = 0;

            for(int i : array){
                if(i == n){
                    target++;}
            }

            return target;
        }

    public static void main(String[] args) {
        Ex03 ex = new Ex03();
        int[] array = {1,3,5,4,7,2};
        System.out.println(ex.solution(array, 9));
    }
}
