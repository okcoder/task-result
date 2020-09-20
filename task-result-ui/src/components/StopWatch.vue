<template>
  <div>
    <h1>
      <span id="hrs">{{hrs}}</span>:
      <span id="min">{{min}}</span>:
      <span id="sec">{{sec}}</span>.
      <span id="ms">{{ms}}</span>
    </h1>
  </div>
</template>

<style>
</style>

<script>
module.exports = {
  data: function () {
    return {
      state: "started",
      startTime: Date.now(),
      currentTime: Date.now(),
      interval: null,
      lapsed: 0,
    };
  },
  mounted: function () {
    this.interval = setInterval(this.updateCurrentTime, 100);
  },
  destroyed: function () {
    clearInterval(this.interval);
  },
  computed: {
    hrs: function () {
      return Math.floor(this.lapsed / 1000 / 60 / 60)
        .toString()
        .padStart(2, "0");
    },

    min: function () {
      return Math.floor((this.lapsed / 1000 / 60) % 60)
        .toString()
        .padStart(2, "0");
    },
    sec: function () {
      return Math.ceil((this.lapsed / 1000) % 60)
        .toString()
        .padStart(2, "0");
    },
    ms: function () {
      return Math.ceil((this.lapsed % 1000) / 10)
        .toString()
        .padStart(2, "0");
    },
  },
  methods: {
    reset: function () {
      this.$data.state = "started";
      this.$data.startTime = Date.now();
      this.$data.currentTime = Date.now();
    },
    pause: function () {
      this.$data.state = "paused";
    },
    resume: function () {
      this.$data.state = "started";
    },
    updateCurrentTime: function () {
      if (this.$data.state == "started") {
        this.lapsed = Date.now() - this.$data.startTime;
      }
    },
  },
};
</script>