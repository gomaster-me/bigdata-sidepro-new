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
