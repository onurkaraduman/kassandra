import {Component, OnInit, Input} from "@angular/core";
import {NewsService} from "../../core/services/news.service";
import {News} from "../../core/model/news/news";

@Component({
  selector: 'app-news-board',
  templateUrl: 'news-board.component.html',
  styleUrls: ['news-board.component.css']
})
export class NewsBoardComponent implements OnInit {

  constructor(private newService: NewsService) {
  }

  ngOnInit(): void {
  }

  @Input()
  public date: string;

  public news: Array<any> = [];

  public columns: Array<any> = [{
    title: 'Title', name: 'title'
  }];

  public update(date: string) {
    this.provideNews(date);
  }

  public provideNews(date: string) {
    this.newService.getNewsByDate(date).subscribe(data => {
      this.news = <News[]>data.json();
    });
  }
}
