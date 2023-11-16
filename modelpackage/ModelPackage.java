package modelpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.*;

public class ModelPackage implements IRepository {
    public ArrayList<File> search(Date startDate, Date endDate) {
        File folder = new File(repositoryPath);
        Stream<File> files = Stream.of(folder.listFiles());
        Stream<File> searchedStream = files.filter(f -> f.lastModified() >= startDate.getTime() && f.lastModified() <= endDate.getTime());
        List<File> list = searchedStream.collect(Collectors.toList()); 
        ArrayList<File> searched = new ArrayList<File>(list);

        //File[] files = folder.listFiles();
        // if (files != null && files.length > 1) {
        //     for (File f : files) {
        //         if (f.lastModified() >= startDate.getTime()
        //                 && f.lastModified() <= endDate.getTime())
        //             searched.add(f);
        //     }
        // }

        return searched;
    }
}
