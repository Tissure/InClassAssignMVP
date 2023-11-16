package modelpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class ModelPackage implements IRepository {
    //Declare instance of singleton
    private static ModelPackage INSTANCE;
    //Constructor
    private ModelPackage() {        
    }
    //
    public static ModelPackage getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ModelPackage();
        }
        
        return INSTANCE;
    }


    //Array of File, searches list
    public ArrayList<File> search(Date startDate, Date endDate) {
        // File 
        File folder = new File(repositoryPath);
        //initiate list of files searched (that meet requirements of date)
        ArrayList<File> searched = new ArrayList<File>();
        //declare list of files 
        File[] files = folder.listFiles();
        //Iterate through list of files, check if file has been modified and add to searched 
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
