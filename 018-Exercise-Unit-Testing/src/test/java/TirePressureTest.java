import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

public class TirePressureTest {

    @Test
    public void defaultAlarmValueOnCreationIsOff() {
        Alarm alarm = new Alarm(new Sensor());

        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void alarmValueShouldBeOnAfterCheckingSensorWithLowerBound() {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.5);

        Alarm alarm = new Alarm(sensor);

        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmValueShouldBeOnAfterCheckingSensorWithUpperBound() {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.01);

        Alarm alarm = new Alarm(sensor);

        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmValueShouldBeOffAfterCheckingSensorWithWithinBound() {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(17.01);

        Alarm alarm = new Alarm(sensor);

        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }
}
