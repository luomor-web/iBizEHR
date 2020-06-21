<template>
    <layout class="app-wizard">
    <el-steps class="wizard-steps"  :active="wizardForms.indexOf(activeForm)" finish-status="success">
      <el-step title="考勤规则"></el-step>
      <el-step title="节假日/调休上班"></el-step>
      <el-step title="请假提示"></el-step>
    </el-steps>
        <i-content class="app-wizard-content">
            <view_wizardpanel_form_wizard01 
              v-if="activeForm == 'wizardpanel_form_wizard01'" 
              :key="'wizardpanel_form_wizard01'" 
              :viewState='wizardState'
              :context="context"
              :viewparams="viewparams"
              updateAction="Update"
              removeAction=""
              loadAction="Get"
              @save="wizardpanel_form_wizard01_save" 
              @load="wizardpanel_form_wizard01_load" 
              name='wizardpanel_form_wizard01' 
              ref='wizardpanel_form_wizard01'>
            </view_wizardpanel_form_wizard01>
            <view_wizardpanel_form_wizard02 
              v-if="activeForm == 'wizardpanel_form_wizard02'" 
              :key="'wizardpanel_form_wizard02'" 
              :viewState='wizardState'
              :context="context"
              :viewparams="viewparams"
              updateAction="Update"
              removeAction=""
              loadAction="GetDraft"
              @save="wizardpanel_form_wizard02_save" 
              @load="wizardpanel_form_wizard02_load" 
              name='wizardpanel_form_wizard02' 
              ref='wizardpanel_form_wizard02'>
            </view_wizardpanel_form_wizard02>
            <view_wizardpanel_form_wizard03 
              v-if="activeForm == 'wizardpanel_form_wizard03'" 
              :key="'wizardpanel_form_wizard03'" 
              :viewState='wizardState'
              :context="context"
              :viewparams="viewparams"
              updateAction="Update"
              removeAction=""
              loadAction="GetDraft"
              @save="wizardpanel_form_wizard03_save" 
              @load="wizardpanel_form_wizard03_load" 
              name='wizardpanel_form_wizard03' 
              ref='wizardpanel_form_wizard03'>
            </view_wizardpanel_form_wizard03>
        </i-content>
        <footer class="app-wizard-footer">
            <i-button :disabled="isDisabled('PREV')" @click="onClickPrev()" type="primary">上一步</i-button>
            <i-button :disabled="isDisabled('NEXT')" @click="onClickNext()" type="primary">下一步</i-button>
            <i-button :disabled="isDisabled('FINISH')" @click="onClickFinish()" type="primary">完成</i-button>
        </footer>
    </layout>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import VacHolidayRulesService from '@/service/vac-holiday-rules/vac-holiday-rules-service';
import KQGZSTXDService from './kqgzstxd-wizardpanel-service';



@Component({
    components: {
      
    }
})
export default class KQGZSTXDBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof KQGZSTXDBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof KQGZSTXDBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof KQGZSTXDBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof KQGZSTXDBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof KQGZSTXDBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof KQGZSTXDBase
     */
    public getControlType(): string {
        return 'WIZARDPANEL'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof KQGZSTXDBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {KQGZSTXDService}
     * @memberof KQGZSTXDBase
     */
    public service: KQGZSTXDService = new KQGZSTXDService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {VacHolidayRulesService}
     * @memberof KQGZSTXDBase
     */
    public appEntityService: VacHolidayRulesService = new VacHolidayRulesService({ $store: this.$store });

    /**
     * wizardpanel_form_wizard01 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof KQGZSTXDBase
     */
    public wizardpanel_form_wizard01_save($event: any, $event2?: any) {
        this.wizardpanel_formsave($event, 'wizardpanel_form_wizard01', $event2);
    }

    /**
     * wizardpanel_form_wizard01 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof KQGZSTXDBase
     */
    public wizardpanel_form_wizard01_load($event: any, $event2?: any) {
        this.wizardpanel_formload($event, 'wizardpanel_form_wizard01', $event2);
    }

    /**
     * wizardpanel_form_wizard02 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof KQGZSTXDBase
     */
    public wizardpanel_form_wizard02_save($event: any, $event2?: any) {
        this.wizardpanel_formsave($event, 'wizardpanel_form_wizard02', $event2);
    }

    /**
     * wizardpanel_form_wizard02 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof KQGZSTXDBase
     */
    public wizardpanel_form_wizard02_load($event: any, $event2?: any) {
        this.wizardpanel_formload($event, 'wizardpanel_form_wizard02', $event2);
    }

    /**
     * wizardpanel_form_wizard03 部件 save 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof KQGZSTXDBase
     */
    public wizardpanel_form_wizard03_save($event: any, $event2?: any) {
        this.wizardpanel_formsave($event, 'wizardpanel_form_wizard03', $event2);
    }

    /**
     * wizardpanel_form_wizard03 部件 load 事件
     *
     * @param {*} [args={}]
     * @param {*} $event
     * @memberof KQGZSTXDBase
     */
    public wizardpanel_form_wizard03_load($event: any, $event2?: any) {
        this.wizardpanel_formload($event, 'wizardpanel_form_wizard03', $event2);
    }
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof KQGZSTXDBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof KQGZSTXDBase
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
     * 部件行为--init
     *
     * @type {string}
     * @memberof KQGZSTXDBase
     */
    @Prop() public initAction!: string;
    
    /**
     * 部件行为--finish
     *
     * @type {string}
     * @memberof KQGZSTXDBase
     */
    @Prop() public finishAction!: string;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof KQGZSTXDBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
      * 获取多项数据
      *
      * @returns {any[]}
      * @memberof KQGZSTXDBase
      */
    public getDatas(): any[] {
        return [this.formParam];
    }

    /**
      * 获取单项数据
      *
      * @returns {*}
      * @memberof KQGZSTXDBase
      */
    public getData(): any {
        return this.formParam;
    }

    /**
     * 视图状态订阅对象
     *
     * @public
     * @type {Subject<{action: string, data: any}>}
     * @memberof KQGZSTXDBase
     */
    public wizardState: Subject<ViewState> = new Subject();

    /**
     * 当前激活表单
     *
     * @type {string}
     * @memberof KQGZSTXDBase
     */
    public activeForm: string = 'wizardpanel_form_wizard01';

    /**
     * 向导表单参数
     *
     * @type {*}
     * @memberof KQGZSTXDBase
     */
    public formParam: any = {};

    /**
     * 执行过的表单
     *
     * @public
     * @type {Array<string>}
     * @memberof KQGZSTXDBase
     */
    public historyForms: Array<string> = [];

    /**
     * 步骤行为集合
     *
     * @type {*}
     * @memberof KQGZSTXDBase
     */
    public stepActions: any = {};

    /**
     * 向导表单集合
     *
     * @type {Array<any>}
     * @memberof KQGZSTXDBase
     */
    public wizardForms: Array<any> = [];

    /**
     * 当前状态
     *
     * @memberof KQGZSTXDBase
     */
    public curState = '';

    /**
     * Vue声明周期(处理组件的输入属性)
     *
     * @memberof KQGZSTXDBase
     */
    public created(): void {
        this.regFormActions();
        if(this.activeForm) {
            this.historyForms.push(this.activeForm);
        }
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (Object.is(tag, this.name)) {
                    if (Object.is('load', action)) {
                        this.doInit(data);
                    }
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof KQGZSTXDBase
     */
    public destroyed() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

    /**
     * 注册表单步骤行为
     *
     * @memberof KQGZSTXDBase
     */
    public regFormActions() {
        this.regFormAction('wizardpanel_form_wizard01', ['NEXT','FINISH']);
        this.regFormAction('wizardpanel_form_wizard02', ['PREV','NEXT']);
        this.regFormAction('wizardpanel_form_wizard03', ['PREV','FINISH']);
    }

    /**
     * 注册表单步骤行为
     *
     * @memberof KQGZSTXDBase
     */
    public regFormAction(name: string, actions: Array<string>) {
        this.stepActions[name] = actions;
        this.wizardForms.push(name);
    }

    /**
     * 初始化行为
     *
     * @memberof KQGZSTXDBase
     */
    public doInit(opt: any = {}) {
        const arg: any = { ...opt };
        Object.assign(arg,{viewparams:this.viewparams});
        const post: Promise<any> = this.service.init(this.initAction, JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (response && response.status === 200) {
                this.formParam = response.data;
                if(response.data.vacholidayrules){
                    Object.assign(this.context,{vacholidayrules:response.data.vacholidayrules})
                }
                this.formLoad();
            }
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            this.$Notice.error({ title: '错误', desc: response.info });
        });
    }

    /**
     * 表单加载
     *
     * @memberof KQGZSTXDBase
     */
    public formLoad() {
        if(this.activeForm) {
            this.wizardState.next({ tag: this.activeForm, action: 'load', data: this.formParam });
        }
    }

    /**
     * 完成行为
     *
     * @memberof KQGZSTXDBase
     */
    public doFinish() {
        let arg: any = {};
        Object.assign(arg, this.formParam);
        Object.assign(arg,{viewparams:this.viewparams});
        const post: Promise<any> = this.service.finish(this.finishAction, JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                this.$emit("finish", data);
            }
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            this.$Notice.error({ title: '错误', desc: response.info });
        });
    }

    /**
     * 向导表单加载完成
     *
     * @param {*} args
     * @param {string} name
     * @memberof KQGZSTXDBase
     */
    public wizardpanel_formload(args: any, name: string, $event2?: any) {
        if(args) {
            Object.assign(this.formParam, args);
        }
    }

    /**
     * 向导表单保存完成
     *
     * @param {*} args
     * @param {string} name
     * @memberof KQGZSTXDBase
     */
    public wizardpanel_formsave(args: any, name: string, $event2?: any) {
        Object.assign(this.formParam, args);
        if(Object.is(this.curState, 'NEXT')) {
            this.historyForms.push(name);
            if (this.getNextForm()) {
                this.activeForm = this.getNextForm();
                setTimeout(() => {
                    this.formLoad();
                }, 1);
            } else {
                this.doFinish();
            }
        }else if(Object.is(this.curState, 'FINISH')) {
            this.doFinish();
        }
    }

    /**
     * 获取下一步向导表单
     *
     * @memberof KQGZSTXDBase
     */
    public getNextForm() {
        let index = this.wizardForms.indexOf(this.activeForm);
        if(index >= 0) {
            if(this.wizardForms[index + 1]) {
                return this.wizardForms[index + 1];
            }
        }
        return undefined;
    }


    /**
     * 上一步
     *
     * @memberof KQGZSTXDBase
     */
    public onClickPrev() {
        const length = this.historyForms.length;
        if(length > 1) {
            this.curState = 'PREV';
            this.activeForm = this.historyForms[length - 1];
            setTimeout(() => {
                this.formLoad();
            }, 1);
            this.historyForms.splice(length - 1, 1);
        }
    }

    /**
     * 下一步
     *
     * @memberof KQGZSTXDBase
     */
    public onClickNext() {
        if(this.activeForm) {
            if(this.$refs && this.$refs[this.activeForm]){
                let form: any = this.$refs[this.activeForm];
                if(form.formValidateStatus()) {
                    this.curState = 'NEXT';
                    this.wizardState.next({ tag: this.activeForm, action: 'save', data: this.formParam });
                } else {
                    this.$Notice.error({ title: '错误', desc: '值规则校验异常' });
                }
            }
        }
    }

    /**
     * 完成
     *
     * @memberof KQGZSTXDBase
     */
    public onClickFinish() {
        if(this.activeForm) {
            if(this.$refs && this.$refs[this.activeForm]){
                let form: any = this.$refs[this.activeForm];
                if(form.formValidateStatus()) {
                    this.curState = 'FINISH';
                    this.wizardState.next({ tag: this.activeForm, action: 'save', data: this.formParam });
                } else {
                    this.$Notice.error({ title: '错误', desc: '值规则校验异常' });
                }
            }
        }
    }

    /**
     * 是否禁用
     *
     * @param {string} type
     * @memberof KQGZSTXDBase
     */
    public isDisabled(type: string) {
        const actions: Array<string> = this.stepActions[this.activeForm]
        if(actions && actions.indexOf(type) < 0) {
            return true;
        }
        return false;
    }
    

}
</script>

<style lang='less'>
@import './kqgzstxd-wizardpanel.less';
</style>