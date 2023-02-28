	Variabila NrNoduri reprezinta nr de noduri pe care o primim de la input.
	Variabila Grad reprezinta gradul pe care fiecare nod ar trebuii sa-l aibe.
	Am pus un if in cazul in care si NrNoduri si Grad este impar, in acest caz este imposibil de a crea un graf regulat.
	Dupa am creat o matrice( este notata fix matrice in problema) si am pus 0 pe fiecare element.
	Am realizat un vector pe nume Grade[], care va contoriza gradul fiecarui nod.
	Dupa am luat cazul in care gradul este 2, graful practic va fi unul de tip K de N noduri.
	Iar practic cazul general, cu 2 for-uri parcurg matricea, si verifica ca nodurile si fie diferite si gradul nodurilor
sa nu fie ajuns deja la nivelul cerut. Am pus 1 in matrice ca sa arat adiacenta intre noduri si am marit numarul
gradului pentru fiecare nod.
	La final am afisat matricea.  
