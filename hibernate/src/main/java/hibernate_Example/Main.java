package hibernate_Example;



import java.text.MessageFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		final Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder =new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		final SessionFactory factory =configuration.buildSessionFactory(builder.build());
		final Session session = factory.openSession();
		final Book book = new Book("12345678", "Thinking in java","Bruce Ekkel");
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		final List<Book> books =session.createCriteria(Book.class).list();
		System.out.println("\n---\n");
		System.out.println(MessageFormat.format("String{0} books in database", books.size()));
		for (final Book b : books){
			System.out.println(b);
		}
		System.out.println("\n--------\n");
		session.close();
		factory.close();

	}

}
