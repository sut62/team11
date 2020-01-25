<template>
<html>
   <NavbarforEm/>
<body background="doc1.jpg">

    <div style="width:100%">
    <md-table v-model="searched" md-sort="name" md-sort-order="asc" md-card md-fixed-header style="width:100%">
      <md-table-toolbar>
        <div class="md-toolbar-section-start">
          <h1 class="md-title">Users</h1>
        </div>

        <md-field md-clearable class="md-toolbar-section-end">
          <md-input placeholder="Search by name..." v-model="search" @input="searchOnTable" />
        </md-field>
      </md-table-toolbar>

      

      <md-table-row slot="md-table-row" slot-scope="{ item }">
        <md-table-cell md-label="ชื่อแพทย์"  >{{ item.profile.name }}</md-table-cell>
        <md-table-cell md-label="ชื่อผู้ป่วย" >{{ item.patient.name }}</md-table-cell>
        <md-table-cell md-label="วันที่นัดหมาย" >{{ item.dateap }}</md-table-cell>
        <md-table-cell md-label="เวลาที่นัดหมาย" >{{ item.appointmenttime.timeap }}</md-table-cell>
        <md-table-cell md-label="สาเหตุ" >{{ item.cause }}</md-table-cell>
      </md-table-row>
    </md-table>
  </div>

</body>
</html>
</template>
<script>
 const toLower = text => {
    return text.toString().toLowerCase()
  }

  const searchByName = (items, term) => {
    if (term) {
      return items.filter(item => toLower(item.profile.name).includes(toLower(term)))
    }

    return items
  }
import NavbarforEm from '../components/NavbarforEm'
import http from "../http-common";
export default {
   components: {
    NavbarforEm
  },
data() {
    return {
      appointments: null ,
       search: '',
      searched: []
     
    };
  },
  methods: {
        /* eslint-disable no-console */
    getAppointments() {
      http
        .get("/appointments")
        .then(response => {
          this.appointments = response.data;
          this.searched = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

    },
    
    
      searchOnTable () {
        this.searched = searchByName(this.appointments, this.search);
      
    },
   
   
  },
    mounted() {
     this.getAppointments();
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
  