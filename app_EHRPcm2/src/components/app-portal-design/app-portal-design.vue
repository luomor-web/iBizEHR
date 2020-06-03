<template>
    <card class="app-portal-design" :dis-hover="true" :padding="0" :bordered="false">
        <p slot="title">
            {{$t('components.appPortalDesign.customPortal')}}
        </p>
        <div class="design-toolbar" slot="extra">
            <i-button @click="click">{{$t('components.appPortalDesign.save')}}</i-button>
        </div>
        <div class="design-container">
            <app-dashboard-design :viewState="viewState" :context="context" :viewparams="viewparams" :utilServiceName="utilServiceName" @save="onSaved"></app-dashboard-design>
        </div>
    </card>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Emit,Watch } from "vue-property-decorator";
import { Subject } from "rxjs";
import AppDashboardDesign from '@components/app-dashboard-design/app-dashboard-design.vue';

@Component({
    components: {
        AppDashboardDesign
    }
})
export default class AppPortalDesign extends Vue {

      /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof AppPortalDesign
     */
    @Prop() protected viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof AppPortalDesign
     */
    @Prop() protected viewparam!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof AppPortalDesign
     */
    @Prop({ default: true }) protected viewDefaultUsage!: boolean;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof AppPortalDesign
     */
    protected context:any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppPortalDesign
     */
    protected viewparams:any = {};

    /**
     * modelId
     *
     * @type {*}
     * @memberof AppPortalDesign
     */
    protected modelId:string = "";

    /**
     * 功能服务名称
     *
     * @type {*}
     * @memberof AppPortalDesign
     */
    protected utilServiceName:string = "";

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof AppPortalDesign
     */
    protected viewState: Subject<ViewState> = new Subject();

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPortalDesign
     */
    @Watch('viewparam',{immediate: true, deep: true})
    onParamData(newVal: any, oldVal: any) {
        this.prepareViewparam();
    }

    /**
     * 处理应用上下文变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppPortalDesign
     */
    @Watch('viewdata')
    onViewData(newVal: any, oldVal: any) {
        this.prepareContext();
    }

    /**
     * 生命周期
     *
     * @memberof AppPortalDesign
     */
    public created() {
        this.prepareViewparam();
        this.prepareContext();
    }

    /**
     * 准备视图参数
     *
     * @memberof AppPortalDesign
     */
    public prepareViewparam() {
        if(this.viewparam){
            Object.assign(this.viewparams, JSON.parse(this.viewparam));
            if(this.viewparams && this.viewparams.modelid){
                this.modelId = this.viewparams.modelid;
            }
            if(this.viewparams && this.viewparams.utilServiceName){
                this.utilServiceName = this.viewparams.utilServiceName;
            }
        } 
    }

    /**
     * 准备视图上下文参数
     *
     * @memberof AppPortalDesign
     */
    public prepareContext() {
        if (!this.viewDefaultUsage && this.viewdata && !Object.is(this.viewdata, '')) {
            Object.assign(this.context, JSON.parse(this.viewdata));
            return;
        } 
    }

     
    /**
     * 点击保存
     *
     * @memberof AppPortalDesign
     */
    public click() {
        this.viewState.next({ tag: "", action: "save", data: {} })
    }

     /**
     * 保存完成
     *
     * @memberof AppPortalDesign
     */
    public onSaved($event: any) {
        this.$emit("close", $event);
    }

}
</script>

<style lang='less'>
@import "./app-portal-design.less";
</style>