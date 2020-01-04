<template>
  <div class="BookRoom">
    <ToolBars/>
    <v-container>
      <v-card
    class="mx-auto"
    max-width="1200"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <v-list-item-title class="headline mb-1">การจองห้องภายในโรงพยาบาลสำหรับแพทย์</v-list-item-title>
        <v-row align="center">
          <v-col class="d-flex" cols="1" sm="3" >
        <v-select
        :items="doctor"
        :menu-props="{ top: true, offsetY: true }"
        label="กรุณาเลือกแพทย์ผู้ทำการจอง"
        ></v-select>
      </v-col>
      <v-spacer></v-spacer>
      <v-col class="d-flex" cols="1" sm="3" >
        <v-select
        :items="patients"
        :menu-props="{ top: true, offsetY: true }"
        label="กรุณาเลือกผู้ป่วยที่ทำการรักษา"
        ></v-select>
      </v-col>
      <v-spacer></v-spacer>
      <v-col class="d-flex" cols="1" sm="3" >
        <v-select
        :items="Room"
        :menu-props="{ top: true, offsetY: true }"
        label="กรุณาเลือกห้องที่ทำการจอง"
        ></v-select>
      </v-col>
    </v-row>
      <v-spacer></v-spacer>
      <p class="text-sm-left">เลือกช่วงเวลาที่ต้องการใช้งานห้อง</p>
    <v-row align="center">
      <v-col class="d-flex" cols="1" sm="3" >
      <v-datetime-picker
        label="เวลาเริ่ม"
        v-model="datetimeStart">
      </v-datetime-picker>
      </v-col>
      <v-spacer></v-spacer>
      <v-col class="d-flex" cols="1" sm="3" >
      <v-datetime-picker
        label="เวลาสิ้นสุด"
        v-model="datetimeEnd">
      </v-datetime-picker>
      </v-col>
       <v-spacer></v-spacer>
       <v-col cols="12" sm="6" md="3">
          <v-text-field
            label="หมายเหตุ"
          ></v-text-field>
        </v-col>


    </v-row>

      </v-list-item-content>
    </v-list-item>
    <v-card-actions>
      <v-row justify="center">
      <div class="text-center">
    <v-btn rounded color="primary" dark>บันทึก</v-btn>
    </div>
    </v-row>
    </v-card-actions>
  </v-card>
  </v-container>
  </div>
</template>

<script>
// @ is an alias to /src
import ToolBars from '../components/ToolBars.vue'

export default {
  name: 'BookRoom',
  components: {
    ToolBars
  }
}
</script>
