<template>
<html>
<body>

    <md-field>
          <label>ชื่อแพทย์</label>
          <md-select v-model="profileSelect">
                <md-option v-for="profile in profiles" :key="profile.profile_id" :value="profile.profile_id">{{profile.name}} </md-option>
          </md-select>
  </md-field>

  <md-field>
          <label>ชื่อผู้ป่วย</label>
          <md-select v-model="patSelect">
                <md-option v-for="pat in patiens" :key="pat.patient_id" :value="pat.patient_id">{{pat.name}} </md-option>
          </md-select>
  </md-field>


<md-datepicker v-model="dateSelect">
      <label>วันที่</label>
    </md-datepicker>

<md-field>
          <label>เวลานัดหมาย</label>
          <md-select v-model="timeappointmentSelect">
                <md-option v-for="time in times" :key="time.appointmenttime_id" :value="time.appointmenttime_id">{{time.timeap}} </md-option>
          </md-select>
  </md-field>

<md-field>
      <label>สาเหตุนัดหมาย</label>
      <md-input v-model ="remark"></md-input>
    </md-field><md-button class="md-raised" @click="savedata()">Save</md-button>

</body>
</html>
</template> 

<script>
import http from "../http-common";
export default {
data() {
    return {
        timeappointmentSelect : null,
        times : null,
        profileSelect : null,
        profiles : null ,
        patSelect : null,
        patiens : null,
        dateSelect : null,
        remark : null,

    /*departments : null ,
    bloods : null,
    genders : null,
    mats : null,
    
    departSelect : null,
    name : null,
    age : null,
    bloodSelect : null,
    genSelect : null,
    tel : null,
    address : null,
    matSelect : null*/
    };
  },
  methods: {
        /* eslint-disable no-console */
    
    getAppointmenttime() {
      http
        .get("/appointmenttime")
        .then(response => {
          this.times = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

    },
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
    getPatient() {
      http
        .get("/patient")
        .then(response => {
          this.patiens = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

    },
    savedata(){
           http
                    .post(
                      "/appointment/" +
                        this.profileSelect +
                        "/" +
                        this.patSelect +
                        "/" +
                        this.dateSelect +
                        "/" +
                        this.timeappointmentSelect +
                        "/" +
                       this.remark

                    )
                    .then(response => {
                      console.log(response);
                    })
                    .catch(e => {
                      console.log(e);
                    });
        console.log(this.profileSelect,this.patSelect,this.dateSelect,this.timeappointmentSelect,this.remark);
            alert("บันทึกข้อมูลสำเร็จ");
        
    }
  },

  

   
    mounted() {
      this.getAppointmenttime();
      this.getProfile();
      this.getPatient();
  }
}

</script>









<style>

</style>
