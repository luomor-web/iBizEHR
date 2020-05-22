<template>
    <div class='portlet org-voc-num-list' :style="{'height': isAdaptiveSize ? 'clac(100% - 16px)' : '300px',}">
        <div class="portlet-without-title">
        <!-- 测试 -->
              <view_portlet_OrgVocNumList_list 
          :viewState="viewState"  
          :viewparams="viewparams" 
          :context="context" 
          createAction="Create"
          removeAction="Remove"
          updateAction="Update"
          fetchAction="FetchREP_VOCATIONAL"
          :showBusyIndicator="true"
          name="portlet_OrgVocNumList_list"  
          ref='portlet_OrgVocNumList_list' 
          @closeview="closeView($event)">
      </view_portlet_OrgVocNumList_list>
        </div>
    </div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import PIMVOCATIONALService from '@/service/pimvocational/pimvocational-service';
import OrgVocNumListService from './org-voc-num-list-portlet-service';



@Component({
    components: {
      
    }
})
export default class PIMVOCATIONALOrgVocNumListBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof OrgVocNumList
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof OrgVocNumList
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof OrgVocNumList
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof OrgVocNumList
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof OrgVocNumList
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof OrgVocNumList
     */
    public getControlType(): string {
        return 'PORTLET'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof OrgVocNumList
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {OrgVocNumListService}
     * @memberof OrgVocNumList
     */
    public service: OrgVocNumListService = new OrgVocNumListService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PIMVOCATIONALService}
     * @memberof OrgVocNumList
     */
    public appEntityService: PIMVOCATIONALService = new PIMVOCATIONALService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof OrgVocNumList
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof OrgVocNumList
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
     * @memberof OrgVocNumList
     */
    @Prop({default: false})public isAdaptiveSize!: boolean;

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof OrgVocNumList
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof OrgVocNumList
     */
    public getData(): any {
        return {};
    }

    /**
     * vue 生命周期
     *
     * @memberof OrgVocNumList
     */
    public created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof OrgVocNumList
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
     * @memberof OrgVocNumList
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof OrgVocNumList
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

}
</script>

<style lang='less'>
@import './org-voc-num-list-portlet.less';
</style>