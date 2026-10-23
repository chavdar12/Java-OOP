import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.boat.PowerBoat;
import models.boat.RowBoat;
import models.engine.JetEngine;
import models.race.Race;
import org.junit.Assert;
import org.junit.Test;

public class RaceTests {

    @Test
    public void addParticipantShouldAddBoat() throws Exception {
        Race race = new Race(1000, 10, 5, false);
        race.addParticipant(new RowBoat("Row", 80, 4));
        Assert.assertEquals(1, race.getParticipants().size());
    }

    @Test(expected = DuplicateModelException.class)
    public void addParticipantShouldRejectDuplicateModel() throws Exception {
        Race race = new Race(1000, 10, 5, false);
        race.addParticipant(new RowBoat("Row", 80, 4));
        race.addParticipant(new RowBoat("Row", 90, 2));
    }

    @Test(expected = ArgumentException.class)
    public void addParticipantShouldRejectMotorBoatsWhenNotAllowed() throws Exception {
        Race race = new Race(1000, 10, 5, false);
        JetEngine engine = new JetEngine("Jet", 100, 200);
        race.addParticipant(new PowerBoat("Power", 500, engine, engine));
    }

    @Test
    public void addParticipantShouldAcceptMotorBoatsWhenAllowed() throws Exception {
        Race race = new Race(1000, 10, 5, true);
        JetEngine engine = new JetEngine("Jet", 100, 200);
        race.addParticipant(new PowerBoat("Power", 500, engine, engine));
        Assert.assertEquals(1, race.getParticipants().size());
    }
}
