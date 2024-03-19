package filesanple;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterFileExample {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/practice/file/output.txt";
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("Hello, this is a sample text.");
            writer.newLine(); // 添加换行符
            writer.write("Another line of text.");
            // TODO すべての学生情報をファイルに書き込みます。一行につき1つのデータで、データはコンマで区切られています。
//            System.out.println();
            // 别忘记关闭文件
            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
