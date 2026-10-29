public class Stella {
    private String nome;
    private float massa;
    private long distanzaDalSoleAnniLuce;
    private Tipologia tipologia;

    public Stella(String nome, float massa, long distanzaDalSoleAnniLuce, Tipologia tipologia) {
        this.nome = nome;
        this.massa = massa;
        this.distanzaDalSoleAnniLuce = distanzaDalSoleAnniLuce;
        this.tipologia = tipologia;
    }

    // Getter e Setter
    public String getNome() { return nome; }
    public float getMassa() { return massa; }
    public long getDistanzaDalSoleAnniLuce() { return distanzaDalSoleAnniLuce; }
    public Tipologia getTipologia() { return tipologia; }
}
