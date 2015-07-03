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


public class HairdresserActivity extends ActionBarActivity {
    private EditText total_bill;
    private Button calculate;

    private TextView tipresult15;
    private TextView tipresult18;
    private TextView tipresult20;
    private TextView result15;
    private TextView result18;
    private TextView result20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hairdresser);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // If your minSdkVersion is 11 or higher, instead use:
        // getActionBar().setDisplayHomeAsUpEnabled(true);

        total_bill = (EditText)findViewById(R.id.et_Hair);
        calculate = (Button)findViewById(R.id.calc);
        tipresult15 = (TextView)findViewById(R.id.tresult15);
        tipresult18 = (TextView)findViewById(R.id.tresult18);
        tipresult20 = (TextView)findViewById(R.id.tresult20);
        result15 = (TextView)findViewById(R.id.final_result15);
        result18 = (TextView)findViewById(R.id.final_result18);
        result20 = (TextView)findViewById(R.id.final_result20);

        /*
        total_bill.setOnClickListener(new View.OnClickListener() {
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
                if (total_bill.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "Please enter a valid number entry", Toast.LENGTH_SHORT).show();
                }
                else {
                    float tbValue1 = Float.parseFloat(total_bill.getText().toString());
                    float res1 = tbValue1 + tbValue1 * (float) 0.15;
                    float roundOff1 = Math.round(res1 * (float) 100.0) / (float) 100.0;
                    result15.setText("$" + Float.toString(roundOff1));

                    float tbValue2 = Float.parseFloat(total_bill.getText().toString());
                    float res2 = tbValue2 + tbValue2 * (float) 0.18;
                    float roundOff2 = Math.round(res2 * (float) 100.0) / (float) 100.0;
                    result18.setText("$" + Float.toString(roundOff2));

                    float tbValue3 = Float.parseFloat(total_bill.getText().toString());
                    float res3 = tbValue3 + tbValue3 * (float) 0.2;
                    float roundOff3 = Math.round(res3 * (float) 100.0) / (float) 100.0;
                    result20.setText("$" + Float.toString(roundOff3));

                    float tip1 = tbValue1 * (float) 0.15;
                    float tipround1 = Math.round(tip1 * (float) 100.0) / (float) 100.0;
                    tipresult15.setText("$" + Float.toString(tipround1));
                    float tip2 = tbValue2 * (float) 0.18;
                    float tipround2 = Math.round(tip2 * (float) 100.0) / (float) 100.0;
                    tipresult18.setText("$" + Float.toString(tipround2));
                    float tip3 = tbValue3 * (float) 0.2;
                    float tipround3 = Math.round(tip3 * (float) 100.0) / (float) 100.0;
                    tipresult20.setText("$" + Float.toString(tipround3));
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hairdresser, menu);
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
