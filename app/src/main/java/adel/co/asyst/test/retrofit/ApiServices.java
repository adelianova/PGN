package adel.co.asyst.test.retrofit;

import adel.co.asyst.test.model.LoginModel;
import adel.co.asyst.test.model.PgnModel;
import adel.co.asyst.test.retrofit.request.LoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {
    @POST("Login/getProfileInfo")
    Call<LoginModel> pgnlogin(@Body LoginRequest loginRequest);

    @POST("Task/getAllTask")
    Call<PgnModel> pgnTask(@Body PgnModel task);
}
