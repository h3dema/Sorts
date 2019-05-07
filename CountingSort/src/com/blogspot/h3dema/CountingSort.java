package com.blogspot.h3dema;

import java.util.Arrays;
import com.blogspot.h3dema.canvas.MyCanvas;
import com.blogspot.h3dema.canvas.Numero;
import com.blogspot.h3dema.canvas.Texto;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author h3dema
 */
public class CountingSort {
    
    JFrame tela;
    MyCanvas my;    
    
    public CountingSort(){
        tela = new JFrame("Counting Sort");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // para garantir que a aplicação será fechada
        
        my = new MyCanvas();
        my.setBackground(Color.WHITE);
        tela.getContentPane().add(my); // desenhamos o canvas dentro da tela
        
        tela.pack();
        tela.setVisible(true);
        
        my.adicionar(new Texto(7, 0, "Counting Sort"));
        my.adicionar(new Texto(1, 3, "Array original"));
        my.adicionar(new Texto(1, 5, "Indice"));
        my.adicionar(new Texto(1, 7, "Array ordenado"));
        my.adicionar(new Texto(10, 10, "h3dema.blogspot.com"));
    }
    
    public void drawArray(int x, int y, int[] a) {
        for(int i = 0; i < a.length; i++) {
            my.adicionar(new Numero(x+i, y, a[i]));
        }
        my.repaint();
    }
    
    public int[] sortDemo(int[] A) throws InterruptedException {
        
        final int TTL = 400;
        
        int[] B = new int[A.length];
        drawArray(1,4,A);
        
        // acha minimo e máximo
        int min = A[0];
        int max = A[0];
        for(int i = 1; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        
        int len = max - min + 1;
        int[] C = new int[len];
        for(int i = 0; i < C.length; i++) C[i] = 0;
        drawArray(1,6,C);
        
        for(int i = 0; i < A.length; i++){
            int j = A[i] - min;
            C[j] += 1;
            Thread.sleep(TTL);
            drawArray(1,6,C);
            Numero num = new Numero(1+j,6,C[j]);
            num.setCor(Color.RED);
            my.adicionar(num);
        }
        
        len = C.length-1;
        C[len] = A.length - C[len];
        for(int i = C.length - 2; i >= 0; i--){
            C[i] = C[i+1] - C[i];
            Thread.sleep(TTL);
            drawArray(1,6,C);
            Numero num = new Numero(1+i,6,C[i]);
            num.setCor(Color.RED);
            my.adicionar(num);
        }
        Thread.sleep(TTL);
        drawArray(1,6,C);
        
        for(int i = 0; i < A.length; i++){
            int j = A[i] - min;
            int k = C[j]++;
            B[ k ] = A[i];
            Thread.sleep(TTL);
            Numero num = new Numero(1+i,4,A[i]);
            num.setCor(Color.RED);
            my.adicionar(num);
            
            drawArray(1,8,B);
            Numero num2 = new Numero(1+k,8,B[k]);
            num2.setCor(Color.RED);
            my.adicionar(num2);            
        }        
        Thread.sleep(TTL);
        drawArray(1,8,B);
        
        return B;
    }

    public static int[] sort(int[] A) {
        int[] B = new int[A.length];
        
        // acha minimo e máximo
        int min = A[0];
        int max = A[0];
        for(int i = 1; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        
        int len = max - min + 1;
        int[] C = new int[len];
        for(int i = 0; i < C.length; i++) C[i] = 0;
        
        for(int i = 0; i < A.length; i++){
            int j = A[i] - min;
            C[j] += 1;
        }
        
        len = C.length-1;
        C[len] = A.length - C[len];
        for(int i = C.length - 2; i >= 0; i--){
            C[i] = C[i+1] - C[i];
        }
        
        for(int i = 0; i < A.length; i++){
            int j = A[i] - min;
            B[ C[j]++ ] = A[i];
        }        
        
        return B;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        CountingSort cs = new CountingSort();
        
        int[] a = {6,5,4,-1,8,0,7,3,-1,8,9,2,11,2,6,7,8,5,2,9,0,1,6};
        System.out.println(Arrays.toString(a));
        int[] r = cs.sortDemo(a);
        System.out.println(Arrays.toString(r));
        
    }
}
