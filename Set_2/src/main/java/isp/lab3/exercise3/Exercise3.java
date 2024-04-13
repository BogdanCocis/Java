package isp.lab3.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        // Vehicul 1: Dacia Logan
        Vehicule vehiculeDacia = new Vehicule("Logan", "Facelift", 130, 'B');
        System.out.println(vehiculeDacia);

        // Vehicul 2: Mercedes-Benz S-Class
        Vehicule vehiculeMercedes = new Vehicule("Mercedes", "S-Class", 240, 'B');
        System.out.println(vehiculeMercedes);

        // Compare vehicule
        if (vehiculeDacia.equals(vehiculeMercedes))
            System.out.println("Dacia not eqals Mercedes :)");
        else
            System.out.println("The car are not eqals");

       if(Vehicule.displayNumberOfVehicles() == 0)
           System.out.println("No cars");
       else if (Vehicule.displayNumberOfVehicles() == 1)
           System.out.println("Only one car");

    }
}
