package cl.mleiva.pruebatoss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements DispatcherCallback {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnSincronizar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestDispatcher requestDispatcher = new RequestDispatcher(MainActivity.this, getApplicationContext());
                requestDispatcher.startDispatching();
            }
        });
    }

    @Override
    public void dispatchIncomplete() {

    }
}
