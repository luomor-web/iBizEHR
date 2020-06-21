<template>
  <Drawer class-name="sider-drawer" placement="left" :closable="false" :mask="false" width="200" v-model="leftDrawerVisiable">
    <div class="context-menu-drag">
      <div class="menu-list">
        <div class="menu-header" @mouseover="showMenuDrawer" @click="rightDrawerVisiable=!rightDrawerVisiable">
          <div class="menuicon">
            <Icon type="md-apps" />
          </div>
          <div class="content">
            <span>服务</span>
          </div>
          <div class="forward">
            <Icon type="ios-arrow-forward" />
          </div>
        </div>
        <div style="padding:8px 0px;" class="col-6">
          <draggable class="list-group" tag="ul" v-model="selectlist" v-bind="dragOptionsVal" @start="drag=true" @end="drag=false" :animation="250" handle=".handle" ghost-class="ghost">
            <transition-group type="transition" :name="!drag ? 'flip-list' : null">
              <li class="list-group-item" v-for="(item,index) in selectlist" :key="item.id">
                <el-row>
                  <el-col class="menuicon" :span="4">
                    <span>
                      <Icon v-if="item.icon" :type="item.icon" />
                      <Icon v-else type="md-menu" />
                    </span>
                  </el-col>
                  <el-col :span="14">
                    <span>{{ item.label }}</span>
                  </el-col>
                  <el-col :span="6">
                    <div class="bar">
                      <div>
                        <Icon type="ios-close" @click="removeAt(index)" />
                      </div>
                      <div>
                        <Icon type="ios-move handle" />
                      </div>
                    </div>
                  </el-col>
                </el-row>
              </li>
            </transition-group>
          </draggable>
        </div>
      </div>
      <Drawer class-name="menu-drawer" width="60" :closable="true" :mask="false" placement="left" v-model="rightDrawerVisiable">
        <div class="menuItems">
          <div class="item" v-for="(item) in list" :key="item.id">
            <span class="title">{{item.label}}</span>
            <span v-if="isStar(item.id)" class="star" @click="outStar(item)">
              <Icon type="ios-star" />
            </span>
            <span v-else class="star" @click="onStar(item)">
              <Icon type="ios-star-outline" />
            </span>
          </div>
        </div>
      </Drawer>
    </div>
  </Drawer>
</template>

<script lang="ts">
import draggable from "vuedraggable";
import EntityService from '@/service/entity-service';
import { Vue,Component,Provide,Watch,Prop,Model } from "vue-property-decorator";

// tslint:disable-next-line:max-classes-per-file
@Component({
  components: {
    draggable
  }
})
export default class ContextMenuDrag extends Vue {

  /**
   * 抽屉菜单状态
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  @Prop() public contextMenuDragVisiable?: boolean;

  /**
   * 拖拽列表配置对象
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  @Model("change") public dragOptions: any;

  /**
   * 右侧飘窗状态
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  public rightDrawerVisiable: boolean = false;

  /**
   * 左侧飘窗状态
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  public leftDrawerVisiable: boolean = false;

  /**
   * 全部应用数据
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  public list: Array<any> = [];

  /**
   * 已选择的应用数据
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  public selectlist: Array<any> = [];

  /**
   * 拖拽列表
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  public drag: boolean = false;

  /**
   * 拖拽列表配置项
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  get dragOptionsVal() {
    return {
      animation: 200,
      group: "description",
      disabled: false,
      ghostClass: "ghost"
    };
  }
  
  /**
   * 实体服务对象
   *
   * @protected
   * @type {EntityService}
   * @memberof ContextMenuDrag
   */
  protected entityService: EntityService = new EntityService();

  /**
   * 监听抽屉菜单状态
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  @Watch("contextMenuDragVisiable")
  public onVisiableChange(newVal: any, oldVal: any) {
    if (newVal) {
      this.leftDrawerVisiable = newVal;
    } else {
      let that: any = this;
      let params: any = {};
      params.model = this.selectlist;
      const put: Promise<any> = this.entityService.updateChooseApp(null,params);
      this.rightDrawerVisiable = false;
      setTimeout(() => {
        that.leftDrawerVisiable = false;
      }, 300);
    }
  }

  /**
   * 鼠标移入服务时显示右侧飘窗
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  public showMenuDrawer() {
    let that: any = this;
    if(this.contextMenuDragVisiable){
      setTimeout(() => {
        that.rightDrawerVisiable = true;
      }, 300);
    }
  }

  /**
   * 判断是否已选择该应用
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  public isStar(id: any) {
    let istar: boolean = false;
    this.selectlist.forEach((item: any) => {
      if (Object.is(item.id, id)) {
        istar = true;
      }
    });
    return istar;
  }

  /**
   * 加入列表
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  public onStar(item: any) {
    item.visabled = 1;
    this.selectlist.push(item);
  }

  /**
   * 从列表中删除
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  public outStar(item: any) {
    item.visabled = 0;
    let index: number = 0;
    let that: any = this;
    this.selectlist.forEach((select: any, index: number) => {
      if (Object.is(item.id, select.id)) {
        that.selectlist.splice(index,1);
      }
    });
  }
  /**
   * 删除已选择应用
   *
   * @returns
   * @memberof ContextMenuDrag
   */
  removeAt(index: any) {
    this.selectlist.splice(index, 1);
  }

  /**
   * 拖拽列表排序
   */
  sort() {
    this.selectlist = this.selectlist.sort((a, b) => a.order - b.order);
  }

  /**
   * 过滤已选择的应用
   * 
   * @returns
   * @memberof ContextMenuDrag
   */
  listFilter() {
    let that: any = this;
    that.selectlist = [];
    this.list.forEach((item: any) => {
      if (item.visabled === 1) {
        that.selectlist.push(item);
      }
    });
  }
  /**
   * vue 生命周期
   *
   * @returns
   * @memberof ContextMenuDrag
   */
  mounted() {
    let that: any = this;
    const get: Promise<any> = this.entityService.getAllApp(null,{});
    get
      .then((response: any) => {
        if (response) {
          that.list = response.data.model;
          that.listFilter();
        }
      });
  }
}
</script>

<style lang='less'>
@import './context-menu-drag.less';
</style>
