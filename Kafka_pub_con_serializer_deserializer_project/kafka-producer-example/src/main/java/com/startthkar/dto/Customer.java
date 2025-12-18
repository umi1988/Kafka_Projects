package com.startthkar.dto;

import lombok.Data;

@Data
public class Customer {

    /*private int id;
    private String name;
    private String email;
    private String contactNo;*/

    private int id;
    private String name;
    private String email;
    private String contactNo;

    // Lombok @Data should generate these, but add manually as fallback
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getContactNo() { return contactNo; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
