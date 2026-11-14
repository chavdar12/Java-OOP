import static org.junit.Assert.assertEquals;
import static support.Console.run;

import org.junit.Test;

public class WorkingWithAbstractionExerciseTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void cardSuit() throws Exception {
        assertEquals("Card Suits:\nOrdinal value: 0; Name value: CLUBS\nOrdinal value: 1; Name value: DIAMONDS\n"
                        + "Ordinal value: 2; Name value: HEARTS\nOrdinal value: 3; Name value: SPADES",
                run(() -> Cards.Main.main(NO_ARGS), "Card Suits\n"));
    }

    @Test
    public void cardRank() throws Exception {
        String output = run(() -> CardRank.Main.main(NO_ARGS), "Card Ranks\n");
        assertEquals("Card Ranks:", output.lines().findFirst().orElseThrow());
        assertEquals("Ordinal value: 12; Name value: KING", output.lines().reduce((a, b) -> b).orElseThrow());
        assertEquals(14, output.lines().count());
    }

    @Test
    public void cardsWithPower() throws Exception {
        assertEquals("Card name: TWO of CLUBS; Card power: 2", run(() -> CardsWithPower.Main.main(NO_ARGS), "TWO\nCLUBS\n"));
        assertEquals("Card name: ACE of SPADES; Card power: 53", run(() -> CardsWithPower.Main.main(NO_ARGS), "ACE\nSPADES\n"));
    }

    @Test
    public void trafficLights() throws Exception {
        assertEquals("YELLOW GREEN RED\nRED YELLOW GREEN\nGREEN RED YELLOW\nYELLOW GREEN RED",
                run(() -> TrafficLights.Main.main(NO_ARGS), "GREEN RED YELLOW\n4\n"));
    }

    @Test
    public void greedyTimes() throws Exception {
        assertEquals("<Gold> $28\n##Gold - 28\n<Gem> $16\n##Rubygem - 16\n<Cash> $9\n##USD - 9",
                run(() -> GreedyTimes.Main.main(NO_ARGS), "150\nGold 28 Rubygem 16 USD 9 GBP 8\n"));
    }
}
