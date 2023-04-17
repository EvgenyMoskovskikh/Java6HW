
public class Laptop {
    private String model;
    private int memory;
    private int hardDrive;
    private String operatingSystem;
    private String color;
    private int price;

    public Laptop(String model, int memory, int hardDrive, String operatingSystem, String color, int price) {
        this.model = model;
        this.memory = memory;
        this.hardDrive = hardDrive;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getMemory() {
        return memory;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ноутбук:\n" +
                "\tМодель: " + model + ";\n" +
                "\tОЗУ: " + memory + ";\n" +
                "\tОбъем жесткого диска: " + hardDrive + ";\n" +
                "\tОперационная система: " + operatingSystem + ";\n" +
                "\tЦвет: " + color + ";\n" +
                "\tЦена: " + price + ";\n";
    }

}