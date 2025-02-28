import { Injectable } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Injectable({
  providedIn: 'root'
})
export class TranslateConfigService {

  currentLang: any;

  constructor(private translate: TranslateService) {
    this.currentLang = localStorage.getItem('lang');
   }
  
   /**
   * getDefaultLanguage:  devuelve el lenguaje por defecto
   * @returns el idioma por defecto del navegador o de un dispositivo móvil
   */
  getDefaultLanguage(){
    if (this.currentLang) {
      this.translate.setDefaultLang(this.currentLang);
    } else {
      localStorage.setItem('lang', this.translate.getBrowserLang()!);
      this.currentLang = this.translate.getBrowserLang();
      this.translate.setDefaultLang(this.currentLang);
    }
    return this.currentLang;
  }

  /**
   * setLanguage: establece un cambio de idioma por parámetro 
   * @param setLang El prefijo del lenguaje a cambiar: "es","en"
   */
  setLanguage(setLang: string) {
    this.translate.use(setLang);
    localStorage.setItem('lang', setLang);
  }

  /**
   * getCurrentLang: Devuelve el idioma actual almacenado en la caché local
   * @returns Devuelve el idioma actual
   */
  getCurrentLang() {
    return localStorage.getItem('lang');
  }


}
