package cegeka.goalfollower.ro.goalfollower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button maddd;
Button mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
maddd=findViewById(R.id.buttonaddm);
mlist=findViewById(R.id.buttonlist);
mlist.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,ListActivity.class);
        startActivity(intent);
    }
});
maddd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =
                new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }
});


    }


    public void OpenListActivity(View view) {
        Intent intent =
                new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }
}

