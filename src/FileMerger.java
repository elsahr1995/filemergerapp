import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileMerger {

    private File output;
    private List<File> files;

    public FileMerger(List<File> files, File output){
        this.files = files;
        this.output = output;
    }

    public void merge() throws IOException{ //слияние найденных файлов в один конечный

        FileWriter writer = new FileWriter(output);

        for (File file : files){
            FileReader reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNext())
            {
                writer.write(scanner.next());
            }
            reader.close();
            scanner.close();
        }

        writer.close();
    }
}
