import {Component} from '@angular/core';
import {RegistrationRequest} from "../../services/models/registration-request";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/services/authentication.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  registerRequest: RegistrationRequest = {email: '', password: '', firstname: "", lastname: "", confirmPassword: ''};
  errorConfirmPassword: boolean = false;
  isEmailValidation = false;
  isFirstNameValidation = false;
  isLastNameValidation = false;
  isPasswordValidation = false;
  isMINIMUM_PASSWORD_LENGTH = false
  isEmailExists = false;

  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) {
  }

  login() {
    this.router.navigate(['login']);
  }

  register() {
    this.errorConfirmPassword = false;
    this.errorConfirmPassword = false;
    this.isEmailValidation = false;
    this.isFirstNameValidation = false;
    this.isLastNameValidation = false;
    this.isPasswordValidation = false;
    this.isMINIMUM_PASSWORD_LENGTH = false
    this.authService.register({body: this.registerRequest}).subscribe({
      next: () => {
        this.router.navigate(['activate-account']);
      },
      error: (err: any) => {
        if (err.error.validationErrors) {
          for (let i = 0; i < err.error.validationErrors.length; i++) {
            switch (err.error.validationErrors[i]) {
              case "EMAIL_REQUIRED":
                this.isEmailValidation = true;
                break;
              case "FIRST_NAME_REQUIRED":
                this.isFirstNameValidation = true;
                break;
              case "LAST_NAME_REQUIRED":
                this.isLastNameValidation = true;
                break;
              case "PASSWORDS_DO_NOT_MATCH":
                this.errorConfirmPassword = true;
                break;
              case "PASSWORD_REQUIRED":
                this.isPasswordValidation = true;
                break;
              case "MINIMUM_PASSWORD_LENGTH_8_CHARACTERS":
                this.isMINIMUM_PASSWORD_LENGTH = true;
                break;
            }
          }
        }
        if(err.error){
          if(err.error.error === "EMAIL_EXISTS"){
            this.isEmailExists = true
          }else{
            this.isEmailExists = false
          }
        }
      }
    });
  }

  checkPasswordMatch(): boolean {
    if (this.registerRequest.confirmPassword === this.registerRequest.password) {
      this.errorConfirmPassword = false;
      return true;
    } else {
      this.errorConfirmPassword = true;
      return false;
    }
  }
}
