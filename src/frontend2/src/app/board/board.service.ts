import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Board} from '../model/board.model';

@Injectable({
  providedIn: 'root'
})
export class BoardService {

  constructor(private http: HttpClient) {
  }

  public getList() {
    return this.http.get<Board[]>('/api/boards');
  }

  public create(board) {
    const payload = {
      'title': board.title,
      'auth': board.auth,
      'content': board.content
    };
    return this.http.post<Board>('/api/boards', payload);
  }
}
