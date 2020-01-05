import Vue from 'vue'
   import Router from 'vue-router';
   import Profile from '../components/Profile';
   import Appointment from '../components/Appointment';
   import PatientManagement from '../components/PatientManagement';
   import Recipe from '../components/Recipe';
   import Schedule from '../components/Schedule';
   //import Index from '../components/Index';
   Vue.use(Router);

   export default new Router({
       mode: 'history',
       base: process.env.BASE_URL,
       routes: [
       {path: '/profile',component: Profile},
       {path: '/appointment',component: Appointment},
       {path: '/patientmanagement',component: PatientManagement},
       {path: '/recipe',component: Recipe},
       {path: '/schedule',component: Schedule},
       //{path: '/',component: Index}
       ]
   });