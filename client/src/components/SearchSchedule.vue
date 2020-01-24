<template>
<body class="body1">
  <center>
    
    <br />
    <br />
    
    <v-card class="mx-auto" max-width="550">
      <div class = "teal lighten-1 text-center1">
        
      <v-layout justify-center>
        <v-card-title  style=" font: 36px Lucida Console, Monospace; width: 100%; text-align=center;" class= "text-center1 white--text">  SEARCH SCHEDULE  </v-card-title>
      </v-layout>
    </div>
      <v-form>
        
        <br />
        <v-col>
          <v-text-field label="Name" outlined dense  solo v-model="Namecheck" :rules="[(v) => !!v || 'กรุณากรอกชื่อ']" required></v-text-field>
          <v-spacer></v-spacer>
          <div class="my-2">
            <v-btn depressed color="primary" @click="getSchedule" v-on="on" >Search</v-btn>
            
          </div>
        </v-col>
        <v-spacer></v-spacer>
        
      </v-form>
       <v-spacer></v-spacer>

       
      
    </v-card>
    <br/>
    <v-card class="mx-auto" max-width="550">
    <v-data-table
          :headers="headers"
          :items="items"
          :items-per-page="5"
          class="elevation-1"
  ></v-data-table>
  </v-card>
  </center>
</body>
</template>


<script>
import http from "../http-common";
export default {
  name: "searchSchedule",
  data() {
    return {
       
        alwayselect: false,
        Namecheck:"",
        checkSave: false
      
      ,
      headers: [
        { text: "Name", value: "profile_id.name" },
        { text: "Ward", value: "department_id.department" },
        { text: "Date", value: "scheduleDate" },
        { text: "Time", value: "worktime.work" },
      ],
      
      dialog:false,
      items:[],
      profileCheck: false,
      profileId: ""

    };
  },

  methods: {
    /* eslint-disable no-console */
    getSchedule(){
      
      http
       .get("/scheduledoctor/"+this.Namecheck)
                .then(response => {
                    this.items = response.data;
                    console.log(this.items);
                    this.alwayselect = true;
                    this.checkSave = true;
                })
                .catch(e => {
                    console.log(e);
                    this.alwayselect = true;
                    this.checkSave = false;
                });
        },
        /*findDoctor(){
          http
                .get("/profile/"+this.Namecheck )
                .then(response => {
                    //this.items = response.data;
                    this.profileId = response.data[0].id;
                    //this.profileCheck = response.status;
                    this.getSchedule();
                    //console.log(this.items);
                })
                .catch(e => {
                    console.log(e);
                    this.clear();
                });*/

        
  },

 clear() {
            this.$refs.form.reset();
        }
        /* eslint-disable no-console */

  
}
</script>



<style>
.card {
  width: 50%;
  height: 50%;

  background-color: white;
}

.body1 {
  background-color: #63ba9d;
}
</style>

