/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.h3dema.canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author h3dema
 */
public class Texto implements Forma {

    private int x, y;
    private String str = "";
    
    /*
     * cria um circulo na posição (x,y) com raio "raio"
     */
    public Texto(int x, int y) {
        this(x, y, "");
    }

    public Texto(int x, int y, String str) {
        this.x = x;
        this.y = y;
        this.str = str;
    }
    
    public void set(String str) {
        this.str = str;
    }
    
    @Override
    public void draw(Graphics g) {
        int px = x*DX;
        int py = y*DY;
        g.setColor(corBorda);
        g.drawString(str, px, (int)(py+0.8*DY));
    }
}
