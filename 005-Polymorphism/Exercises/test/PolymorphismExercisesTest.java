import static org.junit.Assert.assertEquals;
import static support.Console.run;

import org.junit.Test;

public class PolymorphismExercisesTest {
    private static final String[] NO_ARGS = new String[0];

    @Test
    public void vehicles() throws Exception {
        assertEquals("Car travelled 9 km\nCar needs refueling\nTruck travelled 10 km\nCar: 54.20\nTruck: 75.00",
                run(() -> Vehicles.Main.main(NO_ARGS),
                        "Car 15 0.3\nTruck 100 0.9\n4\nDrive Car 9\nDrive Car 30\nRefuel Car 50\nDrive Truck 10\n"));
        assertEquals("Car needs refueling\nCar travelled 13.5 km\nTruck needs refueling\nCar: 113.05\nTruck: 109.13",
                run(() -> Vehicles.Main.main(NO_ARGS), "Car 30.4 0.4\nTruck 99.34 0.9\n5\nDrive Car 500\nDrive Car 13.5\n"
                        + "Refuel Truck 10.300\nDrive Truck 56.2\nRefuel Car 100.2\n"));
    }

    @Test
    public void vehiclesExtension() throws Exception {
        assertEquals("Fuel must be a positive number\nFuel must be a positive number\nCannot fit fuel in tank\n"
                        + "Bus travelled 10 km\nCannot fit fuel in tank\nBus needs refueling\nCannot fit fuel in tank\n"
                        + "Car: 40.00\nTruck: 100.00\nBus: 23.00",
                run(() -> VehiclesExtension.Main.main(NO_ARGS), "Car 30 0.04 70\nTruck 100 0.5 300\nBus 40 0.3 150\n8\n"
                        + "Refuel Car -10\nRefuel Truck 0\nRefuel Car 10\nRefuel Car 300\nDrive Bus 10\nRefuel Bus 1000\n"
                        + "DriveEmpty Bus 100\nRefuel Truck 1000\n"));
    }

    @Test
    public void wildFarm() throws Exception {
        assertEquals("Meowwww\nCat[Gray, Persian, 1.1, Home, 4]",
                run(() -> Wildfarm.Main.main(NO_ARGS), "Cat Gray 1.1 Home Persian\nVegetable 4\nEnd\n"));
        assertEquals("ROAAR!!!\nTigers are not eating that type of food!\nTiger[Tom, 167.7, Asia, 0]",
                run(() -> Wildfarm.Main.main(NO_ARGS), "Tiger Tom 167.7 Asia\nVegetable 1\nEnd\n"));
        assertEquals("Zs\nZebra[Jaguar, 500, Africa, 150]",
                run(() -> Wildfarm.Main.main(NO_ARGS), "Zebra Jaguar 500 Africa\nVegetable 150\nEnd\n"));
        assertEquals("SQUEEEAAAK!\nMouse[Jerry, 0.5, Anywhere, 0]",
                run(() -> Wildfarm.Main.main(NO_ARGS), "Mouse Jerry 0.5 Anywhere\nVegetable 0\nEnd\n"));
    }

    @Test
    public void word() throws Exception {
        assertEquals("sexom3. t", run(() -> Word.Main.main(NO_ARGS), "som3. text\ncut 1 7\npaste 3 4\nexit\n"));
        assertEquals("dabc E", run(() -> Word.Main.main(NO_ARGS), "abc d e\ncut 0 4\nuppercase 1 3\npaste 1 2\nexit\n"));
    }

    @Test
    public void calculator() throws Exception {
        assertEquals("72", run(() -> Calculator.Main.main(NO_ARGS), "1 * 2 * 3 ms * 4 * mr / 2 end\n"));
        assertEquals("8", run(() -> Calculator.Main.main(NO_ARGS), "12 / 3 ms / 2 ms * 5 mr * mr end\n"));
    }
}
