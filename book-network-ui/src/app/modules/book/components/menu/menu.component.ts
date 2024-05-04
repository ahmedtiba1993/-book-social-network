import {Component, inject, OnInit} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  router = inject(Router);

  ngOnInit(): void {
    const linkColor = document.querySelectorAll('.nav-link');
    linkColor.forEach(link => {
      if(window.location.href.endsWith(link.getAttribute('href') || '')){
        link.classList.add('active');
      }
      link.addEventListener('click', (event) => {
        linkColor.forEach(l => l.classList.remove('active'));
        link.classList.add('active');
      })
    })
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['login']);
  }

}
