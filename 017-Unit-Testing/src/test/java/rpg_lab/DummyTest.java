package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DummyTest {
    private static final int BASE_HEALTH = 10;
    private static final int BASE_EXPERIENCE = 10;

    private Dummy dummy;

    private void setupAliveDummy() {
        this.dummy = new Dummy(BASE_HEALTH, BASE_EXPERIENCE);
    }

    private void setupDeadDummy() {
        this.dummy = new Dummy(-BASE_HEALTH, BASE_EXPERIENCE);
    }

    @Test
    public void dummyShouldLoseHealthWhenAttacked() {
        final int attack = 5;
        setupAliveDummy();
        dummy.takeAttack(attack);

        assertEquals(BASE_HEALTH - attack, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenAttackingDeadDummy() {
        final int attack = 5;
        setupDeadDummy();
        dummy.takeAttack(attack);

    }

    @Test
    public void shouldGiveExperienceWhenKilled() {
        setupDeadDummy();
        int actual = dummy.giveExperience();

        assertEquals(BASE_EXPERIENCE, this.dummy.giveExperience());

    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenGivingExperienceIfAlive() {
        setupAliveDummy();
        int actual = dummy.giveExperience();

    }
}
