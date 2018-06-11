package cegeka.goalfollower.ro.goalfollower;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddActivity extends AppCompatActivity {
    EditText editTextdesc = null;
    EditText textDate = null;
    Button addbtn = null;
    int a=1;
    String filename="goals";
    Goal item = new Goal();
    ArrayList<Goal> items=new ArrayList<>(a);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        editTextdesc = findViewById(R.id.editText);
        textDate = findViewById(R.id.editText3);
        addbtn = findViewById(R.id.button3);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Validate()) {

                    item.desc = editTextdesc.getText().toString();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        item.dueDate = sdf.parse(textDate.getText().toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    items.add(item);
                    Addg();


                }
            }
        });
    }
    public void Addg(){File myfile = new File(this.getFilesDir(), filename);
    FileOutputStream outputStream;
    try {
        outputStream = openFileOutput(filename, MODE_APPEND);
        ObjectOutputStream o = new ObjectOutputStream(outputStream);
        o.writeObject(items);
        o.close();
        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        if(myfile.exists())Toast.makeText(AddActivity.this,"yes",Toast.LENGTH_LONG).show();
        setResult(Activity.RESULT_OK, intent);
       finish();
    } catch (Exception e) {
        Toast.makeText(AddActivity.this,"no",Toast.LENGTH_LONG).show();
        e.printStackTrace();

    }
    }
    private boolean Validate() {
        if (editTextdesc.getText().toString().trim().equals("") ||
                textDate.getText().toString().trim().equals("")) {
            Toast.makeText(AddActivity.this,
                    "All the fields are mandatory",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date =
                    format.parse(textDate.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(AddActivity.this,
                    "Invalid date format",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        Date currentDate = new Date();
        if (date != null && date.compareTo(currentDate) <= 0) {
            Toast.makeText(AddActivity.this,
                    "Date should be at least today",
                    Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

}