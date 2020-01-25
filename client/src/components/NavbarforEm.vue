
<template>
  <div>
    <v-toolbar
      dark
      prominent
      src="https://cdn.vuetifyjs.com/images/backgrounds/vbanner.jpg"
    >
      <v-app-bar-nav-icon></v-app-bar-nav-icon>

      <v-toolbar-title>ระบบข้อมูลแพทย์</v-toolbar-title>

      <v-spacer></v-spacer>
      <v-toolbar-items >
        <v-btn text @click="$router.push('/profile')">เพิ่มข้อมูลแพทย์</v-btn>
        <v-btn text @click="$router.push('/profiletable')">ตารางข้อมูลแพทย์</v-btn>
        <v-btn text @click="$router.push('/appointment')">นัดหมายแพทย์</v-btn>
        <v-btn text @click="$router.push('/searchappointment')">ข้อมูลการนัดหมายแพทย์</v-btn>
        <v-btn text @click="$router.push('/')" >ออกจากระบบ</v-btn>
      </v-toolbar-items>
    </v-toolbar>
  </div>
</template>