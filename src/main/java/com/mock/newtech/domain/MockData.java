package com.mock.newtech.domain;


public class MockData {

    private Long id;
    private String first_Name;
    private String last_Name;
    private String email;
    private String gender;
    private String ip_Address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
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

    public String getIp_Address() {
        return ip_Address;
    }

    public void setIp_Address(String ip_Address) {
        this.ip_Address = ip_Address;
    }

    @Override
    public String toString() {
        return "MockData{" +
                "id=" + id +
                ", firstName='" + first_Name + '\'' +
                ", lastName='" + last_Name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", ipAddress='" + ip_Address + '\'' +
                '}';
    }
}
