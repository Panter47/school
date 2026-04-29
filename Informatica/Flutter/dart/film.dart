import 'package:flutter/material.dart';

class Film {
  String titolo;
  int anno;
  String genere;
  int colore;

  Film(this.titolo, this.anno, this.genere, this.colore);
}

void main() {
  runApp(CinemaApp());
}

class CinemaApp extends StatelessWidget {
  final List<Film> film = [
    Film('Inception', 2010, 'Fantascienza', 200),
    Film('The Shining', 1980, 'Horror', 300),
    Film('Il Padrino', 1972, 'Drama', 400),
    Film('Die Hard', 1988, 'Azione', 500),
    Film('Interstellar', 2014, 'Fantascienza', 600),
    Film('Get Out', 2017, 'Horror', 700),
    Film('Forrest Gump', 1994, 'Commedia', 800),
    Film('Mad Max', 2015, 'Azione', 900),
  ];

  @override
  Widget build(BuildContext context) {
    const title = 'Cinema - GridView.count e GridView.builder';

    return MaterialApp(
      title: title,
      home: Scaffold(
        appBar: AppBar(title: const Text(title)),
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            const Padding(
              padding: EdgeInsets.fromLTRB(12, 12, 12, 4),
              child: Text(
                'Generi',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
            ),
            GridView.count(
              shrinkWrap: true,
              physics: const NeverScrollableScrollPhysics(),
              padding: const EdgeInsets.symmetric(horizontal: 10),
              crossAxisSpacing: 6,
              mainAxisSpacing: 6,
              crossAxisCount: 5,
              children: <Widget>[
                CellaGenere(genere: 'Azione'),
                CellaGenere(genere: 'Horror'),
                CellaGenere(genere: 'Commedia'),
                CellaGenere(genere: 'Fantascienza'),
                CellaGenere(genere: 'Drama'),
              ],
            ),
            const Padding(
              padding: EdgeInsets.fromLTRB(12, 12, 12, 4),
              child: Text(
                'Film',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
            ),
            Expanded(
              child: GridView.builder(
                padding: const EdgeInsets.all(10),
                gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 2,
                  mainAxisSpacing: 8.0,
                  crossAxisSpacing: 8.0,
                  childAspectRatio: 1.4,
                ),
                itemCount: film.length,
                itemBuilder: (context, index) {
                  return CardFilm(film: film[index]);
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class CellaGenere extends StatelessWidget {
  String genere;
  CellaGenere({this.genere = 'Altro'});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: Colors.deepPurple[200],
        borderRadius: BorderRadius.circular(8),
      ),
      child: Center(
        child: Text(
          genere,
          style: const TextStyle(fontSize: 10, color: Colors.white),
          textAlign: TextAlign.center,
        ),
      ),
    );
  }
}

class CardFilm extends StatelessWidget {
  Film film;
  CardFilm({required this.film});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(8),
      decoration: BoxDecoration(
        color: Colors.deepPurple[film.colore],
        borderRadius: BorderRadius.circular(10),
      ),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            film.titolo,
            style: const TextStyle(
              color: Colors.white,
              fontWeight: FontWeight.bold,
              fontSize: 13,
            ),
          ),
          const SizedBox(height: 4),
          Text(
            '${film.anno} · ${film.genere}',
            style: const TextStyle(color: Colors.white70, fontSize: 11),
          ),
        ],
      ),
    );
  }
}