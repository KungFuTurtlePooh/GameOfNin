public class Board {
  // Static Variable
  private static int pieces;

  // Populates board with a number between 10-50
  public static void populate()
  {
    pieces = (int)(Math.random() * 41 + 10);
  }

  // Gets current number of pieces
  public static int getNumPieces()
  {
    return pieces;
  }

  // Removes "num" pieces from the board
  public static void removePieces(int num)
  {
    pieces -= num;
  }

  // Typewriter effect using Thread.sleep to time 45 miliseconds between
  // each print of each character of "str"
  public static void type(String str)
  {
    for(int i = 0; i < str.length(); i++){
      System.out.print(str.charAt(i));
      try{
          Thread.sleep(45);
      }catch(InterruptedException ex){
          Thread.currentThread().interrupt();
      }
    }
  }
  
}