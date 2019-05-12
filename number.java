
/**
 * Write a description of class number here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class number
{
    int myInt;
    boolean myAmPrime = true;
    public number(int x){
        myInt = x;
        for(int i = 2; i < x;i++){
            if(x % i == 0){ 
            myAmPrime = false;
            i = x;
        }
        }
    }
    
    public boolean amPrime(){
        return myAmPrime;
    }
    public String getStr(){
        return myInt + "";
    }
}
