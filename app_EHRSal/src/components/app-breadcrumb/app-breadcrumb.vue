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
          v-if="item.redirect === 'noredirect' || index === breadcrumbs.length-1"
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
import { compile } from 'path-to-regexp'
import { Component, Vue, Watch, Prop } from 'vue-property-decorator'
import { RouteRecord, Route } from 'vue-router'

@Component({
  name: 'Breadcrumb'
})
export default class extends Vue {
  private breadcrumbs: RouteRecord[] = []

  
  @Prop() public defPSAppView?: any;

  @Watch('$route')
  private onRouteChange(route: Route) {
    // if you go to the redirect page, do not update the breadcrumbs
    if (route.path.startsWith('/redirect/')) {
      return
    }
    this.getBreadcrumb()
  }

  created() {
    this.getBreadcrumb()
  }

  private getBreadcrumb() {
    let matched = this.$route.matched.filter((item) => item.meta && item.meta.caption)
    const first = matched[0]
    if (!this.isDashboard(first)) {
      matched = [{ path: "/index/:index?", meta: { 
                caption: 'app.views.index.caption',
                viewType: 'APPINDEX',
                parameters: [
                    { pathName: 'index', parameterName: 'index' },
                ],
                requireAuth: true, } } as RouteRecord].concat(matched)
    }
    this.breadcrumbs = matched.filter((item) => {
      return item.meta && item.meta.caption && item.meta.breadcrumb !== false
    })
  }

  private isDashboard(route: RouteRecord) {
    const name = route && route.meta.parameters[0].pathName;
    if (!name) {
      return false
    }
    return name.trim().toLocaleLowerCase() === 'index'.toLocaleLowerCase()
  }

  private pathCompile(item: any) {
    const { params, path, query } = item;
    return { params, path, query };
  }

  private handleLink(item: any) {
    this.$router.push(this.pathCompile(item)).catch(err => {
      console.warn(err);
    });
  }
}
</script>

<style lang='less'>
@import "./app-breadcrumb.less";
</style>