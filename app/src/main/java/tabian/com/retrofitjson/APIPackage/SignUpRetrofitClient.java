package tabian.com.retrofitjson.APIPackage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpRetrofitClient {
    private static final String BASE_URL_FOR_SIGN_UP = "http://uber-likeapp.ddns.net:5511/api/signUp/";
    private static SignUpRetrofitClient mInstance;
    private Retrofit retrofit;

    private SignUpRetrofitClient() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL_FOR_SIGN_UP).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized SignUpRetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new SignUpRetrofitClient();
        }
        return mInstance;
    }

    public APIInterface.SignUpInterface getAPI() {
        return retrofit.create(APIInterface.SignUpInterface.class);
    }

}
