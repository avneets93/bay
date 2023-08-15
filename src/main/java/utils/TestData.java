package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
}


