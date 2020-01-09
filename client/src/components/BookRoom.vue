<template>
<html>
  <Navbar/>
<br>
<br>

<br>
<br>

  <center>
    
    <md-card class="md-accent" md-with-hover>
        <md-card-header>
          <div class="md-title">จองห้องสำหรับแพทย์</div>
        </md-card-header>
        <md-card-content>
          
    <div>
      <div class="md-layout-item">
      <md-field>
          <label>แพทย์ผู้ทำการจองห้อง</label>
          <md-select v-model="profileSelect">
                <md-option v-for="profile in profiles" :key="profile.profile_id" :value="profile.profile_id">{{profile.name}} </md-option>
          </md-select>
  </md-field>
      </div>

      <div class="md-layout-item">
     <md-field>
          <label >ชื่อคนไข้</label>
          <md-select v-model="patSelect">
                 <md-option v-for="pat in pats" :key="pat.patientManage_id" :value="pat.patientManage_id">{{pat.patient.name}} </md-option>
          </md-select>
    </md-field>
      </div>

       <div class="md-layout-item">
      <md-field>
          <label>ห้อง</label>
          <md-select v-model="roomSelect">
                 <md-option v-for="room in rooms" :key="room.room_id" :value="room.room_id">{{room.room}} </md-option>
          </md-select>
  </md-field>
      </div>


      <div class="md-layout-item">
        <md-field>
        <md-icon>event</md-icon>
        <label>วันที่ทำการจอง(วัน-เดือน-ปี dd-MM-YYYY)</label>
        <md-input v-model="dateS"></md-input>
      </md-field>
      <md-field>
        <md-icon>alarm</md-icon>
        <label>เวลาเริ่ม (ชั่วโมง:นาที HH:mm)</label>
        <md-input v-model="timestart"></md-input>
      </md-field>
      </div>

      <md-field>
          <md-icon>alarm</md-icon>
          <label>เวลาสื้นสุด (ชั่วโมง:นาที HH:mm)</label>
        <md-input  v-model="timeend"></md-input>
      </md-field>

         <md-field>
      <label>บันทึกอาการและการรักษา (ห้ามมีเครื่องหมาย /)</label>
      <md-textarea v-model="description"></md-textarea>
      <md-icon>description</md-icon>
    </md-field>

         <center>
          <md-button class="md-raised md-primary" @click = "savedata()">เพิ่ม</md-button> 
        </center>
    </div>
      </md-card-content>
    </md-card>
</center>

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
      profiles: null,
      profileSelect : null,
      patSelect: null,
      pats : null,
      rooms : null,
      roomSelect : null,
      dateS : null,
      timestart : null,
      timeend : null,
     description : null,
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
    getPatient() {
      http
        .get("/patientmanage")
        .then(response => {   
          this.pats = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
          },
     
    getRoom(){
        http
            .get("/Room")
            .then(response =>{
                this.rooms = response.data;
                console.log(response.data);
            })
            .catch(e => {
            console.log(e);
            });
            },

    savedata(){

          http
            .post(
                "/Bookroom/" +
                this.description +
                "/" + 
                this.dateS+
                "/" + 
                this.timestart +
                "/" +
                this.timeend +
                "/" +
                this.roomSelect +
                "/" +
                this.profileSelect+
                "/" +
                this.patSelect
                    )
                    .then(response => {
                      console.log(response);
                      alert("บันทึกข้อมูลสำเร็จ");
                    })
                    .catch(e => {
                      console.log(e);
                      alert("ลงทะเบียนไม่สำเร็จ กรุณาตรวจสอบข้อมูลอีกครั้ง");
                    });
        console.log(this.profileSelect,this.patSelect,this.roomSelect,this.dateS,this.timestart,this.timeend,this.description);
        }
  },
    mounted() {
      this.getProfile();
      this.getPatient();
      this.getRoom();
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

.md-field{
  max-width: 400px;
}
.md-card {
    width: 580px;
    margin: 10px;
    display: inline-block;
    vertical-align: top;
  }

</style>
