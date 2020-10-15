<template>
  <div id="app">
    <div id="nav">
      <el-menu default-active="/" collapse="true" router="true">
        <el-menu-item index="/">
          <i class="el-icon-s-home"></i>
          <span slot="title">Home</span>
        </el-menu-item>
        <el-submenu>
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
      </el-menu>
    </div>
    <div id="main">
      <router-view />
    </div>
  </div>
</template>
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
</style>
