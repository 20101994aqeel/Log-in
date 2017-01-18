package test.codevilla.co.test;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText username, password;
    Button login;
    databs db;
    Cursor cr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new databs(this);
      
        //make the sharedpreference
        SharedPreferences sharedPreferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);

        // if a user is allready login then it will show the username and password on edit text
        username.setText(sharedPreferences.getString("name","username"));
        password.setText(sharedPreferences.getString("password","username"));

        login=(Button) findViewById(R.id.log);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usname=username.getText().toString();
                String pass=password.getText().toString();
             //select all table in the curser
                cr = db.getinformation();
                cr.moveToFirst();
                try {
                    while(cr.moveToNext()) {
                        String u=(cr.getString(cr.getColumnIndex("username")));
                        String p=(cr.getString(cr.getColumnIndex("password")));

                      //compare the editTest username and password with database username and password

                        if(usname.equals(u) && pass.equals(p)){
                            editor.putString("name",usname);
                            editor.putString("password",pass);
                            editor.commit();
                            Intent i=new Intent(MainActivity.this,second.class);
                            i.putExtra("message",usname);
                            startActivity(i);
                        }
                    }
                } finally {
                    cr.close();
                }

            }
        });
    }
}
