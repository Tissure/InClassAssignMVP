package presenterpackage;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelpackage.IRepository;
import modelpackage.ModelPackage;

public class PresenterPackage {
    IRepository repo = modelpackage.getInstance();

    public String GetFiles(String input) throws Exception {
        String[] dates = input.split(",");
        DateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date startDate = format.parse(dates[0]);
        Date endDate = format.parse(dates[1]);
        ArrayList<File> files = repo.search(startDate, endDate);
        String result = "";
        if (files != null) {
            for (File f : files) {
                result += f.getPath() + " ";
            }
        }
        return result;
    }
}
