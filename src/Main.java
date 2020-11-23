import Bank.Bank;
import Client.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static long print_sum(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Print your first sum =  ");
        long sum = scan.nextLong();
        return sum;
    }
    public static void main(String args[]) throws IOException {
        Client cl = new Client("Alexey"  , " Baranov" , "Konstantinovich" , 123789);
        Bank Tinkoff = new Bank("Tinkoff");
        ArrayList<Long> sum = new ArrayList<>();
        sum.add(print_sum());
        Tinkoff.add_client_to_Bank(cl ,sum);
        Client cl2 = new Client("Dmitry"  , " Ivanov" , "Ivanovich" , 110000);
        sum.add(print_sum());
        Tinkoff.add_client_to_Bank(cl2, sum);
        Tinkoff.request_balance(123789);
        Tinkoff.add(123789, 2000, sum);
        Tinkoff.take(110000, 4000, sum);
        Tinkoff.transaction(110000, 123789, 5000, sum);
    }
}
