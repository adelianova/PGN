package adel.co.asyst.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import adel.co.asyst.test.retrofit.ApiClient;
import adel.co.asyst.test.retrofit.ApiServices;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText unameED, passED;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unameED = findViewById(R.id.edit_text_username);
        passED = findViewById(R.id.edit_text_password);
        loginbtn = findViewById(R.id.button_login);

        loginbtn.setOnClickListener(this);
        getDataLogin();
    }

    private void getDataLogin() {
        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);

        // Call<LoginRequest> call = apiServices.pgnlogin();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:

                String user = unameED.getText().toString();
                String pass = passED.getText().toString();
                if (!TextUtils.isEmpty(user)) {
                    if (!TextUtils.isEmpty(pass)) {
                        if (user.equalsIgnoreCase("user") && pass.equalsIgnoreCase("password")) {
                            Intent intent = new Intent(MainActivity.this, ListActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Username atau Password salah", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        passED.setError("Password belum diisi");
                    }
                } else {
                    unameED.setError("Username belum diisi");
                }

                break;
        }
    }
}
