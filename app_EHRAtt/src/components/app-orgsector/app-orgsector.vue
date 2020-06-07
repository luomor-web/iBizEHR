<template>
  <div class="app-org-sector">
    <dropdown @on-click="orgSelect" :transfer="true">
      <div class="orgsector">
        <span>{{selectedOrgName}}</span>
        <icon size="18" type="md-arrow-dropdown" v-if="selectedOrgArray.length > 0"></icon>
      </div>
      <dropdown-menu
        class="menu"
        slot="list"
        style="font-size: 15px !important;"
        v-if="selectedOrgArray.length > 0"
      >
        <dropdown-item
          :name="item.srforgsectorid"
          style="font-size: 15px !important;"
          v-for="(item, index) in selectedOrgArray"
          :key="index"
        >{{item.srforgsectorname}}</dropdown-item>
      </dropdown-menu>
    </dropdown>
  </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Inject } from "vue-property-decorator";

@Component({})
export default class AppOrgSector extends Vue {

  /**
   * 注入加载行为
   *
   * @memberof AppOrgSector
   */
  @Inject("reload")
  reload!: any;

  /**
   * 选中组织部门id
   *
   * @type {string}
   * @memberof AppOrgSector
   */
  public selectedOrgId: string = "";

  /**
   * 选中组织部门名称
   *
   * @type {string}
   * @memberof AppOrgSector
   */
  public selectedOrgName: string = "";

  /**
   * 组织部门名称数组
   *
   * @type {Array<any>}
   * @memberof AppOrgSector
   */
  public selectedOrgArray: Array<any> = [];

  /**
   * 组件初始化数据，vue生命周期
   *
   * @memberof AppOrgSector
   */
  public mounted() {
    if (this.$store.getters.getAppData()) {
      if (this.$store.getters.getAppData().context && this.$store.getters.getAppData().context.srforgsectorid && this.$store.getters.getAppData().context.srforgsectorname) {
        this.selectedOrgId = this.$store.getters.getAppData().context.srforgsectorid;
        this.selectedOrgName = this.$store.getters.getAppData().context.srforgsectorname;
      }
      if (this.$store.getters.getAppData().srforgsections) {
        this.selectedOrgArray = this.$store.getters.getAppData().srforgsections;
      }
    }
  }

  /**
   * 选择组织部门回调
   *
   * @memberof AppOrgSector
   */
  public orgSelect(data: string) {
    if(Object.is(data,this.selectedOrgId)){
        return;
    }
    let item: any = this.selectedOrgArray.find((_item: any) => {
      return _item.srforgsectorid === data;
    });
    if (item.srforgsectorid && item.srforgsectorname) {
      this.selectedOrgId = item.srforgsectorid;
      this.selectedOrgName = item.srforgsectorname;
      this.reload();

    }
    this.updateStoreOrgData(item);
  }

  /**
   * 更新仓库Org信息
   *
   * @memberof AppOrgSector
   */
  public updateStoreOrgData(data: any) {
    let _appdata: any = this.$store.getters.getAppData();
    let _context: any = _appdata.context;
    Object.assign(_context,data);
    Object.assign(_appdata, {context:_context});
    this.$store.commit("updateAppData", _appdata);
  }
}
</script>

<style lang="less">
@import "./app-orgsector.less";
</style>