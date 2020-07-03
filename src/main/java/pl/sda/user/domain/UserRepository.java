package pl.sda.user.domain;

import java.util.List;
import java.util.Optional;

interface UserRepository {

    //Połącz się do bazy i zwróć flagę czy się udało (isValid)
    boolean isConnectionValid();

    //Pobierz wszystkich użytkowników.
    List<User> findAll();

    //Dodaj użytkownika.
    void addUser(User user);

    //Znajdź użytkownika po loginie.
    Optional<User> findByUsername(String username);

    //Zmień hasło użytkownika.
    void changePassword(String username, String password);

    //Usuń użytkownika.
    void deleteByUsername(String username);
}


