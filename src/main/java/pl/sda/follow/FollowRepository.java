package pl.sda.follow;

public interface FollowRepository {

    //Dowolny użytkownik może followować innego użytkownika (dodać do obserwowanych).
    int follow(String follower, String followee);

    //Dowolny użytkownik może zrezygnować ze followowania (śledzenia) danego użytkownika.
    void unfollow(String follower, String followee);
}
