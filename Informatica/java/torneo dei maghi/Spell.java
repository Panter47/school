public class Spell {
    private String nome;
    private int costoMana;
    private int valoreBase;
    private String tipo;
    
    public Spell(String nome, int costoMana, int valoreBase, String tipo) {
        this.nome = nome;
        this.costoMana = costoMana;
        this.valoreBase = valoreBase;
        this.tipo = tipo;
    }

    //getter setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCostoMana() {
        return costoMana;
    }

    public void setCostoMana(int costoMana) {
        this.costoMana = costoMana;
    }

    public int getValoreBase() {
        return valoreBase;
    }

    public void setValoreBase(int valoreBase) {
        this.valoreBase = valoreBase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
