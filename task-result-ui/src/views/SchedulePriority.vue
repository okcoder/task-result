<template>
  <el-row class="priority_type">
    <el-col
      :span="5"
      :key="priorityType"
      :class="priorityType"
      v-for="(schedules,priorityType) in priorityTypes"
    >
      <div class="priority_title">{{priorityType}}</div>
      <draggable :options="options" group="priorityTypes" :list="schedules">
        <el-card class="box-card" v-for="schedule in schedules" :key="schedule.id" shadow="hover">
          <div slot="header" class="clearfix">
            <span>{{schedule.name}}</span>
            <el-button
              style="float: right; padding: 3px 0"
              @click="onEditSchedule(schedule.id)"
              type="text"
            >edit</el-button>
          </div>
          <div>estimatePrepareTime: {{Math.floor(schedule.estimatePrepareTime/60)}}:{{schedule.estimatePrepareTime%60}}</div>
          <div>estimateTime: {{Math.floor(schedule.estimateTime/60)}}:{{schedule.estimateTime%60}}</div>
          <div>estimateCloseTime: {{Math.floor(schedule.estimateCloseTime/60)}}:{{schedule.estimateCloseTime%60}}</div>
        </el-card>
      </draggable>
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
      schedules: [],
      priorityTypes: {
        big_rock: [],
        gravel: [],
        sand: [],
        water: [],
      },
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
    onSubmit: async function () {
      const res = await axios.post(
        "http://192.168.1.112:8080/schedule/6",
        this.schedule
      );
      alert(JSON.stringify(res));
    },
    refresh: async function () {
      const res = await axios.get("http://192.168.1.112:8080/schedule/");
      this.schedules = res.data;
      const priorityTypes = this.priorityTypes;
      this.schedules.forEach((schedule) => {
        const priorityType = schedule.priorityType;
        priorityTypes[priorityType].push(schedule);
      });
    },
  },
};
</script>
<style scoped>
.priority_title {
  height: 100px;
  width: 100%;
}
.big_rock .priority_title {
  background: url("../assets/big_rock.png") no-repeat center center;
}
.gravel .priority_title {
  background: url("../assets/gravel.png") no-repeat center center;
}
.sand .priority_title {
  background: url("../assets/sand.png") no-repeat center center;
}
.water .priority_title {
  background: url("../assets/water.png") no-repeat center center;
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