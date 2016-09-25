package com.movil.p.mathmagic;


public class Jugador {

    private String nick;
    private int nivel;
    private int subNivel;
    private int total_pts;
    private int edad;

    public Jugador() {
        nick = null;
        nivel = 1;
        subNivel=1;
        total_pts = 0;
        edad = 6;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setTotal_pts(int total_pts) {
        this.total_pts = total_pts;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSubNivel(int subNivel) {
        this.subNivel = subNivel;
    }

    public String getNick() {
        return nick;
    }

    public int getNivel() {
        return nivel;
    }

    public int getTotal_pts() {
        return total_pts;
    }

    public int getEdad() {
        return edad;
    }

    public int getSubNivel() {
        return subNivel;
    }
}
