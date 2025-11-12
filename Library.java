/* This is a stub for the Library class */
import java.util.Hashtable;
public class Library extends Building{

private Hashtable<String, Boolean> collection;
private boolean hasElevator;

  /**
   * constructor
   * @param name name of the library
   * @param address adress of the library
   * @param nFloors number of floors in the library
   * @param hasElevator if the building has an elevator or not
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  /**
   * method to add a title to the collection
   * @param title title of the book being added
   */
  public void addTitle(String title){
    if(collection.contains(title)){
      System.out.println("This title is already in the collection");
    } else {
      collection.put(title,true);
    }
  }

  /**
   * method to remove a title from the collection
   * @param title title of the book being removed
   * @return returns the title of the book
   */
  public String removeTitle(String title){
    if(collection.contains(title)){
      collection.remove(title,true);
    } else {
      System.out.println("This title is not in the collection");

    }
    return title;
  }

  /**
   * method to check out a book
   * @param title title of the book being checked out
   */
  public void checkOut(String title){
    if(collection.contains(title)){
      collection.put(title,false);
    }
  }

  /**
   * method to return a book
   * @param title title of the book being returned
   */
  public void returnBook(String title){
    if(collection.contains(title)){
      collection.put(title,true);
    }
  }

  /**
   * method to check if a book is in the collection
   * @param title title of the book being looked for
   * @return returns true/false if the book is/isn't in the collection
   */
  public boolean containsTitle(String title){
    if(collection.contains(title)){
        return true;
    } else {
      return false;
    }
  }

  /**
   * method to check if a book is available to check out
   * @param title title of the book being checked
   * @return returns true/false if the book is/isn't available
   */
  public boolean isAvailable(String title){
    if (collection.containsKey(title)) { 
      Boolean value = collection.get(title);
      if (value == true) { 
          return true;
      }
    }
    return false;
  }

  /**
   * method to print the collection
   */
  public void printCollection(){
    System.out.println("Collection: \n ------------");
    System.out.println(collection);
  }

  public void showOptions(){
    super.showOptions();
    System.out.println(" + addTitle(t) \n + removeTitle(t) \n + checkoutTitle(t) \n + returnBook(t) \n + containsTitle(t) \n + isAvailable(t) \n + printCollection()");
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
    Library myLibrary = new Library("Neilson Library", "Seeyle Lawn", 4, true);
    myLibrary.showOptions();
  }
}