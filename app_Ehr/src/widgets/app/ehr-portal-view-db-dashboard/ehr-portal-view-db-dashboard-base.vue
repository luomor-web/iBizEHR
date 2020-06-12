<template>
  <div class='dashboard'>
    <row v-if="isEnableCustomized">
      <app-build @handleClick="handleClick"></app-build>
    </row>
    <row v-if="!isHasCustomized">
      <i-col :xs="{ span: 8, offset: 0 }" :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }">
        <card class="portlet-card" :bordered="false" dis-hover :padding="0">
          <span>
                      <view_db_sysportlet1 
              :viewState="viewState"  
              :viewparams="viewparams" 
              :context="context" 
              :height="932"
              name="db_sysportlet1"  
              ref='db_sysportlet1' 
              @closeview="closeView($event)">
          </view_db_sysportlet1>
          </span>
        </card>
      </i-col>
      <i-col :xs="{ span: 16, offset: 0 }" :sm="{ span: 16, offset: 0 }" :md="{ span: 16, offset: 0 }" :lg="{ span: 16, offset: 0 }">
        <card class="portlet-card" :bordered="false" dis-hover :padding="0">
          <span>
                      <view_db_sysportlet2 
              :viewState="viewState"  
              :viewparams="viewparams" 
              :context="context" 
              :height="250"
              name="db_sysportlet2"  
              ref='db_sysportlet2' 
              @closeview="closeView($event)">
          </view_db_sysportlet2>
          </span>
        </card>
      </i-col>
      <i-col :xs="{ span: 8, offset: 0 }" :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }">
        <card class="portlet-card" :bordered="false" dis-hover :padding="0">
          <span>
                      <view_db_sysportlet4 
              :viewState="viewState"  
              :viewparams="viewparams" 
              :context="context" 
              :height="666"
              name="db_sysportlet4"  
              ref='db_sysportlet4' 
              @closeview="closeView($event)">
          </view_db_sysportlet4>
          </span>
        </card>
      </i-col>
      <i-col :xs="{ span: 8, offset: 0 }" :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }">
        <card class="portlet-card" :bordered="false" dis-hover :padding="0">
          <span>
                      <view_db_sysportlet5 
              :viewState="viewState"  
              :viewparams="viewparams" 
              :context="context" 
              :height="325"
              name="db_sysportlet5"  
              ref='db_sysportlet5' 
              @closeview="closeView($event)">
          </view_db_sysportlet5>
          </span>
        </card>
      </i-col>
      <i-col :xs="{ span: 8, offset: 0 }" :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }">
        <card class="portlet-card" :bordered="false" dis-hover :padding="0">
          <span>
                      <view_db_sysportlet3 
              :viewState="viewState"  
              :viewparams="viewparams" 
              :context="context" 
              :height="325"
              name="db_sysportlet3"  
              ref='db_sysportlet3' 
              @closeview="closeView($event)">
          </view_db_sysportlet3>
          </span>
        </card>
      </i-col>
    </row>
    <row v-if="isHasCustomized" style="width: 100%;min-height: calc(100% - 40px);">
      <div class="portlet-container" style="position: relative;width:100%;">
        <template v-for="(item, index) of modelDta">
        <div :key="index" :style="{zIndex: 10, position: 'absolute', height: item.h*layoutRowH + 'px', width: `calc(100% / ${layoutColNum} * ${item.w})`,top: item.y*layoutRowH + 'px', left: `calc(100% / ${layoutColNum} * ${item.x})`}">
          <component :key="$util.createUUID()" :is="item.componentName" :name="item.portletCodeName" :context="JSON.parse(JSON.stringify(context))" :viewDefaultUsage="false" :isAdaptiveSize="true" :viewState="viewState"></component>
        </div>
        </template>
    </div>
    </row>
  </div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import EhrPortalView_dbService from './ehr-portal-view-db-dashboard-service';

import UtilService from '@/utilservice/util-service';


@Component({
    components: {
      
    }
})
export default class EhrPortalView_dbBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof EhrPortalView_db
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof EhrPortalView_db
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof EhrPortalView_db
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof EhrPortalView_db
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof EhrPortalView_db
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof EhrPortalView_db
     */
    public getControlType(): string {
        return 'DASHBOARD'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof EhrPortalView_db
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {EhrPortalView_dbService}
     * @memberof EhrPortalView_db
     */
    public service: EhrPortalView_dbService = new EhrPortalView_dbService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof EhrPortalView_db
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof EhrPortalView_db
     */
    public counterRefresh(){
        const _this:any =this;
        if(_this.counterServiceArray && _this.counterServiceArray.length >0){
            _this.counterServiceArray.forEach((item:any) =>{
                if(item.refreshData && item.refreshData instanceof Function){
                    item.refreshData();
                }
            })
        }
    }

    /**
     * 是否支持看板定制
     *
     * @public
     * @type {(boolean)}
     * @memberof EhrPortalView_db
     */
    @Prop() public isEnableCustomized!:boolean;

    /**
     * 是否已有看板定制
     *
     * @public
     * @type {(boolean)}
     * @memberof EhrPortalView_db
     */
    public isHasCustomized:boolean = false;

    /**
     * 模型数据
     *
     * @public
     * @type {(*)}
     * @memberof EhrPortalView_db
     */
    public modelDta:any;

    /**
     * modleId
     *
     * @type {string}
     * @memberof EhrPortalView_db
     */
    public modelId:string = "dashboard_app_ehrportalview_db";

    /**
     * 建构功能服务对象
     *
     * @type {UtilService}
     * @memberof EhrPortalView_db
     */
    public utilService:UtilService = new UtilService();

    /**
     * 功能服务名称
     *
     * @type {string}
     * @memberof EhrPortalView_db
     */
    public utilServiceName:string = "dynadashboard";

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof EhrPortalView_db
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof EhrPortalView_db
     */
    public getData(): any {
        return {};
    }

    /**
     * vue 生命周期
     *
     * @memberof EhrPortalView_db
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof EhrPortalView_db
     */    
    public afterCreated(){
      if (this.viewState) {
          this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
              if (!Object.is(tag, this.name)) {
                  return;
              }
              if (Object.is('load', action)) {
                  this.loadModel();
              }
          });
      }
    }

    /**
     * 动态设计水平列数
     *
     *  @memberof EhrPortalView_db
     */   
    public layoutColNum:number = 12;

    /**
     * 动态设计单元格高度，80px
     *
     *  @memberof EhrPortalView_db
     */ 
    public layoutRowH:number = 80;

    /**
     *  通知状态
     *
     *  @memberof EhrPortalView_db
     */    
    public notifyState(){
      this.$nextTick(() =>{
        if (this.isHasCustomized) {
          if (this.modelDta && this.modelDta.length > 0) {
            this.modelDta.forEach((item: any) => {
              this.viewState.next({
                tag: item.portletCodeName,
                action: "load",
                data: JSON.parse(JSON.stringify(this.viewparams))
              });
            });
          }
        } else {
          if (this.viewState) {
            const refs: any = this.$refs;
            Object.keys(refs).forEach((name: string) => {
              this.viewState.next({
                tag: name,
                action: "load",
                data: JSON.parse(JSON.stringify(this.viewparams))
              });
            });
          }
        }
      })
    }

    /**
     * 加载布局与数据模型
     *
     * @memberof EhrPortalView_db
     */
    public loadModel(){
        if(this.isEnableCustomized){
          this.utilService.getService(this.utilServiceName).then((service:any) =>{
            service.loadModelData(JSON.parse(JSON.stringify(this.context)),{modelid:this.modelId,utilServiceName:this.utilServiceName}).then((res:any) =>{
              if(res && res.status == 200){
                const data:any = res.data;
                if(data && data.length >0){
                  this.isHasCustomized = true;
                  this.modelDta = data;
                  this.$forceUpdate();
                }else{
                  this.isHasCustomized = false;
                }
                this.notifyState();
              }else{
                console.error("加载面板模型异常");
                this.isHasCustomized = false;
                this.notifyState();
              }
            }).catch((error:any)=>{
                console.error("加载面板模型异常");
                console.error(error);
                this.isHasCustomized = false;
                this.notifyState();
            });
          })
        }else{
          this.notifyState();
        }
    }

    /**
     * 处理私人定制按钮
     *
     * @memberof EhrPortalView_db
     */
    public handleClick(){
      const view:any ={
        viewname: 'app-portal-design',
        title: '面板设计',
        width: 1600,
        placement: 'DRAWER_RIGHT'
      }
      const viewparam:any ={
        modelid:this.modelId,
        utilServiceName:this.utilServiceName,
        appdeName:'app'
      }
      const appdrawer = this.$appdrawer.openDrawer(view, JSON.parse(JSON.stringify(this.context)), viewparam);
      appdrawer.subscribe((result: any) => {
          if(Object.is(result.ret,'OK')){
            this.loadModel();
          }
      });
    }

    /**
     * vue 生命周期
     *
     * @memberof EhrPortalView_db
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof EhrPortalView_db
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

}
</script>

<style lang='less'>
@import './ehr-portal-view-db-dashboard.less';
</style>