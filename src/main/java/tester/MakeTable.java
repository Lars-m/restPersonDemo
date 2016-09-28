package tester;

import entiny.Person;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class MakeTable {
  public static void main(String[] args) {
    Persistence.generateSchema("pu", null);
    Person p1 = new Person("æøåÆØÅ","Wonnegut","1234");
    Person p2 = new Person("Hanne","Wonnegut","1234");
    Person p3 = new Person("Jan","Wonnegut","1234");
    Person p4 = new Person("Sandra","Wonnegut","1234");
    EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();
    em.getTransaction().begin();
    em.persist(p1);
    em.persist(p2);
    em.persist(p3);
    em.persist(p4);
    em.getTransaction().commit();
  }
}
