/* This is a stub for the House class */
import java.util.ArrayList;
public class House extends Building {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * constructor
   * @param name name of house
   * @param address address of house
   * @param nFloors number of floors in the house
   * @param hasDiningRoom if the house has a dining hall
   * @param hasElevator if the building has an elevator or not
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  //overloaded constructor only hardcoding nFloors
  public House(String name, String address, boolean hasDiningRoom, boolean hasElevator){
    this(name,address, 1, hasDiningRoom, hasElevator);
    System.out.println("You have built a default house: 🏠");
  }

  //overloaded constructor using only name and address
  public House(String name, String address){
    this(name,address,1,false,false);
  }

  /**
   * method if the hosue has a dining room
   * @return returns true/false if the house has/doesn't have a dining room
   */
  public boolean hasDiningRoom(){
    if (this.hasDiningRoom = true){
      return true;
    } else {
      return false;
    }
  }

  /**
   * method for the number of residents
   * @return the amount of residents in the house
   */
  public int nResidents(){
    int nResidents = residents.size();
    return nResidents;
  }

  /**
   * method to move a student in
   * @param s the student moving into the house
   */
  public void moveIn(Student s){
    if (residents.contains(s)){
      System.out.println("This Student is already moved in");
    } else {
      residents.add(s);
    }
  }

  /**
   * method to move a student out
   * @param s the student moving out
   * @return returns the name of the student moving out
   */
  public Student moveOut(Student s){
    if (residents.contains(s)){
      residents.remove(s);
    } else {
      System.out.println("This Student is already moved in out");
    }
    return s;
  }

  /**
   * method to check if someone is a resident
   * @param s the studnet being checked
   * @return returns true/false if the student is/isn't a resident in the house
   */
  public boolean isResident(Student s){
    if (residents.contains(s)){
      System.out.println("This student is a resident");
      return true;
    } else {
      System.out.println("This student is not a resident");
      return false;
    }
  }

  public void showOptions(){
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + nResidence \n + moveIn(s) \n + moveOut(s) \n + isResident(s)");
  }

  public void goToFloor(int floorNum) {
    if (hasElevator == true) {
        super.goToFloor(floorNum);
    } else {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors ) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
        }
        //Math.abs checks floorNum regardless of if the user is going upstairs or downstairs
        if (Math.abs(floorNum - this.activeFloor) > 1) {
            throw new RuntimeException("Invalid because the House does not have an Elevator and therefore cannot skip floors");
        } else {
            System.out.println("You are now on floor #" + floorNum + " of " + this.name);
            this.activeFloor = floorNum;
        } 
    }
}

  public static void main(String[] args) {
    House myHouse = new House("Albright House", "7 Bedford Terrace", 4, false, false);
    myHouse.showOptions();
    myHouse.enter();
    System.out.println(myHouse.hasElevator);
    myHouse.goToFloor(2);
  }
}