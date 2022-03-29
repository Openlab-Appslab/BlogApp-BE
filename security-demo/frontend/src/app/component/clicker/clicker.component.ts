import { Component, OnInit } from '@angular/core';
import { ScoreService } from '../../service/score.service';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {

  score: number;

  constructor(
    private readonly scoreService: ScoreService
  ) { }

  ngOnInit(): void {
    this.scoreService.getScore()
      .subscribe(score => this.score = score);
  }

  click(): void {
    this.scoreService.setScore(++this.score).subscribe();
  }

}
