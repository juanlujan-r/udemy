package org.jvalencia.Game.Inventory;

abstract class Item {
    private String name;
    private double weight;

    public Item (String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public abstract void inspect ();

    public String getName() {
        return name;
    }
}
