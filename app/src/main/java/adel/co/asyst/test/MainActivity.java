package adel.co.asyst.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import adel.co.asyst.test.model.LoginModel;
import adel.co.asyst.test.retrofit.ApiClient;
import adel.co.asyst.test.retrofit.ApiServices;
import adel.co.asyst.test.retrofit.request.LoginRequest;
import adel.co.asyst.test.retrofit.response.LoginResponse;
import adel.co.asyst.test.utility.Constant;
import adel.co.asyst.test.utility.SessionUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText unameED, passED;
    Button loginbtn;
    SessionUtils sessionUtils;

    String user;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unameED = findViewById(R.id.edit_text_username);
        passED = findViewById(R.id.edit_text_password);
        loginbtn = findViewById(R.id.button_login);

        sessionUtils = new SessionUtils(this);

        loginbtn.setOnClickListener(this);
        loginbtn.setOnClickListener(this);

        if (sessionUtils.isLogin()) {
            startActivity(new Intent(MainActivity.this, ListActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }

    private void getDataLogin() {
        LoginRequest loginRequest = new LoginRequest();
        LoginModel login = new LoginModel();
        user = unameED.getText().toString();
        pass = passED.getText().toString();
        loginRequest.setMethod("getProfileInfo");
        login.setUsername(user);
        login.setPassword(pass);
        loginRequest.setParam(login);
        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);

        Call<LoginResponse> call = apiServices.pgnlogin(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getStatus().equalsIgnoreCase("success")) {
                    sessionUtils.saveLogin(user, pass);
                    sessionUtils.saveIsLogin(Constant.ISLOGIN, true);
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Username atau password salah", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                user = unameED.getText().toString();
                pass = passED.getText().toString();
                if (!TextUtils.isEmpty(user)) {
                    if (!TextUtils.isEmpty(pass)) {
                        getDataLogin();
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
