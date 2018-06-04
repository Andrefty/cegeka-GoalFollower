package cegeka.goalfollower.ro.goalfollower;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<Goal> returnlist=null;
    String[] names;
    String[] duedate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
     //  Readf();
        ListView GoalListView = (ListView) findViewById(R.id.GoalListView);
        Resources res = getResources();
        names = res.getStringArray(R.array.names);
        duedate = res.getStringArray(R.array.due_date);
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
