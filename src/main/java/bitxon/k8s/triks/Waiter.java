package bitxon.k8s.triks;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import bitxon.k8s.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Waiter {
    private final LocalDateTime startTime;
    private final long delayToBeHealth;

    @Autowired
    public Waiter(Properties properties) {
        this.startTime = LocalDateTime.now();
        this.delayToBeHealth = properties.getDelayToBeHealth();
    }

    public boolean isReady() {
        return secondsToWait() <= 0;
    }

    public boolean isNotReady() {
        return !isReady();
    }

    public long secondsToWait() {
        var secondsToWait = delayToBeHealth - secondsAfterStart();
        if (secondsToWait <= 0) {
            return 0;
        }
        return secondsToWait;
    }

    private long secondsAfterStart() {
        var now = LocalDateTime.now();
        return Duration.between(startTime, now).get(ChronoUnit.SECONDS);
    }

}
