package facades;

import entiny.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author lam
 */
public class PersonFacadeImpTest {

  static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_test");
  private static IPersonFacade facade = new PersonFacadeImp(emf);

  public PersonFacadeImpTest() {
  }

  @Before
  public void setUp() {
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();
      em.createQuery("delete from Person").executeUpdate();
      Person p1 = new Person("aa","bb","11");
      Person p2 = new Person("aaa","bbb","111");
      em.persist(p1);
      em.persist(p2);
      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }

  @Test
  public void testAddPerson() throws Exception {
    Person p = new Person("fname", "lname", "phone");
    Person result = facade.addPerson(p);
    assertNotNull(result.getId());
    EntityManager em = emf.createEntityManager();
    try {
      Person result2 = em.find(Person.class, result.getId());
      assertEquals("fname", result2.getFirstName());
    } finally {
      em.close();
    }
  }
  @Test(expected = Exception.class)
  public void testAddPersonMissingName() throws Exception {
    Person p = new Person("f", "lname", "phone");
    Person result = facade.addPerson(p);
    
  }

  @Test
  public void testGetPersons() {
    List<Person> persons = facade.getPersons();
    assertEquals(2, persons.size());  
  }
}
