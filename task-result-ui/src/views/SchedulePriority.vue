<template>
  <el-row class="priority_type">
    <el-col
      :span="4"
      :key="priorityType"
      :class="priorityType"
      v-for="(schedules,priorityType) in priorityTypes"
    >
      <div class="priority_title">
        {{priorityType}}
        <br />
        <i class="el-icon-circle-plus-outline" @click="onAddSchedule(priorityType)"></i>
      </div>
      <draggable :options="options" group="priorityTypes" :list="schedules" @end="onDragEnd">
        <el-card class="box-card" v-for="schedule in schedules" :key="schedule.id" shadow="hover">
          <div @click="onSelectedSchedule(schedule)">
            <span :title="schedule.category">{{schedule.name}}</span>
            <el-button
              style="float: right; padding: 3px 0"
              @click="onEditSchedule(schedule.id)"
              type="text"
            >edit</el-button>
          </div>
        </el-card>
      </draggable>
    </el-col>
    <el-col :span="6">
      <div class="priority_title">
        <h1>detail</h1>
      </div>
      <el-card class="box-card" shadow="hover" v-show="schedule.id !== undefined">
        <div slot="header" class="clearfix">
          <span>{{schedule.name}}({{schedule.category}})</span>
        </div>
        <div>estimatePrepareTime: {{Math.floor(schedule.estimatePrepareTime/60)}}:{{schedule.estimatePrepareTime%60}}</div>
        <div>estimateTime: {{Math.floor(schedule.estimateTime/60)}}:{{schedule.estimateTime%60}}</div>
        <div>estimateCloseTime: {{Math.floor(schedule.estimateCloseTime/60)}}:{{schedule.estimateCloseTime%60}}</div>
      </el-card>
    </el-col>
  </el-row>
</template>
<script>
import axios from "axios";
import draggable from "vuedraggable";

export default {
  components: { draggable },
  data() {
    return {
      options: {
        group: "priorityTypes",
        animation: 200,
      },
      priorityTypes: {
        big_rock: [],
        gravel: [],
        sand: [],
        water: [],
      },
      schedule: {},
    };
  },
  created: async function () {
    await this.refresh();
  },
  computed: {},
  methods: {
    onEditSchedule: function (id) {
      this.$router.push({ path: `/schedule/${id}` });
    },
    onSelectedSchedule: function (schedule) {
      this.schedule = schedule;
    },
    onAddSchedule: function (priorityType) {
      this.$router.push({
        path: `/schedule/new`,
        query: { priorityType: priorityType },
      });
    },
    onSubmit: async function () {
      const res = await axios.post("schedule/6", this.schedule);
      alert(JSON.stringify(res));
    },
    refresh: async function () {
      const res = await axios.get("schedule/");
      this.priorityTypes = res.data;
    },
    onDragEnd: async function () {
      await axios.post("schedule/", this.priorityTypes);
    },
  },
};
</script>
<style scoped>
.priority_title {
  height: 100px;
  width: 100%;
  background-size: cover;
}

.big_rock .priority_title {
  background: url("../assets/big_rock.png");
}

.gravel .priority_title {
  background: url("../assets/gravel.png");
}

.sand .priority_title {
  background: url("../assets/sand.png");
}

.water .priority_title {
  background: url("../assets/water.png");
}

.box-card {
  margin: 5px;
}

.priority_type .el-col {
  border-width: 2px;
  border-style: dotted;
  min-height: 100px;
  margin: 5px;
}
</style>