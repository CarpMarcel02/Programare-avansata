In Clasa ConfigurationPanel am creat am creat butoanele din partea de sus, mai exact Number of dots prin care specific printr-un spinner numarul de
	buline pe care sa le am, Probabilitatea de linii, pe care am facut-o printr-un ChoiceBox, si butonul de Creat new Game, care atunci cand
	este apasat, restul butoanelor nu se mai pot apasa si pe canvas apar buline si linii. Deasemenea cand apas butonul CreatnewGame
	stochez datele intr-o matrice, mai exact bulinele si liniiile pentru a le putea folosii in momentul cand vreau sa salvez sau sa dau load
	Functia startJoc preia cu ajutorul mousului coordonatele acestuia in momentul cand a avut loc click-ul.
	Functia verificaPunctu vede daca mousul a dat click pe pozitia unui punct, dupa asteapta apasarea pe urmatorul punct, adauga 
	linia intr-o lista de adiacenta, si apelezeaza functia de desenat linia.
	Functia schimbaCuloarea vede daca linia care rezulta in urma apasarii bulinelor este neagra, daca este neagra permite colorarea acesteia 
	in culoarea player-ului respectiv. In cazul in care nu mai sunt linii negre libere, afiseaza mesajul de egalitate, De asemenea dupa colorare
	verifica prin functia verificareCastig care parcurge in 3 for-uri lista de adiacenta si vede daca s-a format vreun triunghi
	Mai am si functia de drawLine care dupa ce deseneaza linia in culoarea necesara, adauga linia intr-un array de linii.
Clasa Line contine construirea obiectului linie.
In Clasa ControlPanel am creat butoanele de jos mai exact loadButton, saveButton, resetButton si exitButton. Butonul loadButton ia dintr-un
	fisier datele despre o matrice si un string ce reprezinta conexiunile dintre noduri, si le intocmeste la loc, dupa cum erau puse in fisier
	Butonul de save ia matricea pe care am o am si string-ul si o pune intr-un fisier.
	Butonul de reset apeleaza functia de reset din panoul canvas.v
In Clasa Canvas doar se creeaza plansa si contine si funcita de resetare, ea atunci cand este folosita face practic o noua scena de la 0
	 Aici se regaseste functia de reset, se creeaza un nou panou de fiecare fel. Aici se mai gaseste si functia de egalitate care afiseaza
	pe ecran mesajul cum ca este egalitate. Functia playerCastiga afiseaza pe ecran ce player a castigat.
In Clasa MainFrame se creeaza un nou CanvasPanel, ConfigurationPanel si ControlPanel si le centreaza in board.
In Main se apeleaza clasa Mainframe .
