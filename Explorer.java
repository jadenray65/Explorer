
/**
 * Write a description of class Explorer here.
 * 
 * @author JC Cheek 
 */
public class Explorer
{
    /** The input scanner*/    
    static final java.util.Scanner SCAN = new java.util.Scanner(System.in);
    
    /**The name of our brave adventurer*/
    String name;
    
    /**The status of our brave adventurer */
    String status;
    
    /**Do they want to retired*/
    boolean isRetired;
    
    /**How hungry are they? 0 for full, 100 for near death, >100 for dead */
    int hunger;
    
   public static void main(){
       System.out.println("What is the name of your brave adventurer? ");
       String nombre = SCAN.next();
       Explorer user = createExplorer(nombre);
       String cmd;
       
       while(!user.isRetired){
           System.out.println("What do you want to do?" );
           cmd = SCAN.next();
           user.handleCmd(cmd);
           System.out.println(user.status);
           
        }
       System.out.println("After a long, adventurous journey, you are finally home.");
       
    }
    
    
    /**Explorer constructor that takes in a name only and returns an Explorer.
     * @param String The name of the explorer
     */
    Explorer(String name){
       
        this.name = name;
        this.status = "Ready to take on the world!";
        this.hunger = 0;
        this.isRetired = false;
        
        
    }
    /** Explorer constructore that takes in a name and creates an Explorer.
     * @param String Name of the Explorer
     */ 
     static Explorer createExplorer(String name){
        
        return new Explorer(name);
        
    }
    
    /**Compare two Explorers and returns whether they are the same.
     * @param Explorer The Explorer being compared against.
     * @return boolean True if they are the same, false if they are not.
     */
    boolean isEqual(Explorer other){
        
        return(assertEqual(this.name, other.name).equals("Match!") &&
            assertEqual(this.status, other.status).equals("Match!") &&
            assertEqual(this.getHunger(), other.hunger).equals("Match!")&&
            assertEqual(this.isRetired, other.isRetired).equals("Match!"));           
    }
    
    
    /** Create an easy to read text representation of a student object
     * @return String The easy to read text representation of the students information
     */
    String toPretty(){
        
        return "Explorer's name: " +this.name
            +" Explorer's stauts: " +this.status
            +" Explorer's hunger level: " +this.getHunger()
            +" Is the explorer willing to retire?: " +this.isRetired;
        
    }
    
    /**Make an Explorer eat. Lower the hunger value and set a new status
     */
    void eat(){
        if(this.getHunger() <=10){
            this.hunger = 0;
        }
        else{
            this.hunger -= (this.getHunger()/2);
        }
        this.setStatus("Ate some cool mushrooms I found! This place is awesome -- what was that?"
           + "I think I saw a monster!?!"); 
    }
    
    /**Return the amount of hunger for an Explorer
     * @return int The amount of hunger the explorer has
     */
    int getHunger(){
        return this.hunger;
        
    }
    
    /**Return the status of an Explorer
     * @return String the Status of an Explorer
     */
    String getStatus(){
        
        return this.status;
        
    }
    
    /**Change the status of the explorer
     * @param String The new status
     */
    void setStatus(String status){
        
        this.status = status;
    }
    
    void getHungry(){
        
        this.hunger += 10;
        
        if(this.getHunger() >=30 && this.getHunger() < 50){
            
            this.setStatus("I could use a snack.");
        }
        else if(this.getHunger() >=50 && this.getHunger() < 70){
            
            this.setStatus("Hey, it's lunchtime, isn't it?");
        }
        else if(this.getHunger() >=70){
            
            this.setStatus("I'm amount to die, I'm so hungry. Feed me!" 
                +" Hunger level: " +this.getHunger()+ "/100");
         }
        else{
            
            this.setStatus("Ready to adventure!");
        }     
    }
    
    void look(){
        
        this.setStatus("There's nothing interesting there.");
    }
    
    void grab(){
        
        this.setStatus("There is nothing to grab.");
        
    }
    
    void quit(){
        
        this.setStatus("My adventuring days are done. Time to settle down.");
        this.isRetired = true;
    }
    
    void help(){
        
        this.setStatus("I know how to look, grab, eat, quit and help");
    }
    
    void handleCmd(String cmd){
        
        if(cmd.equals("look")){
            
            this.look();
            
        }
        else if(cmd.equals("grab")){
            
            this.grab();
        }
        else if(cmd.equals("eat")){
            
            this.eat();
        }
        else if(cmd.equals("wait")){
            
            this.getHungry();
        }
        else if(cmd.equals("help")){
            
            this.help();
        }
        else if(cmd.equals("quit")){
            
            this.quit();
        }
        else{
            
            System.out.println("I am not familiar with " +cmd+ ".");
            this.help();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    //---------------------------------TEST FUNCTIONS---------------------------------------------//
    
   /** If two booleans aren't equal, print an error message.
     * Intended for use as a test-helper.
     * @param act The actual boolean returned by a test call.
     * @param exp The expected boolean to be returned by a test call.
     */
    static void assertEqualB(boolean act, boolean exp) {
      if (act==exp) {
        System.out.println("(test passed)");
      }
      else {
        System.out.println( "Actual: " + act + "\nExpect: " + exp );
      }
    }
    
    
    /**Compare two Explorers and returns error if they are not the same.
     * @param Explorer The Explorer being compared against.
     * @return boolean True if they are the same, false if they are not.
     */
    void isEqualError(Explorer other){
        
        if(!this.isEqual(other)){
            
            System.err.print("Explorers are not equal.");
        }
    }
 
    
     /** Helper function for isEqual()
   *  Print a message to if not equal (and otherwise, 
   *  print message indication that the test case passed,
   *  so that we have some confidence that the test actually ran).
   * @param actual The actual result, from calling some function.
   * @param desired The result we desire, if the function is working correctly.
   */
    static String assertEqual( Object actual, Object desired ) {
    if (actual.equals(desired)) {
        return"Match!";
    }
    else{
        return "Pupil's result: " + actual.toString() + "Other pupil's result: " + desired.toString();
    }
  }
  
  /** If two Strings aren't equal, print an error message.
     * Intended for use as a test-helper.
     * @param act The actual String returned by a test call.
     * @param exp The expected String to be returned by a test call.
     */
    static void assertES(String act, String exp) {
      if (act.equals(exp)) {
        System.out.println("(test passed)");
      }
      else {
        System.out.println( "Actual: " + act + "\nExpect: " + exp );
      }
    }
    
    /** If two ints aren't equal, print an error message.
     * Intended for use as a test-helper.
     * @param act The actual int returned by a test call.
     * @param exp The expected int to be returned by a test call.
     */
    static void assertEI(int act, int exp) {
      if (act==exp) {
        System.out.println("(test passed)");
      }
      else {
        System.out.println( "Actual: " + act + "\nExpect: " + exp );
      }
    }
  
       
  static void testIsEqual(){
      
      Explorer milo = new Explorer("Milo");
      Explorer indiana = new Explorer("Indiana");
      Explorer thatch = new Explorer("Milo");
      
      assertEqualB(milo.isEqual(indiana), false);
      assertEqualB(indiana.isEqual(milo), false);
      assertEqualB(thatch.isEqual(milo), true);
      
    }
    
  static void testToPretty(){
      
      Explorer milo = new Explorer("Milo");
      Explorer indiana = new Explorer("Indiana");
      Explorer thatch = new Explorer("Milo");
      
      assertES(milo.toPretty(), "Explorer's name: " +milo.name
            +" Explorer's stauts: " +milo.status
            +" Explorer's hunger level: " +milo.hunger
            +" Is the explorer willing to retire?: " +milo.isRetired);
            
      assertES(indiana.toPretty(), "Explorer's name: " +indiana.name
            +" Explorer's stauts: " +indiana.status
            +" Explorer's hunger level: " +indiana.hunger
            +" Is the explorer willing to retire?: " +indiana.isRetired);
      
      
    }
  
  static void testConstructors(){
      Explorer milo = new Explorer("Milo");
      Explorer indiana = new Explorer("Indiana");
      Explorer thatch = new Explorer("Milo");
      
      milo.isEqualError(indiana);
      milo.isEqualError(thatch);
      thatch.isEqualError(indiana);
    }
    
    static void testEat(){
        
        Explorer milo = new Explorer("Milo");
        
        milo.hunger = 50;
        milo.eat();
        assertEI(milo.getHunger(), 25);
        assertES(milo.getStatus(), "Ate some cool mushrooms I found! This place is awesome -- what was that?"
           + "I think I saw a monster!?!");
        
        milo.hunger = 51;
        milo.eat();
        assertEI(milo.getHunger(), 26);
        assertES(milo.getStatus(), "Ate some cool mushrooms I found! This place is awesome -- what was that?"
           + "I think I saw a monster!?!");
        
        milo.hunger = 10;
        milo.eat();
        assertEI(milo.getHunger(), 0);
        assertES(milo.getStatus(), "Ate some cool mushrooms I found! This place is awesome -- what was that?"
           + "I think I saw a monster!?!");
        
    }
    
    static void testGetHungry(){
        
        Explorer milo = new Explorer("Milo");
        
        milo.hunger = 10;
        
        milo.getHungry();
        assertEI(milo.getHunger(), 20);
        assertES(milo.getStatus(), "Ready to adventure!");
        
        milo.getHungry();
        assertEI(milo.getHunger(), 30);
        assertES(milo.getStatus(), "I could use a snack.");
        
        milo.hunger = 50;
        milo.getHungry();
        assertEI(milo.getHunger(), 60);
        assertES(milo.getStatus(), "Hey, it's lunchtime, isn't it?");
        
        milo.getHungry();
        assertEI(milo.getHunger(), 70);
        assertES(milo.getStatus(), "I'm amount to die, I'm so hungry. Feed me!" 
                +" Hunger level: 70/100");
        
    }
}
    

