import java.util.List;

public class Mago {
    
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
    /**
     * Controlla se il mago è ancora vivo
     * @return true se hp > 0, altrimenti false
     */
    public boolean isAlive(){
        if (this.hp > 0)
            return true;
        return false;
    }

    /**
     * Applica il danno al mago, riducendo i suoi hp. Se gli hp scendono sotto 0, vengono portati a 0.
     * @param danno la quantità di danno da infliggere al mago
     */
    public void takeDamage(int danno){
        this.hp -= danno;
        if (this.hp < 0)
            this.hp = 0;
    }

    /**
     * Cura il mago, aumentando i suoi hp. Se gli hp superano hpMax, vengono portati a hpMax.
     * @param quantita la quantità di hp da curare al mago
     */
    public void heal(int quantita){
        this.hp += quantita;
        if (this.hp > this.hpMax)
            this.hp = this.hpMax;
    }

    /**
     * Controlla se il mago ha abbastanza mana per lanciare una determinata spell
     * @param s la spell da lanciare
     * @return true se il mago ha abbastanza mana, altrimenti false
     */
    public boolean canCast(Spell s){
        if (this.mana >= s.getCostoMana())
            return true;
        return false;
    }

    /**
     * Lancia una spell su un bersaglio. Se la spell è di tipo "attacco", infligge danno al bersaglio. Se la spell è di tipo "cura", cura se stesso.
     * @param s la spell da lanciare
     * @param target il bersaglio della spell
     */
    public void cast(Spell s, Mago target){
        if(target.isAlive() && this.canCast(s)){
            this.setMana(this.getMana() - s.getCostoMana());
            if(s.getTipo().equalsIgnoreCase("attacco")){
                int danno = s.getValoreBase() + this.potenzaMagica - target.getDifesa();
                if (danno < 1) danno = 1;
                target.takeDamage(danno);
            } else
                this.heal(s.getValoreBase());
        }
    }

    /**
     * Riposa il mago, rigenerando mana.
     */
    public void rest(){
        this.mana += 5;
        if (this.mana > this.manaMax)
            this.mana = this.manaMax;
    }   

    /**
     * Rigenera mana al mago. Se il mana supera manaMax, viene portato a manaMax.
     */
    public void regenMana(int quantita){
        this.mana += quantita;
        if (this.mana > this.manaMax)
            this.mana = this.manaMax;
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