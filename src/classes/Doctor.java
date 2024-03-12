package classes;
public class Doctor {
    int id;
    String name;
    String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public String getname() {
        return name;
    }

    public String getspecialization() {
        return specialization;
    }
     public int getid() {
        return id;
     }
     
     

     @Override
    public String toString() {
        String format = "%-5s  %-20s  %-30s %n";
        // StringBuilder sb = new StringBuilder();
        // sb.append();
        return String.format(format, id, name, specialization);
        
    }
}
