import { Component, Output, EventEmitter } from '@angular/core';
import { UiService } from 'src/app/ui.service';
import { Subscription } from 'rxjs';
import { Skill } from 'src/app/Skill';

@Component({
  selector: 'app-add-skill',
  templateUrl: './add-skill.component.html',
  styleUrls: ['./add-skill.component.css']
})
export class AddSkillComponent {
  @Output() onAddSkill: EventEmitter<Skill> = new EventEmitter();
  skill!: string;
  showAddTask!: boolean;
  subscription!: Subscription;
  
  constructor(private uiService: UiService) {
    this.subscription = this.uiService.onToggle().subscribe((value) => (this.showAddTask = value));
  }

  onSubmit() {
    if (!this.skill) {
      alert('Please add a Skill@')
      return;
    }

    const newSkill = {
      skill: this.skill
    }

    this.onAddSkill.emit(newSkill);

    this.skill = '';
  }

}
