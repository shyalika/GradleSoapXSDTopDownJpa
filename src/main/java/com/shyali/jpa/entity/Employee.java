package com.shyali.jpa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Class that represents the employee entity
 */
@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(
            name = "Employee.findByName",
            query = "SELECT e FROM Employee e WHERE e.firstName = :firstName")
})
public class Employee {

    @Id
    @GeneratedValue
    @Basic(optional = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "first-name")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last-name")
    private String lastName;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}
