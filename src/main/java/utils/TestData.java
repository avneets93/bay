package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestData {
    public  List<String> categories = new ArrayList<>();
    public TestData() {
        String filePath = "./src/tesdata.txt"; // Corrected file path
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                categories.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public List<String> getCategories() throws IOException {
        List<String> categories = new ArrayList<>();
        ExcelReader reader = new ExcelReader("TopNav");
        for(int i = 0; i<reader.RowCount(); i++){
            categories.add(reader.ReadCell(i,0));
        }
        return categories;
    }

    public List<String> getData(String key) throws IOException {
        ExcelReader reader = new ExcelReader("TestInputs");
        HashMap<String, List<String>> dataMap = new HashMap<>();
        List<String> inputData = new ArrayList<>();
        for (int i = 0; i < reader.RowCount(); i++) {
            for (int j = 0; j < reader.ColumnCount(i); j++) {
                inputData.add(reader.ReadCell(i, j));
            }
            dataMap.put(reader.ReadCell(i, 0), inputData);
        }
        return dataMap.get(key);
    }
}


