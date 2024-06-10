package classes;

import java.io.Serializable;

public class Patient implements Serializable {
    private int id; // Changed to private
    private String name;
    private String phone;

    public Patient(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        setPhone(phone);
    }

    public int getId() { // Getter name corrected
        return id;
    }

    public String getName() { // Getter name corrected
        return name;
    }

    public String getPhone() { // Getter name corrected
        return phone;
    }

    // Validating phone number and setting it
    public void setPhone(String phone) {
        if (phone.length() <= 11 && phone.length() >= 9) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone number must be between 9 and 11 digits!");
        }
    }

    @Override
    public String toString() {
        return String.format("%-5s  %-20s  %-30s %n", id, name, phone);
    }
}
