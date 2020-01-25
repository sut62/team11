<template>
<html>
  <Navbar />
  <body class="body">
    <br />
    <br />
    <br />

    <center>
      <body class="card">
        <center>
          <br />
          <br />
          <h1>ตารางเวร</h1>

          <br />
          <br />

          <md-field>
            <label>ชื่อแพทย์</label>
            <md-select v-model="profileSelect" class="Profile" id="profile">
              <md-option
                v-for="profile in profiles"
                :key="profile.profile_id"
                :value="profile.profile_id"
              >{{profile.name}}</md-option>
            </md-select>
          </md-field>

          <md-field>
            <label>แผนก</label>
            <md-select v-model="departSelect" class="Department" id="department"> 
              <md-option
                v-for="department in departments"
                :key="department.department_id"
                :value="department.department_id"
              >{{department.department}}</md-option>
            </md-select>
          </md-field>

          <v-col cols="12" lg="6">
            <v-menu
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
                  v-model="selectedDate"
                  label="วันที่"
                  prepend-icon="event"
                  readonly
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker v-model="selectedDate" no-title @input="menu2 = false"></v-date-picker>
            </v-menu>
          </v-col>

          <md-field>
            <label>เวลา</label>
            <md-select v-model="timeSelect" id="time" class="Worktime">
              <md-option
                v-for="worktime in worktimes"
                :key="worktime.worktimeId"
                :value="worktime.worktimeId"
              >{{worktime.work}}</md-option>
            </md-select>
          </md-field>

          <md-button class="md-raised md-primary" @click="savedata()">บันทึกข้อมูล</md-button>

          <br />
          <br />
        </center>
      </body>
    </center>
  </body>
</html>
</template>

<script>
import Navbar from "../components/Navbar";
import http from "../http-common";

export default {
  components: {
    Navbar
  },

  data() {
    return {
      profiles: null,
      departments: null,
      worktimes: null,
      profileSelect: null,
      departSelect: null,
      timeSelect: null,
      selectedDate: null,
      menu2: false
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

    savedata() {
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
          this.$alert("กรอกข้อมูลสำเร็จ", "Success", "success").then(() =>
            console.log("Success",location.reload())
          );
        })
        .catch(e => {
          console.log(e);
          this.$alert("กรอกข้อมูลไม่ครบ", "Warning", "warning").then(() =>
            console.log("Closed")
          );
        });
    }
  },

  mounted() {
    this.getProfile();
    this.getDepartment();
    this.getWorktime();
   
  }
};
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