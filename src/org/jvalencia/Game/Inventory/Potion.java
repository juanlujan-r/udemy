package org.jvalencia.Game.Inventory;

public class Potion extends Item implements Usable{
    private String type;

    public Potion(String name, double weight, String type){
        super(name, weight);
        this.type = type
        ;
    }

    @Override
    public void inspect() {
        System.out.println("It's a glass with a liquid inside " + getName() + " " + type + ".");
    }

    @Override
    public String use() {
        return "You drank the potion " + getName() + " " + type + ".";
    }
}
