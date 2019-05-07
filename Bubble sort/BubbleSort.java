/*
Exemplo utilizando Algoritmo Bubble Sort

Este algoritmo é "facinho" para utilizar o mineirez. Ele basicamente faz:
	o Percorrr o vetor inteiro comparando elementos adjacentes (dois a dois)
	o Troque as posições dos elements se eles estiverem fora de ordem
	o Repita os dois passos acima com os primeiros n-1 itens, depois com os primeiros n-2 itens, até que reste apenas um item

OBS:
Este método só é adequado para arquivo pequeno, pois realiza muita atividade por o número de operações não altera com um vetor (parcialmente) ordenado. É possível melhor terminando a execução quando nenhuma troca é realizada após uma passada pelo vetor

*/

import java.util.Vector; // vamos usar Vector ao invés de Array só para complicar um pouco
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.NumberFormatException;


public class BubbleSort {

   private static void sort(Vector<Integer> v) {
      int n = v.size();
      int temp = 0; // armazena valor temporário para efetuar as trocas

      for(int i=0; i < n; i++){
         for(int j=1; j < (n-i); j++){
             if(v.get(j-1) > v.get(j)){
               //troca
               temp = v.get(j-1);
               v.set(j-1, v.get(j));
               v.set(j, temp);
             } // if
         } // for j
         System.out.println("Vetor passo " + i + " : " + v);
      } // for i
   } // bubbleSort

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
      sort(v);

   } //main

}
