import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../../model/user';
import { AuthorizationService } from '../../service/authorization.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user?: User;

  form: FormGroup = this.formBuilder.group({
    id: [''],
    login: ['', Validators.required],
    password: ['', Validators.required],
    passwordConfirm: ['', Validators.required],
    role: ['']
  })
  passCombineSms: boolean = false;
  constructor(private authService: AuthorizationService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {

  }

  register() {

    let userObj = this.form.value;
    // this.user = new User(userObj.login, userObj.password, userObj.role);

    if (userObj.password != userObj.passwordConfirm) {
      this.passCombineSms = !this.passCombineSms;
    } else {
      if (userObj.role === '') {
        let r = this.form.get('role');
        let roleDefault = r?.setValue('USER') || 'USER';
        // console.log(roleDefault);

        this.user = new User(userObj.login, userObj.password, roleDefault);

        this.authService.register(this.user).subscribe(data => {
        })
      } else {
        this.user = new User(userObj.login, userObj.password, userObj.role);
        this.authService.register(this.user).subscribe(data => {
        })
      }

    }

    // this.authService

  }
}
