package classes;

import java.io.Serializable;

public class Patient implements Serializable {
    int id;
    String name;
    String phone;

    public Patient(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        // setting phone number by calling setPhone method to validate it
        setPhone(phone);
    }

    public String getname() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
     public int getid() {
        return id;
     }

    //  validating phone number and setting it
     public void setPhone(String phone) {
        if (phone.length() <= 11 && phone.length() >= 9) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone number must be less than 11 digits!");
        }
    }

     @Override
        public String toString() {
            return String.format("%-5s  %-20s  %-30s %n", id, name, phone);
        }
}