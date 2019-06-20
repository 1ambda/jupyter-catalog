<template>
  <div>
    <div>
      <el-menu mode="horizontal" menu-trigger="click"
               text-color="#303133" class="navbar-menu"
               :default-active="activeNavbarIndex">
        <el-menu-item index="home"
                      class="navbar-menu-item">
          <img src="@/assets/gopher_inclusion_small.png"
               height="60" width="60" style="padding-left: 7px; padding-right: 2px;">
        </el-menu-item>

        <el-menu-item index="notebook"
                      class="navbar-menu-item">
          <span class="navbar-menu-item-text">Notebook Registry</span>
        </el-menu-item>

        <el-menu-item class="navbar-menu-item">
          <el-dropdown placement="bottom-end"
                       trigger="click">
            <span class="el-dropdown-link navbar-menu-item-text navbar-submenu-item-dropdown-text">
              Recently Viewed
              <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown" class="navbar-menu-item-dropdown-popper">
              <div class="navbar-menu-item-dropdown-search">
                <el-input placeholder="Search" suffix-icon="el-icon-search"
                          size="small"
                          v-model="inputDropdownSearchValue">
                </el-input>
              </div>
              <el-dropdown-item divided></el-dropdown-item>
              <el-dropdown-item>Notebook: Ad Performance</el-dropdown-item>
              <el-dropdown-item>Notebook: Popular Hotels</el-dropdown-item>
              <el-dropdown-item divided></el-dropdown-item>
              <el-dropdown-item>Workspace: User - Kun</el-dropdown-item>
              <el-dropdown-item>Workspace: User - Seho</el-dropdown-item>
              <el-dropdown-item divided></el-dropdown-item>
              <el-dropdown-item>Workspace: Group - Team Data</el-dropdown-item>
              <el-dropdown-item>Workspace: Group - Team a-trium</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-menu-item>

        <el-menu-item class="navbar-menu-item">
          <el-input placeholder="Search" suffix-icon="el-icon-search" class="navbar-search-input" autofocus
                    v-model="inputNavbarSearchValue">
            <el-select v-model="optionValueSearchCategory"
                       class="navbar-search-select"
                       slot="prepend" placeholder="Select">
              <el-option label="Notebook" value="1"></el-option>
              <el-option label="Workspace" value="2"></el-option>
            </el-select>
          </el-input>
        </el-menu-item>

        <!-- right -->

        <el-submenu index="nav-dropdown"
                    class="navbar-username" popper-class="navbar-username-popper" style="float: right;">
          <template slot="title">
            <img :src="stateUserImage" height="35" width="35"
                 class="navbar-username-avatar">
            <span class="navbar-username-text">{{ stateUsername }}</span>
          </template>
          <el-menu-item class="navbar-submenu-item">
            <i class="el-icon-circle-close navbar-submenu-item-icon"></i>
            <span class="navbar-submenu-item-text">로그아웃</span>
          </el-menu-item>
        </el-submenu>

        <el-menu-item index="admin" style="float: right;" class="navbar-menu-item">
          <span class="navbar-menu-item-text ">
            Admin
          </span>
        </el-menu-item>

        <el-menu-item class="navbar-menu-item" style="float: right;">
          <el-button type="text" class="navbar-menu-item-button">
            <a :href="stateJupyterLink" target="_blank"
               class="navbar-menu-item-button-link">Jupyter</a>
          </el-button>
        </el-menu-item>

      </el-menu>
    </div>
  </div>
</template>

<script lang="ts">
  import {Component, Vue} from 'vue-property-decorator'

  @Component
  export default class Navbar extends Vue {
    private activeNavbarIndex = 'home'

    private inputNavbarSearchValue = ''
    private optionValueSearchCategory = '1'
    private inputDropdownSearchValue = ''

    private stateUserImage = 'https://avatars0.githubusercontent.com/' +
      'u/48820946?s=400&u=4823ea772ccc4be4f3d088be9c5aa1c8223d150f&v=4'
    private stateUsername = 'Kun'

    private stateJupyterLink = 'https://jupyter.workspace.io'


  }
</script>

<style lang="scss" scoped>
  .github-link {
    color: #303133;
  }

  .github-link:visited {
    color: #303133;
  }

  .github-icon {
    fill: white;
  }

  .navbar-menu {
    height: 74px !important;
  }

  .navbar-menu-item {
    height: 74px !important;
    line-height: 74px !important;
  }

  .navbar-menu-item-last {
    border-right: solid 1px #e6e6e6;
    padding-right: 40px;
  }

  .navbar-menu-item-text {
    font-size: 17px;
  }

  .el-menu-item:not(.is-active):hover > .navbar-menu-item-text:hover {
    box-shadow: 0 1px 0 #303133;
  }

  .navbar-submenu-item {
  }

  .navbar-submenu-item-icon {
    padding-left: 10px;
  }

  .navbar-submenu-item-text {
    padding-left: 5px;
  }

  .navbar-menu-item-dropdown-popper {
    top: 50px !important;
  }

  .navbar-submenu-item-dropdown-text {
    color: #303133;;
  }

  .navbar-menu-item-dropdown-search {
    padding-left: 20px;
    padding-right: 20px;
  }

  .navbar-menu-item-button {
    font-size: 17px;
    font-weight: 400;
    margin-bottom: 5px;
  }

  .navbar-menu-item-button-link {
    text-decoration: none;
  }

  .navbar-search-select {
    width: 120px;
  }

  .navbar-search-input {
    width: 400px;
  }

  .navbar-username {
    height: 74px;
    line-height: 74px;
    padding-top: 7px;
    margin-left: 10px;
    margin-right: 10px;
  }

  .navbar-username-text {
    font-size: 16px;
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  }

  .navbar-username-avatar {
    margin-right: 16px;
    border-radius: 35%;
    object-fit: cover;
    // border: 1px solid rgb(255, 255, 255);
    background-color: rgb(242, 242, 242) !important;
    box-shadow: rgb(235, 235, 235) 0px 0px 0px 1px !important;
  }


</style>

