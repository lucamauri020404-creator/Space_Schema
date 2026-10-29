import java.util.Set;

public class Pianeta extends CorpiCelestiNonLuminosi {
    private float raggio;
    private TipologiaPlanetaria tipologiaPlanetaria;
    private Set<String> composizioneAtmosfera;

    public Pianeta(String nome, float densita, Set<Stella> stelle, float distanzaDalCentroSistema, 
                   float raggio, TipologiaPlanetaria tipologiaPlanetaria, Set<String> composizioneAtmosfera) {
        super(nome, densita, stelle, distanzaDalCentroSistema);
        this.raggio = raggio;
        this.tipologiaPlanetaria = tipologiaPlanetaria;
        this.composizioneAtmosfera = composizioneAtmosfera;
    }

    @Override
    public float calcoloMassa() {
        // Formula: ((4 * 3.14 * raggio^3) / 3) * densità
        return (float) (((4 * 3.14 * Math.pow(raggio, 3)) / 3) * densita);
    }

    // METODI GETTER AGGIUNTI PER TOGLIERE I WARNING
    public float getRaggio() { return raggio; }
    public TipologiaPlanetaria getTipologiaPlanetaria() { return tipologiaPlanetaria; }
    public Set<String> getComposizioneAtmosfera() { return composizioneAtmosfera; }
}

