import {Injectable} from "@angular/core";
import {BaseUrl, AbstractApiClient, Type, GET, Path, Query} from "angular2-rest-client";
import {Http, ResponseContentType, Response} from "@angular/http";
import {Observable} from "rxjs";

@BaseUrl('http://localhost:8080/api/v1.0.0')


@Injectable()
export class CurrencyProviderService extends AbstractApiClient {

  constructor(protected http: Http) {
    super(http);
  }

  @Type(ResponseContentType.Json)

  @GET('/exchangerate/{currency}/{refCurrency}')
  public getCurrency(@Path('currency') cur: string,
                     @Path('refCurrency') refCur: string,
                     @Query('date') date: string): Observable<Response> {
    return;
  }

  @GET('/exchangerate/{currency}/{refCurrency}')
  public getCurrencyByYearAndMonth(@Path('currency') cur: string,
                                   @Path('refCurrency') refCur: string,
                                   @Query('year') year: number,
                                   @Query('month') month: number): Observable<Response> {
    return;
  }


  @GET('/exchangerate/{currency}/{refCurrency}')
  public getCurrencyBetweenDates(@Path('currency') cur: string,
                                 @Path('refCurrency') refCur: string,
                                 @Query('startDate')  startDate: string,
                                 @Query('endDate') endDate: string): Observable<Response> {
    return;
  }

  @GET('/exchangerate/{currency}/{refCurrency}')
  public getLastNMonth(@Path('currency') cur: string,
                       @Path('refCurrency') refCur: string,
                       @Query('monthBefore')  monthBefore: number): Observable<Response> {
    return;
  }
}
