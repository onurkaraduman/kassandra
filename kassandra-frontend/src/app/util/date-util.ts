import { DatePipe } from "@angular/common";
export class DateUtil {

  private static datePipe: DatePipe = new DatePipe('en-US');
  private static DEFAULT_DATE_PATTERN = 'yyyy-MM-dd';

  public static getToday(pattern: string): string {
    if (pattern == null) {
      pattern = this.DEFAULT_DATE_PATTERN;
    }
    return this.datePipe.transform(new Date(), pattern);
  }

  public static getMocStartkDate(pattern: string): string {
    if (pattern == null) {
      pattern = this.DEFAULT_DATE_PATTERN;
    }
    return this.datePipe.transform('2006-01-01', pattern);
  }

  public static getMocEndkDate(pattern: string): string {
    if (pattern == null) {
      pattern = this.DEFAULT_DATE_PATTERN;
    }
    return this.datePipe.transform('2006-01-15', pattern);
  }

  public static getMonthAgo(number: number, pattern: string): string {
    if (pattern == null) {
      pattern = this.DEFAULT_DATE_PATTERN;
    }
    let currentDate = new Date();
    let newDate = currentDate.setMonth(currentDate.getMonth() - number);
    return this.datePipe.transform(newDate, pattern);
  }

  public static getYearAgo(number: number, pattern: string): string {
    if (pattern == null) {
      pattern = this.DEFAULT_DATE_PATTERN;
    }
    let currentDate = new Date();
    let newDate = currentDate.setFullYear(currentDate.getFullYear() - number);
    return this.datePipe.transform(newDate, pattern);
  }
}
