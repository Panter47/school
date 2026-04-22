import 'dart:convert';
Map<String, String> giocatore = {
  "Nome": "Nikola Karabatić",
  "Nazionalità": "Francia",
  "Ruolo": "Pivot",
  "Squadra": "Paris Saint-Germain HB",
};

String giocatoreJson = '''{
  "Nome": "Domagoj Duvnjak",
  "Nazionalità": "Croazia",
  "Ruolo": "centrale",
  "Squadra": "THW Kiel"
}''';

String giocatoriJson = '''
[
  {
    "Nome": "Andreas Wolff",
    "Nazionalità": "Germania",
    "Ruolo": "Portiere",
    "Squadra": "Lomza Vive Kielce"
  },
  {
    "Nome": "Mikkel Hansen",
    "Nazionalità": "Danimarca",
    "Ruolo": "Ala sinistra",
    "Squadra": "Paris Saint-Germain HB"
  },
  {
    "Nome": "Viran Morros",
    "Nazionalità": "Spagna",
    "Ruolo": "Terzino destro",
    "Squadra": "FC Barcelona"
  }
]''';

class Giocatore {
  final String nome;
  final String nazionalita;
  final String ruolo;
  final String squadra;

  Giocatore(this.nome, this.nazionalita, this.ruolo, this.squadra);

  Giocatore.fromJson(Map<String, dynamic> json)
      : nome = json['Nome'],
        nazionalita = json['Nazionalità'],
        ruolo = json['Ruolo'],
        squadra = json['Squadra'];
}

class ListaGiocatori {
  final List<Giocatore> listaGiocatori;

  ListaGiocatori({required this.listaGiocatori});

  factory ListaGiocatori.fromJson(List<dynamic> parsedJson) {

    List<Giocatore> listaGiocatori =
        parsedJson.map((g) => Giocatore.fromJson(g)).toList();
    return ListaGiocatori(
      listaGiocatori: listaGiocatori,
    );
  }
}

main() {
  print("Stampa direttamente dal tipo Map");
  print(
      "${giocatore['Nome']}, ${giocatore['Nazionalità']}, ${giocatore['Ruolo']}, ${giocatore['Squadra']}");

  print("\nTrasforma in Map da stringa json");
  Map<String, dynamic> giocatoreMap = jsonDecode(giocatoreJson);
  print(
      "${giocatoreMap['Nome']}, ${giocatoreMap['Nazionalità']}, ${giocatoreMap['Ruolo']}, ${giocatoreMap['Squadra']}");

  print("\nTrasforma in classe Giocatore da Map");
  var giocatoreClasse = Giocatore.fromJson(giocatoreMap);
  print(
      '${giocatoreClasse.nome}, ${giocatoreClasse.nazionalita}, ${giocatoreClasse.ruolo}, ${giocatoreClasse.squadra}');

  print("\nTrasforma in lista di classe Giocatore da stringa json");

  List<dynamic> giocatoriMap = jsonDecode(giocatoriJson);
  List<Giocatore> giocatori =
      ListaGiocatori.fromJson(giocatoriMap).listaGiocatori;

  giocatori.forEach((g) => print('${g.nome}, ${g.nazionalita}, ${g.ruolo}, ${g.squadra}'));
}