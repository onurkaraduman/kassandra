import {Injectable} from "@angular/core";
import {NewsProviderService} from "../providers/news/news-provider.service";
import {Observable} from "rxjs";
import {Response} from "@angular/http";

@Injectable()
export class NewsService {

  constructor(private newsProvider: NewsProviderService) {
  }

  public getNewsByDate(date: string): Observable<Response> {
    return this.newsProvider.getNewsByDate(date);
  }
}
