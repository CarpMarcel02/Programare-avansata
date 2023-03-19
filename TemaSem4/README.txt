In clasa Student am ca variabile name, o lista ce contine toate proiectele accesibile studentului, o variabila Project
ce reprezinta proiectul ales in final dupa rezolvarea problemei, un contor al proiectelor din lista. Am realizat metodele
get si set pentru fiecare, constructorul, am functia addElementToList ce adauga in lista un proiect, iar aceasta functie
incrementeaza pentru fiecare proiect variabila proiecteAsignate, ce reprezinta numarul de asignari pentru fiecare proiect.
De asemenea aici se regasesc metodele facute pentru toString si compareTo (compareTo l-am folosit pentru a sorta studentii in functie
de proiectele asignate.
In clasa Project vom regasi ca variabile name, un contor nrPersoaneAsignare, si o variabila aFostAsignat ce verifica daca
proiectul a fost deja asignat la o persoana sau nu. In rest se regasesc metodele set si get pentru fiecare variabila, de asemnea
se regasc si constructorul si implementarile functiilor toString si compareTo
In clasa Problem vom avea o mapa ce retine studenti si lista proiectelor fiecarui student, si o variabila validate ce verifica
daca problema este valida sau nu. Vom avea functia adaugareDateInProblema ce adauga lista de studenti in mapa cu lista fiecaruia de
proiecte. Functia esteProbleemaValida verifica daca problema este valida, in principal vede daca fiecare student are cel putin 1 proiect in lista sa de proiecte
iar pentru fiecare proiect vede daca a fost asignat la macar un student. Functia noOfPreference verifica studentii care au ca nr de proiecte un numar mai mic
decat media de proiecte per persoana si ii returneaza. Iar functia alegereProiect sorteaza fiecare student in ordine crescatoare dupa nr de proiecte disponibile,
iar dupa parcurge lista iar primul student va lua proiectul care are cele mai multe asignari din toate celelalte din lista studentului
