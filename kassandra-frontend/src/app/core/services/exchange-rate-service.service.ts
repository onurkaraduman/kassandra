import {Injectable} from "@angular/core";
import {CurrencyProviderService} from "../providers/currency/currency-provider.service";
import {DatePipe} from "@angular/common";
import {Observable} from "rxjs";
import {Response} from "@angular/http";

@Injectable()
export class ExchangeRateServiceService {

  private static datePattern = 'yyyy-MM-dd';

  constructor(private currencyProvider: CurrencyProviderService, private datePipe: DatePipe) {
  }

  public getExchangeRatesBetweenDate(currency: string, referenceCurrency: string, startDate: string, endDate: string): Observable<Response> {
    var startDateTmp = this.datePipe.transform(startDate, ExchangeRateServiceService.datePattern);
    var endDateTmp = this.datePipe.transform(endDate, ExchangeRateServiceService.datePattern);
    return this.currencyProvider.getCurrencyBetweenDates(currency, referenceCurrency, startDateTmp, endDateTmp);
  }

  public getExchangeRatesByDate(date: Date): Observable<Response> {
    return this.callApi(date);
  }

  public getExchangeRateByYear(year: number): Observable<Response> {
    var date = new Date(year, 0, 1);
    return this.callApi(date);
  }

  public getExchangeRateByYearAndMonth(currency: string, referenceCur: string, year: number, month: number): Observable<Response> {
    return this.currencyProvider.getCurrencyByYearAndMonth(currency, referenceCur, year, month);
  }

  private callApi(date: Date): Observable<Response> {
    var dateText = this.datePipe.transform(date, ExchangeRateServiceService.datePattern);
    return this.currencyProvider.getCurrency('TRY', 'EUR', dateText);
  }

  public getLastNMonthExchangeRates(cur: string, refCur: string, n: number) {
    return this.currencyProvider.getLastNMonth(cur, refCur, n);
  }
}
