import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

import { AccountInfo } from "../../models/AccountInfo"

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {

  // initializing blank form
  accountForm = new FormGroup({
    name: new FormControl('',[Validators.required]),
    identifier: new FormControl('',[Validators.required])
  });

  constructor() { }

  accountInfo: AccountInfo;

  ngOnInit(): void {
  }

   submitAccount(){
    this.accountInfo = this.accountForm.value;
    console.log(JSON.stringify(this.accountInfo));
  }

}
