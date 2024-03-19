package filesanple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\soft\\Desktop\\jdbc\\data\\student.csv";
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bReader = new BufferedReader(reader);
            String line;
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
                // TODO 処理
                // 例: 行を分割して要素を表示

            }
        } catch (IOException e) {
            e.printStackTrace();
            // エラー処理
        }
    }
}
