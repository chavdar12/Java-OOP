package exercise_02;

public class CarAddressBuilder extends CarBuilderFacade {

    public CarAddressBuilder(Car car) {
        super.car = car;
    }

    public CarAddressBuilder withCity(String city) {
        this.car.setCity(city);
        return this;
    }

    public CarAddressBuilder withAddress(String address) {
        this.car.setAddress(address);
        return this;
    }
}
