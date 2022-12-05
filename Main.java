/*
2.5.11 Game of Nim Project
Author: Brian Hoang, Jaden Tagulinao
Date: Dec 5, 2022
Course: APCSA

Description: This program simulates the Game of Nim, where the person
who takes the last piece of the pile loses. Has an algorithmic AI to
win for most cases.

Preconditions: User inputs name & if they want to play against a bot.
User then inputs # of pieces to take, ranging from 1 to half the pile.

Postconditions: Updates # of pieces in board & prints who wins after
one piece is left. Then gets if player wants to play again & count
score.
*****************/

class Main {
  public static void main(String[] args) {
    
    Board.type("Welcome to the Game of Nim!");

    Board.populate(); // static method call
    
    Game nim = new Game(); 
    
    nim.play();
  }
}