package Client;
public class Client
{
    private String name;
    private String surname;
    private String middle_name;
    private long ID;
    public Client(String name, String surname,  String middle_name,  long ID){
        this.ID = ID;
        this.middle_name = middle_name;
        this.name = name;
        this.surname = surname;
    }
    public long getID() {
        return ID;
    }
    public String getName(){
        return name;
    }
    public String getMiddle_name() {
        return middle_name;
    }
    public String getSurname() {
        return surname;
    }
}