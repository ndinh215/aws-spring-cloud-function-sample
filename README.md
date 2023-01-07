# Setup

## Generate deployable Artifacts

Run following command to generate deployable / uploadable .jar file.

```
$mvn clean package
```

This gnerates a JAR file <b>'cloud-function-0.0.1-SNAPSHOT-aws.jar'</b> under target folder. Serverless Framework
uploads this JAR file to AWS Lambda.

### Run the function with data

```
'{"memberId":"1234567890"}'
```

This will invoke the function by passing the Member ID. You would see console output with response <b>MEDICAL</b> as
below.

```
{
    "memberId": "1234567890",
    "coverage": "MEDICAL"
}
--------------------------------------------------------------------
START RequestId: ae39247a-7c6d-11e8-b022-eb1234c7df4f Version: $LATEST
13:58:36.347 [main] INFO org.springframework.cloud.function.adapter.aws.SpringFunctionInitializer - Initializing: class com.healthfirst.memberfunction.MemberFunctionApplication

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                        

2018-06-30 13:58:39.013  INFO 1 --- [           main] lambdainternal.LambdaRTEntry             : Starting LambdaRTEntry on ip-10-22-39-231.ec2.internal with PID 1 (/var/runtime/lib/LambdaJavaRTEntry-1.0.jar started by sbx_user1060 in /)
2018-06-30 13:58:39.016  INFO 1 --- [           main] lambdainternal.LambdaRTEntry             : No active profile set, falling back to default profiles: default
2018-06-30 13:58:39.297  INFO 1 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@23fe1d71: startup date [Sat Jun 30 13:58:39 UTC 2018]; root of context hierarchy
2018-06-30 13:58:44.069  INFO 1 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2018-06-30 13:58:44.152  INFO 1 --- [           main] lambdainternal.LambdaRTEntry             : Started LambdaRTEntry in 7.536 seconds (JVM running for 8.879)
END RequestId: ae39247a-7c6d-11e8-b022-eb1234c7df4f
REPORT RequestId: ae39247a-7c6d-11e8-b022-eb1234c7df4f  Duration: 8002.57 ms    Billed Duration: 8100 ms        Memory Size: 1024 MB    Max Memory Used: 142 MB 

```
