package Hangman.java;
public class Hangman6 {
	
	//variables
	private StringBuffer wordToSee;
    private String wordToGuess;
    private char letter;

    public Hangman6(){
        wordToSee = new StringBuffer();
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public String getWordToSee() {
        return wordToSee.toString();
    }

    public void convertWord(){
        for(int i = 0; i < wordToGuess.length(); i++){
            wordToSee.append("*");//method that converts word to guess to ******
        }
    }

    public void guessingWord(){
        for(int i = 0; i < wordToGuess.length(); i++){
            if (letter == wordToGuess.charAt(i)){
                wordToSee.setCharAt(i,letter);//method for guessing random word
            }
        }
    }
	
}
