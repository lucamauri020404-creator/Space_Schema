import java.util.Set;

public abstract class CorpiCelestiNonLuminosi {
    protected String nome;
    protected float densita;
    protected Set<Stella> stelle; // Un pianeta può orbitare intorno a max 3 stelle
    protected float distanzaDalCentroSistema;

    public CorpiCelestiNonLuminosi(String nome, float densita, Set<Stella> stelle, float distanzaDalCentroSistema) {
        if (stelle != null && stelle.size() > 3) {
            throw new IllegalArgumentException("Un corpo celeste non luminoso può orbitare al massimo intorno a 3 stelle.");
        }
        this.nome = nome;
        this.densita = densita;
        this.stelle = stelle;
        this.distanzaDalCentroSistema = distanzaDalCentroSistema;
    }

    // Metodo astratto richiesto
    public abstract float calcoloMassa();

    // Getter per i metodi di ordinamento e ricerca
    public String getNome() { return nome; }
    public float getDensita() { return densita; }
    public Set<Stella> getStelle() { return stelle; }
}