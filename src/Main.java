import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к папке с файлами: (Пример: C:\\\\Users\\asus\\Desktop\\files)");
        File folder = new File(reader.readLine().toString());
        System.out.println("Введите путь к выходному файлу: (Пример: C:\\\\Users\\asus\\Desktop\\output.txt)");
        File outputFileDir = new File(reader.readLine().toString());

        FileCollector fc = new FileCollector();
        List<String> pathList = fc.collectPathsOfFilesFromFolder(folder, new ArrayList<>());//получение путей к файлам в указанной папке
        List<File> filesList = fc.getFilesFromPaths(pathList);//получение файлов по директориям
        FileMerger fileMerger = new FileMerger(filesList,outputFileDir);
        fileMerger.merge();//переписывание файлов в один конечный

    }


}
