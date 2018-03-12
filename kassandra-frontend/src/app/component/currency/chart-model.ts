///<reference path="../../util/date-util.ts"/>
import {Zoom} from "./enum/zoom.enum";
import {DateUtil} from "../../util/date-util";
import {ExchangeRate} from "../../core/model/currency/exchange-rate";
export class ChartModel {

  // lineChart
  public lineChartData: Array<any> = [
    {data: [], label: 'EUR'}
  ];
  public lineChartLabels: Array<any> = [];
  public lineChartOptions: any = {
    responsive: true
  };
  public lineChartColors: Array<any> = [
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
  ];
  public lineChartLegend: boolean = true;
  public lineChartType: string = 'line';

  public addValues(args: Array<any>) {
    this.lineChartData = args;
  }

  /* public sort() {
   this.lineChartLabels.sort((n1, n2) => {
   var curDate1 = new Date(n1);
   var curDate1 = new Date(n2);
   });
   }*/

  public addValue(data: number, label: string) {
    this.addData(data);
    this.addLabel(label);
  }

  public updateData(data: ExchangeRate[]) {
    let lineChartDat = [];
    this.lineChartLabels = [];
    for (let entry of data) {
      lineChartDat.push(entry.value);
      this.lineChartLabels.push(entry.date);
    }
    this.lineChartData[0].data = lineChartDat;
  }

  public clearChart() {
    this.lineChartData = [{data: [], label: 'EUR'}];
    this.lineChartLabels = [];
  }

  public filterByDate(from: Date, to: Date) {

  }

  public filterByZoom(zoom: Zoom) {
    let datePattern = 'yyyy-MM-dd';
   // let endDate = DateUtil.getToday(datePattern);
    //let startDate = DateUtil.getToday(datePattern);

    let endDate = DateUtil.getMocEndkDate(null);
    let startDate = DateUtil.getMocStartkDate(null);
    switch (zoom) {
      case Zoom.M1:
        startDate = DateUtil.getMonthAgo(1, datePattern);
        break;
      case  Zoom.M3:
        startDate = DateUtil.getMonthAgo(3, datePattern);
        break;
      case Zoom.M6:
        startDate = DateUtil.getMonthAgo(6, datePattern);
        break;
      case Zoom.Y1:
        startDate = DateUtil.getYearAgo(1, datePattern);
        break;
      case Zoom.Y2:
        startDate = DateUtil.getMonthAgo(2, datePattern);
        break;
      case Zoom.Y3:
        startDate = DateUtil.getMonthAgo(3, datePattern);
        break;
      case Zoom.Y10:
        startDate = DateUtil.getMonthAgo(10, datePattern);
        break;
    }
  }

  private addData(data: number) {
    let newLineCharData: Array<any> = new Array(this.lineChartData[0].data.length + 1);
    this.copyArray(this.lineChartData[0].data, newLineCharData);
    newLineCharData[this.lineChartData[0].data.length] = data;
    this.lineChartData[0].data = newLineCharData;
  }

  private addLabel(label: string) {
    let newLabels: Array<any> = new Array(this.lineChartLabels.length + 1);
    this.copyArray(this.lineChartLabels, newLabels);
    newLabels[this.lineChartLabels.length] = label;
    this.lineChartLabels = newLabels;
  }

  private copyArray(source: Array<any>, target: Array<any>) {
    for (var i = 0; i < source.length; i++) {
      target[i] = source[i];
    }
  }

}
