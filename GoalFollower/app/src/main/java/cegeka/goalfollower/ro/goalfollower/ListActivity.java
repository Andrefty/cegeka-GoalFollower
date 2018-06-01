package cegeka.goalfollower.ro.goalfollower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<Goal> returnlist=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

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
