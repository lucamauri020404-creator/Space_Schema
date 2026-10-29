Sistema di Classificazione Corpi Celesti

Un applicativo standalone in Java. Il sistema modella, classifica e analizza i corpi celesti non luminosi (Pianeti e Asteroidi) in orbita intorno a sistemi stellari, generando un report visivo finale senza la necessità di 
infrastrutture server dedicate.

Caratteristiche del Progetto

Il cuore dell'applicazione si basa su:

- Modellazione OOP Avanzata: Utilizzo di classi astratte, ereditarietà (`Pianeta` e `Asteroide`), polimorfismo, incapsulamento e strutture dati dinamiche (`Set`, `List`) con vincoli di cardinalità
- (massimo 3 stelle orbitanti per corpo).

Algoritmi di Ordinamento e Filtraggio: 
  - Ordinamento personalizzato della lista dei corpi celesti in base alla loro densità.
  - Filtraggio avanzato su un pool di oltre 100 elementi per identificare i corpi in orbita intorno ad almeno una stella di tipo spettrale `B`.
  - Unità di Test: Predisposizione per il testing della logica di business.

L'Approccio: generazione di File Statici (Static Site Generation)

A differenza delle classiche architetture server-side questo progetto adotta un approccio offline/stand alone first:

1. L'applicativo Java elabora la logica di business e genera i dati in memoria.
2. Tramite flussi di scrittura, esporta i risultati direttamente in un file statico (`indice.html`).
3. Il file generato include al suo interno la struttura dei dati, lo stile grafico (CSS in Dark Mode) e la codifica *UTF-8* per la resa universale dei caratteri e delle emoji spaziali.

Il file `indice.html` risultante è completamente autonomo e può essere trasferito su qualsiasi dispositivo tramite chiavetta USB e visualizzato in modo interattivo in qualsiasi, 
senza bisogno di connessione Internet o di una Java Virtual Machine installata sul computer di destinazione.

Tecnologie Utilizzate

- Backend: Java (JDK 21)
- Frontend: HTML5 / CSS3 (Embedded)
- Caratteri & Simboli: Standard Unicode (UTF-8)
- IDE: Visual Studio Code

Struttura del Codice (Single-File Architecture)

Per garantire la massima consistenza e superare i disallineamenti di cache locali dell'IDE, la logica è stata centralizzata in un'architettura a file singolo nel file `Main.java`, che comprende:
- I tipi enumerativi per le classi spettrali delle stelle (`Tipologia`) e dei corpi celesti (`TipologiaPlanetaria`, `TipologiaAsteroide`).
- La classe `Stella` e la struttura gerarchica dei corpi celesti non luminosi.
- I metodi di utilità per la generazione casuale dei dati di test, l'ordinamento e la compilazione del file HTML.

Come Eseguire il Progetto

1. Clonare il repository o scarica il file `Main.java`.
2. Aprire il file in VS Code (assicurarsi di avere installato l'estensione per Java).
3. Cliccare su Run sopra il metodo principale.
4. Il file `indice.html` verrà generato nella cartella del progetto, fare poi doppio clic per aprirlo nel browser
