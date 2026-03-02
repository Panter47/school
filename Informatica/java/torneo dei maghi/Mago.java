public abstract class Mago {
    
    private String nome;
    private String alieas;
    private int hp;
    private int hpMax;
    private int mana;
    private int manaMax;
    private int potenzaMagica;
    private int difesa;
    private int velocità;
    private List<Spell> spellBook;
    
    public Mago(String nome, String alieas, int hp, int hpMax, int mana, int manaMax, int potenzaMagica, int difesa,
            int velocità, List<Spell> spellBook) {
        this.nome = nome;
        this.alieas = alieas;
        this.hp = hp;
        this.hpMax = hpMax;
        this.mana = mana;
        this.manaMax = manaMax;
        this.potenzaMagica = potenzaMagica;
        this.difesa = difesa;
        this.velocità = velocità;
        this.spellBook = spellBook;
    }

    private boolean isAlive(){
        if (this.hp > 0)
            return true;
        return false;
    }

    private void takeDamage(int danno){
        this.hp -= danno;
        if (this.hp < 0)
            this.hp = 0;
    }

    private void heal(int quantita){
        this.hp += quantita;
        if (this.hp > this.hpMax)
            this.hp = this.hpMax;
    }

    private boolean canCast(Spell s){
        if (this.mana >= s.manaCost)
            return true;
        return false;
    }

    private void cast(Spell s, Mago target){
        if(target.isAlive() && this.canCast(s)){
            this.setMana(this.getMana() - s.manaCost);
            
        }
    }

    //gettes setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlieas() {
        return alieas;
    }

    public void setAlieas(String alieas) {
        this.alieas = alieas;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getManaMax() {
        return manaMax;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public int getPotenzaMagica() {
        return potenzaMagica;
    }

    public void setPotenzaMagica(int potenzaMagica) {
        this.potenzaMagica = potenzaMagica;
    }

    public int getDifesa() {
        return difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }

    public int getVelocità() {
        return velocità;
    }

    public void setVelocità(int velocità) {
        this.velocità = velocità;
    }

    public List<Spell> getSpellBook() {
        return spellBook;
    }

    public void setSpellBook(List<Spell> spellBook) {
        this.spellBook = spellBook;
    }

    
}
