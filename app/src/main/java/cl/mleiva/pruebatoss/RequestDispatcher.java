package cl.mleiva.pruebatoss;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import cl.mleiva.pruebatoss.requests.BaseRequestHandler;
import cl.mleiva.pruebatoss.requests.FirstRequestHandler;
import cl.mleiva.pruebatoss.requests.SecondRequestHandler;
import cl.mleiva.pruebatoss.requests.callbacks.FirstRequestCallback;
import cl.mleiva.pruebatoss.requests.callbacks.SecondRequestCallback;

/**
 * Created by oscar.urbina on 3/2/16.
 **/
public class RequestDispatcher implements FirstRequestCallback, SecondRequestCallback {

    /**
     * The Dispatcher callback.
     */
    private DispatcherCallback dispatcherCallback;

    /**
     * The Queue.
     */
    private RequestQueue queue;
    private Context context;

    /**
     * Instantiates a new Request dispatcher.
     *
     * @param dispatcherCallback the dispatcher callback
     */
    public RequestDispatcher(DispatcherCallback dispatcherCallback, Context context) {
        this.dispatcherCallback = dispatcherCallback;
        this.context = context;
    }

    /**
     * Start dispatching.
     */
    public void startDispatching() {

        this.queue = VolleySingleton.getInstance(this.context).getRequestQueue();

        final FirstRequestHandler firstRequestHandler = new FirstRequestHandler(this);
        this.generateRequest(firstRequestHandler, firstRequestHandler.getRequestUrl());
    }

    /**
     * On first request success.
     *
     * @param response the response
     */
    @Override
    public void onFirstRequestSuccess(JSONArray response) {
        Log.i("onFirstRequestSuccess", response.toString());
    }

    /**
     * On first request error.
     *
     * @param error the error
     */
    @Override
    public void onFirstRequestError(VolleyError error) {
        Log.i("onFirstRequestError", error.toString());
        this.dispatcherCallback.dispatchIncomplete();
    }

    /**
     * On first request ended.
     *
     * @param request the request
     */
    @Override
    public void onFirstRequestEnded(Request<JSONArray> request) {
        final SecondRequestHandler secondRequestHandler = new SecondRequestHandler(this);
        this.generateRequest(secondRequestHandler, secondRequestHandler.getRequestUrl());
    }

    /**
     * On second request success.
     *
     * @param response the response
     */
    @Override
    public void onSecondRequestSuccess(JSONArray response) {
        Log.i("onSecondRequestSuccess", response.toString());
    }

    /**
     * On second request error.
     *
     * @param error the error
     */
    @Override
    public void onSecondRequestError(VolleyError error) {
        Log.i("onSecondRequestError", error.toString());
        this.dispatcherCallback.dispatchIncomplete();
    }

    /**
     * On second request ended.
     *
     * @param request the request
     */
    @Override
    public void onSecondRequestEnded(Request<JSONArray> request) {
        Log.i("onSecondRequestEnded", request.toString());
    }

    /**
     * Generate request.
     *
     * @param baseRequestHandler the request handler
     * @param url                the url
     */
    private void generateRequest(BaseRequestHandler baseRequestHandler, String url) {
        final JsonArrayRequest request = RequestFactory.fabricRequest(Request.Method.GET, url, baseRequestHandler, baseRequestHandler);

        queue.addRequestFinishedListener(baseRequestHandler);
        queue.add(request);
    }
}
