package com.arteaga.beans;

public enum Categoria {
    PLATINUM(500.0d),
    GOLD(350.0d),
    SILVER(100.0d);

    private final double costo;

    Categoria(double costo){
            this.costo = costo;
        }
    public double getCosto(){
            return costo;
        }

}
