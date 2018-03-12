import {Component, OnInit, ViewChild} from "@angular/core";
import {NewsBoardComponent} from "../news-board/news-board.component";

@Component({
  selector: 'app-main',
  templateUrl: 'main.component.html',
  styleUrls: ['main.component.css']
})
export class MainComponent implements OnInit {

  public date: string;

  @ViewChild(NewsBoardComponent)
  private newsBoard: NewsBoardComponent;

  constructor() {
  }

  ngOnInit() {
  }

  public newsNotify(date: string) {
    this.date = date;
    this.newsBoard.update(date);
  }
}
