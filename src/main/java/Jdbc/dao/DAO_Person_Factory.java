package Jdbc.dao;
import Jdbc.model.Person;

public interface DAO_Person_Factory {
        public int addPerson(Person p);
        public int updatePerson(Person p);
        public int deletePerson(int id);
        public void getPerson(int id);
        public void getAllQuery();
}
