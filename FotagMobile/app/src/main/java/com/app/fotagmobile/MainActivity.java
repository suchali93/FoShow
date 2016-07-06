package com.app.fotagmobile;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.RatingBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ImageAdapter myAdapter;
    private ArrayList<Image> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        myAdapter = new ImageAdapter(this, R.layout.grid_item, data);
        gridView.setAdapter(myAdapter);
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

        switch(item.getItemId()) {

            case R.id.action_clear:
                myAdapter.clearAll();
                return true;

            case R.id.action_load:
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img1);
                myAdapter.addItem(new Image(bitmap, 0));
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img2);
                myAdapter.addItem(new Image(bitmap, 0));
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img3);
                myAdapter.addItem(new Image(bitmap, 0));
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img4);
                myAdapter.addItem(new Image(bitmap, 0));
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img5);
                myAdapter.addItem(new Image(bitmap, 0));
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img6);
                myAdapter.addItem(new Image(bitmap, 0));
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img7);
                myAdapter.addItem(new Image(bitmap, 0));
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img8);
                myAdapter.addItem(new Image(bitmap, 0));
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img9);
                myAdapter.addItem(new Image(bitmap, 0));
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img10);
                myAdapter.addItem(new Image(bitmap, 0));
                return true;

            case R.id.action_search:
//                new DownloadImageTask(new ImageView(this)).execute("https://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png");
//                myAdapter.mThumbIds.add(R.drawable.);
//                System.out.println(R.id.imgView);
//                System.out.println(R.id.imgView);
//                new DownloadImageTask((ImageView) findViewById(R.id.imgView)).execute("https://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png");
//                myAdapter.mThumbIds.add(R.id.imgView);
//                System.out.println(R.id.imgView);
//                myAdapter.notifyDataSetChanged();
                return true;

            case R.id.action_showall:
                myAdapter.getFilter().filter("");
                return true;

            case R.id.action_rate1:
                myAdapter.getFilter().filter("one");
                return true;

            case R.id.action_rate2:
                myAdapter.getFilter().filter("two");
                return true;

            case R.id.action_rate3:
                myAdapter.getFilter().filter("three");
                return true;

            case R.id.action_rate4:
                myAdapter.getFilter().filter("four");
                return true;

            case R.id.action_rate5:
                myAdapter.getFilter().filter("five");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        newConfig.orientation = getResources().getConfiguration().orientation;
        super.onConfigurationChanged(newConfig);
    }
}
