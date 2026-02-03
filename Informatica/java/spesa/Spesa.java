import java.time.LocalDate;

public class Spesa {

    private LocalDate data;
    private double importo;
    private String categoria;
    private String modPagamento;



    public Spesa(LocalDate data, double importo, String categoria, String modPagamento) {
    
        this.data=data;
        this.importo=importo;
        this.categoria=categoria;
        this.modPagamento=modPagamento;
    }
     //getter

     public LocalDate getData() {
        return data;
     }

     public double getImporto() {
        return importo;
     }

     public String getCategoria(){
        return categoria;
     }

     public String getModPagamento() {
        return modPagamento;
     }

     //setter

     public void setData(LocalDate data) {
        this.data=data;
     }
     
     public void setImporto(double importo) {
        this.importo=importo;
     }

     public void setCategoria(String categoria) {
        this.categoria=categoria;
     }

     public void setModPagamento(String modPagamento) {
        this.modPagamento=modPagamento;
     }
     
     /**
      * aggiunge l'iva e resituisce il prezzo con l'iva
      * @return
      */
     public double applicaIVA(){
        return (this.getImporto()/100*22)+this.getImporto();
     }
    
     public String toString() {
        return data + " - " + importo + "€ - " + categoria + " - " + modPagamento;
    }
}
