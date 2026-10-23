import hardwareComponents.Hardware;
import hardwareComponents.HeavyHardware;
import org.junit.Assert;
import org.junit.Test;
import softwareComponents.LightSoftware;

public class HardwareTests {

    @Test
    public void addSoftwareShouldConsumeResources() {
        Hardware hardware = new HeavyHardware("HDD", 100, 100);
        hardware.addSoftware(new LightSoftware("Word", 10, 10));

        Assert.assertEquals(1, hardware.getSoftwareComponentsCount());
        Assert.assertEquals(15, hardware.getUsedCapacity());
        Assert.assertEquals(5, hardware.getUsedMemory());
    }

    @Test
    public void addingDuplicateSoftwareShouldNotConsumeResourcesTwice() {
        Hardware hardware = new HeavyHardware("HDD", 100, 100);
        hardware.addSoftware(new LightSoftware("Word", 10, 10));
        hardware.addSoftware(new LightSoftware("Word", 10, 10));

        Assert.assertEquals(1, hardware.getSoftwareComponentsCount());
        Assert.assertEquals(15, hardware.getUsedCapacity());
        Assert.assertEquals(5, hardware.getUsedMemory());
    }

    @Test
    public void addSoftwareShouldBeIgnoredWithoutFreeCapacity() {
        Hardware hardware = new HeavyHardware("HDD", 1, 100);
        hardware.addSoftware(new LightSoftware("Word", 10, 10));

        Assert.assertEquals(0, hardware.getSoftwareComponentsCount());
        Assert.assertEquals(0, hardware.getUsedCapacity());
    }

    @Test
    public void releaseSoftwareShouldFreeResources() {
        Hardware hardware = new HeavyHardware("HDD", 100, 100);
        hardware.addSoftware(new LightSoftware("Word", 10, 10));
        hardware.releaseSoftware("Word");

        Assert.assertEquals(0, hardware.getSoftwareComponentsCount());
        Assert.assertEquals(0, hardware.getUsedCapacity());
        Assert.assertEquals(0, hardware.getUsedMemory());
    }
}
