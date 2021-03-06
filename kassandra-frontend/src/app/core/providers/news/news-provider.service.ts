import {Injectable} from "@angular/core";
import {Http, ResponseContentType, Response} from "@angular/http";
import {Type, GET, Query, BaseUrl, AbstractApiClient} from "angular2-rest-client";
import {Observable} from "rxjs";

@BaseUrl('https://45.62.231.206:8443/api/v1.0.0')

@Injectable()
export class NewsProviderService extends AbstractApiClient {

  constructor(protected http: Http) {
    super(http);
  }

  @Type(ResponseContentType.Json)

  @GET('/news')
  public getNewsByDate(@Query('date') date: string): Observable<Response> {
    return;
  }
}
