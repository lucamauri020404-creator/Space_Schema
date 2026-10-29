import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Genera più di 100 corpi celesti casuali
        List<CorpiCelestiNonLuminosi> sistema = generaCorpiCasuali(120);

        // 2. Ordinamento e stampa nel terminale
        ordinaEStampaPerDensita(sistema);

        // 3. Ricerca di quelli attorno a stelle di tipo B
        List<CorpiCelestiNonLuminosi> orbitantiIntornoAB = cercaCorpiInOrbitadiClasseB(sistema);
        
        System.out.println("\n--- CORPI CHE ORBITANO INTORNO A STELLE DI CLASSE B ---");
        System.out.println("Totale trovati: " + orbitantiIntornoAB.size());
        for (CorpiCelestiNonLuminosi c : orbitantiIntornoAB) {
            System.out.println("- " + c.getNome());
        }

        // 4. Genera la pagina web interattiva
        generaPaginaWeb(sistema, orbitantiIntornoAB);
    }

    // Generatore casuale di pianeti e asteroidi spostato qui dentro
    public static List<CorpiCelestiNonLuminosi> generaCorpiCasuali(int quantita) {
        List<CorpiCelestiNonLuminosi> lista = new ArrayList<>();
        Random rand = new Random();

        Stella sole1 = new Stella("Sirio", 2.1f, 8, Tipologia.A);
        Stella sole2 = new Stella("Rigel", 21.0f, 860, Tipologia.B);
        Stella sole3 = new Stella("Proxima", 0.12f, 4, Tipologia.M);
        List<Stella> poolStelle = Arrays.asList(sole1, sole2, sole3);

        for (int i = 0; i < quantita; i++) {
            Set<Stella> stelleOrbitanti = new HashSet<>();
            int numStelle = rand.nextInt(3) + 1;
            while (stelleOrbitanti.size() < numStelle) {
                stelleOrbitanti.add(poolStelle.get(rand.nextInt(poolStelle.size())));
            }

            float densita = 1.0f + rand.nextFloat() * 5.0f;
            float distanza = 10.0f + rand.nextFloat() * 500.0f;

            if (rand.nextBoolean()) {
                float raggio = 1000f + rand.nextFloat() * 60000f;
                TipologiaPlanetaria tp = TipologiaPlanetaria.values()[rand.nextInt(TipologiaPlanetaria.values().length)];
                Set<String> atmosfera = Set.of("Azoto", "Ossigeno");
                lista.add(new Pianeta("Pianeta-" + i, densita, stelleOrbitanti, distanza, raggio, tp, atmosfera));
            } else {
                float volume = 50f + rand.nextFloat() * 5000f;
                TipologiaAsteroide ta = TipologiaAsteroide.values()[rand.nextInt(TipologiaAsteroide.values().length)];
                lista.add(new Asteroide("Asteroide-" + i, densita, stelleOrbitanti, distanza, volume, ta));
            }
        }
        return lista;
    }

    // Ordinamento spostato qui dentro
    public static void ordinaEStampaPerDensita(List<CorpiCelestiNonLuminosi> lista) {
        lista.sort(Comparator.comparingDouble(CorpiCelestiNonLuminosi::getDensita));
        
        System.out.println("\n--- CORPI CELESTI ORDINATI PER DENSITÀ ---");
        for (CorpiCelestiNonLuminosi c : lista) {
            System.out.printf("Nome: %s | Densità: %.2f%n", c.getNome(), c.getDensita());
        }
    }

    // Ricerca spostata qui dentro
    public static List<CorpiCelestiNonLuminosi> cercaCorpiInOrbitadiClasseB(List<CorpiCelestiNonLuminosi> lista) {
        List<CorpiCelestiNonLuminosi> filtrati = new ArrayList<>();
        for (CorpiCelestiNonLuminosi c : lista) {
            for (Stella s : c.getStelle()) {
                if (s.getTipologia() == Tipologia.B) {
                    filtrati.add(c);
                    break;
                }
            }
        }
        return filtrati;
    }

    // Generatore HTML spostato qui dentro
    public static void generaPaginaWeb(List<CorpiCelestiNonLuminosi> listaCompleta, List<CorpiCelestiNonLuminosi> listaClasseB) {
        java.io.File file = new java.io.File("indice.html");
        try (java.io.PrintWriter writer = new java.io.PrintWriter(file)) {
            
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang='it'>");
            writer.println("<head>");
            writer.println("    <meta charset='UTF-8'>");
            writer.println("    <title>Esploratore Sistema Solare</title>");
            writer.println("    <style>");
            writer.println("        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #0f172a; color: #f8fafc; margin: 40px; }");
            writer.println("        h1, h2 { color: #38bdf8; text-shadow: 0 0 10px rgba(56, 189, 248, 0.3); }");
            writer.println("        .container { max-width: 1200px; margin: auto; background: #1e293b; padding: 30px; border-radius: 12px; box-shadow: 0 4px 20px rgba(0,0,0,0.5); }");
            writer.println("        .stats { display: flex; gap: 20px; margin-bottom: 30px; }");
            writer.println("        .card { flex: 1; background: #334155; padding: 20px; border-radius: 8px; text-align: center; border-left: 5px solid #38bdf8; }");
            writer.println("        .card.b-type { border-left-color: #fbbf24; }");
            writer.println("        .card h3 { margin: 0; font-size: 14px; text-transform: uppercase; color: #94a3b8; }");
            writer.println("        .card p { margin: 10px 0 0 0; font-size: 32px; font-weight: bold; }");
            writer.println("        table { width: 100%; border-collapse: collapse; margin-top: 20px; background: #1e293b; border-radius: 8px; overflow: hidden; }");
            writer.println("        th, td { padding: 14px 20px; text-align: left; border-bottom: 1px solid #334155; }");
            writer.println("        th { background-color: #0f172a; color: #38bdf8; font-weight: 600; }");
            writer.println("        tr:hover { background-color: #334155; transition: background 0.2s; }");
            writer.println("        .badge { padding: 4px 8px; border-radius: 4px; font-size: 12px; font-weight: bold; }");
            writer.println("        .badge-pianeta { background: #0284c7; color: white; }");
            writer.println("        .badge-asteroide { background: #b45309; color: white; }");
            writer.println("        .badge-star { background: #eab308; color: #0f172a; padding: 2px 6px; font-size: 11px; margin-right: 4px; }");
            writer.println("    </style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("    <div class='container'>");
            writer.println("        <h1>🌌 Registro dei Corpi Celesti</h1>");
            writer.println("        <p>Esame Corso Java Base - Sistema Informatico di Classificazione</p>");
            
            writer.println("        <div class='stats'>");
            writer.println("            <div class='card'><h3>Corpi Totali Ordinati</h3><p>🪐 " + listaCompleta.size() + "</p></div>");
            writer.println("            <div class='card b-type'><h3>In Orbita intorno a Classe B</h3><p>⭐ " + listaClasseB.size() + "</p></div>");
            writer.println("        </div>");
            
            writer.println("        <h2>📋 Lista Completa (Ordinata per Densità)</h2>");
            writer.println("        <table>");
            writer.println("            <thead>");
            writer.println("                <tr>");
            writer.println("                    <th>Nome</th>");
            writer.println("                    <th>Tipo</th>");
            writer.println("                    <th>Densità</th>");
            writer.println("                    <th>Massa Calcolata</th>");
            writer.println("                    <th>Stelle Orbitanti</th>");
            writer.println("                </tr>");
            writer.println("            </thead>");
            writer.println("            <tbody>");
            
            for (CorpiCelestiNonLuminosi c : listaCompleta) {
                String tipoBadge = (c instanceof Pianeta) ? 
                    "<span class='badge badge-pianeta'>Pianeta</span>" : 
                    "<span class='badge badge-asteroide'>Asteroide</span>";
                
                boolean orbitaB = false;
                StringBuilder stelleStr = new StringBuilder();
                for (Stella s : c.getStelle()) {
                    if (s.getTipologia() == Tipologia.B) {
                        orbitaB = true;
                        stelleStr.append("<span class='badge badge-star' style='background:#fbbf24'>").append(s.getNome()).append(" (B)</span> ");
                    } else {
                        stelleStr.append("<span class='badge badge-star'>").append(s.getNome()).append(" (").append(s.getTipologia()).append(")</span> ");
                    }
                }
                
                String stileRiga = orbitaB ? " style='border-left: 4px solid #fbbf24;'" : "";
                
                writer.println("                <tr" + stileRiga + ">");
                writer.println("                    <td><strong>" + c.getNome() + "</strong></td>");
                writer.println("                    <td>" + tipoBadge + "</td>");
                writer.println("                    <td>" + String.format("%.2f", c.getDensita()) + "</td>");
                writer.println("                    <td>" + String.format("%.2f", c.calcoloMassa()) + "</td>");
                writer.println("                    <td>" + stelleStr.toString() + "</td>");
                writer.println("                </tr>");
            }
            
            writer.println("            </tbody>");
            writer.println("        </table>");
            writer.println("    </div>");
            writer.println("</body>");
            writer.println("</html>");
            
            System.out.println("\n🌐 PAGINA WEB GENERATA CON SUCCESSO! Apri il file 'indice.html' nella cartella del progetto.");
            
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Errore nella creazione del file HTML: " + e.getMessage());
        }
    }
}


