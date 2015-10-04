//Antonio Carrion SER 221

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <time.h>

using namespace std;


int humanTurn(int humanTotal);
int computerTurn();
int rollDice();
                        
int main(){
	//Declare Variables
	int humanTotal = 0;
	int computerTotal = 0;
	int returnScore = 0;
	int done = 0;
	
	//seed srand
	srand(time(0));
	
	
	//Loop Program
	while (done == 0){
		
		//Call Human Turn
		returnScore = humanTurn(humanTotal);
		humanTotal = humanTotal + returnScore;
		std::cout << " player total is " << humanTotal << "\n";
		
		//Win Result
		if(humanTotal >= 100){
			std::cout << " You Won!! Congrats!";
			break;
		}
		
		//Call Computer Turn
		computerTotal = computerTotal + computerTurn();
		std::cout << " computer total is " << computerTotal << "\n";
		std::cout << " \n";
		
		//Lose Result
		if (computerTotal >= 100){
			std::cout << " Computer Total is \n" << computerTotal;
			std::cout << " Sorry! You Lose! ";
			done += 1;
		}
		
	}
	cin.get();                          
	return 0;                           
}

//Human Turn function
int humanTurn(int humanTotal){
	
	//Declare function Variables
	int done = 0;
	int humanRoll;
	int currentScore = 0;
	string input;
	
	//Loop function
	while(done == 0){
		std::cout << " Your total score is " << humanTotal << "\n";
		std::cout << " If you hold now your grand total will be " << humanTotal + currentScore << "\n";
		std::cout << " Would you like to <R>oll? or would you like to <H>old? ";
		std::cin >> input;
		std::cout << " \n";
		
		//Input Roll
		if (input == "r" || input == "R"){
			humanRoll = rollDice();
			std::cout << " Your roll is " << humanRoll << " \n";
			
			if(humanRoll == 1){
				std::cout << " You rolled a 1, sorry you lose all the points for this turn. \n";
				currentScore = 0;
				done += 1;
			}
			
			else{
				currentScore += humanRoll;
				std::cout << " Your accumulated points are " << currentScore << " \n";
			}
		}
		
		//Input Hold
		else if (input == "h" || input == "H"){
			std::cout << " Your accumulated points are " << currentScore << " \n";
			done += 1;
		}
	}
	return currentScore;
}

//Computer Turn function
int computerTurn(){
	int done = 0;
	int computerScore;
	int computerRoll;
	
	//loop
	cout << " Computer's turn \n";
	while(done == 0){
		
		//Computer Roll
		if(computerScore < 20){
			computerRoll = rollDice();
			
			cout << computerRoll << "\n";
			if(computerRoll == 1){
				computerScore = 0;
				done += 1;
			}
			else{
				computerScore += computerRoll;
				continue;
			}
		}
		
		//Computer Hold
		else if(computerScore >= 20)
			done += 1;
	}
	return computerScore;
}

//Roll Dice function
int rollDice(){
	int diceRoll;
	
	diceRoll = ((rand() % (6-1 + 1)) + 1);

	return diceRoll;
}
