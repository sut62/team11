<template>
<html>
  <Navbar/>
<body background="ooy.png">
<center>
<br>   
<br>   
<br>   
<br>   
<br>   
<br> 
 <md-field>
  <label id="dee">แผนก</label> 
          <md-select id="de" class="de" v-model="departSelect">
              <md-option v-for="department in departments"  :key="department.department_id" :value="department.department_id">{{department.department}} </md-option>
          </md-select>
        </md-field>

        <md-field>
      <label>ชื่อ</label>
      <md-input id="name" type="text" class="Name" v-model="name"></md-input>
    </md-field>

    <md-field>
      <label>อายุ</label>
      <md-input class="Age" id="age" v-model="age" type="number"></md-input>
    </md-field>
  
  <md-field>
          <label>กรุ๊ปเลือด</label>
          <md-select class="Blood" id="blood" v-model="bloodSelect">
                <md-option v-for="blood in bloods" :key="blood.blood_id" :value="blood.blood_id">{{blood.blood}} </md-option>
          </md-select>
  </md-field>

  <md-field>
          <label>เพศ</label>
          <md-select class="Gender" id="gender" v-model="genSelect">
                <md-option v-for="gender in genders" :key="gender.gender_id" :value="gender.gender_id">{{gender.gender}} </md-option>
          </md-select>
  </md-field>

  <md-field>
          <label>สถานภาพ</label>
          <md-select class="Status" id="status" v-model="matSelect">
                <md-option v-for="mat in mats" :key="mat.status_id" :value="mat.status_id">{{mat.status}} </md-option>
          </md-select>
  </md-field>
    
    <md-field>
      <label>เบอร์</label>
      <md-input class="Phone"  id="phone" v-model="tel" type="number" md-counter="10"></md-input>
    </md-field>


    <md-field>
      <label>ที่อยู่</label>
      <md-textarea class="Address" id="address" v-model="address" md-counter="80"></md-textarea>
    </md-field>


  
    <md-button class="md-primary md-raised" @click="savedata()">SAVE</md-button>
  <md-button class="md-raised" @click="clear()">CLEAR</md-button>


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
    departments : null ,
    bloods : null,
    genders : null,
    mats : null,
    
    departSelect : null,
    name : null,
    age : null,
    bloodSelect : null,
    genSelect : null,
    tel : null,
    address : null,
    matSelect : null
    };
  },
    methods: {
        /* eslint-disable no-console */
    
    getBlood() {
      http
        .get("/blood")
        .then(response => {
          this.bloods = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });


  },

          getMats() {
      http
        .get("/maritalstatus")
        .then(response => {
          this.mats = response.data;
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
    getGender() {
            http
              .get("/gender")
              .then(response => {
                this.genders = response.data;
                console.log(response.data);
              })
              .catch(e => {
                console.log(e);
              });

        },

        savedata(){
                if(this.departSelect==null||this.name==null||this.genSelect==null||this.age==null||this.bloodSelect==null||this.tel==null||this.address==null||this.matSelect==null ){
                       this.$alert(
                           "กรอกข้อมูลไม่ครบ",
                           "Warning",
                           "warning"
                        ).then(() => console.log("Closed"));
                    }
               else
          { http
                    .post(
                      "/profile/" +
                        this.departSelect +
                        "/" +
                        this.name +
                        "/" +
                        this.genSelect +
                        "/" +
                        this.age +
                        "/" +
                       this.bloodSelect+
                        "/" +
                       this.tel+
                       "/"+this.address+
                       "/"+
                       this.matSelect

                    )
                    .then(response => {
                      console.log(response);
                    })
                    .catch(e => {
                      console.log(e);
                    });
                    //console.log(this.departSelect,this.name,this.age,this.bloodSelect,this.genSelect,this.tel,this.address,this.matSelect);
                 this.$alert(
                          "บันทึกข้อมูลสำเร็จ",
                          "Success",
                          "success"
                    ).then(() => console.log("Closed"));

                window.location.reload()
            }
        },
        clear() {
           window.location.reload()
        }

       
       
  },
    mounted() {
      this.getBlood();
      this.getDepartment();
      this.getGender();
      this.getMats();
  }
}

</script>


<style>
.md-field{
  max-width: 400px;
}
</style>
