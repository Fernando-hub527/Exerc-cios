import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FilaBanco {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ManipulaFila manipulaFila = new ManipulaFila();
        List<List> lists = new ArrayList<>();
        List<List> clonelists = new ArrayList<>();

        var countestes = Integer.parseInt(br.readLine());
        while (countestes > 0){
            lists.add(manipulaFila.read(br));
            countestes--;
        }

        lists.forEach(lst->clonelists.add(new ArrayList<>(lst)));
        lists.forEach(lst-> lst.sort(new AuxComparator()));
        manipulaFila.verificPosition(lists, clonelists).forEach(System.out::println);
    }
}

class AuxComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer t1, Integer t2) {
        return t2.compareTo(t1);
    }
}

class ManipulaFila{
    public List<Integer> read(BufferedReader br) throws IOException {
        var count = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        var nums = br.readLine().split(" ");
        for (String num: nums){
            list.add(Integer.parseInt(num));
        }
        return list;
    }
    public List<Integer> verificPosition(List<List> lists, List<List> copylists){
        List<Integer> listreturn = new ArrayList<>();
        int aux = 0;

        for (int lst = 0; lst < lists.size(); lst++){
            for (int item = 0; item < lists.get(lst).size(); item ++){
                if (lists.get(lst).get(item) == copylists.get(lst). get(item)){
                    aux++;
                }
            }
            listreturn.add(aux);
            aux = 0;
        }

        return listreturn;
    }
} 
