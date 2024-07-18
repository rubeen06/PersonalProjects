import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import HeaderComponent from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import DoctoresListComponent from './components/doctores/doctores-list/doctores-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'gestionHospitalFrontEnd';
}
