import java.util.Scanner;

public class Player {
  // Instance variables
  private String name;
  private int score;
  private boolean isBot;

  // Static Variable
  private static Scanner sc = new Scanner(System.in);

  // Constructor (Takes String name & boolean isBot)
  public Player(String name, boolean isBot)
  {
    this.name = name;
    this.score = 0;
    this.isBot = isBot;
  }

  // Takes player turn and checks for correct user input
  public int takeTurn()
  {

    
    int max = Board.getNumPieces() / 2;
    int userChoice;


    // Sets max to one if there is only 1 piece left
    if(Board.getNumPieces() == 1)
    {
      max = 1;
    }


    // Checks for valid input
    while(true)
    {
      // Try catch block to handle invalid input
      try {
        Board.type("\n" + this.getName() + " choose the # of marbles to take (" + 1 + " to " + max + "): ");
        userChoice = sc.nextInt();

        // Throws exception if userChoice is not in range
        if(userChoice > max || userChoice < 1)
        {
          System.out.println(0/0);
        }
        break;
      }
      catch(Exception t) {
        Board.type("\nSorry, but that was invalid\n");
        sc.nextLine();
      }
    }

    // Clears console and returns the user's choice
    System.out.print("\033[H\033[2J");
    System.out.flush();
    return userChoice;

  }

  // Uses algorithm(f(n+1)=2n+1) to find how many pieces to take to ensure a win.
  // Only loses if player goes first and knows algorithm, or if the bot's first 
  // play is on a target # & the player knows the algorithm.
  public int takeBotTurn()
  {
    // Returns one if there is only 1 piece left
    if(Board.getNumPieces() == 1)
    {
      return 1;
    }


    
    // Gets max value bot can take
    int maxVal = Board.getNumPieces() / 2;

    // Finds target (Target must be in reach)
    int target = 0;
    while(Board.getNumPieces() > (2*target + 1))
    {
      target = target*2 + 1;
    }

    // Decides how many pieces to take to get to the target value.
    // If not in reach, takes 1.
    int pieces;
    if(Board.getNumPieces() - target <= maxVal)
    {
      pieces = Board.getNumPieces() - target;
    }
    else
    {
      pieces = 1;
    }
    
    Board.type("\nBot took " + pieces);
    return pieces;  
  }

  // Gets name
  public String getName()
  {
    return name;
  }

  // Gets score
  public int getScore()
  {
    return score;
  }

  // Gets if player is bot
  public boolean getIsBot()
  {
    return isBot;
  }

  // increases player's score
  public void increaseScore()
  {
    score++;
  }
  
}