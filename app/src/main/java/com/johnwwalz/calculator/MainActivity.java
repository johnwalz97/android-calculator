package com.johnwwalz.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, times, plus, minus, divided, equals, button_clicked;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //connecting variables to elements
        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);
        times = (Button) findViewById(R.id.times);
        times.setOnClickListener(this);
        minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(this);
        plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(this);
        divided = (Button) findViewById(R.id.divided);
        divided.setOnClickListener(this);
        equals = (Button) findViewById(R.id.equals);
        equals.setOnClickListener(this);
        Result = (TextView) findViewById(R.id.Result);
        Result.setText("");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        button_clicked = (Button) findViewById(v.getId());

        if(id == R.id.equals){
            Jep jep = new Jep();
            try{
                jep.parse("" + Result.getText());
                Object result = jep.evaluate();
                Result.setText("" + result);
            } catch (JepException e){
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
            }
        } else {
            Result.append(button_clicked.getText());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "The calculator has been reset.", Toast.LENGTH_LONG).show();
            Result.setText("");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}