In clasa EntityManagerFactorySingleton am o singura instanta a functiei EntityManagerFactory pentru aplicatie. Am un constructor privat si unul
	static care are singura instata a lui EntityManagerFactory. Functia getInstance preia instanta lui EntityManagerFactory si o creeaza
Clasa DataRepository este o clasa abstracta care defineste interfata pt repositorul JPA.
Clasa AlbumRepository extinde DataRepository si contine implementatia functiilor findByArtist, findById si create pentru Album
In Clasa Database contin functiile necesare pentru crearea conexiuni cu pgAdmin 4, mai exact getConnection, createConnection, closeConnection si rollback
In clasa Artist sunt definite metodele esentiale pentru atributele artistului.
In clasa Album sunt definite metodele esentiale pentru atributele albumului.
In clasa AbstractEntity am implementat doar id-ul ca fiind abstract.(o sa am nevoie la tema :)