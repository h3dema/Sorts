package com.blogspot.h3dema.canvas;

/*
 * desenha o canvas
 */


import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author h3dema
 */
public class MyCanvas extends JComponent {
    
    private ArrayList<Forma> formas = new ArrayList<>();
    
    /*
     * adiciona uma forma para ser apresentada no canvas
     */
    public void adicionar(Forma f) { formas.add(f); }
    /*
     * remove uma forma pelo indice
     */
    public void remover(int i) {
        if (i < formas.size()) { formas.remove(i); }
    }
    
    /*
     * método herdado que desenha o canvas deste objeto
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Forma f : formas) { f.draw(g); }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 250); // canvas padrão de 500x500 pixels
    }
    
    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize(); // minimo é igual a default
    }
        
}
