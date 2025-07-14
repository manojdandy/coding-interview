package com.java_concepts;

/**
 *   "employeeId": "59-385-1088",
 *     "firstName": "Zacharias",
 *     "lastName": "Schwerin",
 *     "email": "zschwerin0@altervista.org",
 *     "gender": "Male",
 *     "newJoiner": "TRUE",
 *     "learningPending": "FALSE",
 *     "salary": 101146,
 *     "rating": 0
 */
public class Employee {
    String employeeId;
    String firstName;
    String lastName;
    String email;
    String gender;
    String newJoiner;
    String learningPending;
    String salary;
    String rating;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNewJoiner() {
        return newJoiner;
    }

    public void setNewJoiner(String newJoiner) {
        this.newJoiner = newJoiner;
    }

    public String getLearningPending() {
        return learningPending;
    }

    public void setLearningPending(String learningPending) {
        this.learningPending = learningPending;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", newJoiner='" + newJoiner + '\'' +
                ", learningPending='" + learningPending + '\'' +
                ", salary='" + salary + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
