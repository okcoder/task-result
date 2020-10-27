<template>
  <div id="app">
    <div id="nav" v-show="showMenus">
      <el-menu default-active="/" :collapse="collapse" :router="router" @select="handleSelect">
        <template v-for="(menu, i) in menus">
          <el-menu-item :index="menu.index" :key="i" v-if="menu.children.length == 0">
            <i :class="menu.cssClass"></i>
            <span slot="title">{{ menu.title }}</span>
          </el-menu-item>
          <el-submenu :index="menu.index" :key="i" v-if="menu.children.length > 0">
            <template slot="title">
              <i :class="menu.cssClass"></i>
              <span slot="title">{{ menu.title }}</span>
            </template>
            <el-menu-item :key="i" v-for="(subMi, i) in menu.children" :index="subMi.index">{{ subMi.title }}</el-menu-item>
          </el-submenu>
        </template>
        <!--
        <el-menu-item index="/">
          <i class="el-icon-s-home"></i>
          <span slot="title">Home</span>
        </el-menu-item>
        <el-submenu index="">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">导航一</span>
          </template>
          <el-menu-item index="taskPriority"> taskPriority</el-menu-item>
          <el-menu-item index="schedulePriority">
            schedulePriority</el-menu-item
          >
        </el-submenu>
        <el-menu-item index="About">
          <i class="el-icon-setting"></i>
          <span slot="title">About</span>
        </el-menu-item>
        -->
        <el-menu-item index="logout" route="logout">
          <i class="el-icon-switch-button"></i>
          <span slot="title">Logout</span>
        </el-menu-item>
      </el-menu>
    </div>

    <el-container id="main">
      <router-view />
    </el-container>
  </div>
</template>


<script>
export default {
  data() {
    return {
      router: true,
      collapse: true,
    };
  },
  computed: {
    showMenus() {
      let menus = this.$store.state.auth.menus;
      //console.log("menus=", JSON.stringify(menus));
      return menus != null && menus.length > 0;
    },
    menus() {
      //console.log("menus=", JSON.stringify(this.$store.state.auth.menus));
      return this.$store.state.auth.menus;
    },
    userId() {
      //console.log("userId=", JSON.stringify(this.$store.state.auth.userId));
      return this.$store.state.auth.userId;
    },
    token() {
      //console.log("token=", this.$store.state.auth.token);
      return this.$store.state.auth.token;
    },
  },
  methods: {
    handleSelect(key, keyPath) {
      //this.$message([key, keyPath].join("-----"));
      console.log(key, keyPath);
      return false;
      //      console.log(key, keyPath);
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  width: 100%;
  display: table;
  height: 100%;
}
#app > div {
  display: table-cell;
}

#nav {
  width: 60px;
  border: dotted 1px #42b983;
}
html {
  height: 100%;
}
body {
  height: 100%;
  margin: 0;
}
.el-container {
  height: 100%;
  margin: 0;
}
.pageHeader {
  border: dotted 2px #42b983;
}
main.pageMain {
  border: dotted 2px blue;
  height: 100%;
  padding: 0px;
}
.bg-purple {
  background: #d3dce6;
}
.el-header {
  padding: 10px !important;
}
.el-breadcrumb {
  padding-top: 10px;
}
.el-button {
  min-width: 90px;
}
.el-button--small {
  min-width: 20px !important;
}
</style>
