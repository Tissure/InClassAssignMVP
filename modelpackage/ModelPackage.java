package modelpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class ModelPackage implements IRepository {
    public ArrayList<File> search(Date startDate, Date endDate) {
        File folder = new File(repositoryPath);
        ArrayList<File> searched = new ArrayList<File>();
        File[] files = folder.listFiles();
        if (files != null && files.length > 1) {
            for (File f : files) {
                if (f.lastModified() >= startDate.getTime()
                        && f.lastModified() <= endDate.getTime())
                    searched.add(f);
            }
        }
        return searched;
    }
}
