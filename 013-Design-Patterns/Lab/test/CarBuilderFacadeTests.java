import exercise_02.Car;
import exercise_02.CarBuilderFacade;
import org.junit.Assert;
import org.junit.Test;

public class CarBuilderFacadeTests {

    @Test
    public void builderShouldSetAllFields() {
        Car car = new CarBuilderFacade()
                .info().withType("BMW").withColor("Black").withNumberOfDoors(5)
                .address().withCity("Sofia").withAddress("Main 1")
                .build();

        Assert.assertEquals("BMW", car.getType());
        Assert.assertEquals("Black", car.getColor());
        Assert.assertEquals(5, car.getNumberOfDoors());
        Assert.assertEquals("Sofia", car.getCity());
        Assert.assertEquals("Main 1", car.getAddress());
    }
}
