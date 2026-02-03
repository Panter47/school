import java.util.ArrayList;

public class InventarioPC {
	private ArrayList<PC> inventario;

	public InventarioPC() {
		this.inventario = new ArrayList<>();
	}

	public void aggiungiPC(PC pc) {
		inventario.add(pc);
	}

	public boolean rimuoviPC(PC pc) {
		return inventario.remove(pc);
	}
	
	public ArrayList<PC> cercaPerMarca(String marca) {
		ArrayList<PC> trovato = new ArrayList<>();
		
		for(PC p : inventario) {
			if(p.getMarca().equalsIgnoreCase(marca))
				trovato.add(p);
		}
		return trovato;
	}
	
	public ArrayList<PC> cercaPerSistema(String sistemaOperativo) {
		ArrayList<PC> trovato = new ArrayList<>();
		
		for(PC p : inventario) {
			if(p.getSistemaOperativo().equalsIgnoreCase(sistemaOperativo))
				trovato.add(p);
		}
		return trovato;
	}
	
	public PC trovaPCConPiuRAM() {
		PC p= new PC(0,0," "," "," ");
		
		for(PC c : inventario) {
			if(c.getRam()>p.getRam())
				p=c;
		}
		return p;
	}
	
	public double calcolaMediaRAM() {
		
		int i=0;
		double media=0;
		
		for(PC pc : inventario) {
			media+=pc.getRam();
			i++;
		}
		if(media==0)
			return 0;
		return media/i;
	}
	
	public int contaPortatiliConWifi() {
		int i=0;
		
		for(PC pc : inventario) {
			if(pc instanceof PcPortatili) {
				PcPortatili p = (PcPortatili) pc;
				if(p.isIntReteWireless())
					i++;
			}
		}
		return i;
	}
	
	public int contaServerConRaid() {
		int i=0;
		
		for(PC pc : inventario) {
			if(pc instanceof Server) {
				Server p = (Server) pc;
				if(p.isDischiRaid())
					i++;
			}
		}
		return i;
	}
	public Notebook trovaNotebookPiuLeggero() {
		
		Notebook note= new Notebook(0, 0, " ", " ", " ", 0, 0, 0, 0,0, true, true, 0);
		
		for(PC pc : inventario) {
			if(pc instanceof Notebook) {
				Notebook n = (Notebook) pc;
				if(n.getPeso()<note.getPeso())
					note=n;
			}
		}
		return note;
	}
	
	public ArrayList<PC> cercaPortatili(double pesoMassimo, boolean richiedeWifi) {
		
		ArrayList<PC> trovati = new ArrayList<>();
		
		for(PC pc : inventario) {
			if(pc instanceof PcPortatili) {
				PcPortatili pp= (PcPortatili) pc;
				if(pp.getPeso()<=pesoMassimo && pp.isIntReteWireless()==richiedeWifi)
					trovati.add(pp);
			}
		}
		return trovati;
	}
}
