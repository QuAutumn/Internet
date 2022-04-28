package com.example.internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button_third;
    private Button button_second;
    private Button button_show;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_show = (Button) findViewById(R.id.button_show);
        webView = (WebView) findViewById(R.id.web_view);
        button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url){
                        view.loadUrl(url);
                        return true;
                    }
                });
                webView.loadUrl("http://www.gdpu.edu.cn");
            }
        });

        button_second = (Button) findViewById(R.id.button_second);
        button_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HttpURLConnectionActivity.class);
                startActivity(intent);
            }
        });

        button_third = (Button) findViewById(R.id.button_third);
        button_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,OKHttpActivity.class);
                startActivity(intent);
            }
        });
    }
}