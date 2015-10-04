//Antonio Carrion SER 221

#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

class Rational{
		
	public:
		
	//Constructors
		Rational();
		
		Rational(int wholeNumber){
			this -> wholeNumber = wholeNumber/1;
		};
		
		Rational(int numerator, int denominator){
			this-> numerator = numerator;
			this -> denominator = denominator;
		};
		
	//Mutator Prototypes
		void setNumerator(int numerator);
		void setDenominator(int denominator);
		void normalize();
		
	//Accessor Prototypes 
		int getNumerator();
		int getDenominator();
		
	//Overload Operators 
		//Boolean Operators
		bool operator ==(const Rational& Rational1){
			return (numerator*Rational1.denominator == denominator*Rational1.numerator);
		};
		
		bool operator >=(const Rational& Rational1){
			return (numerator*Rational1.denominator >= denominator*Rational1.numerator);
		};
		
		bool operator <=(const Rational& Rational1){
			return (numerator*Rational1.denominator <= denominator*Rational1.numerator);
		};
		
		bool operator <(const Rational& Rational1){
			return (numerator*Rational1.denominator < denominator*Rational1.numerator);
		};
		
		bool operator >(const Rational& Rational1){
			return (numerator*Rational1.denominator > denominator*Rational1.numerator);
		};
		
		//Addition and subtraction operators
		Rational operator +(const Rational& Rational1){
			int num;
			int numerator2;
			int denom;
			
			if (denominator == Rational1.denominator){
				num = numerator + Rational1.numerator;
				denom = denominator;
			}
			if (denominator != Rational1.denominator){
				num = numerator * Rational1.denominator;
				numerator2 = Rational1.numerator * denominator;
				denom = denominator * Rational1.denominator;
				num = num + numerator2;
			}
			
			return Rational(num, denom);
		};
		
		Rational operator -(const Rational& Rational1){
			int num;
			int numerator2;
			int denom;
			
			if (denominator == Rational1.denominator){
				num = numerator - Rational1.numerator;
				denom = denominator;
			}
			if (denominator != Rational1.denominator){
				num = numerator * Rational1.denominator;
				numerator2 = Rational1.numerator * denominator;
				denom = denominator * Rational1.denominator;
				num = num - numerator2;
			}
			
			return Rational(num, denom);
		};
		
		//Multiplication and Division Operator
		Rational operator *(Rational& Rational1){
			
			int newNum = numerator * Rational1.numerator;
			int newDenom = denominator * Rational1.denominator;
			return Rational(newNum, newDenom);
		};
		
		Rational operator /(Rational& Rational1){
			
			int newNum = numerator * Rational1.denominator;
			int newDenom = denominator * Rational1.numerator;
			return Rational(newNum, newDenom);
		}
		
		//Chevron Operators
		friend istream& operator >>(istream& inputStream, Rational& Rational1){
			cout << "Please Enter Your Numerator \n";
			inputStream >> Rational1.numerator;
			cout << "Please Enter Your Denominator \n";
			inputStream >> Rational1.denominator;
			return inputStream;
		};
		
		friend ostream& operator <<(ostream& outputStream, const Rational& Rational1){
			outputStream << Rational1.numerator << "/" << Rational1.denominator;
			return outputStream;
		};
		
	private:
		int numerator;
		int denominator;
		int wholeNumber;
};

int main(){
	//Declare Variables
	int num1;
	int num2;
	int denom1;
	int denom2; 
	
	//Constructors
	Rational fraction1(num1, denom1);
	Rational fraction2(num2, denom2);
	
	//Chevron operator test
	cin >> fraction1;
	cout << " \n";
	cin >> fraction2;
	cout << "\n";
	
	//Addition Subtraction Division and Multiplication
	cout << "Subtraction \n";
	cout << fraction1 << " - " << fraction2 << "\n";
	cout << fraction1 - fraction2 << "\n";
	cout << " \n";
	cout << "Addition \n";
	cout << fraction1 << " + " << fraction2 << "\n";
	cout << fraction1 + fraction2 << "\n";
	cout << " \n"; 
	cout << "Multiplication \n";
	cout << fraction1 << " * " << fraction2 << "\n";
	cout << fraction1 * fraction2 << "\n";
	cout << "\n";
	cout << "Division \n";
	cout << fraction1 << " / " << fraction2 << "\n";
	cout << fraction1 / fraction2 << "\n";
	cout << "\n";
		
	//Normalization
	cout << "Simplification fraction 1 \n";
	fraction1.normalize();
	cout << "Simplification fraction 2 \n";
	fraction2.normalize();
	cout << "\n";
	
	//Boolean Test
	cout << "Equals operator \n";
	cout << fraction1 << " == " << fraction2 << "\n";
	cout << (fraction1 == fraction2) << "\n";
	cout << "\n";
	cout << "Greater Than \n";
	cout << fraction1 << " > " << fraction2 << "\n";
	cout << (fraction1 > fraction2 ) << "\n";
	cout << "\n";
	cout << "Greater Than or Equal to \n";
	cout << fraction1 << " >= " << fraction2 << "\n";
	cout << (fraction1 >= fraction2) << "\n";
	cout << "\n";
	cout << "Less Than \n";
	cout << fraction1 << " < " << fraction2 << "\n";
	cout << (fraction1 < fraction2) << "\n";
	cout << "\n";
	cout << "Less Than or Equals to \n";
	cout << fraction1 << " <= " << fraction2 << "\n";
	cout << (fraction1 <= fraction2) << "\n";
	
	cin.get();
	return 0;
}

//Mutators
void Rational::setNumerator(int numerator){
	this->numerator = numerator;
}

void Rational::setDenominator(int denominator){
	this->denominator = denominator;
}

void Rational::normalize(){
	int remainder;
	int factor;

	for(int i = numerator; i > 0; i--){
		remainder = numerator%i;
		if (remainder == 0){
			remainder = denominator%i;
			if (remainder == 0){
				factor = i;
				numerator = numerator/factor;
				denominator = denominator/factor;
				i = 0;
				
			}
		}
	}
	if (denominator < 0){
		denominator = -denominator;
		numerator = -numerator;
	}
	cout <<numerator << " "<< denominator << "\n";
}

//Accessors
int Rational::getNumerator(){
	return numerator;
}

int Rational::getDenominator(){
	return denominator;
}
