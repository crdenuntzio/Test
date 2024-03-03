#include <iostream>

using namespace std;

int* vectorPret;
string* vectorProdus;
string* vectorProdusePretMare;

int initializareLungimeLista() {
	int lungimeLista;
	
	cout << "Introduceti lungimea listei de cumparaturi: ";
	cin >> lungimeLista;
	
	if (lungimeLista) {
		return lungimeLista;
	}

	cout << "Lista nu poate sa fie goala!" << endl;
	initializareLungimeLista();
}

void initializareVector(int pozitie, int pret) {
	vectorPret[pozitie] = pret;
}

void initializareVector(int pozitie, string produs) {
	vectorProdus[pozitie] = produs;
}

void initializareLista(int lungimeLista) {
	int pret;
	string produs;

	cout << "Introduceti valorile listei" << endl;

	for (int i = 0; i < lungimeLista; i++) {
		cout << "Nume produs " << i + 1 << ": ";
		cin >> produs;
		initializareVector(i, produs);
		cout << "Nume pret " << i + 1 << ": ";
		cin >> pret;
		initializareVector(i, pret);
	}
}

void printLista(int lungimeLista) {
	cout << "Lista: ";

	for (int i = 0; i < lungimeLista; i++) {
		cout << "[" << i + 1 << "]: Nume produs: " << vectorProdus[i] << ", pret: " << vectorPret[i] << "; ";
	}
	cout << endl;
}

int sumaPreturilor(int lungimeLista) {
	int suma = 0;

	for (int i = 0; i < lungimeLista; i++) {
		suma += vectorPret[i];
	}

	return suma;
}

int sumaPreturilorDenumireLunga(int lungimeDenumire, int lungimeLista) {
	int suma = 0;

	for (int i = 0; i < lungimeLista; i++) {
		if (vectorProdus[i].size() > lungimeDenumire) {
			suma += vectorPret[i];
		}
	}

	return suma;
}

int nrProduseCuPretMaiMicDecat(int pretReferinta, int lungimeLista) {
	int numarProduse = 0;

	for (int i = 0; i < lungimeLista; i++) {
		if (vectorPret[i] < pretReferinta) {
			numarProduse ++;
		}
	}

	return numarProduse;
}

void printProduseCuPretMare(int lungimeLista) {
	cout << "Produsele cu pretul mai mare decat valoarea primita sunt: ";

	for (int i = 0; i < lungimeLista; i++) {
		cout << vectorProdusePretMare[i] << "; ";
	}
	cout << endl;
}

string* vectorProduseCuPretMare(int pretReferinta, int lungimeLista) {
	int lungimeVector = 0;
	int* vectorPozitii = new int[lungimeLista];

	for (int i = 0; i < lungimeLista; i++) {
		if (vectorPret[i] > pretReferinta) {
			vectorPozitii[lungimeVector] = i;
			lungimeVector++;
		}
	}

	if (lungimeVector) {
		vectorProdusePretMare = new string[lungimeVector];

		for (int i = 0; i < lungimeVector; i++) {
			vectorProdusePretMare[i] = vectorProdus[vectorPozitii[i]];
		}

		printProduseCuPretMare(lungimeVector);
	}
	else {
		cout << "Nici un produs nu are pretul mai mare decat valoare primita." << endl;
		vectorProdusePretMare = NULL;
	}

	delete []vectorPozitii;
	
	return vectorProdusePretMare;
}

/* Aceasta functie este utila in momentul in care vrem sa aflam numele celui mai scump produs din lista de cumparaturi */
string celMaiScumpProdus(int lungimeLista) {
	int indexComparatie = 0;

	for (int i = 1; i <= lungimeLista; i++) {
		if (vectorPret[i - 1] < vectorPret[i]) {
			indexComparatie = i;
		}
	}

	return vectorProdus[indexComparatie];
}

/* Aceasta metoda poate fi folosita pentru a marca un produs ca fiind adaugat in cos */
void produsAdaugat(int lungimeLista, string numeProdusCumparat) {
	for (int i = 1; i <= lungimeLista; i++) {
		if (vectorProdus[i] == numeProdusCumparat) {
			vectorProdus[i] += " - Adaugat";
		}
	}
}

void main() {
	
	int lungimeLista = initializareLungimeLista();

	vectorPret = new int[lungimeLista];
	vectorProdus = new string[lungimeLista];

	initializareLista(lungimeLista);

	printLista(lungimeLista);

	/* Ex.1 Suma preturi */
	cout << "Suma tuturor preturilor din lista: " << sumaPreturilor(lungimeLista) << endl;

	/* Ex.2 Suma preturi pentru produse cu o denumire mai lunga decat o anumita valoare */
	int nrCaractereDenumireLunga;
	cout << "Introduceti numarul de caractere pentru compararea lungimii numelor de produs: ";
	cin >> nrCaractereDenumireLunga;

	cout << "Suma preturilor care au o denumire mai lunga decat valoare introdusa anterior este: " << 
		sumaPreturilorDenumireLunga(nrCaractereDenumireLunga, lungimeLista) << endl;

	/* Ex.3 Nr de produse cu pretul mai mic decat o anumita valoare */
	int pretReferinta;
	cout << "Introduceti pretul de referinta pentru numarul de preturi mici: ";
	cin >> pretReferinta;

	cout << "Numarul de produse care au o valoare mai mica decat valoare introdusa anterior este: " <<
		nrProduseCuPretMaiMicDecat(pretReferinta, lungimeLista) << endl;

	/* Ex.4 Vector peoduse cu pretul mai mare decat o anumita valoare */
	int pretMare;
	cout << "Introduceti pretul de referinta pentru vectorul cu produse: ";
	cin >> pretMare;

	vectorProduseCuPretMare(pretMare, lungimeLista);

	/* Ex.5 Cel mai scump produs */
	cout << "Produsul cu pretul cel mai mare este: " << celMaiScumpProdus(lungimeLista) << endl;

	/* Ex.6 Produs adaugat in cos */
	string numeProdusCumparat;
	
	cout << "Introduceti numele produsului cumparat: ";
	cin >> numeProdusCumparat;
	
	produsAdaugat(lungimeLista, numeProdusCumparat);
	
	printLista(lungimeLista);

	delete []vectorPret;
	delete []vectorProdus;
	delete []vectorProdusePretMare;
}
