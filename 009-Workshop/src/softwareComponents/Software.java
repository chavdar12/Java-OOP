package softwareComponents;

public abstract class Software {
    private final String name;
    private final String type;
    private int capacityConsumption;
    private int memoryConsumption;

    public Software(String name, String type, int capacityConsumption, int memoryConsumption) {
        this.name = name;
        this.type = type;
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    public String getName() {
        return name;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    public String getType() {
        return type;
    }
}
