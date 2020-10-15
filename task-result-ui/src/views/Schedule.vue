<template>
  <div>
    <el-form ref="schedule" :model="schedule" label-width="180px" style="text-align: left;">
      <el-form-item label="category">
        <el-input v-model="schedule.category"></el-input>
      </el-form-item>
      <el-form-item label="name">
        <el-input v-model="schedule.name"></el-input>
      </el-form-item>
      <el-form-item label="活动时间">
        <el-col :span="4">
          <el-date-picker
            type="date"
            placeholder="From"
            v-model="schedule.startDay"
            style="width: 100%;"
          ></el-date-picker>
        </el-col>
        <el-col class="line" :span="1" style="text-align: center;">-</el-col>
        <el-col :span="4">
          <el-date-picker
            type="date"
            placeholder="To"
            v-model="schedule.finishDay"
            style="width: 100%;"
          ></el-date-picker>
        </el-col>
      </el-form-item>

      <el-form-item label="priorityType">
        <el-radio-group v-model="schedule.priorityType">
          <el-radio-button
            disabled
            v-for="pt in schedule.priorityTypeOptions"
            :label="pt"
            :key="pt"
          >{{pt}}</el-radio-button>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="repeats" style="text-align: left;">
        <el-switch v-model="everyDay" active-text="every day" inactive-text="selected days"></el-switch>
        <el-checkbox-group v-model="schedule.repeats">
          <el-checkbox-button v-for="day in schedule.repeatOptions" :label="day" :key="day">{{day}}</el-checkbox-button>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="estimatePrepareTime">
        <el-col :span="22">
          <el-slider
            v-model="schedule.estimatePrepareTime"
            show-stops
            :max="30"
            :step="5"
            show-input
          ></el-slider>
        </el-col>
        <el-col
          :span="2"
        >{{Math.floor(schedule.estimatePrepareTime/60)}} Hour {{schedule.estimatePrepareTime%60}} Min</el-col>
      </el-form-item>
      <el-form-item label="estimateTime">
        <el-col :span="22">
          <el-slider v-model="schedule.estimateTime" show-stops :max="300" :step="5" show-input></el-slider>
        </el-col>
        <el-col
          :span="2"
        >{{Math.floor(schedule.estimateTime/60)}} Hour {{schedule.estimateTime%60}} Min</el-col>
      </el-form-item>
      <el-form-item label="estimateCloseTime">
        <el-col :span="22">
          <el-slider v-model="schedule.estimateCloseTime" show-stops :max="30" :step="5" show-input></el-slider>
        </el-col>
        <el-col
          :span="2"
        >{{Math.floor(schedule.estimateCloseTime/60)}} Hour {{schedule.estimateCloseTime%60}} Min</el-col>
      </el-form-item>

      <el-form-item label="task time">
        <el-col :span="4">
          <el-time-select
            placeholder="start time"
            v-model="schedule.startTime"
            style="width: 100%;"
            :picker-options="{start: '07:00',step: '00:15',end: '22:00'}"
          ></el-time-select>
        </el-col>
        <el-col class="line" :span="1" style="text-align: center;">-</el-col>
        <el-col :span="4">
          <el-time-select
            placeholder="finish time"
            v-model="schedule.finishTime"
            style="width: 100%;"
            :picker-options="{start: '07:00',step: '00:15',end: '22:00'}"
          ></el-time-select>
        </el-col>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">save</el-button>
        <el-button @click="onCancle">cancle</el-button>
      </el-form-item>
    </el-form>
  </div>
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