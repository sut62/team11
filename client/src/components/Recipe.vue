<template>
<html>
  <Navbar/>
<body background="w.jpg">
<br>
<br>
<br>
<center>
<br>
<br>
<br>
<br>
<br>
    <md-field>
      <label>เลขที่จ่ายยา</label>
      <md-input v-model="nummed"></md-input>
    </md-field>

    <md-field>
          <label >ชื่อยา</label>
          <md-select v-model="medicineSelect">
                 <md-option v-for="medicine in medicines" :key="medicine.medicine_id" :value="medicine.medicine_id">{{medicine.medicine_name}} </md-option>
          </md-select>
    </md-field>

    <md-field>
          <label >ชนิดยา</label>
          <md-select v-model="typeSelect">
              <md-option v-for="type in types" :key="type.typemedicine_id" :value="type.typemedicine_id">{{type.typemedicine_name}} </md-option>
          </md-select>
    </md-field>

    <md-field>
      <label>จำนวน</label>
      <md-input v-model="amount"></md-input>
    </md-field>

    <md-datepicker v-model="selectedDate">
      <label>วันที่สั่งจ่ายยา</label>
    </md-datepicker>

    <md-field>
          <label >ชื่อแพทย์สั่งจ่ายยา</label>
          <md-select v-model="profileSelect">
                 <md-option v-for="profile in profiles" :key="profile.profile_id" :value="profile.profile_id">{{profile.name}} </md-option>
          </md-select>
    </md-field>

    <md-field>
          <label >ชื่อคนไข้</label>
          <md-select v-model="patSelect">
                 <md-option v-for="pat in pats" :key="pat.patientManage_id" :value="pat.patientManage_id">{{pat.patient.name}} </md-option>
          </md-select>
    </md-field>
  
    <br/>
    <md-button class="md-raised" @click="savedata()">บันทึกข้อมูล</md-button>
    <br>
        


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
    medicines : null,
    medicineSelect : null,
    types: null,
    typeSelect: null,
    nummed : null,
    amount: null,
    selectedDate: null,
    profiles: null,
    profileSelect: null,
  patSelect: null,
  pats : null,

    };
  },
  methods: {
        /* eslint-disable no-console */
    


          getMedicine() {
      http
        .get("/medicine")
        .then(response => {
          this.medicines = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
          },
            getType() {
      http
        .get("/typemedicine")
        .then(response => {
          this.types = response.data;
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
        .get("/patientmanage")
        .then(response => {   
          this.pats = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
          },

       savedata(){
           http
                    .post(
                      "/recipe/" +
                        this.nummed +
                        "/" +
                        this.medicineSelect +
                        "/" +
                        this.typeSelect +
                        "/" +
                        this.amount +
                        "/" +
                       this.selectedDate+
                        "/" +
                       this.profileSelect+
                       "/"+this.patSelect

                    )
                    .then(response => {
                      console.log(response);
                    })
                    .catch(e => {
                      console.log(e);
                    });
        
            alert("บันทึกข้อมูลสำเร็จ");
         // console.log(this.nummed , this.medicineSelect , this.typeSelect , this.amount , this.selectedDate,
         // this.profileSelect , this.patSelect);
       },
       
  },
    mounted() {
      this.getMedicine();
      this.getType();
      this.getProfile();
      this.getPatient();
  }
}

</script>









<style>
.md-field{
  max-width: 400px;
}
</style>
