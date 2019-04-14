<template>
  <div class="wrap">
    <header-bar></header-bar>
    <div class="main-container">
      <div class="left-container">
        <Menu ref="menu" @menu-click="menuClick"></Menu>
      </div>
      <div class="right-container">
        <div class="tab-menu"
             v-show="tabArr.length > 0">
          <el-tabs v-model="activeTab"
                   @tab-click="tabClick"
                   closable
                   @tab-remove="removeTab"
                   type="card">
            <el-tab-pane v-for="item in tabArr"
                         :key="item.index"
                         :label="item.label"
                         :name="item.name"
                         :url="item.to"></el-tab-pane>
            <el-tab-pane v-if="tabArr.length>4"
                         key="-1"
                         label="关闭所有"
                         name="closeAllTab"
                         :closable="false"
                         url="closeAllTab"></el-tab-pane>
          </el-tabs>
        </div>
        <keep-alive :include="activeRouters">
          <router-view v-if="isRouterAlive" @openTab="openTab"></router-view>
        </keep-alive>
      </div>
    </div>
  </div>

</template>

<script>
import Menu from "./views/common/menu/menu.vue";
import HeaderBar from "./views/common/header/header.vue";

export default {
  components: { Menu, HeaderBar },
  data() {
    return {
      ctxPath,
      activeTab: "",
      tabArr: [],
      tabArrClone: [],
      isRouterAlive: true,
    };
  },
  computed: {
    activeRouters: {
      get() {
        let arr = [];
        this.tabArrClone.forEach(item => {
          arr.push(item.name);
        });
        return arr;
      },
      set(arr) {
        this.tabArrClone = arr;
      }
    },
  },
  methods: {
    reload (data) {
        this.isRouterAlive = false
        this.$nextTick(() => {
          this.tabArrClone.push(data);
          this.isRouterAlive = true
        });
    },
    menuClick(data) {
      const isIncludes = this.tabArr.includes(data);//如果包含，返回true
      if (isIncludes) {
        // 重复点击当前激活窗口，实现刷新组件
        if (this.activeTab === data.name) {
          this.activeRouters = this.tabArrClone.filter(item => item.name !== data.name);
          this.reload(data);
        }
        this.activeTab = data.name;
        this.$router.push(data.to);
      } else {
        if (this.tabArr.length > 10) {
          this.$message.warning("你打开的窗口太多，请先关闭一些再打开");
        } else {
          this.activeTab = data.name;
          this.$router.push(data.to);
          if (!isIncludes) {
            this.tabArr.push(data);
            this.tabArrClone = this.tabArr;
          }
        }
      }
    },
    tabClick(tab, event) {
      if ("closeAllTab" == tab.name) {
        this.tabArr.splice(this.tabArr.length - 1, 1);
        let length = this.tabArr.length;
        while (length--) {
          this.removeTab(this.tabArr[length].name);
        }
        return;
      }
      this.$router.push(tab.$attrs.url);
    },
    removeTab(targetName) {
      let tabs = this.tabArr;
      let activeTab = this.activeTab;
      let activeUrl = this.$router.fullPath;
      
      if (activeTab === targetName) {
        tabs.forEach((tab, index) => {
          if (tab.name === targetName) {
            let nextTab = tabs[index + 1] || tabs[index - 1];
            if (nextTab) {
              activeTab = nextTab.name;
              activeUrl = nextTab.to;
            }
          }
        });
      }

      this.activeTab = activeTab;
      this.tabArr = tabs.filter(tab => tab.name !== targetName);
      this.tabArrClone = this.tabArr;

      if (activeUrl) {
        this.$router.push(activeUrl);
      }
			
			//全部关闭跳到首页
      if (this.tabArr.length == 0) {
        this.$router.push("/");
      }
    },
    openTab(tab) {
      let result;
      let routerList = this.$refs.menu.$data.RouterList;
      const length = routerList.length;
      for (let i = 0; i < length; i++) {
        let node = routerList[i];
        if (node.label == tab) {
          result = node;
          break;
        }
        if (!node.children) { continue; }

        for (let j = 0; j < node.children.length; j++) {
          let item = node.children[j];
          if (item.label == tab) {
            result = item;
            break;
          }
        }
      }

      this.activeTab = result.name;
      this.menuClick(result);
    },
  }
};
</script>

<style scoped>
</style>