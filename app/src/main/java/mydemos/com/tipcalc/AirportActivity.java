package mydemos.com.tipcalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AirportActivity extends ActionBarActivity {
    private EditText bags;
    private Button calculate;
    private TextView num_bags;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // If your minSdkVersion is 11 or higher, instead use:
        // getActionBar().setDisplayHomeAsUpEnabled(true);

        bags = (EditText)findViewById(R.id.et_Sky);
        num_bags = (TextView)findViewById(R.id.bag_amt);
        calculate = (Button)findViewById(R.id.calc);
        result = (TextView)findViewById(R.id.final_result);

        /*total_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result15.setText("");
                result18.setText("");
                result20.setText("");
            }

        });*/
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bags.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "Please enter a valid number entry", Toast.LENGTH_SHORT).show();
                }
                else {
                    int num = Integer.parseInt(bags.getText().toString());
                    num_bags.setText(Integer.toString(num));
                    if (num == 1) {
                        result.setText("$" + Integer.toString(2));
                    } else {
                        result.setText("$" + Integer.toString(2 + (num - 1)));
                    }
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_airport, menu);
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
            Toast.makeText(getBaseContext(), "Version 1.0, English, Creator: Corinne Nakashima", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
