import 'dart:math';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Higher or Lower',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const HigherLowerPage(),
    );
  }
}

// ── Dati equivalenti a game_data.py ──────────────────────────────────────────
class Personaggio {
  final String nome;
  final double follower;
  final String descrizione;
  final String paese;

  const Personaggio({
    required this.nome,
    required this.follower,
    required this.descrizione,
    required this.paese,
  });
}

const List<Personaggio> data = [
  Personaggio(nome: 'Instagram', follower: 686, descrizione: 'Piattaforma di social media', paese: 'Stati Uniti'),
  Personaggio(nome: 'Cristiano Ronaldo', follower: 651, descrizione: 'Calciatore', paese: 'Portogallo'),
  Personaggio(nome: 'Lionel Messi', follower: 505, descrizione: 'Calciatore', paese: 'Argentina'),
  Personaggio(nome: 'Selena Gomez', follower: 421, descrizione: 'Cantante e attrice', paese: 'Stati Uniti'),
  Personaggio(nome: 'Dwayne Johnson', follower: 394, descrizione: 'Attore e ex wrestler', paese: 'Stati Uniti'),
  Personaggio(nome: 'Kylie Jenner', follower: 394, descrizione: 'Personaggio televisivo e imprenditrice', paese: 'Stati Uniti'),
  Personaggio(nome: 'Ariana Grande', follower: 376, descrizione: 'Cantante e attrice', paese: 'Stati Uniti'),
  Personaggio(nome: 'Kim Kardashian', follower: 357, descrizione: 'Personaggio televisivo e imprenditrice', paese: 'Stati Uniti'),
  Personaggio(nome: 'Beyoncé', follower: 312, descrizione: 'Cantante e attrice', paese: 'Stati Uniti'),
  Personaggio(nome: 'Nike', follower: 301, descrizione: 'Azienda di abbigliamento sportivo', paese: 'Stati Uniti'),
  Personaggio(nome: 'Justin Bieber', follower: 294, descrizione: 'Cantante', paese: 'Canada'),
  Personaggio(nome: 'Kendall Jenner', follower: 288, descrizione: 'Modella e personaggio televisivo', paese: 'Stati Uniti'),
  Personaggio(nome: 'Taylor Swift', follower: 282, descrizione: 'Cantante e cantautrice', paese: 'Stati Uniti'),
  Personaggio(nome: 'National Geographic', follower: 279, descrizione: 'Rivista e organizzazione scientifica', paese: 'Stati Uniti'),
  Personaggio(nome: 'Virat Kohli', follower: 270, descrizione: 'Crickettista', paese: 'India'),
  Personaggio(nome: 'Jennifer Lopez', follower: 249, descrizione: 'Cantante e attrice', paese: 'Stati Uniti'),
  Personaggio(nome: 'Neymar', follower: 229, descrizione: 'Calciatore', paese: 'Brasile'),
  Personaggio(nome: 'Nicki Minaj', follower: 226, descrizione: 'Rapper e cantautrice', paese: 'Trinidad e Tobago'),
  Personaggio(nome: 'Miley Cyrus', follower: 213, descrizione: 'Cantante e attrice', paese: 'Stati Uniti'),
  Personaggio(nome: 'Katy Perry', follower: 204, descrizione: 'Cantante', paese: 'Stati Uniti'),
  Personaggio(nome: 'Zendaya', follower: 179, descrizione: 'Attrice e cantante', paese: 'Stati Uniti'),
  Personaggio(nome: 'Kevin Hart', follower: 177, descrizione: 'Comico e attore', paese: 'Stati Uniti'),
  Personaggio(nome: 'Real Madrid CF', follower: 173, descrizione: 'Club di calcio', paese: 'Spagna'),
  Personaggio(nome: 'Cardi B', follower: 164, descrizione: 'Rapper e attrice', paese: 'Stati Uniti'),
  Personaggio(nome: 'LeBron James', follower: 159, descrizione: 'Giocatore di basket', paese: 'Stati Uniti'),
  Personaggio(nome: 'Rihanna', follower: 149, descrizione: 'Cantante e imprenditrice', paese: 'Barbados'),
  Personaggio(nome: 'Chris Brown', follower: 144, descrizione: 'Cantante e ballerino', paese: 'Stati Uniti'),
  Personaggio(nome: 'Drake', follower: 143, descrizione: 'Rapper e cantautore', paese: 'Canada'),
  Personaggio(nome: 'Kylian Mbappé', follower: 123, descrizione: 'Calciatore', paese: 'Francia'),
  Personaggio(nome: 'Billie Eilish', follower: 123, descrizione: 'Cantante', paese: 'Stati Uniti'),
  Personaggio(nome: 'Lewis Hamilton', follower: 50, descrizione: 'Pilota di Formula 1', paese: 'Regno Unito'),
  Personaggio(nome: 'Rafael Nadal', follower: 57.4, descrizione: 'Tennista', paese: 'Spagna'),
  Personaggio(nome: 'Bad Bunny', follower: 70.3, descrizione: 'Cantante', paese: 'Porto Rico'),
  Personaggio(nome: 'Ed Sheeran', follower: 78.2, descrizione: 'Cantante', paese: 'Regno Unito'),
  Personaggio(nome: 'Dua Lipa', follower: 83.4, descrizione: 'Cantante', paese: 'Regno Unito'),
  Personaggio(nome: 'Harry Styles', follower: 64.2, descrizione: 'Cantante e attore', paese: 'Regno Unito'),
  Personaggio(nome: 'The Weeknd', follower: 63.1, descrizione: 'Cantante', paese: 'Canada'),
  Personaggio(nome: 'Eminem', follower: 61.1, descrizione: 'Rapper', paese: 'Stati Uniti'),
  Personaggio(nome: 'Tom Holland', follower: 76.9, descrizione: 'Attore', paese: 'Regno Unito'),
  Personaggio(nome: 'Gal Gadot', follower: 108, descrizione: 'Attrice', paese: 'Israele'),
];

// ── Pagina principale ─────────────────────────────────────────────────────────
class HigherLowerPage extends StatefulWidget {
  const HigherLowerPage({super.key});

  @override
  State<HigherLowerPage> createState() => _HigherLowerPageState();
}

class _HigherLowerPageState extends State<HigherLowerPage> {
  final Random _random = Random();

  // Stato equivalente alle variabili Python: rand1, rand2, score, guess
  late Personaggio _rand1;
  late Personaggio _rand2;
  int _score = 0;
  bool _gameOver = false;
  String _feedback = '';
  bool _rispostaData = false; // blocca i bottoni tra una risposta e l'altra

  @override
  void initState() {
    super.initState();
    _rand1 = _randomPersonaggio();
    _rand2 = _randomPersonaggio(escludi: _rand1);
  }

  // Equivalente a random.choice(data)
  Personaggio _randomPersonaggio({Personaggio? escludi}) {
    Personaggio p;
    do {
      p = data[_random.nextInt(data.length)];
    } while (escludi != null && p.nome == escludi.nome);
    return p;
  }

  // Equivalente al blocco if/else del while in Python
  void _scelta(String scelta) {
    if (_rispostaData || _gameOver) return;

    final double a = _rand1.follower;
    final double b = _rand2.follower;

    // if (a>=b and scelta=="a" or b>=a and scelta=="b")
    final bool corretta =
        (a >= b && scelta == 'A') || (b >= a && scelta == 'B');

    setState(() {
      _rispostaData = true;
      if (corretta) {
        _score++;
        _feedback = 'Corretto! Score: $_score';
      } else {
        _feedback = 'Sbagliato! Score finale: $_score';
        _gameOver = true;
      }
    });

    if (corretta) {
      // Dopo un secondo avanza: rand1 = rand2 (stessa logica Python)
      Future.delayed(const Duration(seconds: 1), () {
        setState(() {
          _rand1 = _rand2;
          _rand2 = _randomPersonaggio(escludi: _rand1);
          _feedback = '';
          _rispostaData = false;
        });
      });
    }
  }

  // Riavvia il gioco
  void _restart() {
    setState(() {
      _rand1 = _randomPersonaggio();
      _rand2 = _randomPersonaggio(escludi: _rand1);
      _score = 0;
      _gameOver = false;
      _feedback = '';
      _rispostaData = false;
    });
  }

  // Widget card per un personaggio (A o B)
  Widget _cardPersonaggio(Personaggio p, String label, Color colore) {
    return Expanded(
      child: Container(
        margin: const EdgeInsets.all(8),
        padding: const EdgeInsets.all(16),
        decoration: BoxDecoration(
          color: colore,
          borderRadius: BorderRadius.circular(16),
        ),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              label,
              style: const TextStyle(
                fontSize: 28,
                fontWeight: FontWeight.bold,
                color: Colors.white,
              ),
            ),
            const SizedBox(height: 12),
            Text(
              p.nome,
              textAlign: TextAlign.center,
              style: const TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
                color: Colors.white,
              ),
            ),
            const SizedBox(height: 8),
            Text(
              p.descrizione,
              textAlign: TextAlign.center,
              style: const TextStyle(fontSize: 14, color: Colors.white70),
            ),
            Text(
              p.paese,
              textAlign: TextAlign.center,
              style: const TextStyle(fontSize: 13, color: Colors.white54),
            ),
            // Mostra i follower solo dopo la risposta
            if (_rispostaData || _gameOver) ...[
              const SizedBox(height: 12),
              Text(
                '${p.follower.toStringAsFixed(p.follower % 1 == 0 ? 0 : 1)}M follower',
                style: const TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: Colors.yellowAccent,
                ),
              ),
            ],
          ],
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Equivalente al logo ASCII in Python: titolo in alto
      appBar: AppBar(
        title: const Text(
          'Higher or Lower',
          style: TextStyle(fontWeight: FontWeight.bold),
        ),
        centerTitle: true,
        backgroundColor: Colors.deepPurple,
        foregroundColor: Colors.white,
        actions: [
          Padding(
            padding: const EdgeInsets.only(right: 16),
            child: Center(
              child: Text(
                'Score: $_score',
                style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
            ),
          ),
        ],
      ),

      body: Column(
        children: [
          // Domanda
          const Padding(
            padding: EdgeInsets.symmetric(vertical: 16),
            child: Text(
              'Chi ha più follower su Instagram?',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
          ),

          // Le due card A e B con il VS in mezzo (equivalente al logo vs in Python)
          Expanded(
            child: Row(
              children: [
                _cardPersonaggio(_rand1, 'A', Colors.deepPurple),
                // VS badge (equivalente alla variabile vs = art.py)
                Container(
                  width: 40,
                  height: 40,
                  decoration: const BoxDecoration(
                    color: Colors.amber,
                    shape: BoxShape.circle,
                  ),
                  child: const Center(
                    child: Text(
                      'VS',
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 12,
                      ),
                    ),
                  ),
                ),
                _cardPersonaggio(_rand2, 'B', Colors.indigo),
              ],
            ),
          ),

          // Feedback (equivalente ai print() di Python)
          if (_feedback.isNotEmpty)
            Padding(
              padding: const EdgeInsets.all(8),
              child: Text(
                _feedback,
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: _gameOver ? Colors.red : Colors.green,
                ),
              ),
            ),

          // Bottoni A / B (equivalente all'input() Python)
          if (!_gameOver)
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 24),
              child: Row(
                children: [
                  Expanded(
                    child: ElevatedButton(
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.deepPurple,
                        foregroundColor: Colors.white,
                        padding: const EdgeInsets.symmetric(vertical: 16),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(12),
                        ),
                      ),
                      onPressed: _rispostaData ? null : () => _scelta('A'),
                      child: const Text('A ha più follower',
                          style: TextStyle(fontSize: 16)),
                    ),
                  ),
                  const SizedBox(width: 12),
                  Expanded(
                    child: ElevatedButton(
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.indigo,
                        foregroundColor: Colors.white,
                        padding: const EdgeInsets.symmetric(vertical: 16),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(12),
                        ),
                      ),
                      onPressed: _rispostaData ? null : () => _scelta('B'),
                      child: const Text('B ha più follower',
                          style: TextStyle(fontSize: 16)),
                    ),
                  ),
                ],
              ),
            ),

          // Bottone riavvia (equivalente al loop while che riparte)
          if (_gameOver)
            Padding(
              padding: const EdgeInsets.all(16),
              child: ElevatedButton.icon(
                onPressed: _restart,
                icon: const Icon(Icons.refresh),
                label: const Text('Gioca ancora'),
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.deepPurple,
                  foregroundColor: Colors.white,
                  padding:
                      const EdgeInsets.symmetric(vertical: 14, horizontal: 32),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(12),
                  ),
                ),
              ),
            ),

          const SizedBox(height: 12),
        ],
      ),
    );
  }
}