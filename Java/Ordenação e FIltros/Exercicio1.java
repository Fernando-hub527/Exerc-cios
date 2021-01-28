import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class ExercicioOne {
    public static void main(String[] args) throws IOException {
        List<Integer> nums = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = readNumsUsr(Integer.parseInt(br.readLine()), br);
        
        var par = nums.stream().filter(n -> n % 2==0).sorted().collect(Collectors.toList());
        var impa = nums.stream().filter(n -> n % 2==1).sorted().collect(Collectors.toList());
        Collections.reverse(impa);
        par.forEach(n ->System.out.println(n));
        impa.forEach(n ->System.out.println(n));

    }
    
    private static List<Integer> readNumsUsr(int count, BufferedReader br) throws IOException {
        List<Integer> list = new ArrayList<>();
        int countread = 0;

        while (countread < count){
            list.add(Integer.parseInt(br.readLine()));
            countread++;
        }
        return list;
    }
}
