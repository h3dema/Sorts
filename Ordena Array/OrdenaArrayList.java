/*

Exemplo utilizando a ordenação do java com Comparator

*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
import java.util.Arrays;


public class OrdenaArrayList {

  public static void main(String[] args) {

    File f = new File(args[0]);
    if (!f.exists()) {
      System.out.println("Arquivo não existe!");
      System.exit(1);
    }

    // cria o ArrayList que conterá as strings que leremos do arquivo
    String[] dados = In.readStrings(f.getName());
    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList( dados ));


    // use o método de reverseOrder() do Comparator para gerar a ordem reversa dos dados
    Comparator<String> comparator = Collections.reverseOrder();

    System.out.println("Vetor antes de classificar em ordem decrescente : " + arrayList);

    // Para classificar uma ArrayList usando o Comparador use o método sort()
    Collections.sort(arrayList,comparator);

    System.out.println("Depois de ordenado: " + arrayList);

  }
}