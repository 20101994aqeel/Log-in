package test.codevilla.co.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class second extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle b=getIntent().getExtras();
        String usermane=b.getString("message");
        tv=(TextView) findViewById(R.id.tv);
        tv.setText("Welcome..."+usermane);
    }
}
