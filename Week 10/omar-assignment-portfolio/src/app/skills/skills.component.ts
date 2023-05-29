import { Component } from '@angular/core';
import { PortfoliodataService } from '../portfoliodata.service';
import { Skill } from '../Skill';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent {
  skills!: Skill[];

  constructor(private skillArrayService: PortfoliodataService) {
    this.skillArrayService.getSkills().subscribe((skills) => this.skills = skills);
  }

  deleteSkill(skill: Skill){
    this.skillArrayService.deleteSkill(skill).subscribe(() => (this.skills = this.skills.filter((s) => s.id !== skill.id)));
  }

  addSkill(skill: Skill) {
    this.skillArrayService.addSkill(skill).subscribe((skill) => this.skills.push(skill));
  }
}
