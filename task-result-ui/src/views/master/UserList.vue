<template>
  <el-container>
    <el-header class="bg-purple">
      <el-row>
        <el-col :span="10" style="text-align: left !important">
          <el-button type="text" disabled></el-button>
          <el-button type="primary" @click="create()">Create</el-button>
        </el-col>
        <el-breadcrumb separator="/">
          <el-breadcrumb-item>User Management</el-breadcrumb-item>
          <el-breadcrumb-item>Search</el-breadcrumb-item>
        </el-breadcrumb>
      </el-row>
    </el-header>
    <el-main class="search">
      <el-row>
        <el-col :span="24"
          ><div class="grid-content bg-purple-dark">abcd</div></el-col
        >
      </el-row>
    </el-main>
    <el-main class="list">Main</el-main>
    <el-footer>Footer</el-footer>
  </el-container>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      schedule: {
        repeats: [],
      },
    };
  },
  computed: {
    everyDay: {
      get: function () {
        return this.schedule.repeats.length == 7;
      },
      set: function (val) {
        if (val) {
          this.schedule.repeats = this.schedule.repeatOptions;
        } else {
          this.schedule.repeats = [];
        }
      },
    },
  },
  methods: {
    create: function () {
      this.$router.push({ name: "userDetail", params: { mode: "new" } });
    },
    onSubmit: async function () {
      const res = await axios.post(
        "schedule/" + this.$route.params.id,
        this.schedule
      );
      alert(JSON.stringify(res));
    },
    onCancle: async function () {
      this.$router.go(-1);
    },
    refresh: async function () {
      let url = "schedule/";
      if (this.$route.params.id == "new") {
        url = url + "new/" + this.$route.query.priorityType;
      } else {
        url = url + this.$route.params.id;
      }
      const res = await axios.get(url);
      this.schedule = res.data;
    },
  },
};
</script>
<style scoped>
.el-col1 {
  border: 1px solid red;
  background-color: yellow;
}
.search1 {
  border: 1px solid green;
  background-color: yellow;
}
.list1 {
  border: 1px solid blue;
  background-color: yellow;
}
</style>