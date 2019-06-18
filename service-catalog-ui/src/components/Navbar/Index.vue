<template>
  <div>
    <el-menu mode="horizontal" menu-trigger="click"
             text-color="#303133" class="navbar-menu">
      <el-menu-item index="home" class="navbar-menu-item">
        Hello
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script lang="ts">
  import {Component, Vue} from 'vue-property-decorator'

  @Component
  export default class Navbar extends Vue {
  }
</script>

<style lang="scss" scoped>
</style>

