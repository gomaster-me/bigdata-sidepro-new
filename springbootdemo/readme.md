## install sdk
	-- sdk install java
	-- sdk install springboot
	-- sdk install gradle

## install docker

## install sublime3 and VinTage和VinTageEx plugin

## new WebApp.groovy  

```groovy
@RestController
class WebApp{
	@RequestMapping("/")
	String greeting(){
		"greeting from groovy"
	}

}
```

just run `spring run WebApp.groovy`

```java
package springbootdemo 
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 

@RestController
@SpringBootApplication
public class WebApp2{
	@RequestMapping("/")
	public String greetings(){
		return "Greetings from spring boot";
	}
	public static void main(String[] args) {
		SpringApplication.run(WebApp2.class,args)
	}
}

```

notice: just create file and run. the spring-cli will download the dependency. until now, it has no any config file . even pom,gradle script or properties. just one file groovy or java.


## config build.gradle

```gradle
buildscript {

	ext {
		springBootVersion = '1.5.7.RELEASE'
	}

	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
	}

}

apply plugin: ‘java'
apply println 'idea'
apply plugin: 'spring-boot'

jar {
	baseName = 'myapp'
	version = '0.0.1-SNAPSHOT'
}

allprojects {
    repositories {
        maven{ url 'http://maven.aliyun.com/nexus/content/groups/public'}
        maven{ url 'http://maven.aliyun.com/nexus/content/repositories/jcenter'}
    }
}

dependencies {
	compile('org.springframework.boot:spring-boot-starter-web')
	compile("org.springframework.boot:spring-boot-starter-test")
}
```

notice: repository server
https://xiexianbin.cn/java/2016/12/18/change-gradle-maven-repo-url

## spring boot cli
`spring init --list`
`spring init -dweb --build gradle myapp`

### run
- gradle
./gradlew bootRun (project level)
gradlew bootRun  (global level or youself level)

- fat jar
1. gradle clean build 
2. java -jar ...
