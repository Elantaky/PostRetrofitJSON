package tabian.com.retrofitjson.APIPackage;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tabian.com.retrofitjson.model.LoginResponse;
import tabian.com.retrofitjson.model.User;

/**
 * Created by User on 5/1/2017.
 */
public interface APIInterface {
    interface SignUpInterface {

        @FormUrlEncoded
        @POST("{signUp}")
        Call<User> signUp(
                // @HeaderMap Map<String, String> headers,
                // @Path("signUp") String username,
                @Field("email") String email,
                @Field("password") String password,
                @Field("firstName") String firstName,
                @Field("phoneNo") String phoneNo,
                @Field("lastName") String lastName,
                @Field("api-type") String type

        );

    }

    interface SignInInterface {


        @FormUrlEncoded
        @POST("{signIn}")
        Call<User> signIn(
                @Field("email") String email,
                @Field("password") String password,
                @Field("api-type") String type
        );
    }

}



    /*String BASE_URL = "https://www.reddit.com/";

    @Headers("Content-Type: application/json")
    @GET(".json")
    Call<Feed> getData();


    @POST("{user}")
    Call<ResponseBody> login(
      @HeaderMap Map<String, String> headers,
      @Path("user") String username,  //codingwithmitch
      @Query("user") String user,       //?user=codingwithmitch
      @Query("passwd") String password, //&passwd=Mitchtabian1234!
      @Query("api-type") String type    //&api-type=json
    );*/

