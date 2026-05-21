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
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const MyHomePage(title: 'Indovina il numero!'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  final String title;

  const MyHomePage({super.key, required this.title});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final List<int> _numeri = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  final List<bool> _numeriScoperti = [
    false, false, false, false, false,
    false, false, false, false
  ];
  late int _numeroDaScoprire;
  int _tentativi = 3;
  bool _giocoFinito = false;

  @override
  void initState() {
    super.initState();
    _numeroDaScoprire = _numeri[Random().nextInt(_numeri.length)];
  }

  void _handleButtonPress(int index) {
    if (_giocoFinito) return;

    setState(() {
      _numeriScoperti[index] = true;

      if (_numeri[index] == _numeroDaScoprire) {
        _giocoFinito = true;
        _mostraAlert('Hai vinto!', 'Hai indovinato il numero $_numeroDaScoprire!');
      } else {
        _tentativi--;
        if (_tentativi == 0) {
          _giocoFinito = true;
          _mostraAlert('Hai perso!', 'Il numero era $_numeroDaScoprire.');
        }
      }
    });
  }

  void _mostraAlert(String titolo, String messaggio) {
    WidgetsBinding.instance.addPostFrameCallback((_) {
      showDialog(
        context: context,
        builder: (context) => AlertDialog(
          title: Text(titolo),
          content: Text(messaggio),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
                _riavvia();
              },
              child: const Text('Gioca ancora'),
            ),
          ],
        ),
      );
    });
  }

  void _riavvia() {
    setState(() {
      _numeriScoperti.fillRange(0, 9, false);
      _numeroDaScoprire = _numeri[Random().nextInt(_numeri.length)];
      _tentativi = 3;
      _giocoFinito = false;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Tentativi rimasti: $_tentativi',
              style: const TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),
            GridView.builder(
              shrinkWrap: true,
              gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 3,
                mainAxisSpacing: 8.0,
                crossAxisSpacing: 8.0,
              ),
              itemCount: 9,
              itemBuilder: (context, index) {
                return ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    foregroundColor: Colors.black,
                    backgroundColor: _numeriScoperti[index]
                        ? (_numeri[index] == _numeroDaScoprire
                            ? Colors.green
                            : Colors.redAccent)
                        : Colors.orangeAccent,
                    surfaceTintColor: Colors.white,
                    elevation: 12,
                    padding: const EdgeInsets.all(4.0),
                  ),
                  onPressed: _numeriScoperti[index] ? null : () => _handleButtonPress(index),
                  child: Text(
                    _numeri[index].toString(),
                    style: const TextStyle(fontSize: 24),
                  ),
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}