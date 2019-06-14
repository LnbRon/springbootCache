package com.example.springbootcache.mapper;


import com.example.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author jinji.li
 * @email lijinjilijinji@gmail.com
 * @date 2019/6/13
 */
@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE empId=#{empid}")
    public Employee getEmpById(Integer empId);

    @Update("UPDATE employee SET lastname=#{lastName},email=#{email},gender=#{gender},dId=#{dId} WHERE empId=#{empId}")
    public void updateEmp(Employee employee);

    @Delete("DELETE * FROM employee WHERE empId=#{empId}")
    public void  deleteEmpById(Integer empId);

    @Insert("INSERT INTO employee(empId,lastName,email,gender,dId) VALUES(#{empId},#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);
}
