package rpg_lab;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> inventory;

    public Hero(String name) {
        this.name = name;
        this.experience = 0;
        this.weapon = new Axe(10, 10);
    }

    public Hero(String name, int experience, Weapon weapon) {
        this.name = name;
        this.experience = experience;
        this.weapon = weapon;
        this.inventory = new ArrayList<Weapon>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.inventory.add(target.getLoot());
        }
    }

    public List<Weapon> getInventory() {
        return this.inventory;
    }
}
