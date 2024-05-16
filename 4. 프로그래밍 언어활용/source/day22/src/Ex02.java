import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class Ex02 {
    public static void main(String[] args) {
        String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};

        String[] unfinished = solution(todo_list, finished);
        System.out.println(Arrays.toString(unfinished));
    }

    public static String[] solution(String[] todo_list, boolean[] finished) {
        List<String> unfinished = new ArrayList<>();
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) {
                unfinished.add(todo_list[i]);
            }
        }

        /*String[] data = new String[unfinished.size()]
        return unfinished.toArray(data)*/

        /*
        return unfinished.toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
         */
        /*i -> String[i]*/
        //return unfinished.toArray(i -> new String[i]);
        return unfinished.toArray(String[]::new);
    }
}