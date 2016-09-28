package facades;

import entiny.Person;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author lam
 */
public interface IPersonFacade {

  void addEntityManagerFactory(EntityManagerFactory emf);

  public Person addPerson(Person p) throws Exception;

  public Person deletePerson(int id);

  public Person getPerson(int id);

  public List<Person> getPersons();

  public Person editPerson(Person p);
}
