/*
 * Ulam Spiral maker! this is just the front end. the int[][] spiral array will become a 
 *  "number"[][] type array. This "number type will simply be a place to hold data on wheater 
 *      or not a number is prime or not.
 *      
 *      another layer on top of all of this will be a bit of animation, as prime numbers will
 *          slowly blink back and forth. Why? Just so you can see the number underneath
 * 
 */
public class ulamCreator{
    number[][] spiral;  
    //int[][] wheel = {{1,0},{0,-1},{-1,0},{0,1}};    //Representation of ESWN.
    //int[][] wheel = {{-1,0},{0,1},{1,0},{0,-1}};
    int[][] wheel = {{0,1},{1,0},{0,-1},{-1,0}}; 
    int sideLength = 60;         //makes printing easier later
 public ulamCreator(int n) {
     //number nu = new number();
     //sideLength = (int ) Math.sqrt(n) + 1;
     spiral = new number[sideLength][sideLength];
     int[] coord = {sideLength/2,sideLength/2};
     
     spiral[coord[0]][coord[1]] =new number(1);
     
     int stepCounter = 1;
     int wheelCounter = 0;
     
     int NumberAdded = 1;
     while(NumberAdded <= n){         
         //n -= 1;
         for(int i = 0; i < 2; i++){
             for(int j = 0; j < stepCounter; j++){
               NumberAdded++;
                coord[0] = coord[0] + wheel[wheelCounter][0];
                coord[1] = coord[1] + wheel[wheelCounter][1];
               spiral[coord[0]][coord[1]] = new number(NumberAdded);
//printSpiral();
                }
                
                wheelCounter = stepUp(wheelCounter);
            }
            stepCounter++;
                 
         
         
         
        }
     
     printSpiral();
    }
public int stepUp(int w){
  if(w == 3) 
        w = 0;
  else
      w++;
  return w;
}
/*
 * Basic 2d array printer
 * needs some string formatting work. Maybe a logical system to expand place values 
 * just kidding, 3 - 4 places max
 * 
 */
public void printSpiral(){
    String text = "";
    for(int i = 0; i < sideLength; i++) {
        for (int j = 0; j < sideLength; j++) {
            //text += spiral[i][j] + " ";
            if(spiral[i][j] == null){
                text += String.format("%1$4s"," ");
            }
            else
             text += String.format("%1$4s",spiral[i][j].getStr());    //change the 1$_num_s to change max length
            //ring.format("%1$"+length+ "s", string);
        }
        text += "\n";
    }
    System.out.println(text);
}
public void printSpiralBlockPrimes(){
    String text = "";
    for(int i = 0; i < sideLength; i++) {
        for (int j = 0; j < sideLength; j++) {
            //text += spiral[i][j] + " ";
            if(spiral[i][j] == null){
                text += String.format("%1$4s"," ");
            }
            else if (spiral[i][j].amPrime()){
               text +=   String.format("%1$4s","|#|");
               //text +=   String.format("%1$4s",'|' + spiral[i][j].getStr()+ '|');
            }
            else
             text += String.format("%1$4s",spiral[i][j].getStr());    //change the 1$_num_s to change max length
            //ring.format("%1$"+length+ "s", string);
        }
        text += "\n";
    }
    System.out.println(text);
}
public void printOnlyPrimes(){
    String text = "";
    for(int i = 0; i < sideLength; i++) {
        for (int j = 0; j < sideLength; j++) {
            //text += spiral[i][j] + " ";
            if(spiral[i][j] == null){
                text += String.format("%1$4s"," ");
            }
            else if (spiral[i][j].amPrime()){
               text +=   String.format("%1$4s",spiral[i][j].getStr());
               //text +=   String.format("%1$4s",'|' + spiral[i][j].getStr()+ '|');
            }
            else
             text += String.format("%1$4s"," ");    //change the 1$_num_s to change max length
            //ring.format("%1$"+length+ "s", string);
        }
        text += "\n";
    }
    System.out.println(text);
    
}
public void printWheel(){
    for(int i = 0; i < 4; i++){
        System.out.println(wheel[i][0] + " " + wheel[i][1]);
    }
}
public void doublePrint(){
 for(;;){
    printSpiral();
     try
    {
      Thread.sleep(1024L);            //this is rendering everything at ~15 fps
    }
    catch (InterruptedException ex)
    {
      Thread.currentThread().interrupt();
    }
   printSpiralBlockPrimes();
      try
    {
      Thread.sleep(1024L);            //this is rendering everything at ~15 fps
    }
    catch (InterruptedException ex)
    {
      Thread.currentThread().interrupt();
    }
    }
}
}