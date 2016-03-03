package cl.mleiva.pruebatoss.requests;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import cl.mleiva.pruebatoss.requests.callbacks.SecondRequestCallback;

/**
 * Created by oscar.urbina on 3/2/16.
 **/
public class SecondRequestHandler extends BaseRequestHandler {

    /**
     * The First request callback.
     */
    private SecondRequestCallback secondRequestCallback;

    /**
     * The constant REQUEST_URL.
     */
    private static final String REQUEST_URL = "http://jsonplaceholder.typicode.com/posts";

    /**
     * Instantiates a new Request handler.
     *
     * @param secondRequestCallback the first request callback
     */
    public SecondRequestHandler(SecondRequestCallback secondRequestCallback) {
        this.secondRequestCallback = secondRequestCallback;
    }

    /**
     * On response.
     *
     * @param response the response
     */
    @Override
    public void onResponse(JSONArray response) {
        this.secondRequestCallback.onSecondRequestSuccess(response);
    }

    /**
     * On error response.
     *
     * @param error the error
     */
    @Override
    public void onErrorResponse(VolleyError error) {
        this.secondRequestCallback.onSecondRequestError(error);
    }

    /**
     * On request finished.
     *
     * @param request the request
     */
    @Override
    public void onRequestFinished(Request<JSONArray> request) {
        this.secondRequestCallback.onSecondRequestEnded(request);
    }

    /**
     * Gets request url.
     *
     * @return the request url
     */
    public String getRequestUrl() {
        return REQUEST_URL;
    }
}
