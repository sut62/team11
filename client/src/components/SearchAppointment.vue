<template>
<html>
 <NavbarforEm/>

<div class = "light-blue lighten-4">
        
      <v-layout justify-center>
        <v-card-title  style=" font: 18px Lucida Console, Monospace; width: 100%; text-align=center;" class= "text-center1 white--text">  ข้อมูลการนัดหมายแพทย์  </v-card-title>
      </v-layout>
    </div>
  <center>
<v-card class="mx-auto" max-width="max-auto">
    <v-data-table
        hide-default-footer   :headers="headers"
          :items="items"
          :items-per-page="5"
          class="elevation-1"
  ></v-data-table>
  </v-card>
  </center>
  </html>
  </template>

  <script>
import http from "../http-common";
import NavbarforEm from '../components/NavbarforEm'

export default {
  components: {
    NavbarforEm
  },

  name: "Appoint",
   
  data() {
    return {






      headers: [
        { text: "Doctor", value: "profile.name" },
        { text: "Patient", value: "patientManagement.name" },
        { text: "Date", value: "dateap" },
        { text: "Time", value: "appointmenttime.timeap" },
        { text: "Cause", value: "cause" },
      ],
      
      
      items:[],
      

    };
  },

  methods: {
    /* eslint-disable no-console */
    getApp (){
      http
      .get("/appointment")
      .then(response => {
                    this.items = response.data;
                    console.log(this.items);
                    
                })
                .catch(e => {
                    console.log(e);
                    
                });

    }
        
       
  },

    mounted() {
      this.getApp ();
  },

 clear() {
            this.$refs.form.reset();
        }
        /* eslint-disable no-console */

  
}
</script>




