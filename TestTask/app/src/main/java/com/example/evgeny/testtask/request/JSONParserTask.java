package com.example.evgeny.testtask.request;

import android.os.AsyncTask;
import android.util.Log;

import com.example.evgeny.testtask.AsyncTaskResult;
import com.example.evgeny.testtask.MyImage;
import com.example.evgeny.testtask.parceJSON.Parser;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by palevo on 03.05.2017.
 */

public class JSONParserTask extends AsyncTask<Parser, Void, AsyncTaskResult<ArrayList<InputData>>> {

    public static final String LOG_TAG = "JSONParserTask";
    private OnRequestTaskListener listener;

    public JSONParserTask(OnRequestTaskListener listener) {
        this.listener = listener;
    }

    @Override
    protected AsyncTaskResult<ArrayList<InputData>> doInBackground(Parser... params) {

        Parser parser = params[0]; // URL to call
        String resultToDisplay = "";
        InputStream in = null;
        ArrayList dataList = null;

        try {
            URL url = new URL(parser.getUrlString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedInputStream(urlConnection.getInputStream());

            resultToDisplay = IOUtils.toString(in, "UTF-8");
            dataList = parser.parseJSONData(resultToDisplay);
            return new AsyncTaskResult(dataList);
        } catch (IOException|JSONException|MyParseException e) {
            Log.e(LOG_TAG, e.getMessage());
            return new AsyncTaskResult(e);
        }
    }


    @Override
    protected void onPostExecute(AsyncTaskResult<ArrayList<InputData>> result) {
        if (result == null)
            return;
        if (result.getError() != null){
            listener.error(result.getError());
            return;
        }

        listener.requestCompleted(result.getResult());
    }

    public interface OnRequestTaskListener {
        void error(Exception e);
        void requestCompleted(ArrayList dataList);
    }
}