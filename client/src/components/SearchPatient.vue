<template>
<html>
  <Navbar />
<body background="doc1.jpg">
  <center>
    
    <br />
    <br />
    
    <v-card class="mx-auto" max-width="550">
      <div class = "cyan darken-4 text-center1">
        
      <v-layout justify-center>
        <v-card-title  style=" font: 36px Lucida Console, Monospace; width: 100%; text-align=center;" class= "text-center1 white--text">  ค้นหาข้อมูลผู้ป่วย  </v-card-title>
      </v-layout>
    </div>
      <v-form>
        
        <br />
        <v-col>
          <v-text-field id="input-name" class="input-name" label="กรอกชื่อ-สกุลของผู้ป่วย..." outlined dense  solo v-model="Namecheck" :rules="[(v) => !!v || 'กรุณากรอกชื่อ']" required></v-text-field>
          <v-spacer></v-spacer>
          <div class="my-2">
            <v-btn id="click-button" class="click-button" depressed color="primary" @click="getPatientmanagement"  >ค้นหา</v-btn>
            
          </div>
        </v-col>
        <v-spacer></v-spacer>
        
      </v-form>
       <v-spacer></v-spacer>

       
      
    </v-card>
    <br/>
    <v-card class="mx-auto" max-width="700">
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

  name: "searchPatient",
   components: {
    Navbar
  },
  data() {
    return {
       
        
        Namecheck:"",
        
      
      
      headers: [
        { text: "คำนำหน้าชื่อ", value: "title_name" },
        { text: "ชื่อสกุล", value: "name" },
        { text: "เพศ", value: "gender.gender" },
        { text: "อายุ", value: "age" },
        { text: "ผลตรวจ", value: "patient_result" },
        { text: "วันที่", value: "patientDate" },
        { text: "แพทย์", value: "profile.name" }
      ],
      
      
      items:[],
      

    };
  },

  methods: {
    /* eslint-disable no-console */
    getPatientmanagement(){
      
      http
       .get("/patientmanage/"+this.Namecheck)
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

.body {
  background-color: #110327;
}
</style>

