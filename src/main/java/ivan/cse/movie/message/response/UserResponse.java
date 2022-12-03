package ivan.cse.movie.message.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    public String username;
    public String email;
    public String mobileNo;

}
