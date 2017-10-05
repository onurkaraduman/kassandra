
import {Currency} from "./currency";
export interface ExchangeRate {
  id: number;
  value: number;
  date: string;
  referenceCurrency: Currency;
  currency: Currency;
}
