package problems;

import java.util.*;

public class PhoneBookMap {
    public static void main(String []argh)
    {
        Map<String,Long> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            long phone=in.nextLong();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            Long number = phoneBook.get(s);
            if(number == null) {
                System.out.println("Not found");
            }
            else {
                System.out.println(s + "=" + number);
            }
        }
        in.close();
    }
}
