package facades;

import entiny.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class PersonFacadeImp implements IPersonFacade{

  EntityManagerFactory emf;

  public PersonFacadeImp(EntityManagerFactory emf) {
    this.emf = emf;
  }
 
  private EntityManager getEntityManager(){
    return emf.createEntityManager();
  };
  
  @Override
  public void addEntityManagerFactory(EntityManagerFactory emf) {
    this.emf = emf;
  }

  @Override
  public Person addPerson(Person p) throws Exception {
    if(p.getFirstName() == null || p.getFirstName().length() < 2){
      throw new Exception("Firstname required and must me atleast two characters");
    }
    EntityManager em = getEntityManager();
    try{
      em.getTransaction().begin();
      em.persist(p);
      em.getTransaction().commit();
      return p;
    }finally{
      em.close();
    }
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
    System.out.println("Try Get EntityManager");
    EntityManager em = getEntityManager();
    System.out.println("Got it");
    try{
      Query query = em.createQuery("select p from Person p");
      System.out.println("Created the query");
      List<Person> persons = query.getResultList();
      if(persons!= null)
        System.out.println("Got Persons: "+persons.size());
      else
        System.out.println("Got NULL");
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
