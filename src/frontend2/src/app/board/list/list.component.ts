import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {BoardService} from '../board.service';
import {Board} from '../../model/board.model';
import * as M from 'materialize-css/dist/js/materialize';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  boards: Board[];
  post;
  @ViewChild('fixedActionBtn') fixedActionBtn: ElementRef;

  constructor(private boardService: BoardService) {
  }

  onClick($event, id) {
    this.post = this.boards.find(value => value.id === id);
  }

  ngOnInit() {
    this.boardService.getList().subscribe(value => this.boards = value);
    this.post = {
      'title': '',
      'content': ''
    };
    M.Modal.init(document.querySelectorAll('.modal'), {});
  }

}
