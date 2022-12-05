import java.util.Scanner;

public class Game {
  // Instance variables
  private Player player1;
  private Player player2;

  // Static variables
  private static Scanner sc = new Scanner(System.in);

  // Constructor
  public Game()
  {
    // Gets  user 1 input
    Board.type("\nPlayer 1, what is your name? ");

    player1 = new Player(sc.nextLine(), false);
    Board.type("\nHello, " + player1.getName());
    // Times & Refresh console
    try{
      Thread.sleep(1000);
    }catch(InterruptedException e){
      Thread.currentThread().interrupt();
    }
    System.out.print("\033[H\033[2J");
    System.out.flush();


    // Determines if player 1 wants to play the computer or another person
    boolean isTrue;    
    while(true)
    {
      try {
        Board.type("\nDo you want to play against a bot? - true or false: ");
        isTrue = sc.nextBoolean();
        break;
      }
      catch(Exception e) {
        Board.type("\nThat was an invalid response");
        sc.nextLine();
      }
    }
    // Creates either a computer Player object, or a actual Player object
    if(isTrue)
    {
      player2 = new Player("Computer", isTrue);
    }
    else
    {
      Board.type("\nPlayer 2, what is your name? ");
      sc.nextLine();
      player2 = new Player(sc.nextLine(), isTrue);
      Board.type("\nHello, " + player2.getName());
    }
    // Times & Refresh console
    try{
      Thread.sleep(1000);
    }catch(InterruptedException ex){
      Thread.currentThread().interrupt();
    }
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  // Plays the game of nin
  public void play()
  {
    // Randomizes who goes first
    int turn = (int)(Math.random() * 2 + 1);
    // while loop to play until 1 piece is left on the board
    while(Board.getNumPieces() > 0)
    {
      // Prints # of pieces
      Board.type("\nCurrent Pieces: " + Board.getNumPieces());
      // Determines who turn it is depending on turn % 2
      if(turn % 2 == 0)
      {
        Board.removePieces(player1.takeTurn());
      }
      else
      {
        // If statement to determine if to do manual or bot turn
        if(player2.getIsBot())
        {
          Board.removePieces(player2.takeBotTurn());
        }
        else
        {
          Board.removePieces(player2.takeTurn());
        }
      }
      // Increments turn to change who goes next
      turn++;
    }
    
    

    // Decides who takes the last piece and loses
    if(turn%2 == 0)
    {
      Board.type("\n" + player1.getName() + " Wins!");
      player1.increaseScore();
    }
    else
    {
      Board.type("\n" + player2.getName() + " Wins!");
      player2.increaseScore();
    }

    // Calls playAgain() & refreshes everything if they want to
    if(playAgain())
    {
      Board.populate();
      play();
    }
    else
    {
      // Goodbye message for when ending game
      Board.type("Thank you for playing!");
    }
  }

  // Private method which returns true or false if the player wants to play again
  private boolean playAgain()
  {
    boolean isTrue;
    Board.type("\nCurrent Score: \n" + player1.getName() + ": " + player1.getScore() + " | " + player2.getName() + ": " + player2.getScore());

    // While loop + try block to handle correct user input
    while(true)
    {
      try {
        Board.type("\nDo you want to play again? - true or false: ");
        isTrue = sc.nextBoolean();
        break;
      }
      catch(Exception e) {
        Board.type("\nThat was an invalid response");
        sc.nextLine();
      }
    }
    // Refreshes board
    System.out.print("\033[H\033[2J");
    System.out.flush();

    // returns if the player wants to play again
    return isTrue;
  }
  
}