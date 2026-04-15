abstract class Persona {
  String _nominativo;
  String _sesso;
  String _dataDiNascita;
  double _stipendiobase;

  Persona ([this._nominativo = "", this._sesso = "", this._dataDiNascita = "", this._stipendiobase = 0]);

  String get nominativo => _nominativo;
  String get sesso => _sesso;
  String get dataDiNascita => _dataDiNascita;
  double get stipendiobase => _stipendiobase;

  @override
  String toString(){
    return "Persona( nominativo = $nominativo, Sesso = $sesso, Data di nascita = $dataDiNascita, stipendio base = $stipendiobase)";
  }

  double getStipendio();
}

class Docente extends Persona{
  
  int _numeroOre;

  Docente (this._numeroOre , {nominativo = "", sesso = "", dataDiNascita = "", stipendioBase = 0}) 
    : super(nominativo, sesso, dataDiNascita, stipendioBase);
  
  int get numeroOre => _numeroOre;
  
  @override
  double getStipendio() {
    return this.numeroOre * this.stipendiobase;
  }

  @override
  String toString(){
    return "Docente( nominativo = $nominativo, Sesso = $sesso, Data di nascita = $dataDiNascita, stipendio base = $stipendiobase, numero di ore = $numeroOre)";
  }
}


class Impiegato extends Persona{
  int _livello;
  int _oreStraordinario;
  double _retribuzioneOraria;

  Impiegato (this._livello, this._oreStraordinario, this._retribuzioneOraria, {nominativo = "", sesso = "", dataDiNascita = "", stipendioBase = 0})
  : super(nominativo, sesso, dataDiNascita, stipendioBase);

  int get livello => _livello;
  int get oreStraordinario => _oreStraordinario;
  double get retribuzioneOraria => _retribuzioneOraria;

  @override
  double getStipendio(){
    return this.stipendiobase + (this.oreStraordinario * this.retribuzioneOraria); 
  }

  @override 
  String toString(){
    return "Impiegato(nominativo = $nominativo, Sesso = $sesso, Data di nascita = $dataDiNascita, stipendio base = $stipendiobase, livello = $livello, ora di straordiario = $oreStraordinario, retribuzione oraria straordinario = $retribuzioneOraria)";
  }
}

void main() {
  final dipendenti = <Persona>[
    Impiegato(3, 12, 15.0, nominativo: "Mario Rossi", sesso: "M", stipendioBase: 1400.0, dataDiNascita: "1990-05-12"),
    Impiegato(1, 0, 10.0, nominativo: "Laura Verdi", sesso: "F", stipendioBase: 1200.0, dataDiNascita: "1995-03-22"),
    Docente(80, nominativo: "Giulia Bianchi", sesso: "F", stipendioBase: 22.5, dataDiNascita: "1985-11-03"),
    Docente(120, nominativo: "Carlo Neri", sesso: "M", stipendioBase: 18.0, dataDiNascita: "1978-07-15"),];

    
  for (final dipendente in dipendenti) {
    print(dipendente);
    print("Stipendio calcolato: ${dipendente.getStipendio().toStringAsFixed(2)} euro\n");
  }
}