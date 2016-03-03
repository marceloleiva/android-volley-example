package cl.mleiva.pruebatoss.requests.callbacks;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;

/**
 * Created by oscar.urbina on 3/2/16.
 **/
public interface SecondRequestCallback {

    /**
     * On first request success.
     *
     * @param response the response
     */
    void onSecondRequestSuccess(JSONArray response);

    /**
     * On first request error.
     *
     * @param error the error
     */
    void onSecondRequestError(VolleyError error);

    /**
     * On first request ended.
     *
     * @param request the request
     */
    void onSecondRequestEnded(Request<JSONArray> request);
}
