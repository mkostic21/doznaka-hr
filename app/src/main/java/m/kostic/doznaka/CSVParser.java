package m.kostic.doznaka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParser {

    private InputStream stream;
    private String delimiter =";"; //default delimiter

    CSVParser(InputStream stream ){
        this.stream = stream;
    }

    public String getDelimiter() {
        return delimiter;
    }
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }


    Double[][] Parse(){
        List<List<String>> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        try{
            String line;
            while((line = reader.readLine()) != null){
                String[] values = line.split(delimiter);
                data.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = data.size();
        int j = data.get(0).size();
        Double[][] tarifa = new Double[i][j];

        for(int k=0;k<i;k++){
            for(int l=0;l<j;l++){
                tarifa[k][l] = Double.parseDouble(data.get(k).get(l));
            }
        }
        return tarifa;
    }
}
