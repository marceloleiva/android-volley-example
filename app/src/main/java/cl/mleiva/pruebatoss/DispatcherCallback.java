package cl.mleiva.pruebatoss;

/**
 * Created by oscar.urbina on 3/2/16.
 */
public interface DispatcherCallback {

    /**
     * Dispatch incomplete.
     *
     * Executes this method only when a request
     * has not been successfully processed by server
     */
    void dispatchIncomplete();
}
