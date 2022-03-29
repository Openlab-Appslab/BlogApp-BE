import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ScoreService {

  private readonly SCORE_ENDPOINT = 'http://localhost:8080/score';

  private readonly OPTIONS = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(
    private readonly httpClient: HttpClient
  ) { }

  getScore(): Observable<number> {
    return this.httpClient.get<{ score: number }>(this.SCORE_ENDPOINT).pipe(
      map(dto => dto.score)
    );
  }

  setScore(score: number): Observable<any> {
    return this.httpClient.post(this.SCORE_ENDPOINT, { score }, this.OPTIONS);
  }

}
