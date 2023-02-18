package bitxon.k8s;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Value
@Validated
@ConfigurationProperties(prefix = "app")
public class Properties {

    @Min(0)
    @NotNull
    Long delayToBeHealth;
}
