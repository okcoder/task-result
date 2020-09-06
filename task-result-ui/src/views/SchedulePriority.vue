<template>
  <div>
    <template v-for="(schedules,priorityType) in priorityTypes">
      <div v-bind:key="priorityType" v-bind:class="priorityType">
        {{priorityType}}:
        <template class="item" v-for="item in schedules">{{item.name}}</template>
        <br />
      </div>
    </template>
    <hr />
    <template v-for="(schedules,priorityType) in priorityTypes">
      <div v-bind:key="priorityType" v-bind:class="priorityType">
        {{priorityType}}
        <draggable :options="options" group="myGroup" :list="schedules">
          <div class="item" v-for="item in schedules" :key="item.id">{{item.name}}</div>
        </draggable>
        <hr />
      </div>
    </template>
  </div>
</template>
<script>
import axios from "axios";
import draggable from "vuedraggable";
//import Vue from "vue";

export default {
  components: { draggable },
  data() {
    return {
      options: {
        group: "myGroup",
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