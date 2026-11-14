import static org.junit.Assert.assertEquals;
import static support.Console.run;

import org.junit.Test;

public class EncapsulationExercisesTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void classBox() throws Exception {
        assertEquals("Surface Area - 52.00\nLateral Surface Area - 40.00\nVolume - 24.00",
                run(() -> ClassBox.Main.main(NO_ARGS), "2\n3\n4\n"));
        assertEquals("Surface Area - 30.20\nLateral Surface Area - 27.60\nVolume - 7.80",
                run(() -> ClassBox.Main.main(NO_ARGS), "1.3\n1\n6\n"));
    }

    @Test
    public void classBoxDataValidation() throws Exception {
        assertEquals("Width cannot be zero or negative.", run(() -> ClassBoxDataValidation.Main.main(NO_ARGS), "2\n-3\n4\n"));
        assertEquals("Surface Area - 52.00\nLateral Surface Area - 40.00\nVolume - 24.00",
                run(() -> ClassBoxDataValidation.Main.main(NO_ARGS), "2\n3\n4\n"));
    }

    @Test
    public void animalFarm() throws Exception {
        assertEquals("Chicken Chichi (age 10) can produce 1.00 eggs per day.", run(() -> AnimalFarm.Main.main(NO_ARGS), "Chichi\n10\n"));
        assertEquals("Age should be between 0 and 15.", run(() -> AnimalFarm.Main.main(NO_ARGS), "Chichi\n17\n"));
        assertEquals("Chicken Choko (age 6) can produce 1.00 eggs per day.", run(() -> AnimalFarm.Main.main(NO_ARGS), "Choko\n6\n"));
    }

    @Test
    public void shoppingSpree() throws Exception {
        assertEquals("Peter bought Bread\nGeorge bought Milk\nGeorge bought Milk\nPeter can't afford Milk\nPeter - Bread\nGeorge - Milk, Milk",
                run(() -> ShoppingSpree.Main.main(NO_ARGS),
                        "Peter=11;George=4\nBread=10;Milk=2\nPeter Bread\nGeorge Milk\nGeorge Milk\nPeter Milk\nEND\n"));
        assertEquals("Maria can't afford Coffee\nMaria - Nothing bought",
                run(() -> ShoppingSpree.Main.main(NO_ARGS), "Maria=0\nCoffee=2\nMaria Coffee\nEND\n"));
    }

    @Test
    public void pizzaCalories() throws Exception {
        assertEquals("Meatless - 370.00", run(() -> PizzaCalories.Main.main(NO_ARGS),
                "Pizza Meatless 2\nDough Wholegrain Crispy 100\nTopping Veggies 50\nTopping Cheese 50\nEND\n"));
        assertEquals("Number of toppings should be in range [0..10].", run(() -> PizzaCalories.Main.main(NO_ARGS),
                "Pizza Bulgarian 20\nDough Type500 Bulgarian 100\nTopping Cheese 50\nTopping Cheese 50\nTopping Salami 20\nTopping Meat 10\nEND\n"));
        assertEquals("Invalid type of dough.", run(() -> PizzaCalories.Main.main(NO_ARGS),
                "Pizza Bulgarian 2\nDough Type500 Bulgarian 100\nTopping Cheese 50\nTopping Cheese 50\nTopping Salami 20\nTopping Meat 10\nEND\n"));
    }

    @Test
    public void footballTeamGenerator() throws Exception {
        assertEquals("Arsenal - 81", run(() -> FootballTeamGenerator.Main.main(NO_ARGS),
                "Team;Arsenal\nAdd;Arsenal;Kieran_Gibbs;75;85;84;92;67\nAdd;Arsenal;Aaron_Ramsey;95;82;82;89;68\n"
                        + "Remove;Arsenal;Aaron_Ramsey\nRating;Arsenal\nEND\n"));
        assertEquals("Endurance should be between 0 and 100.\nPlayer Aaron_Ramsey is not in Arsenal team.\nArsenal - 81",
                run(() -> FootballTeamGenerator.Main.main(NO_ARGS),
                        "Team;Arsenal\nAdd;Arsenal;Kieran_Gibbs;75;85;84;92;67\nAdd;Arsenal;Aaron_Ramsey;195;82;82;89;68\n"
                                + "Remove;Arsenal;Aaron_Ramsey\nRating;Arsenal\nEND\n"));
        assertEquals("Arsenal - 0", run(() -> FootballTeamGenerator.Main.main(NO_ARGS), "Team;Arsenal\nRating;Arsenal\nEND\n"));
    }
}
