import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

public class App {
    public static void main(String[] args) throws Exception {
        ActivityMain activity = new ActivityMain();
        activity.onCreate();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        activity.onInput(input);
    }
}

interface OnInputListener {
    public void onInput(String input) throws Exception;
}

class Activity {
    public Activity() {
    }

    public void onCreate() {
    }
}

class ActivityMain extends Activity implements OnInputListener {
    public void onCreate() {
        super.onCreate();
        System.out.println("Input StartDate,EndDate in (YYYYMMDD_HHMMSS) format and hit enter:");
    }

    public void onInput(String input) throws Exception {
        String[] dates = input.split(",");
        DateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date startDate = format.parse(dates[0]);
        Date endDate = format.parse(dates[1]);
        ArrayList<File> files = search(startDate, endDate);
        String result = "";
        if (files != null) {
            for (File f : files) {
                result += f.getPath() + " ";
            }
        }
        displayResult(result);
    }

    public void displayResult(String results) {
        System.out.println(results);
    }

    public ArrayList<File> search(Date startDate, Date endDate) {
        String repositoryPath = ".";
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