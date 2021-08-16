package time_management_application.com;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements calenderadapter.OnItemListener {

    private TextView monthyeartext;
    private RecyclerView calenderrecyclerview;
    private LocalDate selecteddate;
    private Button newevent;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newevent=findViewById(R.id.add_event);
        initwidgets();
        selecteddate = LocalDate.now();
        setmonthview();
        newevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,add_event.class);
                startActivity(intent);
            }
        });
    }

    private void initwidgets()
    {
        calenderrecyclerview = findViewById(R.id.calenderRecycleview);
        monthyeartext=findViewById(R.id.monthyear);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setmonthview()
    {
        monthyeartext.setText(monthyearfromdate(selecteddate));
        ArrayList<String> daysinmonth = daysinmontharray(selecteddate);
        calenderadapter calenderadapter = new calenderadapter(daysinmonth,this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),7);
        calenderrecyclerview.setLayoutManager(layoutManager);
        calenderrecyclerview.setAdapter(calenderadapter);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private ArrayList<String> daysinmontharray(LocalDate date)
    {
        ArrayList<String> daysinmontharray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);
        int daysinmonth = yearMonth.lengthOfMonth();
        LocalDate firstofmonth = selecteddate.withDayOfMonth(1);

        int daysofweek = firstofmonth.getDayOfWeek().getValue();

        for(int i = 1;i <= 42; i++)
        {
            if(i <= daysofweek || i > daysinmonth + daysofweek)
            {
                daysinmontharray.add("");
            }
            else{
                daysinmontharray.add(String.valueOf(i - daysofweek));
            }

        }
        return daysinmontharray;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private String monthyearfromdate(LocalDate date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void previousmonthaction(View view)
    {
        selecteddate = selecteddate.minusMonths(1);
        setmonthview();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void nextmonthaction(View view)
    {
        selecteddate = selecteddate.plusMonths(1);
        setmonthview();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(int position, String daytext)
    {
        if(daytext.equals(""))
        {
            String message = "selected date" + daytext + " " + monthyearfromdate(selecteddate);
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        }

    }
}