import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Skill } from '../../Skill';
import { faXmark } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-skill-item',
  templateUrl: './skill-item.component.html',
  styleUrls: ['./skill-item.component.css']
})
export class SkillItemComponent {
  @Input()
  skill!: Skill;
  @Output() onDeleteSkill: EventEmitter<Skill> = new EventEmitter();

  faXmark = faXmark;

  onDelete(skill: Skill) {
    //console.log("OnDelete in Skill item");
    this.onDeleteSkill.emit(skill);
  }
}
