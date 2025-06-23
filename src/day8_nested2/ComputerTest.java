package day8_nested2;

public class ComputerTest {
    public static void main(String[] args) {
        Computer com = new Computer("MiroBook Pro");

        Computer.CPU cpu = new Computer.CPU(8);
        cpu.showSpec();
    }
}
