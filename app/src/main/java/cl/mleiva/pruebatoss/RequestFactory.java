package cl.mleiva.pruebatoss;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oscar.urbina on 3/2/16.
 **/
public class RequestFactory {

    /**
     * Fabric request json object request.
     *
     * @param method        the method
     * @param url           the url
     * @param listener      the listener
     * @param errorListener the error listener
     * @return the json object request
     */
    public static JsonArrayRequest fabricRequest(
            int method,
            String url,
            Response.Listener listener,
            Response.ErrorListener errorListener) {

        final JsonArrayRequest myReq = new JsonArrayRequest(method, url, listener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                params.put("Accept", "application/json");
                return params;
            }
        };

        return myReq;
    }
}
