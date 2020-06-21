<template>
    <el-breadcrumb class="app-breadcrumb"  separator="/">
    <transition-group name="breadcrumb">
      <template v-if="Object.is(this.navModel,'route')">
        <el-breadcrumb-item v-for="(item, index) in breadcrumbs"  :key="item.id">
          <span v-if="index === breadcrumbs.length-1" class="no-redirect">{{ item.title }}
            <span v-if="item.isselected === true">
              <dropdown trigger='click' @on-click="selectNavData($event,item)">
                <span class="app-breadcrumb-selected">
                    <i class="el-icon-caret-bottom"></i>
                </span>
                <dropdown-menu slot='list'>                 
                  <dropdown-item v-for="(dataitem) in getPreNavData(item)" :name="dataitem.srfkey" :key="dataitem.srfkey">
                    <span :class="{'curselected':isCurSelected(item,dataitem)}">{{dataitem.srfmajortext}}</span>  
                  </dropdown-item>                    
                </dropdown-menu>
              </dropdown>
            </span>
          </span>
          <a v-else @click.prevent="handleLink(item)">{{ item.title }}</a>
        </el-breadcrumb-item>
      </template>
      <template v-if="!Object.is(this.navModel,'route')">
        <el-breadcrumb-item v-for="(item, index) in breadcrumbs"  :key="item.path">
          <span v-if="index === breadcrumbs.length-1" class="no-redirect" >{{ $t(item.meta.caption)}}</span>
          <a v-else @click.prevent="handleLink(item)" >{{ $t(item.meta.caption) }}</a>
        </el-breadcrumb-item>
      </template>
    </transition-group>
  </el-breadcrumb>
</template>

<script lang="ts">
import { Component, Vue, Watch, Prop } from 'vue-property-decorator'
import { RouteRecord, Route } from 'vue-router'
import { Environment } from "@/environments/environment";
import NavDataService from '@/service/app/navdata-service';
import {Subscription } from 'rxjs';

@Component({
})
export default class Breadcrumb extends Vue {

  /**
   * 面包屑列表
   *
   * @memberof Breadcrumb
   */
  private breadcrumbs: Array<any> = [];

  /**
   * 导航服务
   *
   * @memberof Breadcrumb
   */
  private navDataService = NavDataService.getInstance(this.$store);
  
  /**
   * 默认视图标识
   *
   * @memberof Breadcrumb
   */
  @Prop() public indexViewTag!: string;

  /**
   * 导航模式
   *
   * @memberof Breadcrumb
   */
  @Prop({default:'tab'}) public navModel?:string;

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
    * 导航服务事件
    *
    * @public
    * @type {(Subscription | undefined)}
    * @memberof Dev
    */
  public serviceStateEvent: Subscription | undefined;

  /**
   * vue  生命周期
   *
   * @memberof Breadcrumb
   */
  created() {
    this.getBreadcrumb();
    if(Object.is(this.navModel,"route")){
      this.serviceStateEvent = this.navDataService.serviceState.subscribe(({ action,name, data }:{ action:string,name:any,data:any }) => {
        if (Object.is(action, 'datarefresh')) {
            this.getBreadcrumb();
        }
      });
    }
  }

  /**
   * 获取面包屑数据
   * 
   * @memberof Breadcrumb
   */
  private getBreadcrumb() {
    if(Object.is(this.navModel,"route")){
      this.breadcrumbs = this.navDataService.getNavData();
      this.$forceUpdate();
    }else{
      this.breadcrumbs = this.$route.matched.filter((item) => {
        return item.meta && item.meta.caption
      })
    }
  }

  /**
   * 获取面包屑指定元素前一条数据
   * 
   * @memberof Breadcrumb
   */
  private getPreNavData(item:any){
    let preNavData:any = this.navDataService.getPreNavDataById(item.id);
    return preNavData.data;
  }

  /**
   * 判断是否为当前选中项
   * 
   * @memberof Breadcrumb
   */
  private isCurSelected(item:any,singleItem:any){
    return item.srfkey === singleItem.srfkey;
  }

  /**
   * 面包屑点击行为
   * 
   * @memberof Breadcrumb
   */
  private handleLink(item: any) {
    if(Object.is(this.navModel,"route")){
      // 首页
      if(Object.is(item.id,this.indexViewTag)){
        this.$router.push((window.sessionStorage.getItem(Environment.AppName))as string);
      }else{
        // 非首页
        this.$router.push(item.path).catch(err => {
          console.warn(err);
        });
      }
      this.navDataService.removeNavData(item.id);
    }else{
      if(item && item.meta && item.meta.viewType && Object.is(item.meta.viewType,"APPINDEX")){
        let path: string | null = window.sessionStorage.getItem(Environment.AppName);
        if (path) {
          this.$router.push({ path: path });
        } else {
          this.$router.push("/");
        }
      }else{
        this.$router.push(item).catch(err => {
          console.warn(err);
        });
      }
    }
  }

  /**
   * 切换导航行为
   * 
   * @memberof Breadcrumb
   */
  private selectNavData($event:any,item:any){
    let preNavData:any = this.getPreNavData(item);
    let curSrfkey:any = $event;
    this.navDataService.serviceState.next({action:'viewrefresh',name:item.id, data:curSrfkey});
  }

    /**
     * 组件销毁
     *
     * @memberof Breadcrumb
     */
    public destroyed() {
        if (this.serviceStateEvent) {
            this.serviceStateEvent.unsubscribe();
        }
    }

}
</script>

<style lang='less'>
@import "./app-breadcrumb.less";
</style>