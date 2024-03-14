package isp.lab3.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        // Vehicle 1: Dacia Logan
        Vehicule vehiculeDacia = new Vehicule();
        vehiculeDacia.setModel("Logan");
        vehiculeDacia.setType("Facelift");
        vehiculeDacia.setSpeed(130);
        vehiculeDacia.setFuelType('B');
        System.out.println(vehiculeDacia);

        // Vehicule Mercedez Benz:
        Vehicule vehiculeMercedez = new Vehicule();
        vehiculeMercedez.setModel("Mercedez");
        vehiculeMercedez.setType("S-Class");
        vehiculeMercedez.setSpeed(240);
        vehiculeMercedez.setFuelType('B');
        System.out.println(vehiculeMercedez);
    }
}
