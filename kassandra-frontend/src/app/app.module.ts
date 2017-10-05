import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {ChartsModule} from "ng2-charts";
import {AppComponent} from "./app.component";
import {CurrencyComponent} from "./component/currency/currency.component";
import {CurrencyProviderService} from "./core/providers/currency/currency-provider.service";
import {DatePipe} from "@angular/common";
import {NewsProviderService} from "./core/providers/news/news-provider.service";
import {NewsBoardComponent} from "./component/news-board/news-board.component";
import {MainComponent} from "./component/main/main.component";
import {Ng2TableModule} from "ng2-table/ng2-table";
import {MyDatePickerModule} from "mydatepicker";
import {ExchangeRateServiceService} from "./core/services/exchange-rate-service.service";
import {NewsService} from "./core/services/news.service";

@NgModule({
  declarations: [
    AppComponent,
    CurrencyComponent,
    NewsBoardComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ChartsModule,
    Ng2TableModule,
    MyDatePickerModule
  ],
  providers: [CurrencyProviderService, NewsProviderService, DatePipe, ExchangeRateServiceService, NewsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
