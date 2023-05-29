import { Component } from '@angular/core';
import { PortfoliodataService } from '../portfoliodata.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent {
  experiences;

  constructor(skillArrayService: PortfoliodataService) {
    this.experiences = skillArrayService.getExperiences();
  }

}
