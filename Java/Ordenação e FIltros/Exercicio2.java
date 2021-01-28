import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Exercicio2 {
    public static void main(String[] args) throws IOException {
        BufferedReader inBr = new BufferedReader(new InputStreamReader(System.in));
        List<List> lists = new ArrayList<>();
        int count = Integer.parseInt(inBr.readLine());

        while (count > 0){
            lists.add(exclDUplicate(readNums(inBr)));
            count--;
        }

        impr(lists);


    }
    
    private static List<String> readNums(BufferedReader in) throws IOException {
        String nota;
        nota = in.readLine();
        return Arrays.stream(nota.split(" ")).collect(Collectors.toList());
    }

    private static List<String> exclDUplicate(List<String> list){
        List<String> listresult = new ArrayList<>();
        listresult.add(list.get(0));

        for(int i=1; i<list.size(); i++){
            if(!listresult.contains(list.get(i))){
                listresult.add(list.get(i));
            }
        }
        
        return listresult.stream().sorted().collect(Collectors.toList());
    }
    
    private static void impr(List<List> lts){
        for (int i = 0; i< lts.size(); i++){
            for(int d = 0; d<lts.get(i).size(); d++){
                System.out.print(lts.get(i).get(d) + " ");
            }
            System.out.println("\n");
        }
    }
}
