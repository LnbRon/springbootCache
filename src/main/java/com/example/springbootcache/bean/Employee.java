package com.example.springbootcache.bean;

/**
 * @author jinji.li
 * @email lijinjilijinji@gmail.com
 * @date 2019/6/13
 */
public class Employee {

    private Integer empId;

    private String lastName;

    private  String email;

    private  Integer gender;

    private  Integer dId;

    public Employee() {
    }

    public Employee(Integer empId, String lastName, String email, Integer gender, Integer dId) {
        this.empId = empId;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", dId=" + dId +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}
