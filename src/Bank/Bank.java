package Bank;
import Client.Client;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Bank {
    private ArrayList<Client> clients = new ArrayList<Client>();
    private FileReader read_client;
    private FileWriter read_write;
    private Pattern search_ID = Pattern.compile("[0-9]{6}");
    private Pattern search_Account = Pattern.compile("[0-9]{1,}");
    private String name_Bank;
    private String path_of_file = "/Users/aydarshigabutdinov/Documents/Java/text.txt";
    public Bank(String name_Bank) {
        this.name_Bank = name_Bank;
    }
    public void add_client_to_Bank(Client cl, ArrayList<Long> sum) throws IOException {
        clients.add(cl);
        read_write = new FileWriter(path_of_file);
        for (int i = 0; i < clients.size(); i++) {
            read_write.write(Integer.toString(i + 1));
            read_write.write(" ");
            String ID_str = Long.toString(clients.get(i).getID());
            read_write.write(ID_str);
            read_write.write(" ");
            String FIO = clients.get(i).getSurname() + " " + clients.get(i).getName() + " " + clients.get(i).getMiddle_name() + " ";
            read_write.write(FIO);
            read_write.write(Long.toString(sum.get(i)) + '\n');
        }
        read_write.close();
    }
    public void request_balance(long ID) throws IOException {
        read_client = new FileReader(path_of_file);
        Scanner scan = new Scanner(read_client);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            Matcher mat = search_ID.matcher(str);
            long ID_search = 0;
            while (mat.find()) {
                ID_search = Long.parseLong(mat.group());
            }
            if (ID_search == ID) {
                long Account = 0;
                Matcher mat2 = search_Account.matcher(str);
                while (mat2.find()) {
                    Account = Long.parseLong(mat2.group());
                }
                System.out.println(Account);
            }
        }
        read_client.close();
    }
    public void add(long ID , long add_sum, ArrayList<Long> sum) throws IOException {
        read_client = new FileReader(path_of_file);
        Scanner scan = new Scanner(read_client);
        long Acc_Sum = 0;
        long ID_search = 0;
        int i = 0;
        while (scan.hasNext()) {
            String str = scan.nextLine();
            Matcher mat = search_ID.matcher(str);
            while (mat.find()) {
                i++;
                if (i == 1) {
                    ID_search = Long.parseLong(mat.group());
                    i = 0;
                    break;
                }
            }
            if (ID_search == ID) {
                Matcher mat2 = search_Account.matcher(str);
                while (mat2.find()) {
                    Acc_Sum = Long.parseLong(mat2.group());
                }
            }
        }
        read_write = new FileWriter(path_of_file);
        for (int j = 0; j < clients.size(); j++) {
            read_write.write(Integer.toString(j + 1));
            read_write.write(" ");
            String ID_str = Long.toString(clients.get(j).getID());
            read_write.write(ID_str);
            read_write.write(" ");
            String FIO = clients.get(j).getSurname() + " " + clients.get(j).getName() + " " + clients.get(j).getMiddle_name() + " ";
            read_write.write(FIO);
            if(clients.get(j).getID() == ID){
                read_write.write(Long.toString(Acc_Sum+add_sum) + '\n');
                sum.set(j, Acc_Sum + add_sum);
            }
            else {
                read_write.write(Long.toString(sum.get(j)) + '\n');
            }
        }
        read_write.close();
    }
    public void take(long ID , long take_sum, ArrayList<Long> sum) throws IOException{
        read_client = new FileReader(path_of_file);
        Scanner scan = new Scanner(read_client);
        long Acc_Sum = 0;
        long ID_search = 0;
        int i = 0;
        while (scan.hasNext()) {
            String str = scan.nextLine();
            Matcher mat = search_ID.matcher(str);
            while (mat.find()) {
                i++;
                if (i == 1) {
                    ID_search = Long.parseLong(mat.group());
                    i = 0;
                    break;
                }
            }
            if (ID_search == ID) {
                Matcher mat2 = search_Account.matcher(str);
                while (mat2.find()) {
                    Acc_Sum = Long.parseLong(mat2.group());
                }
            }
        }
        read_write = new FileWriter(path_of_file);
        for (int j = 0; j < clients.size(); j++) {
            read_write.write(Integer.toString(j + 1));
            read_write.write(" ");
            String ID_str = Long.toString(clients.get(j).getID());
            read_write.write(ID_str);
            read_write.write(" ");
            String FIO = clients.get(j).getSurname() + " " + clients.get(j).getName() + " " + clients.get(j).getMiddle_name() + " ";
            read_write.write(FIO);
            if(clients.get(j).getID() == ID){
                read_write.write(Long.toString(Acc_Sum-take_sum) + '\n');
                sum.set(j, Acc_Sum - take_sum);
            }
            else {
                read_write.write(Long.toString(sum.get(j)) + '\n');
            }
        }
        read_write.close();
    }



    public void transaction(long ID_1, long ID_2, long amount, ArrayList<Long> sum) throws IOException {
        take(ID_1, amount, sum);
        add(ID_2, amount, sum);
    }
}