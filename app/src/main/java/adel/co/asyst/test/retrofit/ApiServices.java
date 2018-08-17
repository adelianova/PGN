package adel.co.asyst.test.retrofit;

import adel.co.asyst.test.model.PgnModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("Login/getProfileInfo")
    Call<PgnModel> pgnlogin(@Body PgnModel login);

    @GET("Task/getAllTask")
    Call<PgnModel> pgnTask(@Body PgnModel task);
}
