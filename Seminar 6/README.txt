In Clasa ConfigurationPanel am creat am creat butoanele din partea de sus, mai exact Number of dots prin care specific printr-un spinner numarul de
	buline pe care sa le am, Probabilitatea de linii, pe care am facut-o printr-un ChoiceBox, si butonul de Creat new Game, care atunci cand
	este apasat, restul butoanelor nu se mai pot apasa si pe canvas apar buline si linii. Deasemenea cand apas butonul CreatnewGame
	stochez datele intr-o matrice, mai exact bulinele si liniiile pentru a le putea folosii in momentul cand vreau sa salvez sau sa dau load
In Clasa ControlPanel am creat butoanele de jos mai exact loadButton, saveButton, resetButton si exitButton. Butonul loadButton ia dintr-un
	fisier datele despre o matrice si un string ce reprezinta conexiunile dintre noduri, si le intocmeste la loc, dupa cum erau puse in fisier
	Butonul de save ia matricea pe care am o am si string-ul si o pune intr-un fisier.
	Butonul de reset face canvas-ul gol si da libertatea de a crea un nou graf.
In Clasa Canvas doar se creeaza plansa si contine si funcita de resetare, ea atunci cand este folosita face practic o noua scena de la 0
In Clasa MainFrame se creeaza un nou CanvasPanel, ConfigurationPanel si ControlPanel si le centreaza in board.
In Main se apeleaza clasa Mainframe .
