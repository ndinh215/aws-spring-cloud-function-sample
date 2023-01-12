# Setup & Run

Run following command to generate deployable / uploadable .jar file.

```
$mvn clean package
```

This gnerates a JAR file <b>'cloud-function-0.0.1-SNAPSHOT-aws.jar'</b> under target folder.

In AWS Lambda Function, add handler: 
```org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest```


Test lambda with data:
``` {"memberId":"1234567890"} ```
