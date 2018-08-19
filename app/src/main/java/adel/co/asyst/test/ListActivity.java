package adel.co.asyst.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import adel.co.asyst.test.adapter.PgnAdapter;
import adel.co.asyst.test.model.LoginModel;
import adel.co.asyst.test.model.PgnModel;
import adel.co.asyst.test.retrofit.ApiClient;
import adel.co.asyst.test.retrofit.ApiServices;
import adel.co.asyst.test.retrofit.response.PgnResponse;
import adel.co.asyst.test.utility.Constant;
import adel.co.asyst.test.utility.SessionUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PgnAdapter pgnAdapter;
    ProgressBar progressBar;
    ArrayList<PgnModel> listTask = new ArrayList<>();
    boolean isLoading = false;
    SessionUtils sessionUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        sessionUtils = new SessionUtils(this);
        pgnAdapter = new PgnAdapter(this, listTask, new PgnAdapter.onItemClickListener() {
            @Override
            public void onItemClickListener(PgnModel pgnModel) {
                Toast.makeText(getApplicationContext(), pgnModel.getCustomer_name(), Toast.LENGTH_SHORT).show();
            }
        });
        getDataTask();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {
                    if (!isLoading) {
                        progressBar.setVisibility(View.VISIBLE);
                        isLoading = true;
                    }
                }
            }
        });
        recyclerView.setAdapter(pgnAdapter);
    }

    private void getDataTask() {
        LoginModel loginModel = new LoginModel();
        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);
        Call<PgnResponse> call = apiServices.pgnTask(loginModel);
        call.enqueue(new Callback<PgnResponse>() {
            @Override
            public void onResponse(Call<PgnResponse> call, Response<PgnResponse> response) {
                progressBar.setVisibility(View.INVISIBLE);
                if (response.body() != null) {
                    if (response.body().getStatus() == "success") {
                        listTask.addAll(response.body().getData());
                        pgnAdapter.notifyDataSetChanged();
                    }
                }
                isLoading = false;
            }

            @Override
            public void onFailure(Call<PgnResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error Occured", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.logout_menu:
                sessionUtils.saveIsLogin(Constant.ISLOGIN, false);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
