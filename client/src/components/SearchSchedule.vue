<template>
<html>
  <Navbar />
<body class="body1">
  <center>
    
    <br />
    <br />
    
    <v-card class="mx-auto" max-width="550">
      <div class = "cyan darken-4 text-center1">
        
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
            <v-btn depressed color="primary" @click="getSchedule"  >Search</v-btn>
            
          </div>
        </v-col>
        <v-spacer></v-spacer>
        
      </v-form>
       <v-spacer></v-spacer>

       
      
    </v-card>
    <br/>
    <v-card class="mx-auto" max-width="550">
    <v-data-table
          hide-default-footer :headers="headers"
          :items="items"
          :items-per-page="5"
          class="elevation-1"
  ></v-data-table>
  </v-card>
  </center>
</body>
</html>
</template>


<script>
import http from "../http-common";
import Navbar from "../components/Navbar";
export default {

  name: "searchSchedule",
   components: {
    Navbar
  },
  data() {
    return {
       
        
        Namecheck:"",
        
      
      
      headers: [
        { text: "Name", value: "profile_id.name" },
        { text: "Ward", value: "department_id.department" },
        { text: "Date", value: "scheduleDate" },
        { text: "Time", value: "worktime.work" },
      ],
      
      
      items:[],
      

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
                    this.$alert("ค้นหาข้อมูลสำเร็จ", "Success", "success")
                     if (this.items == "") {
                    this.$alert("ไม่พบข้อมูล", "Warning", "warning")
              
            } 
                    
                })
                .catch(e => {
                    console.log(e);
                    this.$alert("ทำรายการไม่สำเร็จ กรุณาทำรายการใหม่", "Warning", "warning")
                });
        },
        
        
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
  background-color: #d4fafa;
}
</style>

