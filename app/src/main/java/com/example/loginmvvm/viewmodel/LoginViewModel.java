package com.example.loginmvvm.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

import com.example.loginmvvm.model.User;

public class LoginViewModel extends BaseObservable {

    private String email;
    private String password;

    public ObservableField<String> message = new ObservableField<>();
    public ObservableField<Boolean> iShowMessage = new ObservableField<>();
    public ObservableField<Boolean> colorMessage = new ObservableField<>();

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onClickBtnLogin() {
        User user = new User(getEmail(), getPassword());

        iShowMessage.set(true);

        if (user.isValidEmail() && user.isValidPassword()) {
            message.set("Login success");
            colorMessage.set(true);
        } else {
            message.set("Email or Password invalid");
            colorMessage.set(false);
        }
    }
}
