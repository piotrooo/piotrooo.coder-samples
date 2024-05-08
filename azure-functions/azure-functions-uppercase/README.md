# azure-functions-uppercase

## Test Spring Cloud Functions

Test only functions without Azure context.

```shell
./gradlew clean bootRun
```

## Run locally

Run locally without calling Azure, just running in Azure Functions Worker.

```shell
./gradlew clean azureFunctionsRun
```

## Deploy

```shell
./gradlew clean azureFunctionsDeploy
```
