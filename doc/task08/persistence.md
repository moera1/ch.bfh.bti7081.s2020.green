# Persistence

### tech stack
jdbc/jpa/ORMLite
h2(in-memory) & sqlite

## HealthClientManager & HealthVisitorManager
Der *HealthClientManager* und der *HealthVisitorManager* sind die internen Schnittstellen für jegliche personenbezogene Daten und dienen für deren Bezug und Verarbeitung bzw. Bereitstellung für die **protomed** Kadex-Applikation.
Die Daten werden dann über die Laufzeit gecached. Wiederholter Datenbezug einbaubar. 

## PersistenceManager
Der *PersistenceManager* erstellt und hält die Verbindung zur Datenbank.
Weiter trägt bzw. stellt er DAOs für die zu perstitierenden Entitäten bereit.
Insbesondere für die Persistenz im in-memory-Betrieb stellt er Mockdaten zur Verfügung.

## ApplicationModelManager
Der *ApplicationModelManager* liefert, über die vom *PersistenceManager* bereitgestellten DAOs, die für die Applikation relevanten CRUD-Funktionalitäten und ist auch eine Sammelstelle für speziellere Queries.

## KadexInitializer
Da diese Manager vorwiegend Singletons sind und einerseits einer Initialisierung bedürfen, andererseits voneinander abhängig sind, wurde der *KadexInitializer* ins Leben gerufen. Er stellt sicher, dass alle Manager in der richtigen Reihenfolge instanziert und initialisiert werden.
