	In clasa Location avem atributele necesare pentru caracterizarea locatiei: tip , coordX, coordY, nume si un indexLocatie. 
Dupa se poate observa prezenta Set-urilor si Get-urilor pentru fiecare atribut, Dupa ele am Constructorul default, iar dupa am aplicat
 methoda ToString prin Override pentru afisare;
	In clasa Road aven atributele necesare, imediat se gaseste Constructorul(in constructor am initializat un 
numarLocatiePornire, numarLocatieSosire si indexStrada, ce ma vor ajuta in aplicarea DFS-ului), care contine si functia SetLength,(ea verifica daca lungimea strazii este mai mare decat
distanta euclediana dintre 2 locatii, in cazul in care ea este mai mica, aceasta va printa o eroare pe ecran ), 
pe urma se regasesc Functii-le Get Si Set pentru fiecare atribut, iar la final se regaseste Override-ul pentru 
afisare;
	Fisierul ClasaRoad este un fisier de tip Enum Clas, am vrut sa vad cum functioneaza el defapt :)
	Clasele City,Airports si GasStation sunt sublcase derivate din clasa mama Location ce aduce elemente specifice in plus pentru fiecare.
	In clasa Problem avem initial construit un vector pentru locatii si pentru strazi. Functia addLocation introduce locatiile in vector si 
le verifica sa vada daca nu exista deja acea locatie. Functia addRoad face acceasi chestie plus functia addEdge care ma va ajuta la dfs, ea practic
adauga in lista de adiacenta strazile cu locatiile respective. Am facut un Override pe toString sa ma ajute la verificare/afisare, Functia valid 
verifica daca problema este valida( vede daca exista cel putin o strada si 2 locatii). Functia Graph ma ajuta la dfs, creeaza o lista de
adiacenta si un vector visited pentru fiecare locati.Functia addEdge este pusa in addRoad. Functia dfs este o parcurgere a listei de adiacenta
si in momentul in care locatia de pornire este adiacenta cu locatia de sosire, afiseaza faptul ca este gasita (Found);
	In main am denumit niste locatii si strazi pentru ilustrarea functionalitatii proiectului.
	
	
											Va multumesc!