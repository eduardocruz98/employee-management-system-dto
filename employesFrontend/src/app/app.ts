import { Component, signal } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  //Para trabajar con router-outet debemos importar el modulo RouterModule
  imports: [RouterOutlet, RouterModule],
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('employesFrontend');
}
