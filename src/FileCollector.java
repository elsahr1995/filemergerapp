import java.io.*;
import java.util.*;

public class FileCollector {

    FileCollector(){
    }

    List<String> collectPathsOfFilesFromFolder(File folder, List<String> pathList) {

        File[] folderEntries = folder.listFiles();

        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                collectPathsOfFilesFromFolder(entry, pathList);
                continue;
            }

                pathList.add(entry.getPath());
        }

        return sortPaths(pathList);
    }

    List<String> sortPaths (List<String> paths){

        Collections.sort(paths);
        return paths;
    }

    List<File> getFilesFromPaths (List<String> paths){
        List<File> files = new ArrayList<>();

        for (String path : paths){
            files.add(new File(path));
        }

        return files;
    }

}
