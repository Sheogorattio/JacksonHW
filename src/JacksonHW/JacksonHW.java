package JacksonHW;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JacksonHW {
	public static void main(String[] args) {
		Person person = new Person("John Doe", 40);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// Сериализация объекта в JSON
			String json = objectMapper.writeValueAsString(person);
			System.out.println(json);

			// Запись в JSON файл
			objectMapper.writeValue(new File("person.json"), person);
			System.out.println("Объект записан в person.json");
			
			// Чтение с файла и десирализация
            Person readPerson = objectMapper.readValue(new File("person.json"), Person.class);
            System.out.println("Deserialized object:");
            System.out.println(objectMapper.writeValueAsString(readPerson));

            System.out.println("Ім'я: " + readPerson.getName());
            System.out.println("Вік: " + readPerson.getAge());
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	static class Person {
		private String name;
		private int age;

		public Person() {}
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
