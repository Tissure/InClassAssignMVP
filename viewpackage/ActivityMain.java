package viewpackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

import presenterpackage.PresenterPackage;

interface OnInputListener {
    public void onInput(String input) throws Exception;
}

// VIEW PACKAGE
class Activity {
    public Activity() {
    }

    public void onCreate() {
    }
}

// VIEW PACKAGE
public class ActivityMain extends Activity implements OnInputListener {
    PresenterPackage presenter = new PresenterPackage();

    public void onCreate() {
        super.onCreate();
        System.out.println("Input StartDate,EndDate in (YYYYMMDD_HHMMSS) format and hit enter:");
    }

    // Presenter
    public void onInput(String input) throws Exception {
        String results = presenter.GetFiles(input);
        displayResult(results);
    }

    // Presenter
    public void displayResult(String results) {
        System.out.println(results);
    }

}
