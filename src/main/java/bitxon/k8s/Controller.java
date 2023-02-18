package bitxon.k8s;


import java.security.SecureRandom;

import bitxon.k8s.triks.Enabler;
import bitxon.k8s.triks.Waiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class Controller {

    private final Waiter waiter;
    private final Enabler enabler;

    private final Integer value = new SecureRandom().nextInt(1, 100);


    @GetMapping(value = "/hello")
    public ResponseEntity<String> get() {
        if (waiter.isNotReady()) {
            return ResponseEntity.internalServerError().body("APPLICATION NOT READY");
        }

        return ResponseEntity.ok("Hello: " + value);
    }

    @PostMapping(value = "/enabler/disable")
    public ResponseEntity<String> disable() {
        if (waiter.isNotReady()) {
            return ResponseEntity.internalServerError().body("APPLICATION NOT READY");
        }

        enabler.setEnable(false);
        return ResponseEntity.ok("Done");
    }
}
