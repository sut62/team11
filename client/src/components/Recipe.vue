<template>
<html>
  <Navbar/>
<body style="background-color:powderblue;">
<br>
<br>
<center>
  <body class = "card">
    <center>
<br>
<h1>สั่งจ่ายยาของแพทย์</h1>
<br>
  <center>
    
   
          
    <div>

    <md-field>
      <label>เลขที่จ่ายยา</label>
      <md-input id="nm" class="nm" v-model="nummed"></md-input>
    </md-field>

    <md-field>
          <label >ชื่อยา</label>
          <md-select id="m" class="m" v-model="medicineSelect">
                 <md-option v-for="medicine in medicines" :key="medicine.medicine_id" :value="medicine.medicine_id">{{medicine.medicine_name}} </md-option>
          </md-select>
    </md-field>

    <md-field>
          <label >ชนิดยา</label>
          <md-select id="td" class="td" v-model="typeSelect">
              <md-option v-for="type in types" :key="type.typemedicine_id" :value="type.typemedicine_id">{{type.typemedicine_name}} </md-option>
          </md-select>
    </md-field>

    <md-field>
      <label>จำนวน</label>
      <md-input id="a" class="a" v-model="amount"></md-input>
    </md-field>

    <md-field>
          <label >ประเภทบรรจุภัณฑ์</label>
          <md-select id="tp" class="tp" v-model="typepackingSelect">
              <md-option v-for="typepack in typepackings" :key="typepack.typepacking_id" :value="typepack.typepacking_id">{{typepack.typepacking_name}} </md-option>
          </md-select>
    </md-field>

    
    <v-col cols="12" lg="5">
        <v-menu
        id="td" class="td"
          v-model="menu2"
          :close-on-content-click="false"
          transition="scale-transition"
          offset-y
          full-width
          max-width="290px"
          min-width="290px"
        >
          <template v-slot:activator="{ on }">
            <v-text-field
            id="td" class="td"
              v-model="selectedDate"
              label="วันที่"
             
              prepend-icon="event"
              readonly
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker id="td" class="td" v-model="selectedDate" no-title @input="menu2 = false"></v-date-picker>
        </v-menu>
      </v-col>

    <md-field>
          <label >ชื่อแพทย์สั่งจ่ายยา</label>
          <md-select id="dm" class="dm" v-model="profileSelect">
                 <md-option v-for="profile in profiles" :key="profile.profile_id" :value="profile.profile_id">{{profile.name}} </md-option>
          </md-select>
    </md-field>

    <md-field>
          <label >ชื่อคนไข้</label>
          <md-select id="pm" class="pm" v-model="patSelect">
                 <md-option v-for="pat in pats" :key="pat.patientManage_id" :value="pat.patientManage_id">{{pat.patient.name}} </md-option>
          </md-select>
          
    </md-field>
    <md-button  id="cs" class="md-raised md-primary" @click="savedata()">บันทึกข้อมูล</md-button> 
    <md-button  id="sm" class="md-raised md-primary" @click="dialog = true">แสดงข้อมูลการสั่งจ่ายยา</md-button> 
    <br/>
    <br>
    </div>
      
      </center>
      <v-row justify="center">
    <v-dialog v-model="dialog" fullscreen hide-overlay transition="dialog-bottom-transition">
      <v-card>
        <v-toolbar dark color="primary">
          <v-btn icon dark @click="dialog = false">
            <v-icon>close</v-icon>
          </v-btn>
          <v-toolbar-title>ข้อมูลการสั่งจ่ายยา</v-toolbar-title>
          <v-spacer></v-spacer>
        </v-toolbar>
        <v-data-table
          :headers="headers"
          :items="desserts"
          :items-per-page="5"
          class="elevation-1"
  ></v-data-table>
      </v-card>
    </v-dialog>
  </v-row>
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
    dialog: false,
    notifications: false,
    sound: true,
    widgets: false,
    medicines : null,
    medicineSelect : null,
    types: null,
    typeSelect: null,
    typepackings: null,
    typepackingSelect : null,
    nummed : null,
    amount: null,
    selectedDate: null,
    profiles: null,
    profileSelect: null,
    patSelect: null,
    pats : null,

     headers: [
      //{ text: "ID", value: "id" },
        {
          text: "เลขที่สั่งจ่าย",
          align: "left",
          sortable: false,
          value: "number"
        },
        { text: "ชื่อยา", value: "patientManagement.patient.name" },
        { text: "ชนิด", value: "typemedicine.typemedicine_name" },
        { text: "จำนวน", value: "amount" },
        { text: "ประเภทบรรจุภัณฑ์", value: "typepacking.typepacking_name" },  
        { text: "วันที่จ่ายยา", value: "date" },
        { text: "แพทย์ผู้สั่งจ่ายยา", value: "profile.name" },
        { text: "คนไข้", value: "patientManagement.patient.name" },
      ],

    desserts:[],

    };
  },
  methods: {
        /* eslint-disable no-console */
        getrecipe(){

             http
        .get("/recipe")
        .then(response => {
          this.desserts = response.data;
          console.log(this.desserts);
        })
        .catch(e => {
          console.log(e);
        });

        },
        

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
          getTypepack() {
      http
        .get("/typepacking")
        .then(response => {
          this.typepackings = response.data;
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
                        this.typepackingSelect +
                        "/" +
                        this.selectedDate+
                        "/" +
                        this.profileSelect+
                        "/"+this.patSelect

                    )
                    .then(response => {
          console.log(response);
          this.$alert("กรอกข้อมูลสำเร็จ", "Success", "success").then(() =>
            console.log("Success",location.reload())
          );
        })
        .catch(e => {
          console.log(e);
          this.$alert("กรอกข้อมูลไม่สำเร็จ", "Warning", "warning").then(() =>
            console.log("Closed")
          );
        });
        
           
            

         // console.log(this.nummed , this.medicineSelect , this.typeSelect , this.amount , this.selectedDate,
         // this.profileSelect , this.patSelect);
       },
       
  },
    mounted() {
      this.getMedicine();
      this.getType();
      this.getProfile();
      this.getPatient();
      this.getTypepack();
      this.getrecipe();
  }
}

</script>


<style>

.md-field{
  max-width: 400px;
}
.card {
    width: auto;
    height: auto;
    
     background-color: white;
  }
</style>
