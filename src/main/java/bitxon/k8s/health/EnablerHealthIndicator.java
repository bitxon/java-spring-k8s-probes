package bitxon.k8s.health;

import bitxon.k8s.triks.Enabler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("systemEnabler")
@RequiredArgsConstructor
public class EnablerHealthIndicator implements HealthIndicator {

    private final Enabler enabler;

    @Override
    public Health health() {
        if (enabler.isEnable()) {
            return Health.up().withDetail("system", "on").build();
        } else {
            return Health.down().withDetail("system", "off").build();
        }
    }
}
