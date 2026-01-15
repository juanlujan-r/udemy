package org.jvalencia.Game.Inventory;

public class Weapon extends Item implements Usable{
    double damage;

    public Weapon (String name, double weight, double damage){
        super(name, weight);
        this.damage = damage;
    }

    @Override
    public String use() {
        return "You attacked with " + getName() + ".";
    }

    @Override
    public void inspect() {
        System.out.println(getName()+ "is very sharp.\nDamage: "+ damage);
            }
}
