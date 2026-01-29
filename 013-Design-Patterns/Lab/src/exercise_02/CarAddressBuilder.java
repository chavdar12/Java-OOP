package exercise_02;

public class CarAddressBuilder {

    private String city;
    private String withAddress;

    public CarAddressBuilder() {

    }

    public CarAddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CarAddressBuilder withAddress(String address) {
        this.withAddress = city;
        return this;
    }

    public String build() {

    }
}
