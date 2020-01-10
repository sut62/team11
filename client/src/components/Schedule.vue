<template>
<html>
  <Navbar/>
 <body class = "body" > 
    
<br>
<br>
<br>

<center>
  <body class = "card">
    <center>
      <br>
<br>
<h1>ตารางเวร</h1>
<br>
<br>



  <md-field>
          <label>ชื่อแพทย์</label>
          <md-select v-model="profileSelect">
                <md-option v-for="profile in profiles" :key="profile.profile_id" :value="profile.profile_id">{{profile.name}} </md-option>
          </md-select>
  </md-field>

  <md-field>
          <label>แผนก</label>
          <md-select v-model="departSelect">
                 <md-option v-for="department in departments" :key="department.department_id" :value="department.department_id">{{department.department}} </md-option>
          </md-select>
        </md-field>

        
          <div >
        <md-field>
       
        <label>วันที่(YYYY-MM-DD)</label>
        <md-input v-model="selectedDate"></md-input>
      </md-field>
      
      </div>

        
    <md-field>
        <label>เวลา</label>
        <md-select v-model="timeSelect">
          <md-option v-for="worktime in worktimes" :key="worktime.worktimeId" :value="worktime.worktimeId">{{worktime.work}} </md-option>
        </md-select> 
    </md-field>

   

    <md-button class="md-raised md-primary" @click="savedata()">บันทึกข้อมูล</md-button>   
    
    <br>
<br>  
</center>
</body>
  </center>
 </body>
</html>
</template>

<script>
import Navbar from '../components/Navbar'
import http from "../http-common";

export default {
   components: {
    Navbar
  },
data() {
    return {
      profiles:null,
      departments: null,
      worktimes: null,
      profileSelect: null,
      departSelect: null,
      selectedDate: null,
      timeSelect: null,
    };
  },
  methods: {
        /* eslint-disable no-console */
    getProfile() {
            http
              .get("/profile")
              .then(response => {
                this.profiles = response.data;
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
    getWorktime() {
            http
              .get("/worktime")
              .then(response => {
                this.worktimes = response.data;
                console.log(response.data);
              })
              .catch(e => {
                console.log(e);
              });

    },

    savedata(){
      if(this.profileSelect==null||this.departSelect==null||this.selectedDate==null||this.timeSelect==null ){
        alert("บันทึกข้อมูลไม่สำเร็จ กรุณากรอกข้อมูลให้ครบ");
      }
  else{
         http
                    .post(
                      "/schedule/" +
                        this.profileSelect +
                        "/" +
                        this.departSelect +
                        "/" +
                        this.selectedDate +
                        "/" +
                        this.timeSelect

                    )
                    .then(response => {
                      console.log(response);
                    })
                    .catch(e => {
                      console.log(e);
                    });
        
            alert("บันทึกข้อมูลสำเร็จ"); 
            location.reload();}

    },
       
  },


    mounted() {
      this.getProfile();
      this.getDepartment();
      this.getWorktime();
  }
}

</script>

<style>
.card {
    width: 50%;
    height: 50%;
    
     background-color: white;
  }

  .body {
  background-color: #293214;
}
</style>