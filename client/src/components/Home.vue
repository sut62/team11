<template>
  <v-container>
      
    <v-row justify="center">
      <div @click="GoLoginHR" class = "mt-12">
            <v-btn x-large color="red" dark><v-icon class = "mr-2">account_circle</v-icon>เข้าสู่ระบบในฐานะแพทย์</v-btn>
      </div>
    </v-row> 
     <v-row justify="center">
      <div @click="GoLoginEmployee" class = "mt-12">
            <v-btn x-large color="red" dark><v-icon class = "mr-2">account_circle</v-icon>เข้าสู่ระบบพนักงาน</v-btn>
      </div>
    </v-row>    
  </v-container>
</template>

<script>

export default {
    data(){
        return{
          
    }
  },
   methods: {
      GoLoginHR() {
          this.$router.push("/Logindoctor");
          this.submitted = true;
      },
      GoLoginEmployee() {
          this.$router.push("/Loginemployee");
          this.submitted = true;
      }
    }
};
</script>