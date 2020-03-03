package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public ArrayList<String[]> loadFile(String filePath) {

        ArrayList<String[]> data = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = fileReader.readLine()) != null) {
                if (line.contains("\"") && filePath.equals(DatabaseCreator.SONGSFILE)) {
                   data.add(createFieldsWithCommas(line));
                } else {
                    // use comma as separator
                    String[] fields = line.split(",");
                    data.add(fields);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private String[] createFieldsWithCommas(String line) {
        int commaBreak = line.indexOf(",");
        String guid = line.substring(0, commaBreak);
        line = line.substring(++commaBreak);
        commaBreak = line.indexOf(",");
        String aguid = line.substring(0, commaBreak);
        line = line.substring(++commaBreak);
        commaBreak = line.indexOf(",");
        String duration = line.substring(0, commaBreak);
        String title = line.substring(commaBreak+2, line.length()-2);
        String[] commaFields = {guid, aguid, duration, title};
        return commaFields;
    }
}
