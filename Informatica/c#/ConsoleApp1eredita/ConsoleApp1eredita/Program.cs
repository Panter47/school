Console.WriteLine("Hello, World!");
SuperClasse superClasse = new SuperClasse(5);
superClasse.Attributo = 1;
Console.WriteLine(superClasse.Attributo);
superClasse.Metodo();
Console.ReadLine();

SottoClasse sottoClasse = new SottoClasse { Attributo = 1 };
//sottoClasse.Attributo = 2;
sottoClasse.Metodo();

List<SuperClasse> lista = new List<SuperClasse>();
lista.Add(superClasse);
lista.Add(sottoClasse);

foreach (SuperClasse s in lista)
{
    s.Metodo();
}



public class SuperClasse 
{
    int attributo;

    public SuperClasse()
    {
    }

    public SuperClasse(int attributo) 
    {
        this.Attributo = attributo;
    }

    public int Attributo { get => attributo; set => attributo = value; }

    public virtual void Metodo() 
    {
        Console.WriteLine($"sono il metodo della superClasse {Attributo}");  
    }
}

public class SottoClasse : SuperClasse
{
    int sottoAttributo;
    public SottoClasse()
    {
    }

    public SottoClasse(int attributo, int sottoAttributo) : base(attributo)
    {
        SottoAttributo = sottoAttributo;
    }

    public int SottoAttributo { get => sottoAttributo; set => sottoAttributo = value;  }

    public override void Metodo()
    { 
        Console.WriteLine($"sono il metodo della sottoClasse {SottoAttributo}");
    }
}