package com.example.event1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.MotionEvent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] mobileArray={"Android", "Iphone", "Windowsmobile", "Blckberry", "WebOS", "Ubuntu", "Windows7"};
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.button);
        TextView tv1 = (TextView) findViewById(R.id.tv);
        b.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {


                tv1.setText("Button clicked");
            }
        });
        ListView listview=findViewById(R.id.l1);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, mobileArray);
        listview.setAdapter(adapter);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {
                Toast.makeText(getApplicationContext(), "Long clicked", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
        //implement touch event
        ConstraintLayout myview= (ConstraintLayout) findViewById(R.id.main);
        myview.setOnTouchListener(new View.OnTouchListener()  {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MainActivity.this, "Touch Event", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}