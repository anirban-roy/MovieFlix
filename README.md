# MovieFlix
Personalized Netflix web application

# Backend
The backend is a RESTFull API developed using Java Spring frameworks. It supports retrieval of titles, creation of titles, updation of titles and deletion of a title.
The backend connects to a Mysql based database. The schema can be created using the given script in the DB_Schema_Scripts directory. Execute the queries in the script to create the schema
and then run the backend API to interact with it. The backend has to be configured with the DB server properties for it to be able to connect with it. The data base is normalized based on 
IMDB json data and allows storing the information in the JSON.

# Sample JSON (Create Title)
  {
    "Title": "Batman Begins",
    "Year": "2005",
    "Rated": "PG-13",
    "Released": "",
    "Runtime": "140",
    "Generes": [{"Genere":"Action"},{"Genere":"Adventure"}],
    "Directors": [{"Director":"Christopher Nolan"}],
    "Writers": [{"Writer":"Bob Kane"}, {"Writer":"David S. Goyer"}, {"Writer":"Christopher Nolan"}],
    "Actors": [{"Actor":"Christian Bale"}, {"Actor":"Michael Caine"}, {"Actor":"Liam Neeson"}, {"Actor":"Katie Holmes"}],
    "Plot": {"plottext":"After training with his mentor, Batman begins his war on crime to free the crime-ridden Gotham City from corruption that the Scarecrow and the League of Shadows have cast upon it."},
    "Languages": [{"Language":"English"}, {"Language":"Urdu"}, {"Language": "Mandarin"}],
    "Countries": [{"Country":"USA"}, {"Country":"UK"}],
    "Awards": "Nominated for 1 Oscar. Another 16 wins & 63 nominations.",
    "Poster": "http://ia.media-imdb.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg",
    "Metascore": "70",
    "imdbRating": "8.3",
    "imdbVotes": "906246",
    "imdbID": "tt0372784",
    "Type": "movie"
  }
  
 All multivalued arguments like languages, countries, Actors etc. has to be provided as a JSON array. Internally these will be stored in separate tables due to the process 
 of normalization.