export enum Zoom {
  M1, M3, M6, Y1, Y2, Y3, Y10
}

export module ZoomModule {
  export function getZooms(): string[] {
    let zooms:Array<string> = [];
    for (let item in Zoom) {
      if (isNaN(Number(item))) {
        zooms.push(item);
      }
    }
    return zooms;
  }

  // export function findZoom(opt:string):Zoom{
  //   switch (opt){
  //     case Zoom.M1.toString();
  //   }
  // }
}
