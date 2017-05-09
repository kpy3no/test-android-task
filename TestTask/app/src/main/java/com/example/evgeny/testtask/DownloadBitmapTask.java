package com.example.evgeny.testtask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by palevo on 06.05.2017.
 */

public class DownloadBitmapTask extends AsyncTask<String , Void, AsyncTaskResult<Bitmap>> {
    public static final String LOG_TAG = "DownloadBitmapTask";
    private final ImageView imageView;

    public DownloadBitmapTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected AsyncTaskResult<Bitmap> doInBackground(String... params) {
        try {

            URL url = new URL(params[0]);
            File f = new File("D:\\AndroidProjects\\TestTask\\app\\src\\temp");
            org.apache.commons.io.FileUtils.copyURLToFile(url, f);
            Bitmap mIcon_val = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return new AsyncTaskResult<>(mIcon_val);
        } catch (IOException e) {
            return new AsyncTaskResult<>(e);
        }

    }

    @Override
    protected void onPostExecute(AsyncTaskResult<Bitmap> result) {
        if (result == null || imageView == null)
            return;
        if (result.getError() != null){
            imageView.setImageResource(R.drawable.question);
            return;
        }
        imageView.setImageBitmap(result.getResult());
    }

}
