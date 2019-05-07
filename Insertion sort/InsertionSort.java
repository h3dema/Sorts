/*
Exemplo utilizando Algoritmo Insertion Sort

*/

import java.util.Vector; // vamos usar Vector ao invés de Array só para complicar um pouco
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.Comparator;

public class InsertionSort {

  // is v < w ?
  private static boolean less(Comparable v, Comparable w) {
    return (v.compareTo(w) < 0);
  }

  // is v < w ?
  private static boolean less(Comparator c, Object v, Object w) {
    return (c.compare(v, w) < 0);
  }

  // troca a[i] e a[j]
  private static void troca(Object[] a, int i, int j) {
    Object temp = a[i]; // usa object para tornar a troca genérica
    a[i] = a[j];
    a[j] = temp;
  }

  // exchange a[i] and a[j]  (for indirect sort)
  private static void troca(int[] a, int i, int j) {
    int swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  /**
   * verifica se o array está ordenado
   */
  private static boolean estaOrdenado(Comparable[] a) {
    return estaOrdenado(a, 0, a.length - 1);
  }

  // is the array sorted from a[lo] to a[hi]
  private static boolean estaOrdenado(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      if (less(a[i], a[i-1])) {
        return false;
      }
    }
    return true;
  }

  private static boolean estaOrdenado(Object[] a, Comparator c) {
    return estaOrdenado(a, c, 0, a.length - 1);
  }

  // is the array sorted from a[lo] to a[hi]
  private static boolean estaOrdenado(Object[] a, Comparator c, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      if (less(c, a[i], a[i-1])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Rearranges the array in ascending order, using the natural order.
   * @param a the array to be sorted
   */
  public void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
        troca(a, j, j-1);
      }
      assert estaOrdenado(a, 0, i);
    }
    assert estaOrdenado(a);
  }

  /**
   * Rearranges the array in ascending order, using a comparator.
   * @param a the array
   * @param c the comparator specifying the order
   */
  public void sort(Object[] a, Comparator c) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0 && less(c, a[j], a[j-1]); j--) {
        troca(a, j, j-1);
      }
      assert estaOrdenado(a, c, 0, i);
    }
    assert estaOrdenado(a, c);
  }

  // return a permutation that gives the elements in a[] in ascending order
  // do not change the original array a[]
  /**
   * Returns a permutation that gives the elements in the array in ascending order.
   * @param a the array
   * @return a permutation <tt>p[]</tt> such that <tt>a[p[0]]</tt>, <tt>a[p[1]]</tt>,
   *    ..., <tt>a[p[N-1]]</tt> are in ascending order
   */
  public static int[] indexSort(Comparable[] a) {
    int N = a.length;
    int[] index = new int[N];
    for (int i = 0; i < N; i++)
      index[i] = i;

    for (int i = 0; i < N; i++)
      for (int j = i; j > 0 && less(a[index[j]], a[index[j-1]]); j--)
      troca(index, j, j-1);

    return index;
  }

  /**
   * envia array para tela
   */
  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
    }
    System.out.println();
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
      sort(v);

   } //main

}

