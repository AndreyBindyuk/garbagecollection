package gc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Heap {
    private static List objects = new ArrayList();
    private static boolean cont = true;
    private static String input;
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        while (cont) {
            System.out.println("Currently "+ objects.size() + " objects in use, about "+(objects.size()*10) + " MB.");
            System.out.println("Please choose one of the following actions: ");
            System.out.println("1. Create some objects");
            System.out.println("2. Remove some objects");
            System.out.println("0. Quit");
            input = in.readLine();
            if ((input != null) && (input.length() >= 1)) {
                if (input.startsWith("0")) cont = false;
                if (input.startsWith("1")) createObjects();
                if (input.startsWith("2")) removeObjects();
            }
        }
        System.out.println("Bye!");
    }

    private static void createObjects() {
        System.out.println("Creating objects...");
            objects.add(new byte[10*1024*1024]);

    }

    private static void removeObjects() {
        System.out.println("Removing objects...");
        int start = objects.size() - 1;
        int end = start - 1;
        for(int i = start; ((i>=0) && (i>end)); i--){
            objects.remove(i);
        }
    }
}
