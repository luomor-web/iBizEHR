<template>
  <el-breadcrumb
    class="app-breadcrumb"
    separator="/"
  >
    <transition-group name="breadcrumb">
      <el-breadcrumb-item
        v-for="(item, index) in breadcrumbs"
        :key="item.path"
      >
        <span
          v-if="index === breadcrumbs.length-1"
          class="no-redirect"
        >{{  $t(item.meta.caption) }}</span>
        <a
          v-else
          @click.prevent="handleLink(item)"
        >{{  $t(item.meta.caption) }}</a>
      </el-breadcrumb-item>
    </transition-group>
  </el-breadcrumb>
</template>

<script lang="ts">
import { Component, Vue, Watch, Prop } from 'vue-property-decorator'
import { RouteRecord, Route } from 'vue-router'

@Component({
})
export default class Breadcrumb extends Vue {

  private breadcrumbs: RouteRecord[] = [];  //面包屑列表
  
  @Prop() public defPSAppView: any; //默认视图

  /**
   * 监听路由
   *
   * @memberof Breadcrumb
   */
  @Watch('$route')
  private onRouteChange(route: Route) {
    this.getBreadcrumb()
  }

  /**
   * vue  生命周期
   *
   * @memberof Breadcrumb
   */
  created() {
    this.getBreadcrumb()
  }

  /**
   * 获取面包屑数据
   * 
   * @memberof Breadcrumb
   */
  private getBreadcrumb() {
    this.breadcrumbs = this.$route.matched.filter((item) => {
        return item.meta && item.meta.caption
      })
    if(this.defPSAppView){
      /**如果配置了默认视图,给面包屑第一级赋值默认视图为首页 */
    }
  }

  /**
   * 单机面包屑
   * 
   * @memberof Breadcrumb
   */
  private handleLink(item: any) {
    this.$router.push(item).catch(err => {
      console.warn(err);
    });
  }
}
</script>

<style lang='less'>
@import "./app-breadcrumb.less";
</style>