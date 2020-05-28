<template>
    <div class='portlet orm-pnum-list' :style="{'height': isAdaptiveSize ? 'clac(100% - 16px)' : '300px',}">
        <div class="portlet-without-title">
        <!-- 测试 -->
              <view_portlet_OrmPNumList_list 
          :viewState="viewState"  
          :viewparams="viewparams" 
          :context="context" 
          createAction="Create"
          removeAction="Remove"
          updateAction="Update"
          fetchAction="FetchREP_ORGPNUM"
          :showBusyIndicator="true"
          name="portlet_OrmPNumList_list"  
          ref='portlet_OrmPNumList_list' 
          @closeview="closeView($event)">
      </view_portlet_OrmPNumList_list>
        </div>
    </div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import OrmOrgService from '@/service/orm-org/orm-org-service';
import OrmPNumListService from './orm-pnum-list-portlet-service';



@Component({
    components: {
      
    }
})
export default class OrmOrgOrmPNumListBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof OrmPNumList
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof OrmPNumList
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof OrmPNumList
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof OrmPNumList
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof OrmPNumList
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof OrmPNumList
     */
    public getControlType(): string {
        return 'PORTLET'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof OrmPNumList
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {OrmPNumListService}
     * @memberof OrmPNumList
     */
    public service: OrmPNumListService = new OrmPNumListService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {OrmOrgService}
     * @memberof OrmPNumList
     */
    public appEntityService: OrmOrgService = new OrmOrgService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof OrmPNumList
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof OrmPNumList
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
     * 是否自适应大小
     *
     * @returns {boolean}
     * @memberof OrmPNumList
     */
    @Prop({default: false})public isAdaptiveSize!: boolean;

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof OrmPNumList
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof OrmPNumList
     */
    public getData(): any {
        return {};
    }

    /**
     * vue 生命周期
     *
     * @memberof OrmPNumList
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof OrmPNumList
     */    
    public afterCreated(){
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                const refs: any = this.$refs;
                Object.keys(refs).forEach((_name: string) => {
                    this.viewState.next({ tag: _name, action: action, data: data });
                });
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof OrmPNumList
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof OrmPNumList
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

}
</script>

<style lang='less'>
@import './orm-pnum-list-portlet.less';
</style>