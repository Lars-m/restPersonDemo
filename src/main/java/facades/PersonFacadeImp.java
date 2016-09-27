package facades;

import entiny.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * @author lam
 */
public class PersonFacadeImp implements IPersonFacade{

  EntityManagerFactory emf;
  
  private EntityManager getEntityManager(){
    return emf.createEntityManager();
  };
  
  @Override
  public void addEntityManagerFactory(EntityManagerFactory emf) {
    this.emf = emf;
  }

  @Override
  public Person addPerson(Person p) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Person deletePerson(int id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Person getPerson(int id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Person> getPersons() {
    EntityManager em = getEntityManager();
    try{
      Query query = em.createQuery("select p from Person p");
      List<Person> persons = query.getResultList();
      return persons;
    }
    finally{
      em.close();
    }
  }

  @Override
  public Person editPerson(Person p) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
