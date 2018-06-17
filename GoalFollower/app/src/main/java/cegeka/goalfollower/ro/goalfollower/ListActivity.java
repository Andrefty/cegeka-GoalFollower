package cegeka.goalfollower.ro.goalfollower;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListActivity extends AppCompatActivity {
    ArrayList<Goal> returnlist=new ArrayList<Goal>();
    List<String> names=new ArrayList<>();
    List<Date> duedate=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Readf();
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd");
        ListView GoalListView = (ListView) findViewById(R.id.GoalListView);
        for (Goal item : returnlist) {
            names.add(item.desc);
            duedate.add(item.dueDate);
        }
        com.example.cristi.firstcegeka.ItemAdapter itemAdapt =  new com.example.cristi.firstcegeka.ItemAdapter(this , names , duedate );
        GoalListView.setAdapter(itemAdapt);


    }
    public void Readf(){FileInputStream fis;
        try {
            fis = openFileInput("goals");
            ObjectInputStream ois = new ObjectInputStream(fis);
                returnlist = (ArrayList<Goal>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            Toast.makeText(ListActivity.this,"Err read",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }}
}
