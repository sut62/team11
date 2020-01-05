<template>
<html>


  <md-field>
          <label for="Name">ชื่อแพทย์</label>
          <md-select v-model="vmed">
                <md-option v-for="med in profile" :key="med.profile_id" :value="med.profile_id">{{med.name}} </md-option>
          </md-select>
  </md-field>

  <md-field>
          <label for="Depart">แผนก</label>
          <md-select v-model="vdepart">
                 <md-option v-for="dep in department" :key="dep.id" :value="dep.id">{{dep.department}} </md-option>
          </md-select>
        </md-field>

        <div>
            <md-datepicker v-model="selectedDate">
              <label>เลือกวันที่</label>
            </md-datepicker>
          </div>

        
    <md-field>
        <label for="Time">เวลา</label>
        <md-select v-model="vtime">
          <md-option v-for="t in worktime" :key="t.worktimeId" :value="t.worktimeId">{{t.work}} </md-option>
        </md-select> 
    </md-field>

    <md-button class="md-raised md-primary" @click = "save">ยืนยัน</md-button>
    <md-button class="md-raised md-accent" @click = "clear" >ยกเลิก</md-button>

        



</html>
</template>

<script>
import http from "../http-common";

export default {
data() {
    return {
    vmed: null,
    vdepart : null,
    selectedDate : null ,
    vtime : null ,
    
    };
  },
  methods: {
        /* eslint-disable no-console */
    getProfile() {
            http
              .get("/profile")
              .then(response => {
                this.profile = response.data;
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
                this.department = response.data;
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
                this.worktime = response.data;
                console.log(response.data);
              })
              .catch(e => {
                console.log(e);
              });

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
.md-card {
    width: 600px;
    height: 500px;
    margin: 40px;
    display: inline-block;
    vertical-align: top;
     background-color: white;
  }
  .md-field {
    max-width: 500px;
  }
  body {
  background-color: #c4e4f4;
}
</style>