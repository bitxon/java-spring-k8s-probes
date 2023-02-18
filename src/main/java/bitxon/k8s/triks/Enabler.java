package bitxon.k8s.triks;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Enabler {

    private boolean enable = true;
}
