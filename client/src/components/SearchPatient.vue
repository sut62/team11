<template>
<html>
 <Navbar/>
<body background="doc1.jpg">
<center>
  <br>
    <div style="width:90%">
    <md-table v-model="searched" md-sort="name" md-sort-order="asc" md-card md-fixed-header style="width:100%">
      <md-table-toolbar>
        <div class="md-toolbar-section-start">
          <h1 class="md-title">ข้อมูลผู้ป่วย</h1>
        </div>

        <md-field md-clearable class="md-toolbar-section-end">
          <md-input placeholder="กรอกชื่อผู้ป่วย" v-model="search" @input="searchOnTable" />
        </md-field>
      </md-table-toolbar>

      <md-table-empty-state md-label="ไม่พบข้อมูลผู้ป่วย"></md-table-empty-state>
      <br><br><br><br><br><br>

      <md-table-row slot="md-table-row" slot-scope="{ item }">
        <md-table-cell md-label="คำนำหน้าชื่อ"  >{{ item.patient.title_name }}</md-table-cell>
        <md-table-cell md-label="ชื่อ-นามสกุล" >{{ item.patient.name }}</md-table-cell>
        <md-table-cell md-label="เพศ" >{{ item.patient.gender }}</md-table-cell>
        <md-table-cell md-label="อายุ" >{{ item.patient.age }}</md-table-cell>
        <md-table-cell md-label="ผลตรวจ" >{{ item.patientManage }}</md-table-cell>
        <md-table-cell md-label="วันที่" >{{ item.patientDate }}</md-table-cell>
        <md-table-cell md-label="แพทย์ผู้ตรวจ" >{{ item.profile.name }}</md-table-cell>
      </md-table-row>
    </md-table>
  </div>
  <br>
</center>
</body>
</html>
</template>
<script>
 const toLower = text => {
    return text.toString().toLowerCase()
  }

  const searchByName = (items, term) => {
    if (term) {
      return items.filter(item => toLower(item.patient.name).includes(toLower(term)))
    }

    return items
  }
import Navbar from '../components/Navbar'
import http from "../http-common";
export default {
   components: {
    Navbar
  },
data() {
    return {
      patients: null ,
       search: '',
      searched: []
     
    };
  },
  methods: {
        /* eslint-disable no-console */
    getPatients() {
      http
        .get("/patientmanage")
        .then(response => {
          this.patients = response.data;
          this.searched = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

    },
    
    
      searchOnTable () {
        this.searched = searchByName(this.patients, this.search);
      
    },
   
   
  },
    mounted() {
     this.getPatients();
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

.md-field{
  max-width: 400px;
}
.md-card{
  
  width: 500px;
    height: 500px;
  background-color: white;
}
.body {
  background-color: #E6E6FA;
}

</style>
  