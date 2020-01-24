<template>
  <div>
    <v-toolbar>
      <v-toolbar-title>ระบบข้อมูลแพทย์</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items>
        <v-btn text @click="$router.push('/profile')">เพิ่มข้อมูลแพทย์</v-btn>
        <v-btn text @click="$router.push('/appointment')">นัดผู้ป่วย</v-btn>
        <v-btn text @click="$router.push('/')" >ออกจากระบบ</v-btn>
      </v-toolbar-items>
    </v-toolbar>
  </div>
</template>
<script>

</script>