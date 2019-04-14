<template>
  <div class="fuzzySearch">
    <div class="fuzzySearch__hd" @keyup.enter="handleFuzzySearchClick">
      <div class="fuzzySearch__hd__inner">
        <div class="prepend">
          <slot name="prepend"></slot>
        </div>
        <div :style="hdStyle" class="fuzzySearch__hd__content">
          <el-input :placeholder="placeholder"
                    class="fuzzySearch__input"
                    v-model="fuzzyWord">
            <el-button slot="append"
                       icon="el-icon-search"
                       type="primary"
                       :disabled="advanceVisible"
                       @click="handleFuzzySearchClick">
            </el-button>
          </el-input>
        </div>
        <div class="fuzzySearch__switcher" @click="advanceVisible = !advanceVisible">
          {{ switcherLabel }}
        </div>
      </div>
      <div class="append">
        <slot name="append"></slot>
      </div>
    </div>
    <div class="fuzzySearch__bd" v-show="advanceVisible">
      <slot></slot>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        advanceVisible: false,
        fuzzyWord: '',
      };
    },
    props: {
      placeholder: {
        type: String,
        default: '请输入关键字搜索',
      },
      width: {
        type: String,
        default: '440px',
      }
    },
    computed: {
      hdStyle() {
        return {
          width: this.width,
        };
      },
      switcherLabel() {
        return this.advanceVisible ? '普通搜索' : '高级搜索';
      },
    },
    methods: {
      handleFuzzySearchClick() {
        if (this.advanceVisible) { return; }
        this.$emit('fuzzyClick', JSON.parse(JSON.stringify(this.fuzzyWord)));
      },
    },
  };
</script>

<style scoped>

</style>