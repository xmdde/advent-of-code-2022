import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {
    static List<String> data = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        readData();
        System.out.println(partOne());
        System.out.println(partTwo());
    }

    public static int partOne() {
        int num = 0;
        for (String i : data) {
            String[] arr = i.split(",");
            int start1 = Integer.parseInt(arr[0].split("-")[0]);
            int end1 = Integer.parseInt(arr[0].split("-")[1]);
            int start2 = Integer.parseInt(arr[1].split("-")[0]);
            int end2 = Integer.parseInt(arr[1].split("-")[1]);
            if ((start1 <= start2 && end1 >= end2) || (start2 <= start1 && end2 >= end1)) {
                num++;
            }
        }
        return num;
    }

    public static int partTwo(){
        int num = 0;
        for (String i : data) {
            String[] arr = i.split(",");
            int start1 = Integer.parseInt(arr[0].split("-")[0]);
            int end1 = Integer.parseInt(arr[0].split("-")[1]);
            int start2 = Integer.parseInt(arr[1].split("-")[0]);
            int end2 = Integer.parseInt(arr[1].split("-")[1]);
            if ((start2 <= end1 && start2 >= start1) || (start1 <= end2 && start1 >= start2)){
                num++;
            }
        }
        return num;
    }

    public static void readData() throws FileNotFoundException {
        File file = new File("/Users/justynaziemichod/Desktop/data1.txt");
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            data.add(myReader.nextLine());
        }
        myReader.close();
    }

}
