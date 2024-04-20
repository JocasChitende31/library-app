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
    role: ['', Validators.required]
  })
  passCombineSms: boolean = false;
  constructor(private authService: AuthorizationService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {

  }

  register() {

    let userObj = this.form.value;
    this.user = new User(userObj.login, userObj.password, userObj.role);

    if (userObj.password != userObj.passwordConfirm) {
      this.passCombineSms = !this.passCombineSms;
    } else {
      this.authService.register(this.user).subscribe(data => {
      })
    }

    // this.authService

  }
}
