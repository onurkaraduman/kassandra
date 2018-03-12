import { Component, OnInit, Output, EventEmitter } from "@angular/core";
import { CurrencyProviderService } from "../../core/providers/currency/currency-provider.service";
import { DatePipe } from "@angular/common";
import { ExchangeRate } from "../../core/model/currency/exchange-rate";
import { ChartModel } from "./chart-model";
import { Filter } from "./filter/filter";
import { NewsProviderService } from "../../core/providers/news/news-provider.service";
import { ExchangeRateServiceService } from "../../core/services/exchange-rate-service.service";

@Component({
  selector: 'app-currency',
  templateUrl: './currency.component.html',
  styleUrls: ['./currency.component.css']
})
export class CurrencyComponent implements OnInit {

  public chart = new ChartModel();
  public filter: Filter;

  public news: Array<any> = [];

  @Output()
  chartClickNotify: EventEmitter<string> = new EventEmitter<string>();

  constructor(private exchangeRateService: ExchangeRateServiceService, private currencyProvider: CurrencyProviderService, private newsProvider: NewsProviderService, private datePipe: DatePipe) {
  }

  ngOnInit() {
    this.filter = new Filter();
  }

  public changeYear(year: string) {
    var date = new Date(parseInt(year), 0, 1);
  }

  doFilter() {
    let from = this.filter.from;
    let to = this.filter.to;
    this.exchangeRateService.getExchangeRatesBetweenDate('TRY', 'EUR', from, to).subscribe(data => {
      console.log("data:"+JSON.stringify(data.json()));
      let exchRates: ExchangeRate[] = <ExchangeRate[]>data.json();
      if (exchRates.length > 0)
        this.chart.updateData(exchRates);
    });
  }

  public chartClicked(e: any): void {
    try {
      this.news = [];
      var chartData = e.active[0]['_chart'].config.data;
      var idx = e.active[0]['_index'];

      var label = chartData.labels[idx];
      var value = chartData.datasets[0].data[idx];
      this.chartClickNotify.emit(label);
    }
    catch (e) {
      console.log("Please click on any date");
    }
  }

  public changeZoom(obj: string) {
    this.chart.clearChart();
    switch (obj) {
      case "M1":
        this.updateM1();
        break;
      case "M3":
        this.updateM3();
        break;
      case "M6":
        this.updateM6();
        break;
      case "Y1":
        this.updateY1();
        break;
      case "Y2":
        this.updateY2();
        break;
      case "Y3":
        this.updateY3();
        break;
      case "Y10":
        this.updateY10();
        break;
      default:
        console.log("couldnt find");
    }
  }

  public updateM1() {
    this.getLastNMonth(1);
  }

  public updateM3() {
    this.getLastNMonth(3);
  }

  public updateM6() {
    this.getLastNMonth(6);
  }

  public updateY1() {
    this.getLastNMonth(12);
  }

  public updateY2() {
    this.getLastNMonth(24);
  }

  public updateY3() {
    this.getLastNMonth(36);
  }

  public updateY10() {
    this.getLastNMonth(120);
  }

  getLastNMonth(n: number) {
    this.exchangeRateService.getLastNMonthExchangeRates('TRY', 'EUR', n).subscribe(data => {
      let exchRates: ExchangeRate[] = <ExchangeRate[]>data.json();
      if (exchRates.length > 0)
        this.chart.updateData(exchRates);
    });
  }
}
