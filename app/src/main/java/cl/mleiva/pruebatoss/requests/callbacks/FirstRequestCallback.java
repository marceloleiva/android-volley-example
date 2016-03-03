package cl.mleiva.pruebatoss.requests.callbacks;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;

/**
 * Created by oscar.urbina on 3/2/16.
 **/
public interface FirstRequestCallback {

    /**
     * On first request success.
     *
     * @param response the response
     */
    void onFirstRequestSuccess(JSONArray response);

    /**
     * On first request error.
     *
     * @param error the error
     */
    void onFirstRequestError(VolleyError error);

    /**
     * On first request ended.
     *
     * @param request the request
     */
    void onFirstRequestEnded(Request<JSONArray> request);
}
