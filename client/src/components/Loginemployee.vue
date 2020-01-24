<template>
  <v-app id="inspire">
    <v-content>
      <div>
        <v-container class="fill-height" fluid>
          <v-row align="center" justify="center">
            <v-col md="8">
              <v-card class="elevation-12">
                <v-row class="mx-auto">
                 
                  <v-col class="text-center" md="mx-auto">
                    <v-container class="mx-auto">
                      <v-row class="justify-center">
                        <v-icon size="50" color="blue">account_circle</v-icon>
                        <v-card-text>
                          <h1>LOGIN FOR EMPLOYEE</h1>
                          <v-form>
                            <v-text-field
                              color="blue"
                              label="๊Username"
                              name="login"
                              v-model="username"
                              prepend-icon="person"
                              type="text"
                            ></v-text-field>

                            <v-text-field
                              id="password"
                              color="blue"
                              label="Password"
                              name="password"
                              v-model="password"
                              prepend-icon="lock"
                              type="password"
                            ></v-text-field>
                          </v-form>
                        </v-card-text>

                        <v-card-actions class="justify-center">

                          <v-btn
                            rounded
                            color="blue"
                            dark
                            large
                            @click="getLoginUser"
                          >login</v-btn>
                            <v-btn
                            rounded
                            color="blue"
                            dark
                            large
                            @click="$router.push('/')"
                          >back</v-btn>
                        </v-card-actions>
                      </v-row>
                    </v-container>
                  </v-col>
                </v-row>
              </v-card>
            </v-col>
          </v-row>
        </v-container>
      </div>
    </v-content>
  </v-app>
</template>

<script>
import http from "../http-common";
export default {
  name:"UserLogin",
  data(){
    return{
      Logins: [],
      username: "",
      password: "",
      member:""
    }
  },
  methods: {
    /* eslint-disable no-console */
    getLoginUser() {
          if (this.username == "" || this.password=="") {
        alert("กรุณากรอก username และ password.");
      } else{
      http
        .get("/employee" + "/" + this.username + "/" + this.password)
        .then(response => {
          this.Logins = response.data;
          console.log(this.Logins);
          this.$router.push('/profile')
        })
        .catch(e => {
          console.log(e);
          alert("Username/Password ไม่ถูกต้อง");
        });}
    }
  },
};
</script>

<style>
.img-background {
  width: 100%;
  height: 100%;
  background-size: cover;
}
</style>