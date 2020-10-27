<template>
  <el-container>
    <el-header>Logout</el-header>
    <el-main>
      <el-button type="primary" @click="logout()">Logout</el-button>
    </el-main>
    <el-footer></el-footer>
  </el-container>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    logout() {
      this.$store.dispatch("auth/destroy", {});
      this.$message("logout success");
    },
  },
  computed: {
    token() {
      return this.$store.state.auth.token;
    },
  },
  /*
  created: function () {
    //this.$store.dispatch("message/destroy");
    // already logined
    if (this.$store.state.auth.token) {
      this.$router.push("/");
    }
  },
  */
  watch: {
    token(newToken) {
      console.log(newToken);
      this.$router.push("/");
    },
  },
};
</script>