package tabian.com.retrofitjson.APIPackage;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import tabian.com.retrofitjson.model.UserSignIn;
import tabian.com.retrofitjson.model.UserSignInResponse;
import tabian.com.retrofitjson.model.UserSignUp;
import tabian.com.retrofitjson.model.UserSignUpResponse;
/**
 * Created by UserSignUp on 5/1/2017.
 */
public interface APIInterface {
    interface SignUpInterface {

        @FormUrlEncoded

        //@Headers({"Content-Type: x-www-form-urlencoded"})
        @POST("{signUp}")
        Call<UserSignUpResponse> signUp(

                @Field("email") String email,
                @Field("password") String password,
                @Field("firstName") String firstName,
                @Field("phoneNo") String phoneNo,
                @Field("lastName") String lastName

        );
        /*@FormUrlEncoded
        @GET("{signUp}")
        Call<UserSignUpResponse> signUpResponse(

               // @Field("success") String success,
                //@Field("aid") int aid

        );*/
    }

    interface SignInInterface {

        @FormUrlEncoded
        @POST("{signIn}")
        Call<UserSignInResponse> signIn(
                @Field("email") String email,
                @Field("password") String password
        );

       /* @FormUrlEncoded
        @GET("{signIn}")
        Call<UserSignInResponse> signInResponse(
*//*                @Field("email") String email,
                @Field("firstName") String firstName,
                @Field("phoneNo") String phoneNo,
                @Field("lastName") String lastName,
                @Field("success") String success,
                @Field("aid") int aid*//*
                //@Field("type") String type
        );*/
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

