import { Component, OnInit } from '@angular/core';
import { Entry } from "../../models/Entry";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";


@Component({
  selector: 'app-add-entry',
  templateUrl: './add-entry.component.html',
  styleUrls: ['./add-entry.component.scss']
})
export class AddEntryComponent implements OnInit {

  // initializing blank form
  entryForm = new FormGroup({
    transactionType: new FormControl('',[Validators.required]),
    companyName: new FormControl('',[Validators.required]),
    companyCode: new FormControl('',[Validators.required]),
    accountName: new FormControl('',[Validators.required]),
    billDate: new FormControl(new Date(),[Validators.required]),
    price: new FormControl('',[Validators.required]),
    quantity: new FormControl('',[Validators.required])
  });

  entry : Entry;

  constructor() { }

  ngOnInit(): void {
  }

  submitEntry(){
    this.entry = this.entryForm.value;
    console.log(JSON.stringify(this.entry));
  }

}
