import 'dart:math';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Impiccato',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const ImpiccatoPage(),
    );
  }
}

class ImpiccatoPage extends StatefulWidget {
  const ImpiccatoPage({super.key});

  @override
  State<ImpiccatoPage> createState() => _ImpiccatoPageState();
}

class _ImpiccatoPageState extends State<ImpiccatoPage> {
  final List<String> _parole = [
    'montagna', 'bicicletta', 'ombrello', 'finestra', 'gelato',
    'nuvola', 'tappeto', 'cuscino', 'forchetta', 'specchio',
    'lampada', 'giardino', 'valigia', 'orologio', 'scarpa',
    'pioggia', 'quaderno', 'candela', 'bosco', 'telefono',
  ];

  bool _inizializzato = false;
  String _parola = '';
  List<String> _trattini = [];
  int _errori = 0;

  final FocusNode _focusNode = FocusNode();

  // Ricava la parola casuale (equivalente a getWord() in Java)
  String _getWord() {
    final random = Random();
    return _parole[random.nextInt(_parole.length)];
  }

  // Inizializza il gioco al primo tasto (stessa logica: if(!inizializzato){...})
  void _inizializza() {
    _parola = _getWord();
    _trattini = List.generate(_parola.length, (_) => '_');
    _errori = 0;
    _inizializzato = true;
  }

  // Gestione tasto premuto (equivalente a keyEvent() in Java)
  void _keyEvent(String carattere) {
    if (!_inizializzato) {
      setState(() => _inizializza());
    }

    if (_errori == 10 || !_trattini.contains('_')) return;

    carattere = carattere.toLowerCase();
    if (!RegExp(r'[a-z]').hasMatch(carattere)) return;

    setState(() {
      bool errore = true;

      for (int i = 0; i < _parola.length; i++) {
        if (_parola[i] == carattere) {
          _trattini[i] = carattere;
          errore = false;
        }
      }

      if (errore) {
        _errori++;
      }
    });

    if (_errori == 10) {
      _mostraAlert(
        titolo: 'Sconfitta',
        messaggio: 'Hai perso! La parola era: $_parola',
        onChiudi: () => setState(() => _inizializzato = false),
      );
    }
    else if (!_trattini.contains('_')) {
      _mostraAlert(
        titolo: 'Vittoria',
        messaggio: 'Hai indovinato la parola!',
        onChiudi: () => setState(() => _inizializzato = false),
      );
    }
  }

  // Mostra un dialogo di alert
  void _mostraAlert({
    required String titolo,
    required String messaggio,
    required VoidCallback onChiudi,
  }) {
    showDialog(
      context: context,
      barrierDismissible: false,
      builder: (_) => AlertDialog(
        title: Text(titolo),
        content: Text(messaggio),
        actions: [
          TextButton(
            onPressed: () {
              Navigator.of(context).pop();
              onChiudi();
            },
            child: const Text('OK'),
          ),
        ],
      ),
    );
  }

  // Testo da scoprire con trattini e lettere
  String get _parolaDaScoprire {
    if (!_inizializzato) return '_ _ _ _ _ _';
    return _trattini.join(' ');
  }

  // Percorso dell'immagine corrente dell'impiccato
  String get _immagineCorrente => 'assets/immaginiImpiccato/$_errori.png';

  @override
  void dispose() {
    _focusNode.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return KeyboardListener(
      focusNode: _focusNode,
      autofocus: true,
      onKeyEvent: (event) {
        if (event is KeyDownEvent && event.character != null) {
          _keyEvent(event.character!);
        }
      },
      child: Scaffold(
        body: Column(
          children: [
            Padding(
              padding: const EdgeInsets.all(5.0),
              child: Align(
                alignment: Alignment.centerLeft,
                child: ElevatedButton(
                  onPressed: () => SystemNavigator.pop(),
                  child: const Text('chiudi'),
                ),
              ),
            ),

            Expanded(
              child: Center(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Image.asset(
                      _immagineCorrente,
                      height: 181,
                      width: 117,
                      fit: BoxFit.contain,
                    ),

                    Padding(
                      padding: const EdgeInsets.all(10.0),
                      child: Text(
                        _parolaDaScoprire,
                        style: const TextStyle(
                          fontFamily: 'Courier New',
                          fontWeight: FontWeight.bold,
                          fontSize: 25,
                        ),
                      ),
                    ),

                    if (!_inizializzato)
                      const Padding(
                        padding: EdgeInsets.only(top: 16),
                        child: Text(
                          'Premi un tasto per iniziare',
                          style: TextStyle(fontSize: 14, color: Colors.grey),
                        ),
                      ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}