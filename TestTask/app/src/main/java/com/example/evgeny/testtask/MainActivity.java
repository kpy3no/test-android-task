package com.example.evgeny.testtask;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.evgeny.testtask.parceJSON.ImageDataPacer;
import com.example.evgeny.testtask.parceJSON.InputDataParser;
import com.example.evgeny.testtask.request.InputData;
import com.example.evgeny.testtask.request.MyParseException;
import com.example.evgeny.testtask.request.RequestFragment;
import com.example.evgeny.testtask.request.JSONParserTask;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements RequestFragment.OnFragmentInteractionListener,
        JSONParserTask.OnRequestTaskListener, OnListFragmentInteractionListener {

    private final static String LOG_TAG = "MainActivity";
    public static String VISIBLE_FRAGMENT = "visible_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment(new RequestFragment());
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment, VISIBLE_FRAGMENT);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(String uri) {
        new JSONParserTask(this).execute(new InputDataParser(uri));
    }


    @Override
    public void error(Exception e) {
        String message;
        if (e instanceof IOException){
            message = getString(R.string.error_bond);
        } else if (e instanceof JSONException){
            message = getString(R.string.error_parse);
        } else if (e instanceof MyParseException){
            message = getString(R.string.error_parse);
        } else{
            message = e.getMessage();
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void requestCompleted(ArrayList dataList) {
        if (!dataList.isEmpty() && dataList.get(0) instanceof InputData)
            setFragment(InputDataFragment.newInstance(1, dataList));
        else
            if (!dataList.isEmpty() && dataList.get(0) instanceof MyImage)
                setFragment(ImageFragment.newInstance(1, dataList));
    }

    @Override
    public void onListFragmentInteraction(InputData item) {

    }

    @Override
    public void onListFragmentInteraction(MyImage item) {

    }

    @Override
    public void onValidationCompleted() {
        new JSONParserTask(this).execute(new ImageDataPacer());
    }
}
