In clasa interface Node am methoda care obtine numele unui obiect ori din clasa Person ori din clasa Company.
In clasa Company, i-am pus implement Node, si Comparable<Company>, il utilizez pentru a ordona fiecare obiect de tip Company, in clasa se mai regasesc 
	functiile default set get pentru nume si constructorul. De asemenea se regaseste functia compareTo ce ordoneaza obiectele.
In clasa Company, i-am pus implement Node, si Comparable<Person>, il utilizez pentru a ordona fiecare obiect de tip Person, in clasa se mai regasesc 
	functiile default set get pentru nume si constructorul. De asemenea se regaseste functia compareTo ce ordoneaza obiectele.
In main am creat o lista pentru a adauga obiectele de tip Person/Company, si am adaugat niste obiecte, dupa care le-am ordonat si afisat.