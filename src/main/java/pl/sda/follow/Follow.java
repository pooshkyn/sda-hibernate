package pl.sda.follow;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// <-- lombok
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"creationDate", "follower", "followee"})
// lombok -->
public class Follow {

    /*id, follower, followee, creationDate*/

}
