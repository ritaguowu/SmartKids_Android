package ca.wu.smartkids.repository;

import static java.security.AccessController.getContext;

import org.json.JSONObject;

import ca.wu.smartkids.model.LoginBody;
import ca.wu.smartkids.model.LoginResponse;
import ca.wu.smartkids.model.User;
import ca.wu.smartkids.retrofit.ILoginService;
import ca.wu.smartkids.retrofit.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    public LoginRepository(){
    }

    public void loginRemote(LoginBody loginBody, ILoginResponse loginResponse){
        ILoginService loginService = RetrofitClientInstance.getInstance().create(ILoginService.class);
        Call<LoginResponse> initiateLogin = loginService.login(loginBody);

        initiateLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    loginResponse.onResponse(response.body());
                }
                else{
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        loginResponse.onFailure(new Throwable(jObjError.get("error").toString()));
                    } catch (Exception e) {
                        System.out.println("System Error");
                    }

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginResponse.onFailure(t);
            }
        });
    }

    public interface ILoginResponse{
        void onResponse(LoginResponse loginResponse);
        void onFailure(Throwable t);
    }
}
