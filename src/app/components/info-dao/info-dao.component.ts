import { Component, OnInit } from '@angular/core';
import {RootObject} from './info';
import {InfoDaoService} from '../services/info-dao.service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-info-dao',
  templateUrl: './info-dao.component.html',
  styleUrls: ['./info-dao.component.css']
})
export class InfoDaoComponent implements OnInit {
  public infos: RootObject[];
  public editInfo: RootObject;

  constructor(private infoDaoService: InfoDaoService) { }

  ngOnInit(): void {
    this.getInfo();
  }

  public getInfo(): void{
    this.infoDaoService.getInfos().subscribe(
      (response: RootObject[]) => {
        this.infos = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public addInfo(rootObject: RootObject): void {
    this.infoDaoService.addInfo(rootObject).subscribe(
      (response: RootObject) => {
        console.log(response);
        this.getInfo();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onUpdateInfoById(id: number, info: RootObject): void {
    this.infoDaoService.editInfoById(id, info).subscribe(
      (response: RootObject) => {
        console.log(response);
        this.getInfo();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(rootObject: RootObject, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'edit') {
      this.editInfo = rootObject;
      button.setAttribute('data-target', '#updateInfoModal');
    }
    container.appendChild(button);
    button.click();
  }
}
