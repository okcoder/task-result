<template>
  <el-container>
    <el-header class="bg-purple">
      <el-row>
        <el-col :span="10" style="text-align: left !important">
          <el-button type="text" @click="back()" icon="el-icon-back">back</el-button>
          <el-button type="primary" @click="save()">Save</el-button>
          <!--
          <el-button type="primary" @click="save()" disabled>Split</el-button>
          -->
        </el-col>
        <el-breadcrumb separator="/">
          <el-breadcrumb-item>User Management</el-breadcrumb-item>
          <el-breadcrumb-item>Detail</el-breadcrumb-item>
        </el-breadcrumb>
      </el-row>
    </el-header>
    <el-main>
      <el-form ref="user" :model="user" label-width="180px" style="text-align: left">
        <el-form-item label="Id">
          <el-col :span="4">
            <el-input v-model="user.id" placeholder="ユーザー"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="UserName">
          <el-col :span="9">
            <el-input v-model="user.name" placeholder="ユーザー名"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="Input Keys">
          <el-tag :key="tag" v-for="tag in user.inputKeys" closable effect="plain" :disable-transitions="false" @close="handleClose(tag)">{{ tag }}</el-tag>
          <el-input
            class="input-new-tag"
            v-if="views.inputKeys.inputVisible"
            v-model="views.inputKeys.inputValue"
            ref="saveTagInput"
            size="small"
            @keyup.enter.native="handleInputConfirm"
            @blur="handleInputConfirm"
          ></el-input>
          <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Key</el-button>
        </el-form-item>
        <!--
        <el-form-item label="Period">
          <el-col :span="4">
            <el-date-picker type="date" placeholder="From" v-model="user.startDay" style="width: 100%" disabled></el-date-picker>
          </el-col>
          <el-col class="line" :span="1" style="text-align: center">-</el-col>
          <el-col :span="4">
            <el-date-picker type="date" placeholder="To" v-model="user.finishDay" style="width: 100%" disabled></el-date-picker>
          </el-col>
          <el-col :span="4"></el-col>
        </el-form-item>
        -->
        <el-form-item label="stauts">
          <el-switch v-model="user.valid" active-text="valid" inactive-text="invalid"></el-switch>
        </el-form-item>
        <el-form-item label="System Role" size="mini">
          <el-checkbox-group v-model="user.systemRoles">
            <el-checkbox-button v-for="role in options.systemRoles" :label="role.roleId" :key="role.roleId">{{role.roleName}}</el-checkbox-button>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="Department">
          <el-table :data="user.depts" border style="width: 100%">
            <el-table-column fixed prop="deptId" label="deptId" width="150"></el-table-column>
            <el-table-column fixed prop="deptName" label="deptName" width="150"></el-table-column>
            <!--
            <el-table-column fixed label="roles" width="*">
              <template slot-scope="scope">
                <el-checkbox-group v-model="scope.row.roles" size="mini">
                  <el-checkbox-button v-for="role in options.deptRoles" :label="role.roleId" :key="role.roleId">{{role.roleName}}</el-checkbox-button>
                </el-checkbox-group>
              </template>
            </el-table-column>
            -->
            <el-table-column fixed label="roles" width="*">
              <template slot-scope="scope">
                <el-select v-model="scope.row.roles" multiple placeholder="select role" style="width: 80%;">
                  <el-option v-for="role in options.deptRoles" :key="role.roleId" :label="role.roleName" :value="role.roleId"></el-option>
                </el-select>
              </template>
            </el-table-column>
            <el-table-column fixed="right" label="status" width="250">
              <template slot-scope="scope">
                <el-switch v-if="!scope.row.isNew" v-model="scope.row.valid"></el-switch>
                <el-button type="text" v-if="scope.row.isNew" size="small" icon="el-icon-close" @click="onDeleteRole(scope.row)">delete</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-select v-model="views.newDept" placeholder="Add Dept" @change="onAddDept">
            <el-option v-for="item in options.depts" :key="item.id" :label="item.name" :value="item.id" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </el-main>
    <el-footer>Footer</el-footer>
  </el-container>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      views: {
        inputKeys: {
          inputVisible: false,
          inputValue: "",
        },
        newDept: "",
      },
      options: {
        depts: [
          { id: "depte1", name: "XXXX部門", disabled: true },
          { id: "depte2", name: "yyyy部門", disabled: true },
          { id: "depte3", name: "ZZ11部門" },
          { id: "depte4", name: "ZZ22部門" },
        ],
        systemRoles: [
          { roleId: "role11", roleName: "ユーザー管理者" },
          { roleId: "role21", roleName: "部門マスタ管理者" },
          { roleId: "role31", roleName: "品目マスタ管理者" },
        ],
        deptRoles: [
          { roleId: "roleD11", roleName: "請求書管理者" },
          { roleId: "roleD10", roleName: "請求書閲覧者" },
          { roleId: "roleD21", roleName: "注文書管理者" },
          { roleId: "roleD20", roleName: "注文書閲覧者" },
        ],
      },
      user: {
        name: "Nihon Taro",
        inputKeys: ["nh", "nt", "nihon"],
        systemRoles: ["role11", "role21"],
        startDay: "2000/01/01",
        finishDay: "3000/01/01",
        valid: true,
        depts: [
          {
            deptId: "dept1",
            deptName: "XXXX部門",
            roles: ["roleD11", "roleD20"],
            valid: true,
          },
          {
            deptId: "dept2",
            deptName: "YYYY部門",
            roles: ["roleD10", "roleD21"],
            valid: true,
          },
        ],
      },
      schedule: {
        repeats: [],
      },
    };
  },
  created: async function () {
    await this.refresh();
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
    back: function () {
      this.$router.go(-1);
    },
    onCancle: async function () {
      this.$router.go(-1);
    },
    handleClose(tag) {
      this.user.inputKeys.splice(this.user.inputKeys.indexOf(tag), 1);
    },
    showInput() {
      this.views.inputKeys.inputVisible = true;
      this.$nextTick(() => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },
    onAddDept(newDeptCd) {
      let deptInfo = this.options.depts.filter((d) => d.id == newDeptCd)[0];
      deptInfo.disabled = true;
      var newDept = {
        deptId: deptInfo.id,
        deptName: deptInfo.name,
        roles: [],
        valid: true,
        isNew: true,
      };
      this.user.depts.push(newDept);
      this.views.newDept = "";
    },
    onDeleteRole(row) {
      this.user.depts.splice(this.user.depts.indexOf(row), 1);
      let deptInfo = this.options.depts.filter((d) => d.id == row.deptId)[0];
      deptInfo.disabled = false;
    },
    handleInputConfirm() {
      let inputValue = this.views.inputKeys.inputValue;
      if (inputValue) {
        this.user.inputKeys.push(inputValue);
      }
      this.views.inputKeys.inputVisible = false;
      this.views.inputKeys.inputValue = "";
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
.input-new-tag {
  width: 90px;
  margin-left: 10px;
  vertical-align: bottom;
}
</style>