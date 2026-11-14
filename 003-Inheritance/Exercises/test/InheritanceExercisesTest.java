import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static support.Console.run;

import java.math.BigDecimal;

import org.junit.Test;

public class InheritanceExercisesTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void person() {
        Person.Child child = new Person.Child("Peter", 13);
        assertTrue(child instanceof Person.Person);
        assertEquals("Peter", child.getName());
        assertEquals(13, child.getAge());
        assertThrows(IllegalArgumentException.class, () -> new Person.Child("Peter", 16));
        assertThrows(IllegalArgumentException.class, () -> new Person.Person("Al", 20));
    }

    @Test
    public void zoo() {
        Zoo.Animal snake = new Zoo.Snake("Kaa");
        assertEquals("Kaa", snake.getName());
        assertTrue(snake instanceof Zoo.Reptile);
        assertTrue(new Zoo.Gorilla("King") instanceof Zoo.Mammal);
        assertTrue(new Zoo.Bear("Baloo") instanceof Zoo.Mammal);
        assertTrue(new Zoo.Lizard("Rex") instanceof Zoo.Reptile);
    }

    @Test
    public void playersAndMonsters() {
        PlayersAndMonsters.Hero hero = new PlayersAndMonsters.SoulMaster("Gosho", 10);
        assertTrue(hero instanceof PlayersAndMonsters.DarkWizard);
        assertTrue(new PlayersAndMonsters.BladeKnight("A", 1) instanceof PlayersAndMonsters.Knight);
        assertTrue(new PlayersAndMonsters.MuseElf("B", 2) instanceof PlayersAndMonsters.Elf);
        assertEquals("Type: PlayersAndMonsters.SoulMaster Username: Gosho Level: 10", hero.toString());
    }

    @Test
    public void needForSpeed() {
        NeedForSpeed.Vehicle car = new NeedForSpeed.SportCar(100, 300);
        assertEquals(10, car.getFuelConsumption(), 1e-9);
        car.drive(5);
        assertEquals(50, car.getFuel(), 1e-9);
        car.drive(10); // needs 100 fuel - not enough, nothing happens
        assertEquals(50, car.getFuel(), 1e-9);
        assertEquals(1.25, new NeedForSpeed.CrossMotorcycle(10, 50).getFuelConsumption(), 1e-9);
        assertEquals(8, new NeedForSpeed.RaceMotorcycle(10, 50).getFuelConsumption(), 1e-9);
        assertEquals(3, new NeedForSpeed.FamilyCar(10, 50).getFuelConsumption(), 1e-9);
    }

    @Test
    public void restaurant() {
        Restaurant.Coffee coffee = new Restaurant.Coffee("Espresso", 80);
        assertEquals(50, coffee.getMilliliters(), 1e-9);
        assertEquals(0, BigDecimal.valueOf(3.5).compareTo(coffee.getPrice()));
        assertTrue(coffee instanceof Restaurant.HotBeverage);
        Restaurant.Cake cake = new Restaurant.Cake("Garash");
        assertEquals(250, cake.getGrams(), 1e-9);
        assertEquals(1000, cake.getCalories(), 1e-9);
        assertTrue(new Restaurant.Salmon("Salmon", BigDecimal.TEN) instanceof Restaurant.MainDish);
        assertTrue(new Restaurant.Soup("Tarator", BigDecimal.ONE, 300) instanceof Restaurant.Starter);
    }

    @Test
    public void animals() throws Exception {
        assertEquals("Cat\nTom 12 Male\nMeow meow\nDog\nRex 132 Male\nWoof!",
                run(() -> Animals.Main.main(NO_ARGS), "Cat\nTom 12 Male\nDog\nRex 132 Male\nBeast!\n"));
        assertEquals("Frog\nKermit 12 Male\nRibbit", run(() -> Animals.Main.main(NO_ARGS), "Frog\nKermit 12 Male\nBeast!\n"));
        assertEquals("Invalid input!\nFrog\nFroakie 2 Male\nRibbit",
                run(() -> Animals.Main.main(NO_ARGS), "Frog\nFroakie -2 Male\nFrog\nFroakie 2 Male\nBeast!\n"));
    }
}
