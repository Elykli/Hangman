package Hangman.java;
import java.util.*;

public class Hangman6App {

	public static void main(String[] args) {
		String [] words = {"monkey", "hippopocampus", "rhinoceros", "elephant","tiger", "wallaby", 
							"panther", "lion", "zebra", "hyena", "gorilla", "donkey", "moose"};
		//variables
		int lives;
		String randomWord;
		char letter;
		char answer;
		boolean letterGuessed;
		boolean letterApplied;
		String usedLetters;
		StringBuffer sb = new StringBuffer();//object of type StringBuffer to create modifiable String objects
		       
		System.out.println("Welcome to Hangman game! You have to guess an animal! ");
		System.out.println();
		        
		        do {
		            lives = 6;
		            Scanner sc = new Scanner(System.in);
		            Hangman6 word = new Hangman6();

		            randomWord = words[(int) (Math.random()*words.length)];//picking a random word from String array
		            word.setWordToGuess(randomWord);
		            word.convertWord();

		            usedLetters = " ";
		            String wordToSee = word.getWordToSee();
		            System.out.println("You've got " + lives + " lives.");
		            System.out.println("Animal to guess: " + wordToSee);
		            

		            do {
		                 System.out.println("Enter a letter: ");
		                 letter = sc.next().charAt(0);
		                 letter = Character.toLowerCase(letter);
		                 word.setLetter(letter);
		                 word.guessingWord();
		                 wordToSee = word.getWordToSee();
		                 System.out.println("Animal: " + wordToSee);

		                 letterApplied = usedLetters.contains(String.valueOf(letter));
		                    if(!letterApplied){
		                        usedLetters = String.valueOf(sb.append(letter).append(" "));
		                        System.out.println("Letter`s used: " + sb.toString());
		                    }else{
		                        System.out.println("Letter`s already used!");
		                    }

		                    letterGuessed = randomWord.contains(String.valueOf(letter));
		                    if (!letterGuessed && !letterApplied) {
		                        lives--;
		                    }
		                    if (lives == 6)
				                System.out.println("\t----\n\t|  |\n\t|\n\t|\n\t|\n\t|\n\t|\n\t|\n\t---");
				            else if (lives == 5)
				                System.out.println("\t----\n\t|  |\n\t|  @\n\t|\n\t|\n\t|\n\t|\n\t|\n\t---");
				            else if (lives == 4)
				                System.out.println("\t----\n\t|  |\n\t|  @\n\t| /\n\t|\n\t|\n\t|\n\t|\n\t---");
				            else if (lives == 3)
				                System.out.println("\t----\n\t|  |\n\t|  @\n\t| / \\\n\t|\n\t|\n\t|\n\t|\n\t---");
				            else if (lives == 2)
				                System.out.println("\t----\n\t|  |\n\t|  @\n\t| /|\\\n\t|  |\n\t|\n\t|\n\t|\n\t---");
				            else if (lives == 1)
				                System.out.println("\t----\n\t|  |\n\t|  @\n\t| /|\\\n\t|  |\n\t| /\n\t|\n\t|\n\t---");
				            else if (lives == 0)
				                System.out.println("\t----\n\t|  |\n\t|  @\n\t| /|\\\n\t|  |\n\t| / \\\n\t|\n\t|\n\t---");
		                    
		                    System.out.println("Lives: " + lives);
		                    System.out.println("###################");
		                    System.out.println();


		                } while (lives > 0 && wordToSee.contains("*")) ;

		   
		            if (lives == 0) {
		                System.out.println("Game Over! You didn`t guess the animal: " + randomWord);
		                } else {
		                System.out.println("You Win!");     
		                }

		            System.out.println("Do you want to play again? (y/n)");
		            answer = sc.next().toLowerCase().charAt(0);
		            sb.setLength(0);
		        }while(answer == 'y');
	
		}//main
    }//class

