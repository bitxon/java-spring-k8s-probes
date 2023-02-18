package bitxon.k8s.health;

import bitxon.k8s.triks.Waiter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("startupWaiter")
@RequiredArgsConstructor
public class WaiterHealthIndicator implements HealthIndicator {

    private final Waiter waiter;

    @Override
    public Health health() {
        if (waiter.isReady()) {
            return Health.up()
                .withDetail("message", "Ready")
                .build();
        } else {
            return Health.down()
                .withDetail("message", "Please wait " + waiter.secondsToWait())
                .build();
        }
    }
}
