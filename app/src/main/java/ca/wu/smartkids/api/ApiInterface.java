package ca.wu.smartkids.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("/auth")
    Call<User> getToken(@Body User user);

    @POST("/parent")
    Call<User> signup(@Body User user);

    @POST("/kid/{parentId}")
    Call<User> signupKid(@Path("parentId") String parentId, @Body User user);

    @GET("/kids/{parentId}")
    Call<List<User>> getKidsByParentId(@Path("parentId") String parentId);

    @GET("/parent/{email}")
    Call<List<User>> updateParent(@Path("email") String email);

    @PUT("/kid/{email}&{kid_name}")
    Call<List<User>> updateKid(@Path("email") String email, @Body User user);

    @DELETE("/kid/{email}&{kid_name}")
    Call<List<User>> deleteKid(@Path("email") String email);

}
