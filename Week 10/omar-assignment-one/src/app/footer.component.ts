import { Component } from "@angular/core";

@Component (
    {
        selector: 'footer-comp',
        template: `
        <h1> This is a footer! </h1>
        <p> © 2023 {{name}}</p>
        `
    }
)

export class footerComponent {
    name= "Omar Garcia";
}