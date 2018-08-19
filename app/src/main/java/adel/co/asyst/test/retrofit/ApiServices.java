package adel.co.asyst.test.retrofit;

import adel.co.asyst.test.model.LoginModel;
import adel.co.asyst.test.retrofit.request.LoginRequest;
import adel.co.asyst.test.retrofit.response.LoginResponse;
import adel.co.asyst.test.retrofit.response.PgnResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {
    @POST("Login/getProfileInfo")
    Call<LoginResponse> pgnlogin(@Body LoginRequest loginRequest);

    @POST("Task/getAllTask")
    Call<PgnResponse> pgnTask(@Body LoginModel loginModel);
}
