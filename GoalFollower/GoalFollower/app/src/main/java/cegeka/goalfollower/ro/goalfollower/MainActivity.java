package cegeka.goalfollower.ro.goalfollower;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OpenAddActivity(View view) {
        Intent intent =
                new Intent(MainActivity.this, AddActivity.class);
        startActivityForResult(intent,1);
    }
    public void OpenListActivity(View view) {
        Intent intent =
                new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            switch (resultCode){
                case Activity.RESULT_OK:{
                    Toast.makeText(MainActivity.this, "Merge aparent ", Toast.LENGTH_SHORT).show();
                    break;}
                default:
                    Toast.makeText(MainActivity.this, "nu mrg", Toast.LENGTH_LONG).show();
            }
        }
    }
}

