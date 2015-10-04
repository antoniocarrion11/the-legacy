//Antonio Carrion SER 221

#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

class Ship{
	
	public:
		//constructors
		Ship():m_name(""),m_yearBuilt(0){
			}
		
		Ship(string name, int yearBuilt){
			m_name = name;
			m_yearBuilt = yearBuilt;
		}
		
		//Mutators
		void setName(string name){
			m_name = name;
		}
		
		void setYearBuilt(int yearBuilt){
			m_yearBuilt = yearBuilt;
		}
		
		//Accesors
		string getName() const{
			return m_name;
		}
		
		int getYearBuilt() const{
			return m_yearBuilt;
		}
		
		//Print function
		void printShip(){
			cout << m_name << "\n";
			cout << m_yearBuilt << "\n";	
		}
		
	private:
		//Private Member variables
		string m_name;
		int m_yearBuilt;
};


class CruiseShip: public Ship{
	
	public:
		//Constructors
		CruiseShip():Ship(){
		}
		
		CruiseShip(string cruiseName, int cruiseYear, int passengers)
			:Ship(cruiseName, cruiseYear){
				m_passengers = passengers;
		}
		
		//Mutators
		void setPassengers(int passengers){
			m_passengers = passengers;
		}
	
		//accesors
		int getPassengers(){
			return m_passengers;
		}
		
		void printShip(){
			cout << "The name of this cruise ship is, \n";
			cout << Ship::getName() << "\n";
			cout <<"To this date it can hold ";
			cout << m_passengers << " passenger(s). \n";
			cout << "\n";
		}
		
	private:
		//Private member variables
		int m_passengers;
};

class CargoShip: public Ship{
	
	public:
		//Constructors
		CargoShip():Ship(),m_cargoCap(0){
		}
		
		CargoShip(string cargoName, int cargoYear, int cargoCap)
			:Ship(cargoName, cargoYear),m_cargoCap(cargoCap){
		}
		
		//Mutators
		void setCapacity(int cargoCap){
			m_cargoCap = cargoCap;
		}
	
		//accesors
		int getCapacity(){
			return m_cargoCap;
		}
		
		void printShip(){
			cout << "The name of this cargo ship is, \n";
			cout << Ship::getName() << "\n";
			cout <<"To this date it can hold ";
			cout << m_cargoCap << " ton(s) \n";
		}
	private:
		int m_cargoCap;
};

int main(){
  string cruiseName;
  int cruiseYear;
  int passengers;
  string cargoName;
  int cargoYear;
  int weight;
  
  //Cruise variable inputs
  cout << "Enter the name of the Cruise ship. \n";
  cin >> cruiseName;
  cout << "\n";
  cout << "Enter the year the boat was built. \n";
  cin >> cruiseYear;
  cout << "\n";
  cout << "How many passengers can be on the boat? \n";
  cin >> passengers;
  cout << "\n";
  
  CruiseShip cruise(cruiseName, cruiseYear, passengers);
  
  cruise.printShip();
  
  //cargo object created with default
  CargoShip cargo;
  
  //Cargo variable inputs
  cout << "Enter the name of the Cargo ship. \n";
  cin >> cargoName;
  cout << "\n";
  cout << "Enter the year the ship was built. \n";
  cin >> cargoYear;
  cout << "\n";
  cout << "How many tons can the ship hold? \n";
  cin >> weight;
  cout << "\n";
  
  //defining object variables
  cargo.setName(cargoName);
  cargo.setYearBuilt(cargoYear);
  cargo.setCapacity(weight);
  
  cargo.printShip();
  
  cin.get();
  return 0;                                                                                                                    
}
