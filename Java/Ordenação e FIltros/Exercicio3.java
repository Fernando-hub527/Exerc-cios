import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercicio3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<uniformes> valmap = new ArrayList<>();

        while (true){
            valmap.clear();
            var count = Integer.parseInt(br.readLine());

            if (count == 0){
                break;
            }
            else {
                var auxcount = 0;
                while (auxcount < count) {
                    var nome = br.readLine();
                    var auxval = br.readLine().split(" ");

                    valmap.add(new uniformes(nome, auxval[0], auxval[1]));
                    auxcount++;
                }
                valmap.sort(new AuxComparator());
                valmap.forEach(n -> System.out.println(n));
            }
        }
    }
}


class AuxComparator implements Comparator<uniformes> {
    @Override
    public int compare(uniformes uniformes, uniformes t1) {

        if (!uniformes.getCorcamisa().equals(t1.getCorcamisa())){
            return uniformes.getCorcamisa().compareTo(t1.getCorcamisa());
        }

        else if (!uniformes.getTamanho().equals(t1.getTamanho())){
            return t1.getTamanho().compareTo(uniformes.getTamanho());
        }
        else {
            return uniformes.getNome().compareTo(t1.getNome());
        }

    }
}

class uniformes {
    private String nome, corcamisa, tamanho;

    public uniformes(String nome, String corcamisa, String tamanho) {
        this.nome = nome;
        this.corcamisa = corcamisa;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }
    public String getCorcamisa() {
        return corcamisa;
    }
    public String getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return  corcamisa + " " + tamanho + " " + nome;
    }
}
