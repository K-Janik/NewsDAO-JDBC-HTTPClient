import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {RootObject} from '../info-dao/info';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InfoDaoService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getInfos(): Observable<RootObject[]>{
    return this.http.get<RootObject[]>(`${this.apiServerUrl}/info`);
  }

  public addInfo(rootObject: RootObject): Observable<RootObject>{
    return this.http.post<RootObject>(`${this.apiServerUrl}/info`, rootObject);
  }

  public editInfoById(infoId: number, rootObject: RootObject): Observable<RootObject> {
    return this.http.put<RootObject>(`${this.apiServerUrl}/info/${infoId}`, rootObject);
  }
}
