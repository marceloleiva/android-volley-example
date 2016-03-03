package cl.mleiva.pruebatoss.requests;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;

/**
 * Created by oscar.urbina on 3/2/16.
 **/
public class BaseRequestHandler implements Response.Listener<JSONArray>, Response.ErrorListener,
        RequestQueue.RequestFinishedListener<JSONArray> {

    /**
     * On error response.
     *
     * @param error the error
     */
    @Override
    public void onErrorResponse(VolleyError error) {

    }

    /**
     * On response.
     *
     * @param response the response
     */
    @Override
    public void onResponse(JSONArray response) {

    }

    /**
     * On request finished.
     *
     * @param request the request
     */
    @Override
    public void onRequestFinished(Request<JSONArray> request) {

    }
}
