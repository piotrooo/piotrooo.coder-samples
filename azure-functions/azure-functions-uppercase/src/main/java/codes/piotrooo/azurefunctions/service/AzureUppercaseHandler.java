package codes.piotrooo.azurefunctions.service;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.microsoft.azure.functions.HttpMethod.GET;
import static com.microsoft.azure.functions.HttpMethod.POST;
import static com.microsoft.azure.functions.annotation.AuthorizationLevel.ANONYMOUS;

@Component
public class AzureUppercaseHandler {
    private final UppercaseFunction uppercaseFunction;

    public AzureUppercaseHandler(UppercaseFunction uppercaseFunction) {
        this.uppercaseFunction = uppercaseFunction;
    }

    @FunctionName("uppercase")
    public String execute(
            @HttpTrigger(
                    name = "request",
                    methods = {GET, POST},
                    authLevel = ANONYMOUS
            ) HttpRequestMessage<Optional<String>> request,
            ExecutionContext context
    ) {
        String body = request.getBody().orElse(null);

        // We can log something
        context.getLogger().info("Trying to uppercase string [%s]...".formatted(body));

        return uppercaseFunction.apply(body);
    }
}
