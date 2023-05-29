import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Skill } from './Skill';
import { SKILLS } from './mock-skills';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class PortfoliodataService {
  private apiUrl = 'http://localhost:5000/skills'
  //skillService: Skill[] = SKILLS;

  constructor(private http:HttpClient) { }

  getExperiences() {
    return [
      {
        name: 'Java Full Stack Developer at GenSpark',
        date: 'Sept 2020 – Mar 2022',
        descriptors: ['Completed all Java assignments and projects using - Loops, Arrays, Collections, Classes, OOP, Exceptions, IO Files, Functional Programming, and TDD.',
        'Leveraged sound coding practices by implementing small manageable testable methods, good descriptive commenting, and using version control.',
        'Implemented Test Driven Development while learning Unit Testing with JUnit and Java.',
        'Practiced the Agile Methodology throughout the Training Program.',
        'Built several individual projects such as Humans vs Goblins using Java and applying Java concepts.',
        'Created backend applications with Java, Spring Boot, Hibernate, MySQL and Postman.',
        'Studied the fundamentals of Web Development using HTML, CSS, TypeScript and Angular.',
        'Built several full stack projects using Java, Spring Boot, Hibernate, MySQL, and Angular.',
        'Completed an AWS Module to learn the fundamentals of Containers, EC2, S3, Lambda, Cloud Watch, Storage and Security.',
        'Underwent intense testing during and after the training using an AI proctored assessment tool.']
      },
  
      {
        name: 'Cloud Data Engineer Intern at Prime Therapeutics',
        date: 'Jul 2022 – Dec 2022',
        descriptors: ['Provided support to Enterprise users who are responsible for processing and paying out prescription drug claims.',
        'Deployed, tested, and debugged sets of tasks for compiling data in various test environments in Google Cloud Platform before rolling out tools to the greater company.',
        'Met and collaborated with project managers/owners (enterprise users) on implementing wider system changes.']
      },
  
      {
        name: 'Software Developer Trainee at Dev10 (by Genesis10)',
        date: 'Mar 2022 – Jul 2022',
        descriptors: ['Chosen for highly selective, paid Dev10 training program - less than 5% of applicants are hired.',
        'Training in Java/JavaScript Development and associated tools.']
      },
  
      {
        name: 'Customer Service Representative at Micro Center',
        date: 'Sept 2020 – Mar 2022',
        descriptors: ['Provided speedy service to customers in the checkout area.',
        'Answered customer questions and directed them to the best solution.',
        'Retrieved and checked out internet orders for customers.']
      },
  
      {
        name: 'Student Computing Consultant at Office of Information Technology',
        date: 'May 2019 – May 2020',
        descriptors: ['Assisted students, faculty, and staff with printing, network connectivity, and account management.',
        'Backed up and Restored data from hard drives on damaged computers.',
        'Cataloged work orders to ensure timely service and delivery.',
        'Inspected AV equipment and virtual machines across campus for proper functioning.']
      },
  
      {
        name: 'Analysis of Exoplanet Detection at Rice University',
        date: 'Aug 2019 – Apr 2020',
        descriptors: ['Analyzed data discerning planetary objects around young stars.',
        'Developed algorithms for inspecting stellar properties in Python.',
        'Used characteristics of star systems to inform models of planet formation.']
      },
  
      {
        name: 'Circulation Assistant at Fondren Library',
        date: 'Aug 2017 – May 2019',
        descriptors: ['Handle checking in/out of books, DVDs, microfilm, and supplemental materials.',
        'Located obscure print & digital materials in an efficient manner for library patrons.',
        'Collaborated with staff to reorganize library material and develop student events.']
      },
  
      {
        name: 'Data Analyst & Research Assistant at Rice University',
        date: 'Jun 2017 – Aug 2018',
        descriptors: ['Extracted and analyzed data from high-energy gamma ray experiments.',
        'Evaluated the effectiveness of a new apparatus designed for such high energy experiments.',
        'Prepared experiments and maintained communication between professor and laboratory regarding equipment failure.']
      }
  
    ];
  }

  getSkills(): Observable<Skill[]> {
    return this.http.get<Skill[]>(this.apiUrl);
    //return this.skillService;
  }

  getDegrees() {
    return [
      {
        degree: 'B.S. in Astrophysics',
        setting: 'Rice University, May 2020'
      }
    ];
  }

  getCertifications() {
    return [
      {
        certification: 'GenSpark Java Full Stack Certification – In Progress',
        setting: 'July 2023 (Expected Completion)'
      }
    ];
  }

  deleteSkill(skill: Skill): Observable<Skill> {
    const url = `${this.apiUrl}/${skill.id}`;
    return this.http.delete<Skill>(url);
  }

  addSkill(skill: Skill): Observable<Skill> {
    return this.http.post<Skill>(this.apiUrl, skill, httpOptions);
  }
}
