# **Documento di Specifica dei Requisiti per il Software di Gestione Contatti**

# **INDICE** {#indice}

**[INDICE	1](#indice)**

[**INTRODUZIONE	1**](#introduzione)

[**Descrizione Requisiti Funzionali	2**](#descrizione-requisiti-funzionali)

[**RF 1 Gestione contatti	2**](#gestione-contatti)

      [Descrizione Requisiti Non Funzionali	3](#descrizione-requisiti-non-funzionali)

[Tabelle Gestione	4](#tabelle-gestione)

[**Tabella Informazione sui Contatti	4**](#tabella-informazione-sui-contatti)

            [Casi d'Uso Principali	7](#casi-d'uso-principali)

[UC1: Crea Contatto	8](#uc1:-crea-contatto)

[UC2: Modifica Contatto	8](#uc2:-modifica-contatto)

[UC3: Cancella Contatto	9](#uc3:-cancella-contatto)

[UC4: Visualizza Rubrica	10](#uc4:-visualizza-rubrica)

[UC7: Cerca Contatto	11](#uc7:-cerca-contatto)

[UC5: Salva Rubrica	11](#uc5:-salva-rubrica)

[UC6: Carica Rubrica	11](#uc6:-carica-rubrica)

[UC7: Cerca Contatto	12](#uc7:-cerca-contatto-1)

[UC8: Visualizza Dettagli Contatto	12](#uc8:-visualizza-dettagli-contatto)

[UC9: Aggiungi Contatto alla Lista Preferiti	13](#uc9:-aggiungi-contatto-alla-lista-preferiti)

[UC10: Visualizza Preferiti	13](#uc10:-visualizza-preferiti)

[UC11: Aggiungi Contatto a un Gruppo	15](#uc11:-aggiungi-contatto-a-un-gruppo)

[UC12: Crea Gruppo	16](#uc12:-crea-gruppo)

[UC13: Visualizza Gruppi	16](#uc13:-visualizza-gruppi)

[UC14: Visualizza Contatti in un Gruppo	17](#uc14:-visualizza-contatti-in-un-gruppo)

# **INTRODUZIONE** {#introduzione}

Questo documento definisce i requisiti funzionali e i casi d'uso per un software di gestione di una rubrica di contatti con interfaccia grafica (GUI). Il software consente la creazione, modifica, cancellazione, ricerca e gestione dei contatti, con la possibilità di salvare e caricare la rubrica su file.

**Team di sviluppo**

 Il seguente software e la relativa documentazione verrà realizzata dai seguenti sviluppatori:

* Simone Ungolo  
* Giuseppe Pio Loria  
* Leonardo Pane  
* Francesco Specchio Mazzullo

# **Descrizione Requisiti Funzionali** {#descrizione-requisiti-funzionali}

1. # [**Gestione contatti**](#tabelle-gestione) {#gestione-contatti}

   1. Il sistema deve consentire la **creazione di contatti.** È possibile creare un singolo contatto alla volta.  
   2. Il sistema deve consentire la **modifica delle informazioni** di contatti esistenti. È possibile modificare un singolo contatto alla volta  
   3. Il sistema deve consentire la **cancellazione di contatti**. È possibile cancellare un singolo contatto alla volta.  
   4. Il sistema deve consentire **l’inserimento di contatti in una “lista preferiti”.** È possibile inserire un contatto alla volta nella lista preferiti.  
   5. Il sistema deve consentire **la cancellazione di contatti in una lista preferiti.** È possibile cancellare un contatto alla volta dalla lista preferiti.  
        
2. [**Informazioni sui Contatti**](#tabella-informazione-sui-contatti)  
   1. Ogni contatto deve avere **un nome e un cognome**, con la possibilità che uno dei due possa essere vuoto (ma non entrambi).  
   2. Ogni contatto deve poter avere **da zero a tre numeri di telefono**. Ogni numero di telefono può contenere solo numeri.  
   3. Ogni contatto deve poter avere **da zero a tre indirizzi e-mail**. Ogni e-mail deve essere in un formato valido.  
   4. È possibile aggiungere una **breve descrizione** opzionale al contatto.  
   5. È possibile caricare una **foto profilo** per il contatto.  
        
3. [**Interfaccia Grafica (GUI)**](#tabella-interfaccia-grafica)  
   1. Il sistema deve fornire un'**interfaccia grafica intuitiva** per l'interazione con l'utente.  
        
4. [**Salvataggio e Caricamento**](#tabella-salvataggio-e-caricamento)  
   1. Il sistema deve consentire il **salvataggio delle informazioni** di tutti i contatti su un file.  
   2. Il sistema deve consentire il **caricamento delle informazioni** di tutti i contatti da un file.  
        
5. [**Visualizzazione dei Contatti**](#tabella-visualizzazione-dei-contatti)  
   1. Il sistema deve visualizzare i contatti in una **lista ordinata alfabeticamente** (prima per cognome e poi per nome).  
   2. È possibile selezionare un contatto dalla lista per visualizzarne le **informazioni dettagliate.**  
   3. È possibile **visualizzare una lista dei contatti preferiti.**  
        
6. [**Ricerca dei Contatti**](#tabella-ricerca-dei-contatti)  
   1. Il sistema deve consentire la ricerca di un contatto inserendo una **sottostringa iniziale del nome o del cognome**.  
   2. Il sistema deve consentire la ricerca di un contatto tramite il **numero di telefono**.  
        
        
      

### **Descrizione Requisiti Non Funzionali** {#descrizione-requisiti-non-funzionali}

1. [**Usabilità**](#tabella-usabilità)  
   1. L'interfaccia grafica deve essere **user-friendly e facilmente navigabile.**  
2. [**Affidabilità**](#tabella-affidabilità)  
   1. Il sistema deve garantire la **corretta gestione dei dati**, evitando perdite di informazioni durante il salvataggio e il caricamento.  
3. [**Portabilità**](#tabella-portabilità)  
   1. Il sistema deve essere **compatibile con i principali sistemi operativi** (Windows, macOS, Linux).

**REQUISITI FUNZIONALI EXTRA**

1. **Condivisione contatti (categoria non si sa)**: Il sistema, tramite una specifica funzionalità, consente di copiare tutte le informazioni relative ad uno specifico contatto.   
2. **Gruppi(gestione contatti)**: Il sistema fornisce la possibilità di selezionare un limitato numero di contatti e creare un gruppo (o categoria), per facilitarne la ricerca.  
   

**Priorità, tipizzazione e tracciabilità**

Le seguenti tabelle hanno lo scopo di:

* individuare i **tipi** dei requisiti seguendo le sei dimensioni di quest’ultimi;  
* individuare le **priorità** di realizzazione dei requisiti seguendo questa suddivisione:  
* **Alta** : il requisito deve essere assolutamente soddisfatto;  
* **Media**: il requisito è importante ma non comporta un fallimento se omesso;  
* **Basso**: il requisito è da soddisfare solo se non richiede grandi sforzi;  
* **tracciare** i requisiti individuando la persona che lo ha definito;

  ## **Tabelle Gestione** {#tabelle-gestione}


| Numero del requisito | Priorità | Tipo | Autore |
| :---- | :---- | :---- | :---- |
| RF 1.1 | Alta | Funzionalità individuale | Cliente |
| RF 1.2 | Alta | Funzionalità individuale | Cliente |
| RF 1.3 | Alta | Funzionalità individuale | Cliente |
| RF 1.4 | Media | Funzionalità individuale | Cliente |
| RF 1.5 | Bassa  | Funzionalità individuale | Cliente |


  # **Tabella Informazione sui Contatti** {#tabella-informazione-sui-contatti}


| Numero del requisito | Priorità | Tipo | Autore |
| :---- | :---- | :---- | :---- |
| RF 2.1 | Alta | Esigenze di dati e informazioni | Cliente |
| RF 2.2 | Alta | Esigenze di dati e informazioni | Cliente |
| RF 2.3 | Alta | Esigenze di dati e informazioni | Cliente |
| RF 2.4 | Media | Esigenze di dati e informazioni | Cliente |
| RF 2.5 | Bassa | Esigenze di dati e informazioni | Cliente |

	

## ---

	**Tabella interfaccia grafica** {#tabella-interfaccia-grafica}

| Numero del requisito | Priorità | Tipo | Autore |
| :---- | :---- | :---- | :---- |
| RF 3.1 | Alta | Interfaccia Utente | Cliente |

## **Tabella Salvataggio e caricamento** {#tabella-salvataggio-e-caricamento}

| Numero del requisito | Priorità | Tipo | Autore |
| :---- | :---- | :---- | :---- |
| RF 4.1 | Alta | Funzionalità Individuale | Cliente  |
| RF 4.2 | Alta | Funzionalità Individuale | Cliente |

---

## 	**Tabella Visualizzazione dei contatti** {#tabella-visualizzazione-dei-contatti}

| Numero del requisito | Priorità | Tipo | Autore |
| :---- | :---- | :---- | :---- |
| RF 5.1 | Alta | Funzionalità Individuale | Cliente |
| RF 5.2 | Media | Funzionalità Individuale | Cliente |

---

## **Tabella Ricerca dei contatti** {#tabella-ricerca-dei-contatti}

| Numero del requisito | Priorità | Tipo | Autore |
| :---- | :---- | :---- | :---- |
| RF 6.1 | Alta | Funzionalità individuale | Cliente |
| RF 6.2 | Bassa | Funzionalità individuale |  |

	  
	

---

## **Tabella Usabilità** {#tabella-usabilità}

| Numero del requisito | Priorità | Tipo | Autore |
| :---- | :---- | :---- | :---- |
| RNF 1.1 | Alta |  | Cliente |

---

## **Tabella affidabilità** {#tabella-affidabilità}

| Numero del requisito | Priorità | Tipo | Autore |
| :---- | :---- | :---- | :---- |
| RNF 2.1 | Alta |  | Cliente |

---

## **Tabella portabilità** {#tabella-portabilità}

| Numero del requisito | Priorità | Tipo | Autore |
| :---- | :---- | :---- | :---- |
| RNF 3.1 | Media |  | Cliente |

**Casi d'Uso per il Sistema di Gestione Contatti**

**Descrizione dei casi d’uso**

### **Casi d'Uso Principali** {#casi-d'uso-principali}

1. **Crea Contatto**  
   Il sistema permette all'utente di aggiungere un nuovo contatto alla rubrica con le relative informazioni.  
2. **Modifica Contatto**  
   Il sistema permette all'utente di modificare le informazioni di un contatto esistente dopo averne visualizzato i dettagli.  
3. **Cancella Contatto**  
   Il sistema consente all'utente di eliminare un contatto esistente dopo averne visualizzato i dettagli.  
4. **Visualizza Rubrica**  
   Il sistema mostra l’elenco completo dei contatti, ordinati alfabeticamente per cognome e nome.  
5. **Salva Rubrica**  
   Il sistema permette all'utente di salvare l'intera rubrica in un file.  
6. **Carica Rubrica**  
   Il sistema consente di caricare un file contenente contatti per aggiornare o ripristinare la rubrica.  
7. **Cerca Contatto**  
   Il sistema consente di cercare un contatto nella rubrica inserendo una sottostringa iniziale del nome o del cognome, o mediante il numero di telefono.  
8. **Visualizza Dettagli Contatto**  
   Il sistema consente all'utente di selezionare un contatto dall'elenco per visualizzarne i dettagli completi.  
9. **Aggiungi Contatto alla Lista Preferiti**  
   Il sistema permette di aggiungere un contatto alla lista dei preferiti durante la creazione o visualizzazione di un contatto.  
10. **Visualizza Preferiti**                                                                                                     Il sistema mostra l’elenco dei contatti contrassegnati come preferiti.  
11. **Aggiungi Contatto a un Gruppo**  
    Il sistema consente di aggiungere un contatto a uno o più gruppi durante la creazione o visualizzazione di un contatto.  
12. **Crea Gruppo**  
    Il sistema permette di creare un nuovo gruppo per classificare i contatti.  
13. **Visualizza Gruppi**  
    Il sistema consente all'utente di visualizzare l'elenco dei gruppi esistenti.  
14. **Visualizza Contatti in un Gruppo**  
    Il sistema consente di visualizzare l’elenco di tutti i contatti appartenenti a uno specifico gruppo.  
  


### **UC1: Crea Contatto** {#uc1:-crea-contatto}

**Attori**: Utente  
**Precondizioni**: L’interfaccia grafica è avviata e l’utente sta visualizzando la rubrica.  
**Flusso principale**:

1. L'utente seleziona l'opzione **"Crea Nuovo Contatto"**.  
2. Il sistema visualizza una finestra di dialogo per l'inserimento dei dati del contatto.  
3. L'utente inserisce almeno il nome o il cognome (obbligatorio).  
4. L'utente può inserire fino a tre numeri di telefono e tre indirizzi e-mail.  
5. L'utente può aggiungere una descrizione opzionale e una foto profilo.  
6. L'utente conferma l'inserimento cliccando sul pulsante "Salva".  
7. Il sistema verifica la correttezza dei dati (es. formato e-mail) e salva il contatto.  
8. Il sistema aggiorna la lista dei contatti ordinata alfabeticamente.

**Flussi alternativi**:

* \[UC1.A1\] **Campi vuoti obbligatori**: Se né il nome né il cognome sono forniti, il sistema mostra un messaggio di errore e richiede la correzione.

**Eccezioni**:

* \[UC1.E1\] **Dati non validi**: Se un numero di telefono o un indirizzo e-mail non sono in un formato valido, il sistema segnala l’errore specifico e richiede la correzione.

**Post-condizioni**:

* Il nuovo contatto è salvato nella rubrica e visibile nella lista.

### **UC2: Modifica Contatto** {#uc2:-modifica-contatto}

**Attori**: Utente

**Precondizioni**:

* La rubrica contiene almeno un contatto.  
* L'utente ha visualizzato i dettagli di un contatto (riferimento a **UC4: Visualizza Dettagli Contatto**).

**Flusso principale**:

1. Dopo aver visualizzato i dettagli di un contatto (UC4), l’utente seleziona l’opzione **"Modifica"**.  
2. Il sistema apre una finestra per l’editing dei campi del contatto (nome, cognome, numeri di telefono, e-mail, ecc.).  
3. L'utente apporta le modifiche desiderate.  
4. L'utente conferma cliccando su **"Salva"**.  
5. Il sistema valida i dati inseriti e aggiorna il contatto con le modifiche.  
6. Il sistema chiude la finestra di modifica e torna alla lista dei contatti.

**Flussi alternativi**:

* \[UC2.A1\] **Annullamento**: L'utente seleziona l’opzione **"Annulla"** invece di salvare. Nessuna modifica viene applicata.

**Post-condizioni**:

* Il contatto selezionato è aggiornato con i nuovi dati.

---

### **UC3: Cancella Contatto** {#uc3:-cancella-contatto}

**Attori**: Utente

**Precondizioni**:

* La rubrica contiene almeno un contatto.  
* L'utente ha visualizzato i dettagli di un contatto (riferimento a **UC4: Visualizza Dettagli Contatto**).

**Flusso principale**:

1. Dopo aver visualizzato i dettagli di un contatto (UC4), l’utente seleziona l’opzione **"Elimina"**.  
2. Il sistema mostra un messaggio di conferma: *"Sei sicuro di voler eliminare questo contatto?"*.  
3. L'utente conferma selezionando **"Sì"**.  
4. Il sistema rimuove il contatto dalla rubrica.  
5. Il sistema aggiorna la lista dei contatti visibili, escludendo il contatto eliminato.

**Flussi alternativi**:

* \[UC3.A1\] **Annullamento**: L'utente seleziona l’opzione **"No"** nella finestra di conferma. Il contatto non viene eliminato e il sistema torna alla visualizzazione del contatto.

**Post-condizioni**:

* Il contatto selezionato è rimosso dalla rubrica.

### **UC4: Visualizza Rubrica** {#uc4:-visualizza-rubrica}

**Attori**: Utente

**Precondizioni**:

* L'applicazione è avviata e l'utente si trova nella schermata principale.  
* La rubrica contiene almeno un contatto.

**Flusso principale**:

1. L'utente accede alla schermata principale dell’applicazione.  
2. Il sistema visualizza l’elenco di tutti i contatti salvati nella rubrica.  
   * I contatti sono ordinati alfabeticamente per cognome e, a parità di cognome, per nome.  
   * Ogni contatto è rappresentato da una scheda o riga che mostra informazioni essenziali (es. nome, cognome, primo numero di telefono o indirizzo e-mail).  
3. L'utente può scorrere l’elenco dei contatti.  
4. L'utente può selezionare un contatto per visualizzarne i dettagli (riferimento a **UC8**).

**Flussi alternativi**:

* \[UC9.A1\] **Rubrica vuota**:  
  1. Se la rubrica non contiene contatti, il sistema mostra un messaggio che informa l’utente: *"Non ci sono contatti salvati nella rubrica"*.  
  2. L'utente può accedere alle opzioni per creare un nuovo contatto (riferimento a **UC1**).

**Eccezioni**:

* Nessuna eccezione prevista per questo caso d’uso.

**Post-condizioni**:

* L'utente ha visualizzato l’elenco dei contatti attualmente salvati nella rubrica.  
* Se l'utente ha selezionato un contatto, il sistema ha fornito i dettagli del contatto selezionato.


### **UC7: Cerca Contatto** {#uc7:-cerca-contatto}

**Attori**: Utente  
**Precondizioni**: La rubrica contiene almeno un contatto.

**Flusso principale**:

1. L'utente inserisce un termine di ricerca (es. una sottostringa del nome o cognome) nella barra di ricerca.  
2. Il sistema filtra i contatti e mostra i risultati corrispondenti.  
3. L'utente può selezionare un contatto dai risultati per visualizzarne i dettagli.

**Flussi alternativi**:

* \[UC5.A1\] **Ricerca tramite numero di telefono**: L'utente inserisce un numero di telefono, e il sistema filtra i contatti per numero.

**Post-condizioni**:

* I risultati della ricerca sono visualizzati.  
  ---

### **UC5: Salva Rubrica** {#uc5:-salva-rubrica}

**Attori**: Utente  
**Precondizioni**: La rubrica contiene almeno un contatto.

**Flusso principale**:

1. L'utente seleziona l’opzione **"Salva Rubrica"**.  
2. Il sistema richiede di specificare un nome e un percorso per il file.  
3. L'utente conferma.  
4. Il sistema salva tutti i contatti in un file nel formato specificato (es. CSV o JSON).

**Post-condizioni**:

* La rubrica è salvata correttamente nel file specificato.  
  ---

### **UC6: Carica Rubrica**  {#uc6:-carica-rubrica}

**Attori**: Utente  
**Precondizioni**: Esiste un file di rubrica valido salvato in precedenza.

**Flusso principale**:

1. L'utente seleziona l’opzione **"Carica Rubrica"**.  
2. Il sistema consente all'utente di scegliere un file.  
3. L'utente conferma.  
4. Il sistema carica i dati dal file e li aggiunge o sostituisce i contatti attuali.

**Eccezioni**:

* \[UC7.E1\] **File non valido**: Se il file non è valido, il sistema segnala l’errore e annulla il caricamento.

**Post-condizioni**:

* La rubrica è aggiornata con i dati del file caricato.

### **UC7: Cerca Contatto** {#uc7:-cerca-contatto-1}

**Attori**: Utente  
**Precondizioni**: La rubrica contiene almeno un contatto.

**Flusso principale**:

4. L'utente inserisce un termine di ricerca (es. una sottostringa del nome o cognome) nella barra di ricerca.  
5. Il sistema filtra i contatti e mostra i risultati corrispondenti.  
6. L'utente può selezionare un contatto dai risultati per visualizzarne i dettagli.

**Flussi alternativi**:

* \[UC5.A1\] **Ricerca tramite numero di telefono**: L'utente inserisce un numero di telefono, e il sistema filtra i contatti per numero.

**Post-condizioni**:

* I risultati della ricerca sono visualizzati.  
  


---

### **UC8: Visualizza Dettagli Contatto** {#uc8:-visualizza-dettagli-contatto}

**Attori**: Utente

**Precondizioni**:

* La rubrica contiene almeno un contatto.

**Flusso principale**:

1. L'utente seleziona un contatto dall’elenco nella rubrica (riferimento a **UC4: Visualizza Rubrica**).  
2. Il sistema mostra una schermata con i dettagli completi del contatto, inclusi:  
   * Nome e cognome.  
   * Numeri di telefono.  
   * Indirizzi e-mail.  
   * Descrizione e immagine (se presenti).  
3. L'utente può scegliere tra le opzioni disponibili:  
   * **Modifica Contatto** (riferimento a UC2).  
   * **Elimina Contatto** (riferimento a UC3).  
   * **Torna alla Lista dei Contatti**.

**Post-condizioni**:

* I dettagli del contatto selezionato sono visibili.

### **UC9: Aggiungi Contatto alla Lista Preferiti** {#uc9:-aggiungi-contatto-alla-lista-preferiti}

**Attori**: Utente

**Precondizioni**:

* L'utente ha iniziato la creazione di un nuovo contatto (riferimento a **UC1: Crea Contatto**) **oppure** ha visualizzato i dettagli di un contatto esistente (riferimento a **UC4: Visualizza Dettagli Contatto**).

**Flusso principale**:

1. Durante la creazione o la visualizzazione di un contatto, l'utente seleziona l'opzione **"Aggiungi ai Preferiti"**.  
2. Il sistema verifica che il contatto non sia già presente nella lista dei preferiti.  
3. Il sistema aggiunge il contatto alla lista dei preferiti.  
4. Il sistema conferma l’operazione con un messaggio del tipo: *"Il contatto è stato aggiunto ai preferiti."*.

**Flussi alternativi**:

* \[UC11.A1\] **Contatto già nei Preferiti**:  
  1. Il sistema informa l'utente che il contatto è già nella lista dei preferiti con un messaggio: *"Il contatto è già nei preferiti."*.  
  2. Nessuna modifica viene effettuata.

**Post-condizioni**:

* Il contatto selezionato è presente nella lista dei preferiti.

  ### **UC10: Visualizza Preferiti** {#uc10:-visualizza-preferiti}

**Attore**: Utente

---

**Precondizioni**:

1. L’utente deve aver avviato il software ed essere nella schermata principale.  
2. Almeno un contatto deve essere stato aggiunto alla lista dei preferiti.  
   ---

**Postcondizioni**:

1. L’elenco dei contatti contrassegnati come "Preferiti" è visualizzato, ordinato alfabeticamente per cognome e nome.  
2. L’utente può interagire con i contatti preferiti (visualizzarne i dettagli, modificarli, o rimuoverli dalla lista preferiti).  
   ---

**Flusso di eventi principale**:

1. L’utente seleziona l’opzione **"Visualizza Preferiti"** dalla barra dei menu o dalla schermata principale.  
2. Il sistema accede alla lista dei contatti contrassegnati come "Preferiti".  
3. Il sistema ordina i contatti preferiti alfabeticamente per cognome e nome.  
4. Il sistema visualizza l’elenco dei contatti preferiti in formato tabellare o a lista. Ogni riga include:  
   * Nome  
   * Cognome  
   * Numero di telefono principale  
   * Icona per accedere ai dettagli del contatto  
5. L’utente può selezionare un contatto dall’elenco per visualizzarne i dettagli o eseguire altre operazioni (come modificarlo o rimuoverlo dai preferiti).  
   ---

**Flusso di eventi alternativi**:

* **Nessun contatto preferito presente**:  
  1. Se non ci sono contatti contrassegnati come "Preferiti", il sistema visualizza un messaggio informativo del tipo:  
     *"Nessun contatto preferito disponibile. Aggiungi contatti alla lista dei preferiti per accedere a questa funzionalità."*  
  2. Il sistema permette all’utente di tornare alla schermata principale o alla lista completa dei contatti.

  ---

**Eccezioni**:

* **Errore di accesso ai dati**:  
  1. Se il sistema non riesce a recuperare i dati dei contatti preferiti (ad esempio, a causa di un problema tecnico), viene visualizzato un messaggio d’errore:  
     *"Errore durante il recupero della lista preferiti. Riprova più tardi."*  
  2. L’utente può scegliere di riprovare o tornare alla schermata principale.

  ---

**Dettagli addizionali**:

* **Ordinamento dinamico**: L’utente può scegliere di ordinare i contatti preferiti per nome, cognome, o data di aggiunta alla lista preferiti.  
* **Filtri**: Il sistema offre un’opzione per filtrare i contatti preferiti in base a criteri come tag personalizzati o gruppo di appartenenza (se implementato).  
* **Rimozione rapida**: Accanto a ciascun contatto, il sistema fornisce un’icona o pulsante per rimuoverlo rapidamente dalla lista dei preferiti senza dover accedere ai dettagli del contatto.


### **UC11: Aggiungi Contatto a un Gruppo** {#uc11:-aggiungi-contatto-a-un-gruppo}

**Attori**: Utente

**Precondizioni**:

* L'utente ha iniziato la creazione di un nuovo contatto (riferimento a **UC1: Crea Contatto**) **oppure** ha visualizzato i dettagli di un contatto esistente (riferimento a **UC8: Visualizza Dettagli Contatto**).  
* Almeno un gruppo esiste nel sistema.

**Flusso principale**:

1. Durante la creazione o la visualizzazione di un contatto, l'utente seleziona l'opzione **"Aggiungi a Gruppo"**.  
2. Il sistema visualizza un elenco di gruppi disponibili.  
3. L'utente seleziona uno o più gruppi dall’elenco.  
4. Il sistema associa il contatto ai gruppi selezionati.  
5. Il sistema conferma l’operazione con un messaggio del tipo: *"Il contatto è stato aggiunto ai gruppi selezionati."*.

**Flussi alternativi**:

* \[UC11.A1\] **Nessun gruppo selezionato**:  
  1. L'utente chiude la finestra di selezione dei gruppi senza selezionare alcun gruppo.  
  2. Nessuna modifica viene effettuata e il sistema ritorna alla schermata precedente.

**Post-condizioni**:

* Il contatto selezionato è associato ai gruppi scelti.  
  


### **UC12: Crea Gruppo** {#uc12:-crea-gruppo}

**Attori**: Utente  
**Precondizioni**: Almeno due contatti esistono nella rubrica.

**Flusso principale**:

1. L'utente seleziona l’opzione **"Crea Gruppo"**.  
2. Il sistema visualizza una finestra con l’elenco dei contatti disponibili.  
3. L'utente seleziona uno o più contatti da includere nel gruppo.  
4. L'utente inserisce un nome per il gruppo.  
5. L'utente conferma cliccando su "Salva".  
6. Il sistema verifica che il nome del gruppo sia univoco.  
7. Il gruppo viene creato e salvato con i contatti associati.

**Flussi alternativi**:

* \[UC8.1.A1\] **Annullamento**: L'utente seleziona "Annulla" invece di "Salva". Nessun gruppo viene creato.

**Eccezioni**:

* \[UC8.1.E1\] **Nome duplicato**: Se il nome del gruppo è già in uso, il sistema segnala l’errore e richiede di inserire un nome diverso.

**Post-condizioni**:

* Un nuovo gruppo con i contatti selezionati è salvato nel sistema.  
  ---

### **UC13: Visualizza Gruppi** {#uc13:-visualizza-gruppi}

**Attori**: Utente

**Precondizioni**: Almeno un gruppo esiste nel sistema.

**Flusso principale**:

1. L'utente seleziona l’opzione **"Visualizza Gruppi"**.  
2. Il sistema mostra un elenco di tutti i gruppi disponibili, ordinati alfabeticamente per nome.  
3. L'utente può selezionare un gruppo dall’elenco per visualizzarne i contatti (riferimento a UC8.3).

**Post-condizioni**:

* L’elenco dei gruppi è visibile e accessibile.  
  ---

### **UC14: Visualizza Contatti in un Gruppo** {#uc14:-visualizza-contatti-in-un-gruppo}

**Attori**: Utente

**Precondizioni**: Almeno un gruppo esiste nel sistema e contiene almeno un contatto.

**Flusso principale**:

1. L'utente seleziona un gruppo dall’elenco visualizzato (UC8.2).  
2. Il sistema mostra i contatti associati al gruppo selezionato in un elenco ordinato alfabeticamente.  
3. L'utente può selezionare un contatto per visualizzarne i dettagli (riferimento a UC4).

**Flussi alternativi**:

* \[UC8.3.A1\] **Gruppo vuoto**: Se il gruppo selezionato non contiene contatti, il sistema mostra un messaggio che indica che il gruppo è vuoto.

**Post-condizioni**:

* I contatti del gruppo selezionato sono visibili e accessibili.


