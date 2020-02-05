<template>
<html>
<NavbarforEm/>
<center>
  <div>
    <md-table >
      <md-table-toolbar>
        <h1 class="md-title">Profile Table</h1>
      </md-table-toolbar>



      <md-table-row>
        <md-table-head md-numeric>ID</md-table-head>
        <md-table-head>Department</md-table-head>
        <md-table-head >Name</md-table-head>
        <md-table-head>Age</md-table-head>
        <md-table-head>Blood</md-table-head>
        <md-table-head>Gender</md-table-head>
        <md-table-head>Maritalstatus</md-table-head>
        <md-table-head>Phone number</md-table-head>
        <md-table-head>Address</md-table-head>
      </md-table-row>

      <md-table-row v-for="prof in pro"  :key="prof.profile_id" :value="prof.profile_id">

        <md-table-cell >{{prof.profile_id}}</md-table-cell>
        <md-table-cell >{{prof.department.department}}</md-table-cell>
        <md-table-cell>{{prof.name}}</md-table-cell>
        <md-table-cell>{{prof.age}}</md-table-cell>
        <md-table-cell>{{prof.blood.blood}}</md-table-cell>
        <md-table-cell>{{prof.gender.gender}}</md-table-cell>
        <md-table-cell>{{prof.maritalstatus.status}}</md-table-cell>
         <md-table-cell>{{prof.phone}}</md-table-cell>
         <md-table-cell>{{prof.address}}</md-table-cell>
      </md-table-row>


    </md-table>
                <v-card class="mx-auto" max-width="max-auto">
                    <v-data-table
                        hide-default-footer   :headers="headers"
                          :items="items"
                          :items-per-page="5"
                          class="elevation-1"
                  ></v-data-table>
                  </v-card>
  </div>
 </center>
</html>
</template>

<script>
import NavbarforEm from '../components/NavbarforEm'
import http from "../http-common";
export default {
   components: {
    NavbarforEm
  },

data() {
    return {
    departments : null ,
    bloods : null,
    genders : null,
    mats : null,
    pro : null,
    };
  },
    methods: {
        /* eslint-disable no-console */
    getProfile() {
      http
        .get("/profile")
        .then(response => {
          this.pro = response.data;
          console.log(response.data);
          this.items = response.data;


        })
        .catch(e => {
          console.log(e);
        });


  },
    getBlood() {
      http
        .get("/blood")
        .then(response => {
          this.bloods = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });


  },

          getMats() {
      http
        .get("/maritalstatus")
        .then(response => {
          this.mats = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
          },
  
  getDepartment() {
        http
          .get("/department")
          .then(response => {
            this.departments = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });

    },
    // ดึงข้อมูล Pilot ใส่ combobox
    getGender() {
            http
              .get("/gender")
              .then(response => {
                this.genders = response.data;
                console.log(response.data);
              })
              .catch(e => {
                console.log(e);
              });

        },

        

       
       
  },
    mounted() {
      this.getBlood();
      this.getDepartment();
      this.getGender();
      this.getMats();
      this.getProfile();
  }
}

</script>


<style>

</style>