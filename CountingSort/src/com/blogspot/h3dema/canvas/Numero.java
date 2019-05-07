/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.h3dema.canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author h3dema
 */
public class Numero implements Forma {

    private int x, y;
    private int num = 0;
    private Color corFundo = Color.WHITE;
    
    /*
     * cria um circulo na posição (x,y) com raio "raio"
     */
    public Numero(int x, int y) {
        this(x, y, 0);
    }

    public Numero(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
    
    public void set(int num) {
        this.num = num;
    }
    
    public void setCor(Color cor) {
        corFundo = cor;
    }
    
    @Override
    public void draw(Graphics g) {
        Polygon p = new Polygon();
        int px = x*DX;
        int py = y*DY;
        p.addPoint(px, py);
        p.addPoint(px, py + DY);
        p.addPoint(px + DX, py + DY);
        p.addPoint(px + DX, py);
        g.setColor(corFundo);
        g.fillPolygon(p);
        g.setColor(corBorda);
        g.drawPolygon(p);

        g.drawString(Integer.toString(num), (int)(px+DX*0.2), (int)(py+0.8*DY));
    }
}
