package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTest {
    private static final int BASE_ATTACK = 50;
    private static final int BASE_DURABILITY = 1;
    private static final int BASE_HEALTH = 10;
    private static final int BASE_EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setup() {
        this.axe = new Axe(BASE_ATTACK, BASE_DURABILITY);
        this.dummy = new Dummy(BASE_HEALTH, BASE_HEALTH);
    }

    @Test
    public void shouldLoseDurabilityAfterAttack() {

        axe.attack(dummy);

        assertEquals(BASE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWithNegativeDurability() {

        this.axe = new Axe(BASE_ATTACK, 0);
        axe.attack(dummy);

    }
}
