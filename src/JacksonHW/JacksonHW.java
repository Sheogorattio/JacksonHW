package JacksonHW;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JacksonHW {
	public static void main(String[] args) {
		Person person = new Person("John Doe", 30);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// Сериализация объекта в JSON
			String json = objectMapper.writeValueAsString(person);
			System.out.println(json);

			// Запись в JSON файл
			objectMapper.writeValue(new File("person.json"), person);
			System.out.println("Объект записан в person.json");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}
	}
}
