package pl.sda.post.domain;

import java.util.List;
import java.util.Optional;

interface PostRepository {
    //Znajdź posty użytkownika
    List<Post> findUserPosts(String username);

    //Dodaj post i zwróć jego identyfikator
    int addPost(Post post);

    //Pobierz posty z dnia dzisiejszego
    List<Post> findDailyPosts();

    //Znajdź post po identyfikatorze
    Optional<Post> findById(int id);

    //Zmień treść posta
    void editPost(int id, String newText);

    //Usuń post
    void deletePost(int id);

    //Dla chętnych pobranie postów tylko followanych użytkowników
}
