package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public ArrayList<String[]> loadFile(String filePath) {

        String fileToBeRead = "/rsc/" + filePath;
        String splitOnChar = ",";
        ArrayList<String[]> data = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = fileReader.readLine()) != null) {

                // use comma as separator
                String[] fields = line.split(splitOnChar);
                data.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
