#Zadania JPA/Hibernate

W klasie `JpaUserRepository`, `JpaPostRepository` i `JpaFollowRepository` należy zaimplementować 
interfejsy odpowiednio `UserRepository`, `PostRepository` i `FollowRepository` oraz metody tam zadeklarowane.
Do każdej metody w interfejsach zostały napisane testy automatyczne. 

Przed rozpoczęciem zadań należy:
1. włączyć annotation procesor w ustwieniach IntellJ 
    * Build, Execution, Deployment -> Compiler -> Annotation Processors
2. stworzyć bazę danych o nazwie `twitter` oraz odpowiednią strukturę.
    * skrypty znajdują się w katalogu `/baza`
4. stworzyć osobnego brancha na którym będziesz pracować.
3. zdefiniować jednostkę persystencji w pliku `/resources/META-INF/persistence.xml`
    * na potrzeby testów proszę o zdefiniowanie propertisów do bazy w klasie
    `EntityManagerProvider.getEntityManagerProps()`
4. dodać potrzebne zależności do pom.xml.
    * ```xml
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <version>8.0.17</version>
      </dependency>
       <dependency>
          <groupId>org.hibernate</groupId>
          <artifactId>hibernate-core</artifactId>
          <version>5.4.0.Final</version>
       </dependency>

Uwaga! Dane są usuwane z bazy przed każdym uruchomieniem testów.

Zadania do zrobienia:
1. Zaimplementuj metody które pozwolą wykonywać operacje na tabeli użytkowników:
    * Sprawdzić połączenie z bazą (użyj metody isValid()).
    * Pobrać wszystkich użytkowników. 
    * Dodać użytkownika. 
    * Znaleźć użytkownika po loginie. 
    * Zmienić hasło użytkownika.
    * Usunąć użytkownika.
2. Zaimplementuj metody które pozwolą wykonywać operacje na tabeli postów:
    * Pobrać wszystkie posty użytkownika.
    * Pobrać posty z dnia dzisiejszego.
    * Znaleźć post po Id.
    * Wyedytować treść posta.
    * Usunąć post.
    * Pobierać posty tylko obserwowanych użytkowników (dla chętnych).
3. Dodaj możliwość obserwowanie (follow) użytkownika przez drugiego użytkownika 
oraz możliwość zaprzestania subskrypcji.
