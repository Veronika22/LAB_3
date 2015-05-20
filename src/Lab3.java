import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class  Lab3 {

    public static void main(String[] args) throws IOException {
        String s = "";
        Scanner in = new Scanner(new File("D:\\f1.txt"));
        while(in.hasNext())
            s += in.nextLine() + "\r\n";
        in.close();


       //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String s = reader.readLine();

        System.out.println("Итого: " + getNumOfVerbs(s) + " совпадения.");
        System.out.println("Итого: " + getNumOfAdj(s) + " совпадения.");
        System.out.println("Итого: " + getNumOfAdv(s) + " совпадения.");
    }

    public static int getNumOfVerbs(String string) {
        String reV = "\\b[а-яА-ЯёЁ]+((ть)|(тся)|(ться)|(л)|(ла)|(ло)|(ли)|(шь)|(ет)|(ют)|(ит)|(ят)|(аю)|(ти))\\b";
        Pattern p = Pattern.compile(reV);
        Matcher m = p.matcher(string);
        System.out.println("Ищем глаголы:");
        int numOfVerbs = 0;
        while (m.find()) {
            System.out.println(m.group());
            numOfVerbs++;
        }
        return numOfVerbs;
    }

    public static int getNumOfAdj(String string) {
        String reAdj;
        reAdj = "\\b[а-яА-ЯёЁ]+((ое)|(ый)|(ые)|(ие)|(ий)|(ую)|(ого)|(его)|(ому)|(ему)|(им)|(ым)|(ой))\\b";
        Pattern p = Pattern.compile(reAdj);
        Matcher m = p.matcher(string);
        System.out.println("Ищем прилагательные:");
        int numOfAdj = 0;
        while (m.find()) {
            System.out.println(m.group());
            numOfAdj++;
        }
        return numOfAdj;
    }

    public static int getNumOfAdv(String string) {
        String reAdv = "\\b[а-яА-ЯёЁ]{2,}о\\b";
        Pattern p = Pattern.compile(reAdv);
        Matcher m = p.matcher(string);
        System.out.println("Ищем наречия:");
        int numOfAdv = 0;
        while (m.find()) {
            System.out.println(m.group());
            numOfAdv++;
        }
        return numOfAdv;
    }
}