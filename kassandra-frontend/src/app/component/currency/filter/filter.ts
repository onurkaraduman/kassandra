import {Zoom, ZoomModule} from "../enum/zoom.enum";
import {FilterType} from "./filter-type.enum";
import {DateUtil} from "../../../util/date-util";
export class Filter {
  public from: string = DateUtil.getYearAgo(1, null);
  public to: string = DateUtil.getToday(null);
  public zoom: Zoom = Zoom.Y1;

  public type: FilterType = FilterType.ZOOM;

  public getZooms(): string[] {
    return ZoomModule.getZooms();
  }

}
