In clasa interface Node am methoda care obtine numele unui obiect ori din clasa Person ori din clasa Company.
In clasa Company, i-am pus implement Node, si Comparable<Company>, il utilizez pentru a ordona fiecare obiect de tip Company, in clasa se mai regasesc 
	functiile default set get pentru nume si constructorul. De asemenea se regaseste functia compareTo ce ordoneaza obiectele. Aici am
	adaugat doar HashMap-ul pentru relationships.
In clasa Person, i-am pus implement Node, si Comparable<Person>, il utilizez pentru a ordona fiecare obiect de tip Person, in clasa se mai regasesc 
	functiile default set get pentru nume si constructorul. De asemenea se regaseste functia compareTo ce ordoneaza obiectele. Am adaugat si
	HashMap-ul pentru relationship cu functiile addRelationship ce adauga nodul in HashMap si dupa set, si get-ul basic. Am adaugat si 
	ziua de nastere pentru clasa Person.
In clasa Designer ce extinde Person contine precum caracterisca speciala un String ce reprezinta exact firma pe care o detine designerul.
In clasa Programmer ce extinde Person contine precum caracterisca speciala un array de string-uri ce reprezinta limbajele de programare pe care el le cunoaste.
In clasa Network avem un ArrayList ce contine nodurile,	am facut o functie ce calculeaza importanta fiecarui nod mai intai intre Person-Person, Company-Company 
	ori eventual Person-Company, daca gasestte in relationship o relatie intre ele se implementeaza o variabila importance iar la finalul 
	algoritmului returneaza importance. De asemenea am si o functie ce verifica importanta fiecarui nod si afiseaza toate nodurile in ordine descrescatoaree
In main am creat o lista pentru a adauga obiectele de tip Person/Company, si am adaugat niste obiecte, dupa care le-am ordonat si afisat.