import java.util.Set;

public class Asteroide extends CorpiCelestiNonLuminosi {
    private float volume;
    private TipologiaAsteroide tipologiaAsteroide;

    public Asteroide(String nome, float densita, Set<Stella> stelle, float distanzaDalCentroSistema, 
                     float volume, TipologiaAsteroide tipologiaAsteroide) {
        super(nome, densita, stelle, distanzaDalCentroSistema);
        this.volume = volume;
        this.tipologiaAsteroide = tipologiaAsteroide;
    }

    @Override
    public float calcoloMassa() {
        // Formula: volume * densità
        return volume * densita;
    }

    // METODI GETTER AGGIUNTI PER TOGLIERE IL WARNING
    public float getVolume() { return volume; }
    public TipologiaAsteroide getTipologiaAsteroide() { return tipologiaAsteroide; }
}
