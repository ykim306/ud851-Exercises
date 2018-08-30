package com.udacity.example.quizexample;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

import com.udacity.example.droidtermsprovider.DroidTermsExampleContract;

import java.lang.ref.WeakReference;

public class WordFetchTask extends AsyncTask<Void, Void, Cursor> {

    public interface IWordFetchListener {
        void OnWordFetchComplete(Cursor data);
    }

    private IWordFetchListener wordFetchListener;
    private WeakReference<Context> contextReference;

    public WordFetchTask(IWordFetchListener wordFetchListener){
        this.wordFetchListener = wordFetchListener;

        if (wordFetchListener instanceof Context) {
            contextReference = new WeakReference<>((Context)wordFetchListener);
        }
    }

    @Override
    protected Cursor doInBackground(Void... voids) {
        // Make the query to get the data

            // Get the content resolver
            ContentResolver resolver = contextReference.get().getContentResolver();

            // Call the query method on the resolver with the correct Uri from the contract class
            Cursor cursor = resolver.query(DroidTermsExampleContract.CONTENT_URI,
                    null, null, null, null);
            return cursor;
    }

        // Invoked on UI thread
        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);

            wordFetchListener.OnWordFetchComplete(cursor);
        }

}
