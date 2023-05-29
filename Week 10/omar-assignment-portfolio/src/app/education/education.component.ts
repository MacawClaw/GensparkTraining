import { Component } from '@angular/core';
import { PortfoliodataService } from '../portfoliodata.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent {
  degrees;
  certifications;

  constructor(eduArrayService: PortfoliodataService) {
    this.degrees = eduArrayService.getDegrees();
    this.certifications = eduArrayService.getCertifications();
  }

}
