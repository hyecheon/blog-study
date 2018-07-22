import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import * as M from 'materialize-css/dist/js/materialize';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @ViewChild('dropDownTrigger') dropDownTrigger: ElementRef;

  constructor() {
  }

  ngOnInit(): void {
    M.Dropdown.init(this.dropDownTrigger.nativeElement, {});
  }
}
