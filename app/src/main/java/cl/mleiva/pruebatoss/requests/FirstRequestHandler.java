package cl.mleiva.pruebatoss.requests;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import cl.mleiva.pruebatoss.requests.callbacks.FirstRequestCallback;

/**
 * Created by oscar.urbina on 3/2/16.
 **/
public class FirstRequestHandler extends BaseRequestHandler {

    /**
     * The constant REQUEST_URL.
     */
    private static final String REQUEST_URL = "http://jsonplaceholder.typicode.com/posts?userId=1";

    /**
     * The First request callback.
     */
    private FirstRequestCallback firstRequestCallback;

    /**
     * Instantiates a new Request handler.
     *
     * @param firstRequestCallback the first request callback
     */
    public FirstRequestHandler(FirstRequestCallback firstRequestCallback) {
        this.firstRequestCallback = firstRequestCallback;
    }

    /**
     * On response.
     *
     * @param response the response
     */
    @Override
    public void onResponse(JSONArray response) {
        this.firstRequestCallback.onFirstRequestSuccess(response);
    }

    /**
     * On error response.
     *
     * @param error the error
     */
    @Override
    public void onErrorResponse(VolleyError error) {
        this.firstRequestCallback.onFirstRequestError(error);
    }

    /**
     * On request finished.
     *
     * @param request the request
     */
    @Override
    public void onRequestFinished(Request<JSONArray> request) {
        this.firstRequestCallback.onFirstRequestEnded(request);
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
