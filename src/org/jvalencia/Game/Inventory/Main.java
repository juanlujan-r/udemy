package org.jvalencia.Game.Inventory;

public class Main {
        public static void main(String[] args) {
            // Backpack exclusively for Potions
            Backpack<Potion> potionBag = new Backpack<>();
            potionBag.add(new Potion("Minor Health", 0.5, "Health"));
            potionBag.add(new Potion("Major Mana", 0.7, "Magic"));

            // Backpack exclusively for Weapons
            Backpack<Weapon> armory = new Backpack<>();
            armory.add(new Weapon("Rusty Sword", 5.0, 10));

            // COMPILATION ERROR TEST
            // The following line would cause an error if uncommented:
            // potionBag.add(new Weapon("Axe", 8.0, 20));
            // Error: "Weapon cannot be converted to Potion"

            potionBag.checkBackpack();
            potionBag.useAll();

            armory.checkBackpack();
        }
    }
