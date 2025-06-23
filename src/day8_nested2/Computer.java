package day8_nested2;

public class Computer {
    String model;
    static Computer instance;

    public Computer(String model) {
        this.model = model;
        instance = this;
    }

    public void showModel() {
        System.out.println("Computer model: " + model);
    }

    public static class CPU {
        int cores;

        public CPU(int cores) {
            this.cores = cores;
        }

        public void showSpec() {
            System.out.println("CPU cores: " + cores);
            System.out.println("Belongs to: " + Computer.instance.model);
        }
    }
}
