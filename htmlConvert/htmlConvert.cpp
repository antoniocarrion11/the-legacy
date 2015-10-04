//Antonio Carrion SER 221

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>

using namespace std;

int main(){
	//Input output stream objects
	ifstream input;
	ofstream output;
	
	//Opening Files
	input.open("Test.txt");
	output.open("htmlConvert.txt");
	
	//Variable to read in next character in
	//File
	char ch;
	
	//Check if Input file opened
	if(input.fail()){
		cout << " File Not opened";
		exit(1);
	}
	
	output << "<PRE> \n";
	
	//Read in next character
	input.get(ch);
	
	//Check if end of file
	while(!input.eof()){
		
		//Checks if character is chevron
		if(ch == '<'){
			output.put('&');
			output.put('l');
			output.put('t');
			output.put(';');
		}
		else if (ch == '>'){
			output.put('&');
			output.put('g');
			output.put('t');
			output.put(';');
		}
		
		//If not puts character in output file
		else{
			output.put(ch);
		}
		
		//Read in next character
		input.get(ch);
	}
	output << "\n</PRE>";
	
	//Close file
	input.close();
	output.close();
}
