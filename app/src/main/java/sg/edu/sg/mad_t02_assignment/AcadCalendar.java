package sg.edu.sg.mad_t02_assignment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AcadCalendar extends AppCompatActivity {

    final String TAG = "Academic Calendar";
    private static String[] allHolidays = {"07/20/2020","09/07/2020", "12/19/20", "03/01/21"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acadcalendar);

        TextView countdownDate = findViewById(R.id.coutdown);
        setTitle("Academic Calendar");

        try{
            Date cDate = new Date();
            SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
            for (int i = 0; i < allHolidays.length; i++){
                Date eDate = date.parse(allHolidays[i]);
                long diff = eDate.getTime() - cDate.getTime();
                long diffInDate = diff / (24 * 60 * 60 * 1000);
                String dayDifference = Long.toString(diffInDate);
                if (diffInDate > 0)
                {
                    countdownDate.setText(dayDifference + " Days left to the next holiday!");
                }
            }
        } catch (Exception e)
        {
            Log.v(TAG,e.toString());
        }
        Log.v(TAG, "Finished Pre-Initialization");

    }
}
