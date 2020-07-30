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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acadcalendar);

        TextView countdownDate = findViewById(R.id.coutdown);
        setTitle("Academic Calendar");

        try{
            Date cDate = new Date();
            String endDate = "09/07/2020";
            Date eDate;
            SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
            eDate = date.parse(endDate);
            long diff = eDate.getTime() - cDate.getTime();
            long diffInDate = diff / (24 * 60 * 60 * 1000);
            String dayDifference = Long.toString(diffInDate);
            countdownDate.setText(dayDifference + " Days left to holiday!");
        } catch (Exception e)
        {
            Log.v(TAG,e.toString());
        }
        Log.v(TAG, "Finished Pre-Initialization");

    }
}
