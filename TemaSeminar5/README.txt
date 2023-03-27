In Clasa Catalog am o lista de documente, constructorul normal si un constructor gol si get-ul pentru documents, findById ce returneaza un document dupa id si metoda toString
Clasa AddCommand am facut-o pentru a putea sa imi adauge un document in catalog
In Clasa Document am atributele necesare, get si set-urile necesare, constructorul, o mapa si metodele get si set ale ei
In clasa InvalidCatalogException am o exceptie
In ListCommand pur si simplu face o afisare a tuturor documentelor dintr-un anumit catalog.
In LoadCommand imi pune intr-un nou catalog detaliile despre un catalog deja existent dintr-un anumit folder.
In ReportCommand am o functie ce ma ajuta, ea creeaza o configuratie pentru FreeMarker, care imi incarca
    sabloanele de tip HTML, seteaza un director pentru template, ia template-ul pe care l-am facut, intr-o mapa pun catalogul cu
    documentele sale si prin StringWriter le scrie pe acel sablon, iar functia execute deschide acel fisier creat prin functie
SaveCommand-ul pur si simplu salveaza un catalog cu documentele sale intr-un fisier.
ViewCommand-ul Imi deschide un anumit fisier dintr-o anumita locatie
In Main adaug 2 documente in catalog, salvez catalogul in fisier si dupa ii dau load.
