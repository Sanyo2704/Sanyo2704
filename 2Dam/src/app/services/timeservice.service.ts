import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TimeserviceService {

  private url_service: string = "https://api.openweathermap.org/data/2.5/forecast?units=metric"
  private api_key: string = "774396eca2c42b768d4825df06754bc1"
  url:string = "";

  constructor(private http: HttpClient) { }

  get_weather(latitud:string, longitud:string) {
    this.url = this.url_service + "&lat=" + latitud + "&lon=" + longitud + "&appid=" + this.api_key;
    return this.http.get(this.url);
  }
}
