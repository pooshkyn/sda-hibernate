package pl.sda.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.sda.follow.Follow;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/* <--lombok */
@Builder
@Getter
@Setter
@ToString(exclude = {"followers", "followees"})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"followers", "followees"})
/* lombok --> */

public class User {
   /*username, password, followers, followee*/
}
