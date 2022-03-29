import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { LandingComponent } from './component/landing/landing.component';
import { ClickerComponent } from './component/clicker/clicker.component';
import { LoginComponent } from './component/login/login.component';
import { AuthGuard } from './guard/auth.guard';

const routes: Route[] = [
  { path: '', component: LandingComponent },
  { path: 'login', component: LoginComponent },
  { path: 'clicker', component: ClickerComponent, canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
