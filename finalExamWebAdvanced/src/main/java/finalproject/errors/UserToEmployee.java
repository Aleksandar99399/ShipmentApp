package finalproject.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.IM_USED, reason = "User cannot be accessed")
public class UserToEmployee extends RuntimeException {
}
