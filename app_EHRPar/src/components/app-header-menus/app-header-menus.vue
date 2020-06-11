<template>
  <div class="app-header-menus">
    <div v-for="(menu,index) in menus" :key="index" class="app-header-menu-item text" @click="openWindow(menu)">
      <div class="app-header-menu-item-icon">
        <i :class="menu.iconcls" :aria-hidden="true" />
      </div>
      <div class="app-header-menu-item-text">{{$t(menu.title)}}</div>

    </div>
  </div> 
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Emit } from "vue-property-decorator";
import { Subject } from "rxjs";
import { Environment } from '@/environments/environment';

@Component({
})
export default class AppHeaderMenus extends Vue {

  /**
   * 菜单数据
   * 
   * @type {any}
   * @memberof AppHeaderMenus
   */
  public menus:any = [
      {
          name: "ibizlab",
          title: "components.appHeaderMenus.ibizlab.title",
          url: Environment.ibizlabtUrl,
          iconcls: 'fa fa-home',
      },
      {
          name: "publishProject",
          title: "components.appHeaderMenus.publishProject.title",
          url: Environment.PublishProjectUrl,
          iconcls: 'fa fa-folder-open-o',
      },
      {
          name: "ibizstudio",
          title: "components.appHeaderMenus.ibizstudio.title",
          url: `${Environment.StudioUrl}?#/common_slnindex/srfkeys=${Environment.SlnId}/sysdesign_psdevslnsysmodeltreeexpview`,
          iconcls: 'fa fa-wrench',
      },
      {
          name: "ibizbbs",
          title: "components.appHeaderMenus.ibizbbs.title",
          url: Environment.ibizbbstUrl,
          iconcls: 'fa fa-comments-o',
      },
  ];

  /**
   * 触发界面行为
   * 
   * @memberof AppHeaderMenus
   */
  public openWindow(menu:any){
      window.open(menu.url, '_blank');
  }


}
</script>

<style lang='less'>
@import "./app-header-menus.less";
</style>