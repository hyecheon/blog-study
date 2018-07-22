import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {BoardService} from '../board.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  form = new FormGroup({
    formContent: new FormControl(''),
    formTitle: new FormControl(''),
    formAuth: new FormControl('')
  });

  constructor(private boardService: BoardService, private router: Router) {
  }

  ngOnInit() {
  }

  onSubmit() {
    const {
      value: {
        formContent: content,
        formTitle: title,
        formAuth: auth
      }
    } = this.form;
    const board = {content, title, auth};
    const created = this.boardService.create(board);
    created.subscribe(value => {
      console.log(value);
      this.router.navigate(['/board-list']);
    });
  }
}
