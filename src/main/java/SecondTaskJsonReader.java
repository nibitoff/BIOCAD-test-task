import com.google.gson.Gson;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SecondTaskJsonReader {
    public static void manageReader() {
        while (true) {
            System.out.println("Enter the path to the JSON file:");
            Scanner scanner = new Scanner(System.in);
            String filePath = scanner.nextLine();
            String[][] data = parseFile(filePath);
            if (data.length > 0){
                printTable(data);
                break;
            }
        }
    }

    private static String[][] parseFile(String filePath) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            Map<String, List<Double>> map = gson.fromJson(reader, Map.class);
            String[][] data = new String[map.size()][2];
            int i = 0;
            for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
                data[i][0] = entry.getKey();
                data[i][1] = entry.getValue().toString();
                i = i + 1;
            }
            reader.close();

            return data;
        } catch (IOException e) {
            System.err.println("Error! Problems with file. Try again!");
        }
        return new String[0][0];
    }


    private static void printTable(String[][] data){
        String[] columns = {"NAME", "DATA"};
        JFrame jFrame = new JFrame();
        JTable jTable = new JTable(data, columns);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jFrame.add(jScrollPane);
        jFrame.setSize(700, 200);
        jFrame.setVisible(true);
    }
}

