<template>
    <div class='portlet org-person-org-type-pie' :style="{'height': isAdaptiveSize ? 'clac(100% - 16px)' : '300px',}">
        <div class="portlet-without-title">
        <!-- 测试 -->
              <view_portlet_OrgPersonOrgTypePie_chart 
          :viewState="viewState"  
          :viewparams="viewparams" 
          :context="context" 
          fetchAction="FetchREP_PERSONORGTYPE"
          :showBusyIndicator="true" 
          name="portlet_OrgPersonOrgTypePie_chart"  
          ref='portlet_OrgPersonOrgTypePie_chart' 
          @closeview="closeView($event)">
      </view_portlet_OrgPersonOrgTypePie_chart>
        </div>
    </div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import PIMPERSONService from '@/service/pimperson/pimperson-service';
import OrgPersonOrgTypePieService from './org-person-org-type-pie-portlet-service';



@Component({
    components: {
      
    }
})
export default class PIMPERSONOrgPersonOrgTypePieBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof OrgPersonOrgTypePie
     */
    @Prop() protected name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof OrgPersonOrgTypePie
     */
    @Prop() protected viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof OrgPersonOrgTypePie
     */
    @Prop() protected context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof OrgPersonOrgTypePie
     */
    @Prop() protected viewparams: any;

    /**
     * 视图状态事件
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof OrgPersonOrgTypePie
     */
    protected viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof OrgPersonOrgTypePie
     */
    protected getControlType(): string {
        return 'PORTLET'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof OrgPersonOrgTypePie
     */    
    protected counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {OrgPersonOrgTypePieService}
     * @memberof OrgPersonOrgTypePie
     */
    protected service: OrgPersonOrgTypePieService = new OrgPersonOrgTypePieService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PIMPERSONService}
     * @memberof OrgPersonOrgTypePie
     */
    protected appEntityService: PIMPERSONService = new PIMPERSONService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof OrgPersonOrgTypePie
     */
    protected closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof OrgPersonOrgTypePie
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
     * @memberof OrgPersonOrgTypePie
     */
    @Prop({default: false})public isAdaptiveSize!: boolean;

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof OrgPersonOrgTypePie
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof OrgPersonOrgTypePie
     */
    public getData(): any {
        return {};
    }

    /**
     * vue 生命周期
     *
     * @memberof OrgPersonOrgTypePie
     */
    protected created() {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof OrgPersonOrgTypePie
     */    
    protected afterCreated(){
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
     * @memberof OrgPersonOrgTypePie
     */
    protected destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof OrgPersonOrgTypePie
     */
    protected afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

}
</script>

<style lang='less'>
@import './org-person-org-type-pie-portlet.less';
</style>