package mydemos.com.tipcalc;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;

import java.io.InputStream;


public class MainActivity extends ActionBarActivity {
    AnimationDrawable animation = new AnimationDrawable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context ctx = getApplicationContext();
        Resources res = ctx.getResources();

        String[] options = res.getStringArray(R.array.post_strings);
        TypedArray icons = res.obtainTypedArray(R.array.post_pics);
        TypedArray borders = res.obtainTypedArray(R.array.post_border);

        ListView lv;
        lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(new ImageAndTextAdapter(ctx, R.layout.main_list_item, options, icons,borders));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // In the following line "v" refers to the View returned by the `getView()` method; meaning the clicked View.
                TextView txtName = (TextView)view.findViewById(R.id.option_text);
                String name = txtName.getText().toString();
                switch(position)
                {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(MainActivity.this, HairdresserActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, TaxiActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, AirportActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, TourGuideActivity.class);
                        startActivity(intent);
                        break;
                    //And so on and so forth....
                }
                //go_calc(position);
                /*
                if (position==0) {
                    Toast.makeText(ctx, "Restaurant was clicked.", Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(this,RestaurantActivity.class);
                    //
                }
                if (position==1) {
                    Toast.makeText(ctx, "Hairdresser was clicked.", Toast.LENGTH_LONG).show();
                }
                if (position==2){
                    Toast.makeText(ctx, "Taxi was clicked.", Toast.LENGTH_LONG).show();
                }
                if (position==3){
                    Toast.makeText(ctx, "Airport was clicked.", Toast.LENGTH_LONG).show();
                }
                if (position==4){
                    Toast.makeText(ctx, "Tour guide was clicked.", Toast.LENGTH_LONG).show();
                }
                */
            }
        });
        //setListAdapter(new ImageAndTextAdapter(ctx, R.layout.main_list_item, options, icons));
        /* //2nd uncomment~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        animation.addFrame(getResources().getDrawable(R.drawable.accountant_dog), 5000);//100
        animation.addFrame(getResources().getDrawable(R.drawable.awful), 5000);
        animation.addFrame(getResources().getDrawable(R.drawable.sheldon_meme), 5000);//300
        animation.addFrame(getResources().getDrawable(R.drawable.clubbingseals), 5000);//500

        animation.setOneShot(false);

        ImageView imageAnim =  (ImageView) findViewById(R.id.img1);
        //imageAnim.setBackgroundDrawable(animation);
        imageAnim.setImageDrawable(animation);
        */ //2nd uncomment~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
        /* //1st uncomment - start--------------------------------------------------------------
        b1 = (Button)findViewById(R.id.bG);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "You Green Shared this post", Toast.LENGTH_SHORT).show();
            }
        });
        b2 = (Button)findViewById(R.id.bR);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "You Red Shared this post", Toast.LENGTH_SHORT).show();
            }
        });*/ // 1st uncomment -end----------------------------------------------------------------
    }

    public class ImageAndTextAdapter extends ArrayAdapter<String> {

        private LayoutInflater mInflater;

        private String[] mStrings;
        private TypedArray mIcons;
        private TypedArray mBorders;


        private int mViewResourceId;

        public ImageAndTextAdapter(Context ctx, int viewResourceId,
                                   String[] strings, TypedArray icons, TypedArray borders) {
            super(ctx, viewResourceId, strings);

            mInflater = (LayoutInflater)ctx.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            mStrings = strings;
            mIcons = icons;
            mBorders = borders;


            mViewResourceId = viewResourceId;
        }

        @Override
        public int getCount() {
            return mStrings.length;
        }

        @Override
        public String getItem(int position) {
            return mStrings[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = mInflater.inflate(mViewResourceId, null);

            ImageView iv = (ImageView)convertView.findViewById(R.id.option_icon);
            iv.setImageDrawable(mIcons.getDrawable(position));

            TextView tv = (TextView)convertView.findViewById(R.id.option_text);
            tv.setText(mStrings[position]);


            RelativeLayout rlayout = (RelativeLayout)convertView.findViewById(R.id.main_list_rl);
            rlayout.setBackgroundDrawable(mBorders.getDrawable(position));

            return convertView;
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
            Toast.makeText(getBaseContext(), "Version 1.0, English, Creator: Corinne Nakashima", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // start the animation!
        animation.start();
    }*/
}
