Per la creazione del database: Creare un database di nome Aereoporto su PGAdmin eseguire nel query editor il testo contenuto nel file "Creazione Database" in seguito eseguire nella stesso query editor il testo contenuto nel file "popolazione database" 

Per inserire una tratta in ritardo inserire o aggiornare uno slot relativo a quella tratta con TempoDiImbarcoStimato > TempoDiImbarcoEffettivo 

Negli inserimenti di Gate, Coda di imbarco e Slot la data viene inserita automaticamente da un Trigger che la ottiene dai loro collegamenti
la stessa cosa è valida per Ngate in Slot quindi nei loro inserimenti questi valori possono essere impostati a null. 

il tipo di Biglietto puo assumere solo determinati valori per effettuare questo controllo si utilizza un comboBox nel codice stessa cosa valida per Ngate Data ed altri valori i cui controlli vengono effettuati nel codice utilizzando una combinazione di comboBox e metodi della classe Controller.