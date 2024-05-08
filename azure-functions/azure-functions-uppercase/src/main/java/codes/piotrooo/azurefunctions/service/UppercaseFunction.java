package codes.piotrooo.azurefunctions.service;

import org.springframework.stereotype.Component;

import java.util.function.Function;

import static org.springframework.util.StringUtils.hasText;

@Component
public class UppercaseFunction implements Function<String, String> {
    @Override
    public String apply(String message) {
        String payload = hasText(message) ? message : "default";
        return payload.toUpperCase();
    }
}
