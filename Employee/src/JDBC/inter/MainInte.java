package JDBC.inter;

import java.util.List;

import JDBC.Models.DisEmployee;
import JDBC.Models.Employee;

public interface MainInte {
    public boolean insert(Employee e);
    public boolean update(Employee e,String id);
    public boolean delete(String id);
    public List<DisEmployee> display();
    public List<Employee> RetrieveById(String id);
    public boolean Auth(String name,String password);
}
