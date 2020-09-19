<template>
  <el-row class="priority_type">
    <el-col
      :span="3"
      :key="priorityType"
      :class="priorityType"
      v-for="(tasks,priorityType) in priorityTypes"
    >
      <div class="priority_title">{{priorityType}}</div>
      <draggable :options="options" group="priorityTypes" :list="tasks" @end="onDragEnd">
        <el-card
          class="box-card"
          v-for="task in tasks"
          :key="task.id"
          shadow="hover"
          :body-style="{padding:'5px'}"
        >
          <div @click="onSelectedTask(task)">
            <span>{{task.title}}</span>
          </div>
        </el-card>
      </draggable>
    </el-col>
    <el-col :span="10">
      <div class="priority_title">
        <h1>detail</h1>
      </div>
      <el-card class="box-card" shadow="hover" v-show="task.id !== undefined">
        <div slot="header" class="clearfix">
          <span>{{task.title}}({{task.category}})</span>
          <el-input v-model="task.subTitle" @change="onChangedTask(task.id)"></el-input>
        </div>
        <div>
          <div>Prepare</div>
          estimateTime: {{Math.floor(task.estimatePrepareTime/60)}}:{{task.estimatePrepareTime%60}}
          <el-button type="primary" plain>start</el-button>
          <el-button type="success" plain>finish</el-button>
        </div>
        <el-divider></el-divider>
        <div>
          <div>work</div>
          <div>work time: {{task.startTime}} ~ {{task.finishTime}}</div>
          estimateTime: {{Math.floor(task.estimateTime/60)}}:{{task.estimateTime%60}}
          <el-button type="warning" round>start</el-button>
          <el-button type="success" round>finish</el-button>
        </div>
        <el-divider></el-divider>
        <div>
          <div>Close</div>
          estimateTime: {{Math.floor(task.estimateCloseTime/60)}}:{{task.estimateCloseTime%60}}
          <el-button type="primary">start</el-button>
          <el-button type="success">finish</el-button>
        </div>
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
    onChangedTask: async function (id) {
      const res = await axios.post(
        "http://192.168.1.112:8080/task/" + id,
        this.task
      );
      console.log(res);
    },
    onSelectedTask: function (task) {
      this.task = task;
    },
    refresh: async function () {
      const res = await axios.get("http://192.168.1.112:8080/task/");
      this.priorityTypes = res.data;
    },
    onDragEnd: async function () {
      await axios.post("http://192.168.1.112:8080/task/", this.priorityTypes);
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
  padding-top: 10px;
  padding-bottom: 10px;
}

.priority_type .el-col {
  border-width: 2px;
  border-style: dotted;
  margin: 5px;
}
</style>