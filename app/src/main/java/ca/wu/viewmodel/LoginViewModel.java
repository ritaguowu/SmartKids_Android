package ca.wu.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ca.wu.smartkids.model.LoginBody;
import ca.wu.smartkids.repository.LoginRepository;
import ca.wu.smartkids.model.LoginResponse;


public class LoginViewModel extends ViewModel {
    MutableLiveData<String> mLoginResultMutableData = new MutableLiveData<>();
    LoginRepository loginRepository;

    public LoginViewModel(){
        mLoginResultMutableData.postValue("Not Logged in");
        loginRepository = new LoginRepository();
    }

    public void login(String email, String password){
        mLoginResultMutableData.postValue("Checking");
        loginRepository.loginRemote(new LoginBody(email, password), new LoginRepository.ILoginResponse() {
            @Override
            public void onResponse(LoginResponse loginResponse) {
                mLoginResultMutableData.postValue("Login Success");
            }

            @Override
            public void onFailure(Throwable t) {
                mLoginResultMutableData.postValue("Login failure: "+ t.getLocalizedMessage());
            }
        });
    }

    public LiveData<String> getLoginResult(){
        return mLoginResultMutableData;
    }
}
