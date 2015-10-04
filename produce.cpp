//Antonio Carrion SER 221

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <time.h>

using namespace std;

class BoxOfProduce{
	
	public:
	//Max Value for Array
		static const int m_MAX = 3;
		
	//No arg Default Constructor
		BoxOfProduce();
		
	//arg constructor
		BoxOfProduce(string box[]){
			for(int i = 0; i < m_MAX; i++)
				this->m_box[i] = box[i];
		};
		
	//Mutators
		void fillBox(string produce[], string box[]);
		void outputList(string box[]);
		void substitution(string produce[], string box[]);
		void reset(string box[]);

	private:
	//Private Member Variables
		string m_box[m_MAX];
};

//Main Function Prototypes
int random();
void fillProduce(string produce[]);
void outputProduce(string produce[]);

//Main function
int main(){
	string produce[5];
	string box[BoxOfProduce::m_MAX];
	string condition = "y";
	
	//seed srand
	srand(time(0));
	
	
	//Create first array of Produce and output
	fillProduce(produce);
	
	while(condition == "y" || condition == "Y"){
		
		cout << "Your shipment of produce includes \n";
		outputProduce(produce);
	
		//Create Box Object and call member functions
		BoxOfProduce boxObj(box);
		boxObj.fillBox(produce, box);
		boxObj.outputList(box);
		boxObj.substitution(produce, box);
		boxObj.outputList(box);
		
		cout << "Would You like to create another box of produce? \n";
		cin >> condition;
		if(condition == "y" || condition == "Y"){
			boxObj.reset(box);
			cout << "\n";
			continue;
		}
	}
	cin.get();
	return 0;
}

//Functions
void fillProduce(string produce[]){
	produce[0] = "Broccoli";
	produce[1] = "Tomato";
	produce[2] = "Kiwi";
	produce[3] = "Kale";
	produce[4] = "Tomatillo";
}

void outputProduce(string produce[]){
	
	for(int i = 0; i < 5; i++){
		cout << i << " " << produce[i];
		cout << "\n";
	}
	
	cout << "\n";
}

//random function
int random(){
	
	int j;
	j = ((rand() % (4-0 + 0)) + 0);

	return j;
}

//Mutator for Box Object
void BoxOfProduce::fillBox(string produce[], string box[]){
	
	int j;
	
	for (int i = 0; i < BoxOfProduce::m_MAX; i++){
		j = random();
		box[i] = produce[j];
		this->m_box[i] = box[i];
	}
}

//Output for Box Object
void BoxOfProduce::outputList(string box[]){
	
	cout << "Your box already holds these bundles of produce: \n";
	for(int i = 0; i < BoxOfProduce::m_MAX; i++)
		cout << this->m_box[i] << "\n";
}

void BoxOfProduce::substitution(string produce[], string box[]){
	
	string condition = "y";
	int i;
	
	cout << "Would you like to substitute the first bundle in your Box? (Y)es or (N)o? \n";
	cin >> condition;
	if (condition == "y" || condition == "Y"){
		cout << "With Which bundle? Please enter a number between 0-4 \n";
		outputProduce(produce);
		cin >> i;
		box[0] = produce[i];
		this->m_box[0] = box[0];
	}
	
	cout << "Would you like to substitute the second bundle in your Box? (Y)es or (N)o? \n";
	cin >> condition;
	if (condition == "y" || condition == "Y"){
		cout << "With Which bundle? Please enter a number between 0-4 \n";
		outputProduce(produce);
		cin >> i;
		box[1] = produce[i];
		this->m_box[1] = box[1];
	}
	
	cout << "Would you like to substitute the third bundle in your Box? (Y)es or (N)o? \n";
	cin >> condition;
	if (condition == "y" || condition == "Y"){
		cout << "With Which bundle? Please enter a number between 0-4 \n";
		outputProduce(produce);
		cin >> i;
		box[2] = produce[i];
		this->m_box[2] = box[2];
	}
}
	
void BoxOfProduce::reset(string box[]){
	for(int i = 0; i < BoxOfProduce::m_MAX; i++){
		box[i] = "";
		this->m_box[i] = box[i];
	}
}


