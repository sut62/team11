import Vue from 'vue'
   import Router from 'vue-router';
   import Profile from '../components/Profile';
   import Appointment from '../components/Appointment';
   import PatientManagement from '../components/PatientManagement';
   import Recipe from '../components/Recipe';
   import Schedule from '../components/Schedule';
   import ProfileTable from '../components/ProfileTable';
   import BookRoom from '../components/BookRoom';
   import Logindoctor from '../components/Logindoctor'
   import Home from '../components/Home' 
   import Loginemployee from '../components/Loginemployee'
   import SearchPatient from '../components/SearchPatient';
   //import Index from '../components/Index';
   Vue.use(Router);

   export default new Router({
       mode: 'history',
       base: process.env.BASE_URL,
       routes: [
       {path: '/',component: Home},
       {path: '/Loginemployee',component: Loginemployee}, 
       {path: '/Logindoctor',component: Logindoctor},    
       {path: '/BookRoom',component: BookRoom},
       {path: '/profile',component: Profile},
       {path: '/profiletable',component: ProfileTable},
       {path: '/appointment',component: Appointment},
       {path: '/patientmanagement',component: PatientManagement},
       {path: '/searchPatient',component: SearchPatient},
       {path: '/recipe',component: Recipe},
       {path: '/schedule',component: Schedule},
       //{path: '/',component: Index}
       ]
   });