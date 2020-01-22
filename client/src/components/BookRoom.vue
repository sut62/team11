<template>
<html>
  <Navbar/>
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
          <md-select id="doc" v-model="profileSelect">
                <md-option v-for="profile in profiles" :key="profile.profile_id" :value="profile.profile_id">{{profile.name}} </md-option>
          </md-select>
  </md-field>
      </div>

      <div class="md-layout-item">
     <md-field>
          <label >ชื่อคนไข้</label>
          <md-select id="pat"  v-model="patSelect">
                 <md-option v-for="pat in pats" :key="pat.patientManage_id" :value="pat.patientManage_id">{{pat.patient.name}} </md-option>
          </md-select>
    </md-field>
      </div>
       <div class="md-layout-item">
      <md-field>
          <label>ห้อง</label>
          <md-select id="room"  v-model="roomSelect">
                 <md-option v-for="room in rooms" :key="room.room_id" :value="room.room_id">{{room.room}} </md-option>
          </md-select>
  </md-field>
      </div>
      <v-col cols="10"  md="1000">
                <v-menu
                  ref="menu"
                  v-model="menu"
                  :close-on-content-click="false"
                  :return-value.sync="date"
                  transition="scale-transition"
                  offset-y
                  full-width
                  min-width="290px"
                >
                  <template v-slot:activator="{ on }">
                    <v-text-field
                      v-model="dateS"
                      label="เลือกวันที่ทำการจอง"
                      prepend-icon="event"
                      readonly
                      v-on="on"
                    ></v-text-field>
                  </template>
                  <v-date-picker id ="date" v-model="dateS" locale="th" no-title scrollable>
                    <v-spacer></v-spacer>
                    <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
                    <v-btn text color="primary" @click="$refs.menu.save(dateS),menu = false">OK</v-btn>
                  </v-date-picker>
                </v-menu>
              </v-col>            
        
          <v-col cols="10"  md="1000">
      <v-menu
        ref="menu"
        v-model="menu2"
        :close-on-content-click="false"
        :nudge-right="40"
        :return-value.sync="time"
        transition="scale-transition"
        offset-y
        max-width="290px"
        min-width="290px"
      >
        <template v-slot:activator="{ on }">
          <v-text-field
            v-model="timestart"
            label="Picker in menu"
            prepend-icon="access_time"
            readonly
            v-on="on"
          ></v-text-field>
        </template>
        <v-time-picker
        id ="times"
          v-if="menu2"
          v-model="timestart"
          full-width
          @click:minute="$refs.menu.save(time)"
        ></v-time-picker>
      </v-menu>
    </v-col>
    <v-col cols="10"  md="1000">
      <v-menu
        ref="menu"
        v-model="modal2"
        :close-on-content-click="false"
        :nudge-right="40"
        :return-value.sync="time"
        transition="scale-transition"
        offset-y
        max-width="290px"
        min-width="290px"
      >
        <template v-slot:activator="{ on }">
          <v-text-field
          id ="timee"
            v-model="timeend"
            label="Picker in menu"
            prepend-icon="access_time"
            readonly
            v-on="on"
          ></v-text-field>
        </template>
        <v-time-picker
          v-if="modal2"
          v-model="timeend"
          full-width
          @click:minute="$refs.menu.save(time)"
        ></v-time-picker>
      </v-menu>
    </v-col>      
       <md-field>
      <label>บันทึกอาการและการรักษา (ห้ามมีเครื่องหมาย /)</label>
      <md-textarea v-model="description"></md-textarea>
      <md-icon>description</md-icon>
    </md-field>
         <center>
          <md-button id="btsave" class="md-raised md-primary" @click = "savedata()">บันทึก</md-button> 
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
      dateS : new Date().toISOString().substr(0, 10),
      menu : false,
      timestart : null,
        menu2: false,
        modal2: false,
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
    margin: 30px;
    display: inline-block;
    vertical-align: top;
  }
</style>
