<template>
<html>
 <Navbar/>
<body background="doc1.jpg">
  <center>
    <div>
    <br>
      
      <div class="md-layout-item">
        <label>แพทย์</label>
      <md-field>
          <label>แพทย์ผู้ตรวจ</label>
          <md-select id="doctor" class="Doctor" v-model="profileSelect">
                <md-option v-for="profile in profiles" :key="profile.profile_id" :value="profile.profile_id">{{profile.name}} </md-option>
          </md-select>
  </md-field>
      </div>

      <div class="md-layout-item">
      <md-field>
          <label >แผนก</label>
          <md-select id="department" class="Department" v-model="departSelect">
                 <md-option v-for="department in departments" :key="department.department_id" :value="department.department_id">{{department.department}} </md-option>
          </md-select>
        </md-field>
      </div>

      <div class="md-layout-item">
      <label>ข้อมูลของคนไข้</label>
      <md-field>
        <label>คำนำหน้าชื่อ</label>
        <md-input id="title" class="Title" v-model="title"></md-input>
      </md-field>
      </div>

      <md-field>
          <label>ชื่อ-นามสกุล</label>
        <md-input  id="name" class="Name" v-model="name"></md-input>
      </md-field>

      <div class="md-layout-item">
      <md-field>
          <label>เพศ</label>
          <md-select id="gen" class="Gen" v-model="genSelect">
                <md-option v-for="gender in genders" :key="gender.gender" :value="gender.gender">{{gender.gender}} </md-option>
          </md-select>
  </md-field>
      </div>

      <md-field>
        <label>อายุ</label>
        <md-input id="age" class="Age" v-model="age" type="number"></md-input>
      </md-field>

      <md-field>
        <label>ผลตรวจ</label>
        <md-input id="patient" class="Patient" v-model="pati"></md-input>
      </md-field>

      <md-datepicker id="date" class="Date" v-model="dateSelect">
      <label>วันที่</label>
    </md-datepicker>
         <center>
          <md-button class="md-raised md-primary" @click = "savedata()">เพิ่ม</md-button> 
         
        </center>



    </div>

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
      profiles: null,
      profileSelect : null,
      departments : null ,
      departSelect : null,
      genders : null,
      genSelect : null,
      title: null,
      name : null,
      age: null,
      pati : null,
      dateSelect : null,
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

    savedata(){

          http
                    .post(
                      "/patientmanagement/" +
                        this.profileSelect +
                        "/" +
                        this.departSelect +
                        "/" +
                        this.title +
                        "/" +
                        this.name +
                        "/" +
                       this.genSelect+
                        "/" +
                       this.age+
                       "/"+this.pati+"/"+
                       this.dateSelect

                    )
                    .then(response => {
                      console.log(response);
                      this.$alert(
                      "บันทึกข้อมูลสำเร็จ",
                      "Success",
                      "success"
                      ).then(() => console.log("Closed"));


                    })
                    .catch(e => {
                      console.log(e);
                        this.$alert(
                           "บันทึกข้อมูลไม่สำเร็จ",
                           "Warning",
                           "warning"
                        ).then(() => console.log("Closed"));

                    });
        console.log(this.profileSelect,this.departSelect,this.title,this.name,this.genSelect,this.age,this.pati,this.dateSelect);

        }

      

  },
    mounted() {
      this.getProfile();
      this.getDepartment ();
      this.getGender();
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

.md-field{
  max-width: 400px;
}

.body {
  background-color: #E6E6FA;
}

</style>
