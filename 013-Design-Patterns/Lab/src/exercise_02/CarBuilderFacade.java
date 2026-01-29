package exercise_02;

public class CarBuilderFacade {
    protected Car car;

    public CarBuilderFacade() {
        this.car = new Car();
    }

    public Car build() {
        return this.car;
    }

    public CarInfoBuilder info() {
        return new CarInfoBuilder(this.car);
    }

    public CarAddressBuilder build() {
        return new CarAddressBuilder(car);
    }
}
