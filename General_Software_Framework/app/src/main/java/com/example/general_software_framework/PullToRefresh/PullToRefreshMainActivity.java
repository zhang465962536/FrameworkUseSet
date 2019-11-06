package com.example.general_software_framework.PullToRefresh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.general_software_framework.R;

public class PullToRefreshMainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button listview;
    private Button gridview;
    private Button fragment;
    private Button viewpager;
    private Button viewpager2;
    private Button webview;
    private TextView title_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh_main);

        findViews();
    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2019-11-02 17:47:18 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        listview = (Button)findViewById( R.id.listview );
        gridview = (Button)findViewById( R.id.gridview );
        fragment = (Button)findViewById( R.id.fragment );
        viewpager = (Button)findViewById( R.id.viewpager );
        viewpager2 = (Button)findViewById( R.id.viewpager2 );
        webview = (Button)findViewById( R.id.webview );
        title_name = findViewById(R.id.title_name);
        title_name.setText("Android-PullToRefresh");

        listview.setOnClickListener( this );
        gridview.setOnClickListener( this );
        fragment.setOnClickListener( this );
        viewpager.setOnClickListener( this );
        viewpager2.setOnClickListener( this );
        webview.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2019-11-02 17:47:18 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == listview ) {
            // Handle clicks for listview
            startActivity(new Intent(PullToRefreshMainActivity.this,PullToRefreshListActivity.class));
        } else if ( v == gridview ) {
            // Handle clicks for gridview
            startActivity(new Intent(PullToRefreshMainActivity.this,PullToRefreshGridActivity.class));
        } else if ( v == fragment ) {
            // Handle clicks for fragment
        } else if ( v == viewpager ) {
            // Handle clicks for viewpager
        } else if ( v == viewpager2 ) {
            // Handle clicks for viewpager2
        } else if ( v == webview ) {
            // Handle clicks for webview
            startActivity(new Intent(PullToRefreshMainActivity.this,PullToRefreshWebViewActivity.class));
        }
    }

}
