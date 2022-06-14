package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeroTest {

    private static final int BASE_EXPERIENCE = 10;

    @Test
    public void shouldReceiveExperienceIfDummyDiesDuringAttack() {
        Weapon axe = new Axe(10, 10);
        Target dummy = new Dummy(10, 10);

        Hero hero = new Hero("Gosho", BASE_EXPERIENCE, axe);
        hero.attack(dummy);

        assertEquals(BASE_EXPERIENCE + 10, hero.getExperience());
    }

    @Test
    public void shouldReceiveLootAfterKillingTarget() {
        Axe mockAxe = Mockito.mock(Axe.class);
        Hero hero = new Hero("Gosho", 0, mockAxe);


        Target mockTarget = Mockito.mock(Target.class);
        Mockito.when(mockTarget.getLoot()).thenReturn(mockAxe);
        Mockito.when(mockTarget.isDead()).thenReturn(true);

        hero.attack(mockTarget);

        assertEquals(hero.getInventory().size(), 1);


        assertTrue(hero.getInventory().contains(mockAxe));
    }
}
