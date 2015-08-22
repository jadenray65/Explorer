
/**
 * Cataloging information on items of value sentimental and monetary.
 * 
 * @author (JC Cheek) 
 */
public class Treasure extends Object120
{
    /**What the object is called*/
    String name;
    
    /**How the object can be described, concisely.*/
    String desc;
    
    /**How heavy in pounds*/
    double weight;
    
    /**URL of the item's picture */
    String url;
    
    /**URL used if no URL given*/
    static final String NO_URL = "http://ru-itec120.pbwiki.com/f/Question_mark.svg.png";
    
    /**Constructor initializing all fields*/
    Treasure(String _name, String _desc, double _weight, String _url){
        
        this.name = _name;
        this.desc = _desc;
        this.weight = _weight;
        if(equals(_url, "")){
            this.url = NO_URL;
        }
        else{
            this.url = _url;
        }
        
    }
    
    /**Creates short pretty text representation for the object.
     * @param Treasure The object with name and weight used in text representation
     * @return String Pretty text representation of name and weight
     */
    static String toPretty(Treasure treasure){
        
        return toUpperCase(treasure.name) + " is " + treasure.weight + " pounds.";
        
    }
    
    /**Is this Treasure lint?
     * @param Treasure The treasure being inspected.
     * @return boolean True if object is lint.
     */
    static boolean isLint(Treasure treasure){
        
        return(equals(toLowerCase(treasure.name), "lint") && treasure.weight == 0.0);
        
    }
    
    /** Is thisTres better than thatTreas? Better meaning weighs less but is not lint
     * @param Treasure Treasure being compared
     * @param Treasure Treasure being compared against
     * @return boolean True if the Treasure being compared is better than the Treasure being compared against.
     */
    static boolean isBetter(Treasure thisTreas, Treasure thatTreas){
        
        return(!isLint(thisTreas) && thisTreas.weight < thatTreas.weight);
        
        
    }
    
    /**Create a counterfeit version of a Treasure
     * @param Treasure Treasure that is used as a model for the duplicate
     * @return Treasure The new Treasure that is a counterfeit duplicate.
     */
    static Treasure counterf(Treasure treasure){
        
        return new Treasure(treasure.name, substring(treasure.desc,0,length(treasure.desc)-1) 
            + ",but feels a bit chintzy" 
            + substring(treasure.desc,length(treasure.desc)-1,length(treasure.desc)), (treasure.weight/2.0), treasure.url);
        
    }
    
    /** test functions*/ 
    static void testFuns(){
        
        //test toPretty
        
        Treasure picString = new Treasure("Piece of String", "Long piece of silver string.", .1, "picture.png");
        Treasure noPicLint = new Treasure("lint", "ugly and filthy.", 0.0, "");
        
        System.out.println("Actual: " + toPretty(picString));
        System.out.println("Desired: PIECE OF STRING is .1 pounds." );
        System.out.println("Actual: " + toPretty(noPicLint));
        System.out.println("Desired: LINT is 0.0 pounds." );
        
        //test isLint
        
        System.out.println("Actual: " + isLint(picString));
        System.out.println("Desired: false" );
        System.out.println("Actual: " + isLint(noPicLint));
        System.out.println("Desired: true" );
        
        //test isBetter
        
        System.out.println("Actual: " + isBetter(picString, noPicLint));
        System.out.println("Desired: true" );
        System.out.println("Actual: " + isBetter(noPicLint, picString));
        System.out.println("Desired: PIECE OF STRING is .1 pounds." );
        
        //test counterf
        
        System.out.println("Actual: " + counterf(picString));
        System.out.println("Desired: Piece of String Long piece of silver string, but feels a bit chintzy. .05 picture.png");
        System.out.println("Actual: " + toPretty(noPicLint));
        System.out.println("lint ugly and filthy, but feels a bit chintzy. 0.0 http://ru-itec120.pbwiki.com/f/Question_mark.svg.png");
        
        
    }
    
    /**
     * 9 The purpose of a constructor is to initialize all variables
     * 10
     * a 3 and 4
     * b 8
     * c 6
     * d Glarkzle glar;
     * e glar = new Glarkzle(2, 15);
     * f System.out.println("Your order ID:" + placeOrder(glar, 100000));
     * 11
     * a f
     * b f 
     * c f (we have so far but there are other ways, but the constructor has nothing)
     */
    
}
