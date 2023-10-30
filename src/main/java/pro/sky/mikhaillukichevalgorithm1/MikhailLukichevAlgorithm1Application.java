package pro.sky.mikhaillukichevalgorithm1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MikhailLukichevAlgorithm1Application {

	public static void main(String[] args) {
//		SpringApplication.run(MikhailLukichevAlgorithm1Application.class, args);

		StringList stringList = new StringListImpl(5);

		stringList.add("0");
		stringList.add("1");
		stringList.add("2");
		stringList.add("3");
		stringList.add("4");
		System.out.println(stringList.print());

	}

}
