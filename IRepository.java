package modelpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public interface IRepository {
    public String repositoryPath = ".";

    public ArrayList<File> search(Date startDate, Date endDate);
}