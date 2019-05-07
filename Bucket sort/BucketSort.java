import java.util.LinkedList;

// depende de InsertionSort que deve estar no classpath


public class BucketSort {

  public static int[] sort(int[] vetor, int maiorValor) {
    int[] resultado = null;

    int numBaldes = maiorValor/5;

    LinkedList[] B = new LinkedList[numBaldes];

    for (int i = 0; i < numBaldes; i++){
      B[i] = new LinkedList<Integer>();
    }

    //Coloca os valores no balde respectivo:
    for (int i = 0; i < vetor.length; i++) {
      int j = numBaldes-1;
      while (true){
        if(j<0){
          break;
        }
        if(vetor[i] >= (j*5)){
          B[j].add(vetor[i]);
          break;
        }
        j--;
      }
    }

    InsertionSort is = new InsertionSort();
    resultado = new int[vetor.length];

    //Ordena e atualiza o vetor:
    int indice = 0;
    for (int i = 0; i < numBaldes; i++){

      Integer[] aux = new Integer[B[i].size()];

      //Coloca cada balde num vetor:
      for (int j = 0; j < aux.length; j++){
        aux[j] = (Integer)B[i].get(j);
      }

      is.sort(aux); //algoritmo escolhido para ordenação.

      // Devolve os valores ao vetor de entrada:
      for (int j = 0; j < aux.length; j++, indice++){
        resultado[indice] = aux[j];
      }

    }
    return resultado;
  }


   public static void main(String[] args) {

      // cria o vetor
      Vector<Integer> v = new Vector<Integer>();
      // preenche o vetor com os dados do arquivo
      String nomeArquivo = "../dados.txt";
      try {
         BufferedReader in = new BufferedReader(new FileReader(nomeArquivo));
         String linha = null;
         while ((linha = in.readLine()) != null) {
           try {
             v.add(Integer.valueOf(linha));
           } catch (NumberFormatException e1) {
             // somente não insere
           } // try
         } // while
         in.close();
      } catch (IOException e) {
         System.out.println( "erro não tratado - somente indicação ");
      } // try

      System.out.println("Vetor não ordenado : " + v);

      // ordena os dados usando o algoritmo
      sort(v, 100);  // 100 é necessário para definir os buckets

   } //main

}