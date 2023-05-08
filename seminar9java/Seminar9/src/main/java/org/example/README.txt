In clasa EntityManagerFactorySingleton am o singura instanta a functiei EntityManagerFactory pentru aplicatie. Am un constructor privat si unul
	static care are singura instata a lui EntityManagerFactory. Functia getInstance preia instanta lui EntityManagerFactory si o creeaza
Clasa DataRepository este o clasa abstracta care defineste metodele create, findById si findByName pentru a fi folosite pentru clasele
	AlbumRepository, GenreRepository si ArtistRepository
In clasa AbstractEntity am implementat doar id-ul ca fiind abstract pentru clasele Album Genre si Artist.
In clasa Artist sunt definite metodele esentiale pentru atributele artistului. Am implementat aceasta functie avand relatia OneToMany avand o lista pentru albume.
In clasa Genre sunt definite metodele esentiale pentru atributele genului. Am implementat aceasta functie avand relatia ManyToMany avand o lista pentru albume.
In clasa Album sunt definite metodele esentiale pentru atributele artistului. Am implementat aceasta functie avand relatia ManyToOne avand un element artist si o functie ManyToMany avand o lista de genuri
In Clasa Database contin functiile necesare pentru crearea conexiuni cu pgAdmin 4, mai exact getConnection, createConnection, closeConnection si rollback
Clasa AlbumRepository extinde DataRepository avand ca elemente obiectul Album si un Long pentru ID si returneaza elementele esentiale ca functia abstracta sa-si da seama ca e vorba despre album.
Clasa ArtistRepository extinde DataRepository avand ca elemente obiectul Artist si un Long pentru ID si returneaza elementele esentiale ca functia abstracta sa-si da seama ca e vorba despre artist.
Clasa GenreRepository extinde DataRepository avand ca elemente obiectul Genre si un Long pentru ID si returneaza elementele esentiale ca functia abstracta sa-si da seama ca e vorba despre gen.
In main am folosit Java Faker pentru a crea mai multe tipuri de obiecte pentru fiecare si am facut niste teste.
