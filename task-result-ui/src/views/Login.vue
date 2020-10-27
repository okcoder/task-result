<template>
  <el-container>
    <el-header>Login</el-header>
    <el-main>
      <el-form ref="form" :model="user" :rules="rules" label-width="80px">
        <el-form-item label="User" prop="userId">
          <el-input placeholder="请输入用户名" v-model="user.userId"></el-input>
        </el-form-item>
        <el-form-item label="Password" prop="password"
          ><el-input
            type="password"
            placeholder="请输入密码"
            v-model="user.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login('form')">Login</el-button>
        </el-form-item>
      </el-form>
    </el-main>
    <el-footer></el-footer>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      user: {
        userId: "user",
        password: "password",
      },
      rules: {
        userId: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 5, max: 8, message: "长度在 5 到 8 个字符", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    login(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$store.dispatch("auth/create", this.user);
        } else {
          this.$message.error("错了哦");
        }
      });
    },
  },
  computed: {
    token() {
      return this.$store.state.auth.token;
    },
  },
  created: function () {
    //this.$store.dispatch("message/destroy");
    // already logined
    if (this.$store.state.auth.token) {
      this.$router.push("/");
    }
  },
  watch: {
    token(newToken) {
      console.log(newToken);
      this.$router.push("/");
    },
  },
};
</script>