/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * constructor
     * @param name name of the building
     * @param address address of the building
     * @param nFloors number of floors
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 30;
        this.nSugarPackets = 30;
        this.nCreams = 30;
        this.nCups = 30;

        System.out.println("You have built a cafe: ☕");
    }

    //overloaded constructor
    public Cafe(String name, String address){
        this(name, address, 1);
        System.out.println("You have built a default cafe: ☕");
    }

    /**
     * method to sell coffee
     * @param size size of the coffee in ounces
     * @param nSugarPackets number of sugar packets used
     * @param nCreams number of creams used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1){
            
            System.out.println("Not enough supplies. Restocking...");
            restock(20, 20, 20, 20);
        } else {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;

            System.out.println("Sold a coffee");
        }
    }

    /**
     * method to restock the cafe
     * @param nCoffeeOunces amount of coffee restocked
     * @param nSugarPackets number of sugar packets restocked
     * @param nCreams number of creams restocked
     * @param nCups number of cups restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Cafe restocked!");
    } 

    // overloaded method
    private void restock(){
        this.nCoffeeOunces += 10;
        this.nSugarPackets += 10;
        this.nCreams += 10;
        this.nCreams += 10;
        this.nCups += 10;
        System.out.println("Default amounts restocked");
    }

    public void showOptions(){
        super.showOptions();
        System.out.println(" + sellCoffee(int n, int n, int n) \n + restock(int n, int n, int n, int n)");
    }

    public void goToFloor(int floorNum){
        super.goToFloor(floorNum);
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass", "Neilson Library", 1);
        myCafe.showOptions();
        myCafe.enter();
        myCafe.goToFloor(-1);
    }
}
