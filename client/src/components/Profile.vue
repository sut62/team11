<template>
<html>
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
          <label >แผนก</label>
          <md-select v-model="departSelect">
                 <md-option v-for="department in departments" :key="department.department_id" :value="department.department_id">{{department.department}} </md-option>
          </md-select>
        </md-field>

        <md-field>
      <label>ชื่อ</label>
      <md-input v-model="name"></md-input>
    </md-field>

    <md-field>
      <label>อายุ</label>
      <md-input v-model="age"></md-input>
    </md-field>
  
  <md-field>
          <label>กรุ๊ปเลือด</label>
          <md-select v-model="bloodSelect">
                <md-option v-for="blood in bloods" :key="blood.blood_id" :value="blood.blood_id">{{blood.blood}} </md-option>
          </md-select>
  </md-field>

  <md-field>
          <label>เพศ</label>
          <md-select v-model="genSelect">
                <md-option v-for="gender in genders" :key="gender.gender_id" :value="gender.gender_id">{{gender.gender}} </md-option>
          </md-select>
  </md-field>

  <md-field>
          <label>สถานภาพ</label>
          <md-select v-model="matSelect">
                <md-option v-for="mat in mats" :key="mat.status_id" :value="mat.status_id">{{mat.status}} </md-option>
          </md-select>
  </md-field>
    
    <md-field>
      <label>เบอร์</label>
      <md-input v-model="tel"></md-input>
    </md-field>

    <md-field>
      <label>ที่อยู่</label>
      <md-input v-model="address"></md-input>
    </md-field>
    <br/>
    <md-button class="md-raised" @click="savedata()">Save</md-button>

        <br>
        




</center>
</body>
</html>
</template> 

<script>
import http from "../http-common";
export default {
data() {
    return {
    departments : null ,
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
    matSelect : null
    };
  },
  methods: {
        /* eslint-disable no-console */
    
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

        savedata(){

          http
                    .post(
                      "/profile/" +
                        this.departSelect +
                        "/" +
                        this.name +
                        "/" +
                        this.genSelect +
                        "/" +
                        this.age +
                        "/" +
                       this.bloodSelect+
                        "/" +
                       this.tel+
                       "/"+this.address+"/"+
                       this.matSelect

                    )
                    .then(response => {
                      console.log(response);
                    })
                    .catch(e => {
                      console.log(e);
                    });
                    //console.log(this.departSelect,this.name,this.age,this.bloodSelect,this.genSelect,this.tel,this.address,this.matSelect);
            alert("บันทึกข้อมูลสำเร็จ");
        }
       
       
  },
    mounted() {
      this.getBlood();
      this.getDepartment();
      this.getGender();
      this.getMats();
  }
}

</script>









<style>
.md-field{
  max-width: 400px;
}
</style>
