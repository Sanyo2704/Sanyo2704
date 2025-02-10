import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaintComponent } from './paint/paint.component';


@NgModule({
  declarations: [PaintComponent],
  imports: [
    CommonModule
  ],
  exports: [
    PaintComponent
  ]
})
export class ComponentesModule { }
