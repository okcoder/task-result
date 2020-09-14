<template>
  <el-row class="priority_type">
    <el-col
      :span="4"
      :key="priorityType"
      :class="priorityType"
      v-for="(tasks,priorityType) in priorityTypes"
    >
      <div class="priority_title">
        {{priorityType}}
        <br />
        <i class="el-icon-circle-plus-outline" @click="onAddTask(priorityType)"></i>
      </div>
      <draggable :options="options" group="priorityTypes" :list="tasks" @end="onDragEnd">
        <el-card class="box-card" v-for="task in tasks" :key="task.id" shadow="hover">
          <div slot="header" class="clearfix" @click="onSelectedTask(task)">
            <span>{{task.title}}</span>
            <el-button
              style="float: right; padding: 3px 0"
              @click="onEditTask(task.id)"
              type="text"
            >edit</el-button>
          </div>
          <div>subTitle: {{task.subTitle}}</div>
        </el-card>
      </draggable>
    </el-col>
    <el-col :span="6">
      <div class="priority_title">
        <h1>detail</h1>
      </div>
      <el-card class="box-card" shadow="hover" v-show="task.id !== undefined">
        <div slot="header" class="clearfix">
          <span>{{task.title}}</span>
          <el-button
            style="float: right; padding: 3px 0"
            @click="onEditTask(task.id)"
            type="text"
          >edit</el-button>
        </div>
        <div>estimatePrepareTime: {{Math.floor(task.estimatePrepareTime/60)}}:{{task.estimatePrepareTime%60}}</div>
        <div>estimateTime: {{Math.floor(task.estimateTime/60)}}:{{task.estimateTime%60}}</div>
        <div>estimateCloseTime: {{Math.floor(task.estimateCloseTime/60)}}:{{task.estimateCloseTime%60}}</div>
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
      task: {},
    };
  },
  created: async function () {
    await this.refresh();
  },
  computed: {},
  methods: {
    onEditTask: function (id) {
      this.$router.push({ path: `/task/${id}` });
    },
    onSelectedTask: function (task) {
      this.task = task;
    },
    onAddTask: function (priorityType) {
      this.$router.push({
        path: `/task/new`,
        query: { priorityType: priorityType },
      });
    },
    refresh: async function () {
      const res = await axios.get("http://localhost:8080/task/");
      this.priorityTypes = res.data;
    },
    onDragEnd: async function () {
      await axios.post("http://localhost:8080/task/", this.priorityTypes);
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