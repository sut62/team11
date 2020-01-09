<template>
  <v-app>


   <v-content>

         <router-view />
       </v-content>
  </v-app>
</template>

import Navigation from './components/Navigation'
<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>
