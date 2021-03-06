package by.grodno.zagart.observer.observerandroid.http;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.widget.Toast;

import by.grodno.zagart.observer.observerandroid.http.interfaces.IHttpClient;
import by.grodno.zagart.observer.observerandroid.singletons.ContextHolder;

public class HttpRequestTask extends AsyncTask<String, Void, String> {
    private IHttpClient.IRequest mRequest;
    private String mResult;

    public HttpRequestTask(String pUrl,
                           IHttpClient.IRequest pRequest) {
        mRequest = pRequest;
    }

    @Override
    @Nullable
    protected String doInBackground(String... urls) {
        return (new HttpClient()).executeRequest(mRequest, IHttpClient.Method.GET);
    }

    @Override
    protected void onPostExecute(final String pResponse) {
        super.onPostExecute(pResponse);
        Toast.makeText(ContextHolder.get(), pResponse, Toast.LENGTH_SHORT).show();
        mResult = pResponse;
    }

    @Nullable
    public String getResult() {
        return mResult;
    }
}
