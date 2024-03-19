import java.io.File; // Fileクラスを使用する
import java.io.FileReader; // FileReaderクラスを使用する
import java.io.BufferedReader; // BufferedReaderクラスを使用する
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;  // クラスjava.io.FileNotFoundExceptionの使用
import java.io.IOException; // 入出力処理中の例外を管理するクラス

public class ScoreFunction {
    public static void main(String[] args) {
        String inputFilePath = "src/filesanple/score.txt";
        String outputFilePath = "src/filesanple/addscore.txt";

        Map<String, Integer> stringCountMap = new HashMap<>();

         /* FileReaderクラスのオブジェクトを作成する場合には、
        "FileNotFoundException"という例外が発生する可能性があるため、
        例外の処理をしておく必要がある */
        try{
            File file = new File(inputFilePath);

            if (checkBeforeReadfile(file)){
                BufferedReader br = new BufferedReader(new FileReader(file));
                // FileReaderクラスのオブジェクトを引数としてBufferedReaderクラスのオブジェクトを作成
                StringWriter sWriter = new StringWriter();
                String str;
                while((str = br.readLine()) != null){ // readLine"メソッド
                    if (str.endsWith("100")) { // endsWithメソッドを使用
                        String modifiedLine = str + ",*\n"; // 100が含まれていた場合,*を追加
                        System.out.print(modifiedLine);
                        sWriter.write(modifiedLine);
                        String[] columns = str.split(",");
                        String name = columns[1];
                        stringCountMap.put(name, stringCountMap.getOrDefault(name, 0) + 1);

                        continue; // continueで次の処理へ
                    }
                    String modifiedLine = str + "\n";
                    System.out.print(modifiedLine);
                    sWriter.write(modifiedLine);
                    String[] columns = str.split(",");
                    String name = columns[1];
                    stringCountMap.put(name, stringCountMap.getOrDefault(name, 0) + 1);

                }

                // 重複した名前とレコード数の表示
                System.out.println("重複した氏名とレコード数:");
                sWriter.write("重複した氏名とレコード数:\n");
                for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
                    if (entry.getValue() > 1) {
                        System.out.println(entry.getKey() + ": " + ",レコード数:" + entry.getValue() + "\n");
                        sWriter.write(entry.getKey() + ": " + ",レコード数: " + entry.getValue() + "\n");
                    }
                }
                String effect = sWriter.toString();
                System.out.println(effect);

                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
                writer.write(effect);
                // BufferedReaderクラスのオブジェクトに対して"close"処理を行えば、
                // その元になっているFileReaderクラスの方は"close"しなくても構いません
                br.close();
                writer.close();
            }else{
                System.out.println("ファイルが見つからないか開けません");
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    private static boolean checkBeforeReadfile(File file){
        if (file.exists()){
            if (file.isFile() && file.canRead()){
                return true;
            }
        }

        return false;

    }
}