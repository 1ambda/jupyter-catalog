<template>
  <div id="app">
    <el-container>
      <el-header style="padding: 0;">
        <navbar-app></navbar-app>
      </el-header>
      <div>
        <router-view></router-view>
      </div>
    </el-container>
  </div>
</template>

<script lang="ts">
  import {Component, Vue} from 'vue-property-decorator'
  import Navbar from '@/components/Navbar/Index.vue' // @ is an alias to /src

  @Component({
    components: {
      'navbar-app': Navbar,
    },
  })
  export default class App extends Vue {
  }

</script>

<style lang="scss">
  @import './App.scss';

</style>
