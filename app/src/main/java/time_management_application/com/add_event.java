package time_management_application.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_event extends AppCompatActivity {

    EditText Eventname,Eventdate,Eventtime;
    Button savebtn;

    DatabaseReference eventdbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Eventname=findViewById(R.id.eventname);
        Eventdate=findViewById(R.id.eventdate);
        Eventtime=findViewById(R.id.eventime);
        savebtn=findViewById(R.id.save_btn);

        eventdbref= FirebaseDatabase.getInstance().getReference().child("event");

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertEventdata();
            }
        });
    }
    private void insertEventdata(){
        String name=Eventname.getText().toString();
        String date=Eventdate.getText().toString();
        String time=Eventtime.getText().toString();


        event event=new event(name,date,time);
        eventdbref.push().setValue(event);
        Toast.makeText(add_event.this,"Event Saved",Toast.LENGTH_SHORT).show();
    }
}